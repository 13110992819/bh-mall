package com.bh.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bh.mall.bo.IAgentImpowerBO;
import com.bh.mall.bo.base.PaginableBOImpl;
import com.bh.mall.dao.IAgentImPowerDAO;
import com.bh.mall.domain.AgentImpower;
import com.bh.mall.exception.BizException;

@Component
public class AgentImpowerBOImpl extends PaginableBOImpl<AgentImpower>
        implements IAgentImpowerBO {

    @Autowired
    private IAgentImPowerDAO agentImPowerDAO;

    @Override
    public void editAgentImpower(AgentImpower data) {
        agentImPowerDAO.update(data);
    }

    @Override
    public AgentImpower getAgentImpower(String code) {
        AgentImpower data = null;
        if (StringUtils.isNotBlank(code)) {
            AgentImpower condition = new AgentImpower();
            condition.setCode(code);
            data = agentImPowerDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "代理授权编号不存在");
            }
        }
        return data;
    }

    @Override
    public List<AgentImpower> queryAgentImpowerList(AgentImpower condition) {
        return agentImPowerDAO.selectList(condition);
    }

    @Override
    public AgentImpower getAgentImpowerByLevel(Integer level) {
        AgentImpower condition = new AgentImpower();
        condition.setLevel(level);
        return agentImPowerDAO.select(condition);

    }

}
