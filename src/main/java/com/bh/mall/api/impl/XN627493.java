package com.bh.mall.api.impl;

import com.bh.mall.ao.IJourAO;
import com.bh.mall.api.AProcessor;
import com.bh.mall.common.JsonUtil;
import com.bh.mall.core.StringValidater;
import com.bh.mall.domain.Jour;
import com.bh.mall.dto.req.XN627493Req;
import com.bh.mall.exception.BizException;
import com.bh.mall.exception.ParaException;
import com.bh.mall.spring.SpringContextHolder;

/**
 * 根据业务订单编号(refNo)查询所有关联流水(front/oss)
 * @author: xieyj 
 * @since: 2016年12月24日 上午8:17:00 
 * @history:
 */
public class XN627493 extends AProcessor {

    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN627493Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Jour condition = new Jour();
        condition.setRefNo(req.getRefNo());
        return jourAO.queryJourList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN627493Req.class);
        StringValidater.validateBlank(req.getRefNo(), req.getSystemCode());
    }
}
