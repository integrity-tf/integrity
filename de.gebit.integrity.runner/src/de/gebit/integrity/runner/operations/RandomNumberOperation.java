/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.operations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import de.gebit.integrity.operations.custom.Operation;

/**
 * A random number generator. This one is special in two respects: it is automatically re-seeded before test execution
 * (that means: once before the dry AND real run), and its seed is forwarded to forks to ensure their randomness is in
 * sync with that of the master.
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
	 * Reseeds the RNG with the stored seed.
	 */
	public static void reSeed() {
		random = new Random(seed);
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
		reSeed();
	}

	public static long getSeed() {
		return seed;
	}

	@Override
	public BigDecimal execute(Object aPrefixParameter, Integer aPostfixParameter) {
		BigDecimal tempRand = new BigDecimal(random.nextDouble());

		if (aPostfixParameter != null) {
			return tempRand.setScale(aPostfixParameter, RoundingMode.HALF_UP);
		} else {
			return tempRand;
		}
	}
}
