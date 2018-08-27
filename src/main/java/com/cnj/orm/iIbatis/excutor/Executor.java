package com.cnj.orm.iIbatis.excutor;

import com.cnj.orm.iIbatis.mapping.MappedStatement;

public interface Executor {
	<T> T query(MappedStatement ms,Object parameter);
}
