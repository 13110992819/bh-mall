package com.bh.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.bh.mall.ao.ICompanyChannelAO;
import com.bh.mall.api.AProcessor;
import com.bh.mall.common.JsonUtil;
import com.bh.mall.core.StringValidater;
import com.bh.mall.domain.CompanyChannel;
import com.bh.mall.dto.req.XN627780Req;
import com.bh.mall.exception.BizException;
import com.bh.mall.exception.ParaException;
import com.bh.mall.spring.SpringContextHolder;

/**
 * 分页查询渠道公司
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:36:59 
 * @history:
 */
public class XN627780 extends AProcessor {
    private ICompanyChannelAO companyChannelAO = SpringContextHolder
        .getBean(ICompanyChannelAO.class);

    private XN627780Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        CompanyChannel condition = new CompanyChannel();
        condition.setSystemCode(req.getSystemCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCompanyName(req.getCompanyName());
        condition.setChannelType(req.getChannelType());
        condition.setStatus(req.getStatus());
        condition.setChannelCompany(req.getChannelCompany());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICompanyChannelAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return companyChannelAO
            .queryCompanyChannelPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN627780Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
        StringValidater.validateBlank(req.getSystemCode());
    }
}
