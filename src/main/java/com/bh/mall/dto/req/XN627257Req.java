package com.bh.mall.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 审核授权
 * @author: nyc 
 * @since: 2018年3月29日 下午6:28:14 
 * @history:
 */
public class XN627257Req {

    // （必填）编号
    @NotBlank(message = "编号不能为空")
    private String userId;

    // （必填） 审核人
    @NotBlank(message = " 审核人不能为空")
    private String approver;

    // （必填）结果;（0，不通过，1 通过）
    @NotBlank(message = "结果不能为空")
    private String result;

    // （选填）审核备注
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
