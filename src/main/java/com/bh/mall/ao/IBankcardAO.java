package com.bh.mall.ao;

import java.util.List;

import com.bh.mall.bo.base.Paginable;
import com.bh.mall.domain.Bankcard;
import com.bh.mall.dto.req.XN627520Req;
import com.bh.mall.dto.req.XN802012Req;
import com.bh.mall.dto.req.XN802013Req;

/**
 * @author: xieyj 
 * @since: 2017年6月7日 下午10:34:08 
 * @history:
 */
public interface IBankcardAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBankcard(XN627520Req req);

    public void dropBankcard(String code);

    public void editBankcard(XN802012Req req);

    public void editBankcard(XN802013Req req);

    public Paginable<Bankcard> queryBankcardPage(int start, int limit,
            Bankcard condition);

    public List<Bankcard> queryBankcardList(Bankcard condition);

    public Bankcard getBankcard(String code);

}
