package com.bh.mall.ao;

import java.util.List;

import com.bh.mall.bo.base.Paginable;
import com.bh.mall.domain.CompanyChannel;

public interface ICompanyChannelAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addCompanyChannel(CompanyChannel data);

    public void dropCompanyChannel(Long id);

    public void editCompanyChannel(CompanyChannel data);

    public Paginable<CompanyChannel> queryCompanyChannelPage(int start,
            int limit, CompanyChannel condition);

    public List<CompanyChannel> queryCompanyChannelList(CompanyChannel condition);

    public CompanyChannel getCompanyChannel(Long id);
}
