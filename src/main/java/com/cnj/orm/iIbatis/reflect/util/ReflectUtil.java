package com.cnj.orm.iIbatis.reflect.util;

import java.util.HashMap;
import java.util.Map;

import com.cnj.orm.iIbatis.util.StringUtils;

import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtil {
	
	public final static Map<String,Object> newInstances=new HashMap<>();
	
	public final static Map<String,Class<?>> baseTypes=new HashMap<String, Class<?>>() {{
		put("byte", byte.class);
		put("short", short.class);
		put("char", char.class);
		put("boolean", boolean.class);
		put("int", int.class);
		put("long", long.class);
		put("double", double.class);
		put("float", float.class);
	}};
	static {
		initNewInstances();
	}		
	@SuppressWarnings("unchecked")
	public static <T> T classInstanceForName(String className){
		try {
			String upperName=className.toUpperCase();
			if(newInstances.containsKey(upperName)) {
				return (T) newInstances.get(upperName);
			}else {
				Object instance=Class.forName(className).newInstance();
				newInstances.put(upperName,instance);
				return (T) instance;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void initNewInstances() {
		classInstanceForName("java.lang.String");
		classInstanceForName("java.lang.Object");
	}
	
	public static Object invokeGet(Object obj, String fieldName) {
		Class<? extends Object> clazz=obj.getClass();
		Object result=null;
		try {
			if("SerialVersionUID".equalsIgnoreCase(fieldName)){
				return null;
			}
			Method m=clazz.getDeclaredMethod("get"+StringUtils.firstChar2UppdateCase(fieldName),null);
			result=m.invoke(obj);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param obj
	 * @param columnName
	 * @param columnValue
	 */
	public static void invokeSet(Object obj, String columnName, Object columnValue) {
		Class<? extends Object> clazz=obj.getClass();
		try {
			Method[] ms=clazz.getDeclaredMethods();
			Method m=null;
			String name="";
			for (Method method : ms) {
				if((name=method.getName()).equalsIgnoreCase("set"+columnName)) {
					m=method;
					break ;
				}
			}
		//	String returnType=getMethodParameterType(m,0);
			/*Class<?> parameterClazz=isBaseType(returnType)?baseTypes.get(returnType)
					:columnValue==null?
							null:columnValue.getClass();
*/			//System.out.println(columnName+"__"+getMethodParameterType(m,0)+"__"+columnValue+"___"+parameterClazz);
			/*String returnType=getMethodParameterType(m,0);*/
			/*Class<?> parameterClazz=isBaseType(returnType)?baseTypes.get(returnType)
										:columnValue==null?
												null:columnValue.getClass();*/
			/*if(isBaseType(returnType)) {
				columnValue=columnValue==null?0:columnValue;
			}*/
			m.invoke(obj,columnValue);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getMethodParameterType(Method m,int index) {
		return m.getParameterTypes()[index].getName();
	}
	/**
	 * 
	 * @param val
	 * @param m
	 * @return
	 */
	public static boolean isBaseType(String typeName) {
		return baseTypes.containsKey(typeName);
	}   
	
	public static void main(String[] args) {
		isBaseType("");
	}
	

}
