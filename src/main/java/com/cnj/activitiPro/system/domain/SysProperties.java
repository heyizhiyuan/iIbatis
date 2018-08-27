package com.cnj.activitiPro.system.domain;

import java.sql.Timestamp;

public class SysProperties {
	
	

	private String id;
	
	private String parentId;
	
	private int hasChild;
	
	private String itemName;
	
	private String itemValue;
	
	private String itemCode;
	
	private int isDisable;
	
	private int level;
	
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	private Timestamp editTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getHasChild() {
		return hasChild;
	}

	public void setHasChild(int hasChild) {
		this.hasChild = hasChild;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(int isDisable) {
		this.isDisable = isDisable;
	}

	public Timestamp getEditTime() {
		return editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}
	@Override
	public String toString() {
		return "SysProperties [id=" + id + ", parentId=" + parentId + ", hasChild=" + hasChild + ", itemName="
				+ itemName + ", itemValue=" + itemValue + ", itemCode=" + itemCode + ", isDisable=" + isDisable
				+ ", level=" + level + ", status=" + status + ", editTime=" + editTime + "]";
	}
	
}
