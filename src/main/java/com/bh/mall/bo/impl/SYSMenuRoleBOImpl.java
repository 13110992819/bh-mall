/**
 * @Title SYSMenuRoleBOImpl.java 
 * @Package com.std.security.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月17日 上午8:58:08 
 * @version V1.0   
 */
package com.bh.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bh.mall.bo.ISYSMenuRoleBO;
import com.bh.mall.bo.base.PaginableBOImpl;
import com.bh.mall.dao.ISYSMenuRoleDAO;
import com.bh.mall.domain.SYSMenu;
import com.bh.mall.domain.SYSMenuRole;

/** 
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:58:08 
 * @history:
 */
@Component
public class SYSMenuRoleBOImpl extends PaginableBOImpl<SYSMenuRole> implements
        ISYSMenuRoleBO {

    @Autowired
    private ISYSMenuRoleDAO sysMenuRoleDAO;

    @Override
    public int saveSYSMenuRole(SYSMenuRole data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = sysMenuRoleDAO.insert(data);
        }
        return count;
    }

    @Override
    public int removeSYSMenuRoleByRole(String roleCode) {
        int count = 0;
        if (StringUtils.isNotBlank(roleCode)) {
            SYSMenuRole condition = new SYSMenuRole();
            condition.setRoleCode(roleCode);
            count = sysMenuRoleDAO.deleteSYSMenuRoleByRole(condition);
        }
        return count;
    }

    @Override
    public List<SYSMenu> querySYSMenuList(SYSMenuRole data) {
        return sysMenuRoleDAO.selectSYSMenuList(data);
    }

    /** 
     * @see com.bh.mall.bo.ISYSMenuRoleBO#removeSYSMenuRoleByMenu(java.lang.String)
     */
    @Override
    public int removeSYSMenuRoleByMenu(String menuCode) {
        int count = 0;
        if (StringUtils.isNotBlank(menuCode)) {
            SYSMenuRole condition = new SYSMenuRole();
            condition.setMenuCode(menuCode);
            count = sysMenuRoleDAO.deleteSYSMenuRoleByMenu(condition);
        }
        return count;
    }
}
