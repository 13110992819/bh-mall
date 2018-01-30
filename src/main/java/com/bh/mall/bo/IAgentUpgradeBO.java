package com.bh.mall.bo;

import java.util.List;

import com.bh.mall.bo.base.IPaginableBO;
import com.bh.mall.domain.AgentUpgrade;

public interface IAgentUpgradeBO extends IPaginableBO<AgentUpgrade> {

	public int updateAgentUpgrade(AgentUpgrade data);
	
	public List<AgentUpgrade> queryList(AgentUpgrade condition);
	
	public List<AgentUpgrade> queryList(AgentUpgrade condition, int start, int limit);
	
	public AgentUpgrade getAgentUpgrade(String code);
}
