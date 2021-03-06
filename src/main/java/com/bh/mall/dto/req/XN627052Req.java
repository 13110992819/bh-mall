package com.bh.mall.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN627052Req {
    // 编号(必填)
    @NotBlank
    private String code;

    // 菜单名称(必填)
    @NotBlank
    private String name;

    // 请求url(必填)
    @NotBlank
    private String url;

    // 父菜单编号(必填)
    @NotBlank
    private String parentCode;

    // 类型(必填)
    @NotBlank
    private String type;

    // 菜单顺序号（必填）
    @NotBlank
    private String orderNo;

    // 更新人(必填)
    @NotBlank
    private String updater;

    // 备注(选填)
    private String remark;

    // 系统编号（必填）
    @NotBlank
    private String systemCode;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
