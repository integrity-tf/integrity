package de.gebit.integrity.experiments.fixtures;

import java.util.Arrays;
import java.util.HashMap;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class BeanFixture {

	@FixtureMethod(description = "inputs $bean$")
	public TestBean beanInput(@FixtureParameter(name = "bean") TestBean aBean) {
		TestBean tempReturn = new TestBean();
		tempReturn.setPrefixedString("123");
		return tempReturn;
	}

	@FixtureMethod()
	public Object untypedBeanEcho() {
		HashMap<String, Object> result = new HashMap<>();
		result.put("aKey", Arrays.asList(1,2));
		//result.put("aKey", new int[] {1,2});
		//result.put("aKey", 1);
		
		HashMap<String, Object> inner = new HashMap<>();
		inner.put("innerKey", 1);
		
		HashMap<String, Object> inner2 = new HashMap<>();
		inner2.put("innerKey", 2);
		
		//result.put("aKey", Arrays.asList(inner, inner2));
		//result.put("aKey", new HashMap[] {inner, inner2});
		
		return result;
	}

}
