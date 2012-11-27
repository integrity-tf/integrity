package de.gebit.integrity.tests.fixtures.basic.beans;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class CollectionTestBean {

	private String[] arrayParameter;

	private List<Integer> parameterizedListParameter;

	private List<?> plainListParameter;

	private List<? extends Integer> lowerBoundParameterizedListParameter;

	private Set<InnerBean> setParameterWithInnerBean;

	@SuppressWarnings("rawtypes")
	private Collection plainCollectionParameter;

	public String[] getArrayParameter() {
		return arrayParameter;
	}

	public void setArrayParameter(String[] arrayParameter) {
		this.arrayParameter = arrayParameter;
	}

	public List<Integer> getParameterizedListParameter() {
		return parameterizedListParameter;
	}

	public void setParameterizedListParameter(
			List<Integer> parameterizedListParameter) {
		this.parameterizedListParameter = parameterizedListParameter;
	}

	public List<?> getPlainListParameter() {
		return plainListParameter;
	}

	public void setPlainListParameter(List<?> plainListParameter) {
		this.plainListParameter = plainListParameter;
	}

	public Set<InnerBean> getSetParameterWithInnerBean() {
		return setParameterWithInnerBean;
	}

	public void setSetParameterWithInnerBean(
			Set<InnerBean> setParameterWithInnerBean) {
		this.setParameterWithInnerBean = setParameterWithInnerBean;
	}

	@SuppressWarnings("rawtypes")
	public Collection getPlainCollectionParameter() {
		return plainCollectionParameter;
	}

	@SuppressWarnings("rawtypes")
	public void setPlainCollectionParameter(Collection plainCollectionParameter) {
		this.plainCollectionParameter = plainCollectionParameter;
	}

	public List<? extends Integer> getLowerBoundParameterizedListParameter() {
		return lowerBoundParameterizedListParameter;
	}

	public void setLowerBoundParameterizedListParameter(
			List<? extends Integer> lowerBoundParameterizedListParameter) {
		this.lowerBoundParameterizedListParameter = lowerBoundParameterizedListParameter;
	}

	public static class InnerBean {

		private BigDecimal innerParameter;

		public BigDecimal getInnerParameter() {
			return innerParameter;
		}

		public void setInnerParameter(BigDecimal innerParameter) {
			this.innerParameter = innerParameter;
		}

	}

}
