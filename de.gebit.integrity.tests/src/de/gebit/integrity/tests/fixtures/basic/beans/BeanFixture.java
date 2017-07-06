/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.tests.fixtures.basic.beans.CollectionTestBean.InnerBean;
import de.gebit.integrity.tests.fixtures.basic.beans.EnumTestBean.InnerEnum;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class BeanFixture {

	@FixtureMethod(description = "checks the bean $bean$")
	public boolean checkSimpleBean(@FixtureParameter(name = "bean") SimpleTestBean aBean) {
		return "string".equals(aBean.getFirstParameter()) && aBean.getSecondParameter() == 100
				&& aBean.getThirdParameter().getInnerParameter().equals(new BigDecimal("1.99"));
	}

	@FixtureMethod(description = "gets the bean $bean$ and counts all entries in all lists")
	public int checkCollectionBean(@FixtureParameter(name = "bean") CollectionTestBean aBean) {
		int tempCount = 0;
		if (aBean.getArrayParameter() != null) {
			tempCount += aBean.getArrayParameter().length;
		}
		if (aBean.getParameterizedListParameter() != null) {
			// Verify these are of the right type by casting
			for (@SuppressWarnings("unused")
			Integer tempElement : aBean.getParameterizedListParameter()) {
				tempCount++;
			}
		}
		if (aBean.getPlainCollectionParameter() != null) {
			tempCount += aBean.getPlainCollectionParameter().size();
		}
		if (aBean.getPlainListParameter() != null) {
			tempCount += aBean.getPlainListParameter().size();
		}
		if (aBean.getSetParameterWithInnerBean() != null) {
			// Verify these are of the right type by casting
			for (@SuppressWarnings("unused")
			InnerBean tempElement : aBean.getSetParameterWithInnerBean()) {
				tempCount++;
			}
		}
		if (aBean.getLowerBoundParameterizedListParameter() != null) {
			// Verify these are of the right type by casting
			for (@SuppressWarnings("unused")
			Integer tempElement : aBean.getLowerBoundParameterizedListParameter()) {
				tempCount++;
			}
		}

		return tempCount;
	}

	@FixtureMethod(description = "takes the bean $bean$, alters it a little bit and returns it")
	public PrimitiveTypeTestBean alterPrimitiveBean(@FixtureParameter(name = "bean") PrimitiveTypeTestBean aBean) {
		aBean.alterABit();
		return aBean;
	}

	@FixtureMethod(description = "checks the bean $bean$")
	public boolean checkSimpleBeanUntyped(@FixtureParameter(name = "bean") Object aBean) {
		SimpleTestBean tempBean = (SimpleTestBean) aBean;

		return "string".equals(tempBean.getFirstParameter()) && tempBean.getSecondParameter() == 100
				&& tempBean.getThirdParameter().getInnerParameter().equals(new BigDecimal("1.99"));
	}

	@FixtureMethod(description = "creates a bean with predefined values and returns it")
	public Object createSimpleBeanUntyped() {
		SimpleTestBean tempBean = new SimpleTestBean();
		tempBean.setFirstParameter("string");
		tempBean.setSecondParameter(100);
		SimpleTestBean.InnerBean tempInnerBean = new SimpleTestBean.InnerBean();
		tempInnerBean.setInnerParameter(new BigDecimal("1.99"));
		tempBean.setThirdParameter(tempInnerBean);

		return tempBean;
	}

	@FixtureMethod(description = "creates a map with some key-value pairs in it and returns it")
	public Map<String, Object> createMapForSimpleBeanUntyped() {
		Map<String, Object> tempOuterMap = new HashMap<String, Object>();
		tempOuterMap.put("firstParameter", "string");
		tempOuterMap.put("secondParameter", 100);
		Map<String, Object> tempInnerMap = new HashMap<String, Object>();
		tempInnerMap.put("innerParameter", new BigDecimal("1.99"));
		tempOuterMap.put("thirdParameter", tempInnerMap);

		return tempOuterMap;
	}

	@FixtureMethod(description = "echoes the provided enum test bean")
	public EnumTestBean echoEnumTestBean(@FixtureParameter(name = "bean") EnumTestBean aTestBean) {
		return aTestBean;
	}

	@FixtureMethod(description = "echoes the enum value from the provided enum test bean")
	public InnerEnum echoEnumValueFromTestBean(@FixtureParameter(name = "bean") EnumTestBean aTestBean) {
		return aTestBean.getEnumValue();
	}

	@FixtureMethod(description = "echoes the input as a map converted by Integrity")
	public Map<String, Object> echoMap(@FixtureParameter(name = "bean") Map<String, Object> aBean) {
		return aBean;
	}

	@FixtureMethod(description = "creates an instance of PrimitiveTypeArrayTestBean")
	public PrimitiveTypeArrayTestBean createPrimitiveTypeArrayTestBean() {
		PrimitiveTypeArrayTestBean tempBean = new PrimitiveTypeArrayTestBean();
		tempBean.setPrimitiveBoolean(new boolean[] { true, false });
		tempBean.setPrimitiveByte(new byte[] { 1, 2, 3 });
		tempBean.setPrimitiveChar(new char[] { 'a', 'b', 'c' });
		tempBean.setPrimitiveDouble(new double[] { 1.0, 1.1, 1.2 });
		tempBean.setPrimitiveFloat(new float[] { 1.0f, 1.1f, 1.2f });
		tempBean.setPrimitiveInt(new int[] { 1, 2, 3 });
		tempBean.setPrimitiveLong(new long[] { 1, 2, 3 });
		tempBean.setPrimitiveShort(new short[] { 1, 2, 3 });

		return tempBean;
	}

	@FixtureMethod(description = "creates an empty bean and returns it")
	public Object createSimpleBeanUntypedEmpty() {
		SimpleTestBean tempBean = new SimpleTestBean();

		return tempBean;
	}

	@FixtureMethod(description = "creates a transient test bean and returns it")
	public Object createTransientTestBean() {
		return new TransientTestBean();
	}

	@FixtureMethod(description = "creates a map test bean and returns it")
	public MapTestBean createMapTestBean() {
		return new MapTestBean();
	}

	@FixtureMethod(description = "creates a map test bean and returns it")
	public MapTestBeanWithMapInMap createMapTestBeanWithMapInMap() {
		return new MapTestBeanWithMapInMap();
	}

	@FixtureMethod(description = "creates a map test bean and returns it")
	public MapTestBeanWithTreeMap createMapTestBeanWithTreeMap() {
		return new MapTestBeanWithTreeMap();
	}

	@FixtureMethod(description = "Creates a nested list test bean object with $innerObjects$ inner objects")
	public NestedListTestBean createNestedListTestBeanParameterized(
			@FixtureParameter(name = "innerObjects") Integer anInnerObjectCount) {
		return new NestedListTestBean(anInnerObjectCount != null ? anInnerObjectCount : 3);
	}

	@FixtureMethod(description = "Creates a simple test bean array with $elements$ elements")
	public SimpleArrayBean createSimpleTestBeanArray(@FixtureParameter(name = "elements") Integer aNumberOfElements) {
		List<SimpleTestBean> tempList = new ArrayList<>();

		for (int i = 0; i < aNumberOfElements; i++) {
			tempList.add(new SimpleTestBean("foo", i, null));
		}

		return new SimpleArrayBean(tempList.toArray(new SimpleTestBean[0]));
	}
}
