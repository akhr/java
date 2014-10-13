package com.akh.JSONParserTest;

public enum AppType {
	
	ENTERPRISE("enterprise"),
	PUBLIC("public");
	
	private String value;
	
	private AppType(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public static AppType getEnum(String val){
		if(val.equalsIgnoreCase(ENTERPRISE.getValue())){
			return ENTERPRISE;
		}else if(val.equalsIgnoreCase(PUBLIC.getValue())){
			return PUBLIC;
		}else{
			return null;
		}
	}

}
