package com.cnj.orm.iIbatis.session;

import java.util.List;

public interface SqlSession {
	
	<T> T selectOne(String id,Object parameter);
	
	<E> List<E> selectList(String id,Object parameter);
	
	<T> T getMapper(Class<T> clazz);

}
