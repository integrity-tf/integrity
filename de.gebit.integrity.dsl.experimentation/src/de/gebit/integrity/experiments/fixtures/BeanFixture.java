package de.gebit.integrity.experiments.fixtures;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;

import de.gebit.integrity.experiments.fixtures.TestBean.InnerBean;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class BeanFixture {

	@FixtureMethod(description = "inputs $bean$")
	public TestBean[] beanInput(@FixtureParameter(name = "bean") TestBean aBean) {
		TestBean tempReturn = new TestBean();
		tempReturn.setPrefixedString("123");
		InnerBean tempInner = new InnerBean();
		tempInner.setLocalDate(LocalDate.of(2023, 1, 1));
		tempInner.setLocalTime(LocalTime.of(18, 00, 05));
		tempReturn.setInnerBeanListParam(Arrays.asList(tempInner));
		return new TestBean[] { tempReturn };
	}

	@FixtureMethod()
	public Object untypedBeanEcho() {
		HashMap<String, Object> result = new HashMap<>();
		result.put("aKey", Arrays.asList(1, 2));
		// result.put("aKey", new int[] {1,2});
		// result.put("aKey", 1);

		HashMap<String, Object> inner = new HashMap<>();
		inner.put("innerKey", 1);

		HashMap<String, Object> inner2 = new HashMap<>();
		inner2.put("innerKey", 2);

		// result.put("aKey", Arrays.asList(inner, inner2));
		// result.put("aKey", new HashMap[] {inner, inner2});

		return result;
	}

}
