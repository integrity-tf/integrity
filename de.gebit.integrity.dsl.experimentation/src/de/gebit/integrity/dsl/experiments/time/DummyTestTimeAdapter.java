/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.dsl.experiments.time;

import java.math.BigDecimal;
import java.util.Date;

import de.gebit.integrity.runner.time.TestTimeAdapter;

/**
 * Dummy Test Time Adapter.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class DummyTestTimeAdapter implements TestTimeAdapter {

	@Override
	public void setTestTime(Date aStartTime, BigDecimal aProgressionFactor) {
		System.out.println("==> Setting test time to " + aStartTime + " with progression factor " + aProgressionFactor);
		// if (Math.random() < 0.5) {
		// throw new RuntimeException("Random failure!");
		// }
	}

}
