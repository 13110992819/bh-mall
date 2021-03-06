package com.bh.mall.bo;

import java.util.List;

import com.bh.mall.bo.base.IPaginableBO;
import com.bh.mall.domain.Agent;

public interface IAgentBO extends IPaginableBO<Agent> {

    public void editAgent(Agent data, String name, String amount,
            String minChargeAmount, String redAmount, String updater,
            String remark);

    public Agent getAgent(String code);

    public List<Agent> queryAgentList(Agent condition);

}
