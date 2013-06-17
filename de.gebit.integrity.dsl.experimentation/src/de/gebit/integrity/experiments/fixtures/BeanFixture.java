package de.gebit.integrity.experiments.fixtures;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class BeanFixture {

	@FixtureMethod(description = "inputs $bean$")
	public TestBean beanInput(@FixtureParameter(name = "bean") TestBean aBean) {
		System.out.println(aBean);
		return null;
	}

	@FixtureMethod(description = "echoes $bean$")
	public Object untypedBeanEcho(@FixtureParameter(name = "bean") Object aBean) {
		return aBean;
	}

}
