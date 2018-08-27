package com.cnj.orm.iIbatis.util;

public class StringUtils {
	
	public static String firstChar2UppdateCase(String target){
		return target==null||target.trim().equals("")?
				null: target.substring(0,1).toUpperCase()+target.substring(1).toLowerCase();
	}
}
