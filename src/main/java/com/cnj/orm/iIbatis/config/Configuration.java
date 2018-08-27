package com.cnj.orm.iIbatis.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.cnj.activitiPro.system.dao.SysDicDao;
import com.cnj.orm.iIbatis.contant.Contant;
import com.cnj.orm.iIbatis.mapping.MappedStatement;
import com.cnj.orm.iIbatis.session.SqlSession;
import com.cnj.orm.iIbatis.session.SqlSessionFactory;

public class Configuration {
	
	Logger log=Logger.getLogger(Configuration.class);
	
	public String mapperPath=Contant.MAPPER_PATH;
	
	public String dbFile=Contant.DB_FILE;
	
	public static BasicDataSource dataSource;
	
	public static DataSourceConfig dataSorceConfig;
	
	private static Configuration conf=null;
	
	public static Map<String,MappedStatement> msMap=new HashMap<>();
	
	static {
		BasicConfigurator.configure();
		conf=new Configuration();
	}
	
	public static DataSourceConfig getDataSorceConfig() {
		return dataSorceConfig;
	}
	
	public static BasicDataSource getDataSource() {
		return dataSource;
	}
	public Configuration() {
		loadMapperXml(mapperPath);
		loadDbFile(dbFile);
	}


	private void loadDbFile(String dbFile) {
		dataSource=DataSourceConfig.loadProperties(dbFile);
		log.debug("dataSource "+dataSource);
	}

	private void loadMapperXml(String mapperPath) {
		msMap=MpperXmlConfig.loadMapperXml(mapperPath);
		log.debug("mapper "+msMap);
	}
	public static Map<String, MappedStatement> getMappedStatementMap() {
		return msMap;
	}

	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		System.out.println();
		SqlSession session=SqlSessionFactory.openSession();
		SysDicDao dao=session.getMapper(SysDicDao.class);
		System.out.println("dicList--"+dao.findSysDicBySuperId("0"));
		System.out.println(System.currentTimeMillis()-start);
	}
	/*@Test 
	public void test01() {
		//SqlSession session=SqlSessionFactory.openSession();
		//SysDicDao dao=session.getMapper(SysDicDao.class);
		//System.out.println("dicList--"+dao.findSysDicBySuperId("0"));
		Object o=null;
		System.out.println("111111"+o.getClass());
		//com.cnj.activitiPro.system.dao.SysDicDao.findSysDicBySuperId
		//com.cnj.activitiPro.system.dao.findSysDicBySuperId
	}*/
	/*public static void main(String[] args) {
		SqlSession session=SqlSessionFactory.openSession();
		SysDicDao dao=session.getMapper(SysDicDao.class);
		System.out.println("dicList--"+dao.findSysDicBySuperId("0"));
		
	}*/



}
