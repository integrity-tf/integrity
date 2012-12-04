package de.gebit.integrity.experiments.fixtures;

import java.math.BigDecimal;
import java.util.List;

public class TestBean extends SuperTestBean {

	private int primitiveInt;

	private InnerBean[] innerBeanArrayParam;

	private List<InnerBean> innerBeanListParam;

	public InnerBean[] getInnerBeanArrayParam() {
		return innerBeanArrayParam;
	}

	public void setInnerBeanArrayParam(InnerBean[] innerBeanArrayParam) {
		this.innerBeanArrayParam = innerBeanArrayParam;
	}

	public List<InnerBean> getInnerBeanListParam() {
		return innerBeanListParam;
	}

	public void setInnerBeanListParam(List<InnerBean> innerBeanListParam) {
		this.innerBeanListParam = innerBeanListParam;
	}

	public int getPrimitiveInt() {
		return primitiveInt;
	}

	public void setPrimitiveInt(int primitiveInt) {
		this.primitiveInt = primitiveInt;
	}

	public static class InnerBean {

		/**
		 * Another comment.
		 */
		private BigDecimal innerParameter;

		public BigDecimal getInnerParameter() {
			return innerParameter;
		}

		public void setInnerParameter(BigDecimal innerParameter) {
			this.innerParameter = innerParameter;
		}

	}

}
