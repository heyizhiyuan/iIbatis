package com.cnj.orm.iIbatis.test;

import org.junit.Test;

import com.cnj.activitiPro.system.dao.SysDicDao;
import com.cnj.orm.iIbatis.session.SqlSession;
import com.cnj.orm.iIbatis.session.SqlSessionFactory;

public class IIbatisTest {
	
	@Test
	public void test01(){
		long start=System.currentTimeMillis();
		System.out.println();
		SqlSession session=SqlSessionFactory.openSession();
		SysDicDao dao=session.getMapper(SysDicDao.class);
		System.out.println("dicList--"+dao.findSysDicBySuperId("0"));
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		SysDicDao dao1=session.getMapper(SysDicDao.class);
		System.out.println("dicList--"+dao1.findSysDicBySuperId("0"));
		System.out.println(System.currentTimeMillis()-end);
	}

}






