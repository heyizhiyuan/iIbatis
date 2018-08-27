package com.cnj.activitiPro.system.domain;

import java.math.BigDecimal;

public class SysDic {
	
	private String dicId;
	private String dicName;
	private String dicValue;
	private String dicCode;
	private String appDicId;
	private String superDicId;
	private BigDecimal dicLevel;
	private String isLeaf;
	private String manageOrgno;
	private String manageDepno;
	private BigDecimal dispOrder;
	private String status;
	private String creator;
	private String createTime;
	private String editor;
	private String editTime;
	@Override
	public String toString() {
		return "SysDic [dicId=" + dicId + ", dicName=" + dicName + ", dicValue=" + dicValue + ", dicCode=" + dicCode
				+ ", appDicId=" + appDicId + ", superDicId=" + superDicId + ", dicLevel=" + dicLevel + ", isLeaf="
				+ isLeaf + ", manageOrgno=" + manageOrgno + ", manageDepno=" + manageDepno + ", dispOrder=" + dispOrder
				+ ", status=" + status + ", creator=" + creator + ", createTime=" + createTime + ", editor=" + editor
				+ ", editTime=" + editTime + "]";
	}
	public final String getDicId() {
		return dicId;
	}
	public final void setDicId(String dicId) {
		this.dicId = dicId;
	}
	public final String getDicName() {
		return dicName;
	}
	public final void setDicName(String dicName) {
		this.dicName = dicName;
	}
	public final String getDicValue() {
		return dicValue;
	}
	public final void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}
	public final String getDicCode() {
		return dicCode;
	}
	public final void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}
	public final String getAppDicId() {
		return appDicId;
	}
	public final void setAppDicId(String appDicId) {
		this.appDicId = appDicId;
	}
	public final String getSuperDicId() {
		return superDicId;
	}
	public final void setSuperDicId(String superDicId) {
		this.superDicId = superDicId;
	}
	public final BigDecimal getDicLevel() {
		return dicLevel;
	}
	public final void setDicLevel(BigDecimal dicLevel) {
		this.dicLevel = dicLevel;
	}
	public final String getIsLeaf() {
		return isLeaf;
	}
	public final void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public final String getManageOrgno() {
		return manageOrgno;
	}
	public final void setManageOrgno(String manageOrgno) {
		this.manageOrgno = manageOrgno;
	}
	public final String getManageDepno() {
		return manageDepno;
	}
	public final void setManageDepno(String manageDepno) {
		this.manageDepno = manageDepno;
	}
	public final BigDecimal getDispOrder() {
		return dispOrder;
	}
	public final void setDispOrder(BigDecimal dispOrder) {
		this.dispOrder = dispOrder;
	}
	public final String getStatus() {
		return status;
	}
	public final void setStatus(String status) {
		this.status = status;
	}
	public final String getCreator() {
		return creator;
	}
	public final void setCreator(String creator) {
		this.creator = creator;
	}
	public final String getCreateTime() {
		return createTime;
	}
	public final void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public final String getEditor() {
		return editor;
	}
	public final void setEditor(String editor) {
		this.editor = editor;
	}
	public final String getEditTime() {
		return editTime;
	}
	public final void setEditTime(String editTime) {
		this.editTime = editTime;
	}

	
	
	
	
}
