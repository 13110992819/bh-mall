package com.bh.mall.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改收货地址以及运费
 * @author: nyc 
 * @since: 2018年3月27日 下午4:51:33 
 * @history:
 */
public class XN627722Req {

    // （必填）订单编号
    @NotBlank(message = "不能为空")
    private String code;

    // （必填）收货人
    @NotBlank(message = "不能为空")
    private String signer;

    // （必填）收货电话
    @NotBlank(message = "不能为空")
    private String mobile;

    // （必填）收货省
    @NotBlank(message = "不能为空")
    private String province;

    // （必填）收货市
    @NotBlank(message = "不能为空")
    private String city;

    // （必填）收货区
    @NotBlank(message = "不能为空")
    private String area;

    // （必填）收货地址
    @NotBlank(message = "不能为空")
    private String address;

    // （必填）更新人
    @NotBlank(message = "不能为空")
    private String updater;

    // （选填）备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
