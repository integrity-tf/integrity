package de.gebit.integrity.experiments.fixtures;

import de.gebit.integrity.forker.ForkerParameter;
import de.gebit.integrity.runner.forking.DefaultForker;

public class ParameterizedForker extends DefaultForker {

	public ParameterizedForker(
			@ForkerParameter(name = "stringParam") String stringParam,
			@ForkerParameter(name = "numberParam") Integer numberParam) {
		System.out.println(stringParam);
		System.out.println(numberParam);
	}

}
