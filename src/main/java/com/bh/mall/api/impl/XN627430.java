package com.bh.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.bh.mall.ao.IMaterialAO;
import com.bh.mall.api.AProcessor;
import com.bh.mall.core.StringValidater;
import com.bh.mall.domain.Material;
import com.bh.mall.dto.req.XN627430Req;
import com.bh.mall.exception.BizException;
import com.bh.mall.exception.ParaException;
import com.bh.mall.http.JsonUtils;
import com.bh.mall.spring.SpringContextHolder;

/**
 * 素材分页查询
 * @author: nyc 
 * @since: 2018年2月1日 下午4:50:45 
 * @history:
 */
public class XN627430 extends AProcessor {

    private IMaterialAO materialAO = SpringContextHolder
        .getBean(IMaterialAO.class);

    private XN627430Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Material condition = new Material();
        condition.setLevel(req.getLevelList());
        condition.setStatus(req.getStatus());
        condition.setTitle(req.getTitle());
        condition.setType(req.getType());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IMaterialAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return materialAO.queryMaterialListPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN627430Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
