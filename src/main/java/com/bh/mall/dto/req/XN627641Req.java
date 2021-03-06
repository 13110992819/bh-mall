package com.bh.mall.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 无购物车提交订单
 * @author: nyc 
 * @since: 2018年3月28日 上午10:34:21 
 * @history:
 */
public class XN627641Req {

    // 购物车订单编号列表
    @NotBlank(message = "产品规格编号不能为空")
    private String productSpecsCode;

    // （必填）下单人
    @NotBlank(message = "下单人不能为空")
    private String applyUser;

    // （选填）下单备注
    private String applyNote;

    // （必填）订单归属人
    @NotBlank(message = "订单归属人不能为空")
    private String toUser;

    // （必填）收件人
    @NotBlank(message = "收件人不能为空")
    private String signer;

    // （必填）收件人电话
    @NotBlank(message = "收件人电话不能为空")
    private String mobile;

    // （必填）收货地址
    @NotBlank(message = "收货地址不能为空")
    private String address;

    // （必填）区
    @NotBlank(message = "区不能为空")
    private String area;

    // （必填）市
    @NotBlank(message = "市不能为空")
    private String city;

    // （必填）省
    @NotBlank(message = "省不能为空")
    private String province;

    // 是否送货到家
    @NotBlank(message = "是否送货到家")
    private String isSendHome;

    // 数量
    @NotBlank(message = "数量不能为空")
    private String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getIsSendHome() {
        return isSendHome;
    }

    public void setIsSendHome(String isSendHome) {
        this.isSendHome = isSendHome;
    }

    public String getProductSpecsCode() {
        return productSpecsCode;
    }

    public void setProductSpecsCode(String productSpecsCode) {
        this.productSpecsCode = productSpecsCode;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
