package com.cnj.orm.iIbatis.session;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.executor.Executor;

import com.cnj.orm.iIbatis.contant.Contant;

public class SqlSessionFactory {
	
	public final static String DEFAULT_SQL_SESSION_CLASS_NAME=Contant.DEFAULT_SQL_SESSION_CLASS_NAME; 
	
	public static Map<Class<?>,SqlSession> sessionMap=new HashMap<Class<?>,SqlSession>();
	
	static{
		openSession(DEFAULT_SQL_SESSION_CLASS_NAME);
	}
	
	public static SqlSession openSession(String className) {
		Class<?> clazz=newClass(className);
		if(sessionMap.containsKey(clazz)) {
			return sessionMap.get(clazz);
		}else {
			SqlSession session = null;
			try {
				session = (SqlSession) clazz.newInstance();
				sessionMap.put(clazz, session);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			return session;
		}
	}
	public static SqlSession openSession() {
		return sessionMap.get(newClass(DEFAULT_SQL_SESSION_CLASS_NAME));
	}
	
	private static Class<?> newClass(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
