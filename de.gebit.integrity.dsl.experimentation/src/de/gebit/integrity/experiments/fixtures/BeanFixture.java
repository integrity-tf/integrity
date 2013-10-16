package de.gebit.integrity.experiments.fixtures;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class BeanFixture {

	@FixtureMethod(description = "inputs $bean$")
	public TestBean beanInput(@FixtureParameter(name = "bean") TestBean aBean) {
		TestBean tempReturn = new TestBean();
		tempReturn.setPrefixedString("123");
		return tempReturn;
	}

	@FixtureMethod(description = "echoes $bean$")
	public Object untypedBeanEcho(@FixtureParameter(name = "bean") Object aBean) {
		return aBean;
	}

}
