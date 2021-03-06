package com.bh.mall.domain;

import java.util.Date;

import com.bh.mall.dao.base.ABaseDO;

/**
* 产品订单
* @author: chenshan 
* @since: 2018-03-28 10:30:22
* @history:
*/
public class Order extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 是否云仓发货
    private String isCompanySend;

    // 分类
    private String kind;

    // 产品编号
    private String productCode;

    // 产品名称
    private String productName;

    // 规格编号
    private String productSpecsCode;

    // 规格名称
    private String productSpecsName;

    // 图片
    private String pic;

    // 数量
    private Integer quantity;

    // 单价
    private Long price;

    // 向谁提货
    private String toUser;

    // 单价
    private Long amount;

    // 运费
    private Long yunfei;

    // 状态
    private String status;

    // 支付渠道
    private String payType;

    // 支付组号
    private String payGroup;

    // 支付金额
    private Long payAmount;

    // 支付时间
    private Date payDatetime;

    // 渠道编号
    private String payCode;

    // 下单人
    private String applyUser;

    // 下单备注
    private String applyNote;

    // 下单时间
    private Date applyDatetime;

    // 收件人姓名
    private String signer;

    // 收件人电话
    private String mobile;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String area;

    // 收货地址
    private String address;

    // 发货人
    private String deliver;

    // 发货时间
    private Date deliveDatetime;

    // 物流单号
    private String logisticsCode;

    // 物流公司
    private String logisticsCompany;

    // 物流单
    private String pdf;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 更新备注
    private String updateNote;

    // 审核人
    private String approver;

    // 审核时间
    private Date approveDatetime;

    // 审核备注
    private String approveNote;

    // 备注
    private String remark;

    // 是否送货到家
    private String isSendHome;

    // ************************db*********************
    private Date startDatetime;

    private Date endDatetime;

    private String statusForQuery;

    private String statusList;

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getIsSendHome() {
        return isSendHome;
    }

    public void setIsSendHome(String isSendHome) {
        this.isSendHome = isSendHome;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setIsCompanySend(String isCompanySend) {
        this.isCompanySend = isCompanySend;
    }

    public String getIsCompanySend() {
        return isCompanySend;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductSpecsCode(String productSpecsCode) {
        this.productSpecsCode = productSpecsCode;
    }

    public String getProductSpecsCode() {
        return productSpecsCode;
    }

    public void setProductSpecsName(String productSpecsName) {
        this.productSpecsName = productSpecsName;
    }

    public String getProductSpecsName() {
        return productSpecsName;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getYunfei() {
        return yunfei;
    }

    public void setYunfei(Long yunfei) {
        this.yunfei = yunfei;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayGroup() {
        return payGroup;
    }

    public void setPayGroup(String payGroup) {
        this.payGroup = payGroup;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getStatusList() {
        return statusList;
    }

    public void setStatusList(String statusList) {
        this.statusList = statusList;
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

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public Date getDeliveDatetime() {
        return deliveDatetime;
    }

    public void setDeliveDatetime(Date deliveDatetime) {
        this.deliveDatetime = deliveDatetime;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUpdateNote() {
        return updateNote;
    }

    public void setUpdateNote(String updateNote) {
        this.updateNote = updateNote;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getApproveDatetime() {
        return approveDatetime;
    }

    public void setApproveDatetime(Date approveDatetime) {
        this.approveDatetime = approveDatetime;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatusForQuery() {
        return statusForQuery;
    }

    public void setStatusForQuery(String statusForQuery) {
        this.statusForQuery = statusForQuery;
    }

}
