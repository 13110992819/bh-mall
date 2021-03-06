package com.bh.mall.ao;

import java.util.List;

import com.bh.mall.bo.base.Paginable;
import com.bh.mall.domain.Agent;

public interface IAgentAO {

    String DEFAULT_ORDER_COLUMN = "level";

    /**
     * 修改代理
     * @param level
     * @param name 
     * @param amount 
     * @param minChargeAmount 
     * @param redAmount 
     * @param updater 
     * @param remark
     * @create: 2018年1月31日 上午9:45:54 chenshan
     * @history:
     */
    public void editAgent(String level, String name, String amount,
            String minChargeAmount, String redAmount, String updater,
            String remark);

    /**
     * 分页查询代理
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2018年1月31日 下午2:30:59 nyc
     * @history:
     */
    public Paginable<Agent> queryAgentListPage(int start, int limit,
            Agent condition);

    /**
     * 查询代理详情
     * @param level
     * @return 
     * @create: 2018年1月31日 下午2:31:14 nyc
     * @history:
     */
    public Agent getAgent(String level);

    /**
     * 列表查询代理
     * @param condition
     * @return 
     * @create: 2018年1月31日 下午2:31:23 nyc
     * @history:
     */
    public List<Agent> queryAgentList(Agent condition);

}
