package com.bh.mall.api.impl;

import com.bh.mall.ao.IMaterialAO;
import com.bh.mall.api.AProcessor;
import com.bh.mall.core.ObjValidater;
import com.bh.mall.dto.req.XN627421Req;
import com.bh.mall.dto.res.BooleanRes;
import com.bh.mall.exception.BizException;
import com.bh.mall.exception.ParaException;
import com.bh.mall.http.JsonUtils;
import com.bh.mall.spring.SpringContextHolder;

/**
 * 修改素材
 * @author: nyc 
 * @since: 2018年2月1日 上午10:02:18 
 * @history:
 */
public class XN627421 extends AProcessor {

    private IMaterialAO materialAO = SpringContextHolder
        .getBean(IMaterialAO.class);

    private XN627421Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        materialAO.editMaterial(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN627421Req.class);
        ObjValidater.validateReq(req);
    }

}
