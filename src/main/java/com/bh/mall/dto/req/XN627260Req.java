package com.bh.mall.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改推荐人
 * @author: nyc 
 * @since: 2018年4月1日 上午10:58:40 
 * @history:
 */
public class XN627260Req {

    // （必填）编号
    @NotBlank(message = "编号不能为空")
    private String userId;

    // （必填）上级
    @NotBlank(message = "上级不能为空")
    private String userReferee;

    // （选填）更新人
    @NotBlank(message = "更新人不能为空")
    private String updater;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
