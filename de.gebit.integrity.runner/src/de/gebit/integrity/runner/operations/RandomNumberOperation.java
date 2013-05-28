/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.operations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.operations.custom.Operation;

/**
 * A random number generator. This one is special in several respects: it is automatically seeded on execution start, it
 * caches randoms determined for every custom operation instance, and its seed is forwarded to forks to ensure their
 * randomness is in sync with that of the master. All of this is required to safely work with random elements in
 * Integrity tests.
 * 
 * This operation doesn't have any input parameters, it just returns a random decimal number between 0 and 1.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class RandomNumberOperation implements Operation<Object, Integer, BigDecimal> {

	/**
	 * The seed value.
	 */
	private static long seed = new Random().nextLong();

	/**
	 * The RNG.
	 */
	private static Random random = new Random(seed);

	/**
	 * Calculated randoms are cached here.
	 */
	private static Map<Thread, Map<CustomOperation, BigDecimal>> calculatedRandoms = new HashMap<Thread, Map<CustomOperation, BigDecimal>>();

	/**
	 * The operation which is processed will be injected here.
	 */
	@Inject
	private CustomOperation operation;

	private static Map<CustomOperation, BigDecimal> getCalculatedRandomsMap() {
		Map<CustomOperation, BigDecimal> tempMap = calculatedRandoms.get(Thread.currentThread());
		if (tempMap == null) {
			tempMap = new HashMap<CustomOperation, BigDecimal>();
			calculatedRandoms.put(Thread.currentThread(), tempMap);
		}

		return tempMap;
	}

	/**
	 * Sets a new seed and reseeds the RNG.
	 * 
	 * @param aSeed
	 */
	public static void seed(Long aSeed) {
		if (aSeed == null) {
			seed = new Random().nextLong();
		} else {
			seed = aSeed;
		}
		random = new Random(seed);
	}

	public static long getSeed() {
		return seed;
	}

	@Override
	public BigDecimal execute(Object aPrefixParameter, Integer aPostfixParameter) {
		BigDecimal tempResult = getCalculatedRandomsMap().get(operation);
		if (tempResult == null) {
			BigDecimal tempRand = new BigDecimal(random.nextDouble());
			if (aPostfixParameter != null) {
				tempResult = tempRand.setScale(aPostfixParameter, RoundingMode.HALF_UP);
			} else {
				tempResult = tempRand;
			}
			getCalculatedRandomsMap().put(operation, tempResult);
		}

		return tempResult;
	}
}
