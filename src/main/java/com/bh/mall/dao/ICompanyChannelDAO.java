package com.bh.mall.dao;

import com.bh.mall.dao.base.IBaseDAO;
import com.bh.mall.domain.CompanyChannel;

/**
 * @author: xieyj 
 * @since: 2016年11月10日 下午7:46:21 
 * @history:
 */
public interface ICompanyChannelDAO extends IBaseDAO<CompanyChannel> {
    String NAMESPACE = ICompanyChannelDAO.class.getName().concat(".");

    /**
     * 更新公司渠道
     * @param data
     * @return 
     * @create: 2016年11月10日 下午7:46:43 xieyj
     * @history:
     */
    public int update(CompanyChannel data);
}
