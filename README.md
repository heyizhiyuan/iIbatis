# iIbatis
手写mybatis
例子：
@Test
	public void test01(){
		long start=System.currentTimeMillis();
		SqlSession session=SqlSessionFactory.openSession();
		SysDicDao dao=session.getMapper(SysDicDao.class);
		System.out.println("dicList--"+dao.findSysDicBySuperId("0"));
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		SysDicDao dao1=session.getMapper(SysDicDao.class);
		System.out.println("dicList--"+dao1.findSysDicBySuperId("0"));
		System.out.println(System.currentTimeMillis()-end);
	}
