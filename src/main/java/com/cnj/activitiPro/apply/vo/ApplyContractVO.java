package com.cnj.activitiPro.apply.vo;

public class ApplyContractVO {
	private String id;
	private String contractCode;
	private String applyId;
	private String unitName1;
	private String unitName2;
	private String unitName3;
	private String unitName4;
	private String insNum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getUnitName1() {
		return unitName1;
	}
	public void setUnitName1(String unitName1) {
		this.unitName1 = unitName1;
	}
	public String getUnitName2() {
		return unitName2;
	}
	public void setUnitName2(String unitName2) {
		this.unitName2 = unitName2;
	}
	public String getUnitName3() {
		return unitName3;
	}
	public void setUnitName3(String unitName3) {
		this.unitName3 = unitName3;
	}
	public String getUnitName4() {
		return unitName4;
	}
	public void setUnitName4(String unitName4) {
		this.unitName4 = unitName4;
	}
	public String getInsNum() {
		return insNum;
	}
	public void setInsNum(String insNum) {
		this.insNum = insNum;
	}
	@Override
	public String toString() {
		return "ApplyContractVO [id=" + id + ", contractCode=" + contractCode + ", applyId=" + applyId + ", unitName1="
				+ unitName1 + ", unitName2=" + unitName2 + ", unitName3=" + unitName3 + ", unitName4=" + unitName4
				+ ", insNum=" + insNum + "]";
	}
	
}
