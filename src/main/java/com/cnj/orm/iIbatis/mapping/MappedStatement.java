package com.cnj.orm.iIbatis.mapping;

public class MappedStatement {
	public String nameSpace;
	public String id;
	public String resultType;
	public String sql;
	public String parameterType;
	
	public MappedStatement() {
		
	}
	
	public final String getNameSpace() {
		return nameSpace;
	}
	public final void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getResultType() {
		return resultType;
	}
	public final void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public final String getSql() {
		return sql;
	}
	public final void setSql(String sql) {
		this.sql = sql;
	}
	public final String getParameterType() {
		return parameterType;
	}
	public final void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	@Override
	public String toString() {
		return "MappedStatement [nameSpace=" + nameSpace + ", id=" + id + ", resultType=" + resultType + ", sql=" + sql
				+ ", parameterType=" + parameterType + "]";
	}
}
