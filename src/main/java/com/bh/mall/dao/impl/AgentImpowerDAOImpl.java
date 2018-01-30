package com.bh.mall.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.bh.mall.dao.IAgentImPowerDAO;
import com.bh.mall.dao.base.support.AMybatisTemplate;
import com.bh.mall.domain.AgentImpower;

@Repository("agentImpowerDAOImpl")
public class AgentImpowerDAOImpl extends AMybatisTemplate implements IAgentImPowerDAO {

	@Override
	public AgentImpower select(AgentImpower condition) {
		return super.select(NAMESPACE.concat("get_agentImpower"), condition, AgentImpower.class);
	}

	@Override
	public long selectTotalCount(AgentImpower condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_count"), condition);
	}

	@Override
	public int update(AgentImpower data) {
		return super.update(NAMESPACE.concat("update_agentImpower"), data);
	}

	@Override
	public List<AgentImpower> selectList(AgentImpower condition, int start, int pageSize) {
		return super.selectList(NAMESPACE.concat("select_agentImpower"), start, pageSize, condition, AgentImpower.class);
	}

	@Override
	public List<AgentImpower> selectList(AgentImpower condition) {
		return super.selectList(NAMESPACE.concat("select_agentImpower"), condition, AgentImpower.class);
	}

	@Override
	public AgentImpower getAgentImpower(AgentImpower condition) {
		return super.select(NAMESPACE.concat("get_agentImpower"), condition, AgentImpower.class);
	}

	@Override
	public int insert(AgentImpower data) {
		// XXX Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(AgentImpower data) {
		// XXX Auto-generated method stub
		return 0;
	}

}
