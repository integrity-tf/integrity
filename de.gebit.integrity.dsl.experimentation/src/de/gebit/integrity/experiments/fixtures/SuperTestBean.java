package de.gebit.integrity.experiments.fixtures;

import java.util.List;

public class SuperTestBean {

	/**
	 * This one has a comment!
	 */
	private String[] stringArrayParam;

	private List<String> stringListParam;

	public String[] getStringArrayParam() {
		return stringArrayParam;
	}

	public void setStringArrayParam(String[] stringArrayParam) {
		this.stringArrayParam = stringArrayParam;
	}

	public List<String> getStringListParam() {
		return stringListParam;
	}

	public void setStringListParam(List<String> stringListParam) {
		this.stringListParam = stringListParam;
	}

}
