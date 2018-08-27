package com.cnj.activitiPro.system.dao;

import java.util.List;

import com.cnj.activitiPro.system.domain.SysDic;

public interface SysDicDao {
	List<SysDic> findSysDicBySuperId(String superId);
	
}
