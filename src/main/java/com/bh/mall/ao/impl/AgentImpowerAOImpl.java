package com.bh.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bh.mall.ao.IAgentImpowerAO;
import com.bh.mall.bo.IAgentImpowerBO;
import com.bh.mall.bo.base.Page;
import com.bh.mall.bo.base.Paginable;
import com.bh.mall.domain.AgentImpower;
import com.bh.mall.exception.BizException;

@Service
public class AgentImpowerAOImpl implements IAgentImpowerAO {

	@Autowired
	IAgentImpowerBO agentImpowerBO;

	@Override
	@Transactional
	public int editAgentImpower(AgentImpower data) {
		return agentImpowerBO.updateAgentImpower(data);
	}


	@Override
	@Transactional
	public List<AgentImpower> selectList(String code) {
		AgentImpower data = getAgentImpower(code);
		if(data == null) {
			throw new BizException("xn0000", "该代理不存在");
		}
		return agentImpowerBO.queryList(data.getAgentCode());
	}

	@Override
	@Transactional
	public AgentImpower getAgentImpower(String code) {
		return agentImpowerBO.getAgentImpower(code);
	}


	@Override
	@Transactional
	public Paginable<AgentImpower> selectPageList(AgentImpower condition, int start, int limit) {
		Paginable<AgentImpower> list = agentImpowerBO.getPaginable(start, limit, condition);
		return list;
	}

	

}