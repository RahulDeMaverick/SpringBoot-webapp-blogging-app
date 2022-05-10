package com.foodapp.myapp.pojo;

import org.springframework.stereotype.Component;

@Component
public class LableValue {
	
	private String label;
	private String value;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
