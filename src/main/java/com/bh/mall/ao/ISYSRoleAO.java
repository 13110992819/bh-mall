package com.bh.mall.ao;

import java.util.List;

import com.bh.mall.bo.base.Paginable;
import com.bh.mall.domain.SYSRole;

/**
 * @author: Gejin 
 * @since: 2016年4月16日 下午9:18:16 
 * @history:
 */
public interface ISYSRoleAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String addSYSRole(SYSRole data);

    public boolean dropSYSRole(String roleCode);

    public boolean editSYSRole(SYSRole data);

    public List<SYSRole> querySYSRoleList(SYSRole condition);

    public Paginable<SYSRole> querySYSRolePage(int start, int limit,
            SYSRole condition);

    public SYSRole getSYSRole(String code);

}
