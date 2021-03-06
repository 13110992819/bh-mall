package com.bh.mall.dto.req;

import javax.validation.constraints.NotNull;

/**
 * 查询代理详情
 * @author: nyc 
 * @since: 2018年1月31日 下午2:50:03 
 * @history:
 */
public class XN627007Req {

    // 编号 （必填）
    @NotNull(message = "等级不能为空")
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
