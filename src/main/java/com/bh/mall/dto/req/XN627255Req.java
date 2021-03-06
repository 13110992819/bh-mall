package com.bh.mall.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 通过
 * @author: nyc 
 * @since: 2018年3月29日 下午6:28:14 
 * @history:
 */
public class XN627255Req {

    // （必填）用户编号
    @NotBlank(message = "用户编号不能为空")
    private String userId;

    // （必填）代理等级
    @NotBlank(message = "代理等级不能为空")
    private String level;

    // （必填） 详细地址
    @NotBlank(message = "详细地址不能为空")
    private String address;

    // （必填）省
    @NotBlank(message = "省不能为空")
    private String province;

    // （必填）市
    @NotBlank(message = "市不能为空")
    private String city;

    // （必填）区
    @NotBlank(message = "区不能为空")
    private String area;

    // （必填）微信号
    @NotBlank(message = "微信号不能为空")
    private String wxId;

    // （必填）电话
    @NotBlank(message = "电话不能为空")
    private String mobile;

    // （选填）姓名
    private String realName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
