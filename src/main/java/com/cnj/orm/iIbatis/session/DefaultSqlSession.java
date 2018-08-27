package com.cnj.orm.iIbatis.session;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.TooManyResultsException;

import com.cnj.orm.iIbatis.config.Configuration;
import com.cnj.orm.iIbatis.excutor.DefaultExecutor;
import com.cnj.orm.iIbatis.excutor.Executor;
import com.cnj.orm.iIbatis.mapping.MappedStatement;
import com.cnj.orm.iIbatis.reflect.proxy.MapperProxy;

public class DefaultSqlSession implements SqlSession {
	
	Executor executor=new DefaultExecutor();
	Map<String,MappedStatement> ms=Configuration.getMappedStatementMap();

	@Override
	public <T> T selectOne(String id, Object parameter) {
		List<T> list=this.<T>selectList(id, parameter);
		if (list.size() == 1) {
	      return list.get(0);
	    } else if (list.size() > 1) {
	      throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
	    } else {
	      return null;
	    }
	}

	@Override
	public  <E> List<E> selectList(String id, Object parameter) {
		return  executor.query(ms.get(id), parameter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getMapper(Class<T> clazz) {
		return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {clazz},new MapperProxy(this));
	}

}
