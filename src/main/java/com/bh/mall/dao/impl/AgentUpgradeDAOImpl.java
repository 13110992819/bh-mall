package com.bh.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bh.mall.dao.IAgentUpgradeDAO;
import com.bh.mall.dao.base.support.AMybatisTemplate;
import com.bh.mall.domain.AgentUpgrade;

@Repository("agentUpgradeDAOImpl")
public class AgentUpgradeDAOImpl extends AMybatisTemplate implements
        IAgentUpgradeDAO {

    @Override
    public long selectTotalCount(AgentUpgrade condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_agentUpgrade_count"), condition);
    }

    @Override
    public void update(AgentUpgrade data) {
        super.update(NAMESPACE.concat("update_agentUpgrade"), data);
    }

    @Override
    public List<AgentUpgrade> selectList(AgentUpgrade condition, int start,
            int pageSize) {
        return super.selectList(NAMESPACE.concat("select_agentUpgrade"), start,
            pageSize, condition, AgentUpgrade.class);
    }

    @Override
    public List<AgentUpgrade> selectList(AgentUpgrade condition) {
        return super.selectList(NAMESPACE.concat("select_agentUpgrade"),
            condition, AgentUpgrade.class);

    }

    @Override
    public AgentUpgrade select(AgentUpgrade condition) {
        return super.select(NAMESPACE.concat("select_agentUpgrade"), condition,
            AgentUpgrade.class);
    }

    @Override
    public int insert(AgentUpgrade data) {
        // XXX Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(AgentUpgrade data) {
        // XXX Auto-generated method stub
        return 0;
    }

}
