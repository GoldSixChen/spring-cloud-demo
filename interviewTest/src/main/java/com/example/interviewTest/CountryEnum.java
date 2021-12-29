package com.example.interviewTest;

import lombok.Data;
import lombok.Getter;
public enum CountryEnum {
	ONE(1,"齐国"),TWO(2,"燕国"),THREE(3,"魏国"),FOUR(4,"赵国"),FIVE(5,"韩国"),SIX(6,"楚国"),SERVEN(7,"秦国");
	
	private Integer retCode;
	private String retName;
	
	CountryEnum(int retCode, String retName) {
		// TODO Auto-generated constructor stub
		this.retCode=retCode;
		this.retName=retName;
	}

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetName() {
		return retName;
	}

	public void setRetName(String retName) {
		this.retName = retName;
	}

	public static CountryEnum foreach_countryenum(int code) {
		CountryEnum[] myarray=CountryEnum.values();
		for(CountryEnum em:myarray) {
			if(code == em.getRetCode()) {
				return em;
			}
		}
		return null;
	}
}
