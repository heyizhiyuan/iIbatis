package com.cnj.orm.iIbatis.excutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cnj.orm.iIbatis.config.DataSourceConfig;
import com.cnj.orm.iIbatis.mapping.MappedStatement;
import com.cnj.orm.iIbatis.reflect.util.ReflectUtil;


public class DefaultExecutor implements Executor{
		
	Logger log=Logger.getLogger(DefaultExecutor.class);
	@Override
	public <T> T query(MappedStatement ms, Object parameter) {
		String sql=ms.getSql();
		log.debug("sql-->"+sql+",parameter-->"+parameter);
		Connection conn=DataSourceConfig.getConnection();
		PreparedStatement ps=null;
		ResultSet  rs=null;
		try {
			ps=conn.prepareStatement(sql);
			setParameters(ps,new Object[] {parameter});
			rs=ps.executeQuery();
			ResultSetMetaData metaData=rs.getMetaData();
			List<Object> list=null;
			while (rs.next()) {
				if(list==null){
					list=new ArrayList<Object>();
				}
				T obj=ReflectUtil.classInstanceForName(ms.getResultType());  
				for (int i=0,len=metaData.getColumnCount();i<len;i++) {
					String columnName=metaData.getColumnLabel(i+1);
					Object columnValue=rs.getObject(i+1);
					ReflectUtil.invokeSet(obj,columnName,columnValue);
				}
				list.add(obj);
			}
			log.debug("result-->"+list);
			return (T) list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataSourceConfig.close(conn);
		}
		return null;
	}
	public void setParameters(PreparedStatement ps, Object[] args) throws SQLException {
		for (int i = 0,len=args.length; i < len; i++) {
			ps.setObject(i+1,args[i]);
		}
	}


}
