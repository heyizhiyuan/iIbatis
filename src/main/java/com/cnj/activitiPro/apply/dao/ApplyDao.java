package com.cnj.activitiPro.apply.dao;

import com.cnj.activitiPro.apply.vo.ApplyContractVO;

public interface ApplyDao {
	ApplyContractVO findApplyListAll(String applyCode) ;
}
