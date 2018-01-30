package com.bh.mall.domain;

import com.bh.mall.dao.base.ABaseDO;

public class Agent extends ABaseDO{
	
	/**
	 * tbh
	 */
	private static final long serialVersionUID = -8708365669948607235L;


	// 编号
	private String code;
	
	// 等级名称
	private String name;
	
	// 等级
	private String level;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}