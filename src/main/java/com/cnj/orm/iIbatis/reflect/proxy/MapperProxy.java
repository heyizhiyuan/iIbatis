package com.cnj.orm.iIbatis.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;

import com.cnj.orm.iIbatis.config.Configuration;
import com.cnj.orm.iIbatis.mapping.MappedStatement;
import com.cnj.orm.iIbatis.session.DefaultSqlSession;
import com.cnj.orm.iIbatis.session.SqlSession;

public class MapperProxy<T> implements InvocationHandler {
	SqlSession sqlSession =null;
	
	public MapperProxy(DefaultSqlSession defaultSqlSession) {
		this.sqlSession=defaultSqlSession;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	   // MappedStatement ms=Configuration.getMappedStatementMap().get(method.getDeclaringClass().getName()+"."+method.getName());
	    String id=method.getDeclaringClass().getName()+"."+method.getName();
	    Class<?> type=method.getReturnType(); 
	    Object arg=args==null?null:args[0];
	    if(List.class.isAssignableFrom(type)) {
	    	return sqlSession.selectList(id, arg);
	    }else{
	    	return sqlSession.selectOne(id, arg);
	    }
	}

}
