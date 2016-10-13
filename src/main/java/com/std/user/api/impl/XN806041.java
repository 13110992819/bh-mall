package com.std.user.api.impl;

import com.std.user.ao.ICBannerAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN806041Req;
import com.std.user.dto.res.BooleanRes;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/** 
 * 删除Banner
 * @author: zuixian 
 * @since: 2016年10月10日 下午3:58:13 
 * @history:
 */
public class XN806041 extends AProcessor {
    private ICBannerAO cBannerAO = SpringContextHolder
        .getBean(ICBannerAO.class);

    private XN806041Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        int count = cBannerAO.dropCBanner(req.getCode());
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN806041Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
