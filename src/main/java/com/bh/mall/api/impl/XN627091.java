package com.bh.mall.api.impl;

import com.bh.mall.api.AProcessor;
import com.bh.mall.common.JsonUtil;
import com.bh.mall.core.ObjValidater;
import com.bh.mall.dto.req.XN627091Req;
import com.bh.mall.dto.res.XN805951Res;
import com.bh.mall.exception.BizException;
import com.bh.mall.exception.ParaException;
import com.bh.mall.spring.SpringContextHolder;
import com.bh.mall.third.qiniu.impl.QnTokenImpl;

/**
 * 根据系统编号获取七牛uploadToken
 * @author: xieyj 
 * @since: 2016年10月11日 上午9:45:51 
 * @history:
 */
public class XN627091 extends AProcessor {
    private QnTokenImpl qnTokenImpl = SpringContextHolder
        .getBean(QnTokenImpl.class);

    private XN627091Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XN805951Res(qnTokenImpl.getUploadToken(req.getCompanyCode(),
            req.getSystemCode()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN627091Req.class);
        ObjValidater.validateReq(req);
    }
}
