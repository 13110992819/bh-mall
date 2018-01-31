package com.bh.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.bh.mall.ao.IAgentImpowerAO;
import com.bh.mall.api.AProcessor;
import com.bh.mall.core.StringValidater;
import com.bh.mall.domain.AgentImpower;
import com.bh.mall.dto.req.XN627015Req;
import com.bh.mall.exception.BizException;
import com.bh.mall.exception.ParaException;
import com.bh.mall.http.JsonUtils;
import com.bh.mall.spring.SpringContextHolder;

/**
 * 分页查询代理授权
 * @author nyc
 *
 */
public class XN627015 extends AProcessor {

    private IAgentImpowerAO agentImpowerAO = SpringContextHolder
        .getBean(IAgentImpowerAO.class);

    private XN627015Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        AgentImpower condition = new AgentImpower();
        condition.setAgentCode(req.getAgentCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IAgentImpowerAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return agentImpowerAO
            .queryAgentImpowerListPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN627015Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
