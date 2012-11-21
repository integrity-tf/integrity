package de.gebit.integrity.tests.fixtures.basic.beans;

import java.math.BigDecimal;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class BeanFixture {

	@FixtureMethod(description = "checks the bean $bean$")
	public boolean checkSimpleBean(@FixtureParameter(name = "bean") SimpleTestBean aBean) {
		return "string".equals(aBean.getFirstParameter()) && aBean.getSecondParameter() == 100
				&& aBean.getThirdParameter().getInnerParameter().equals(new BigDecimal("1.99"));
	}

}
