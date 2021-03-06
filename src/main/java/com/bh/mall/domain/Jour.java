package com.bh.mall.domain;

import java.util.Date;
import java.util.List;

import com.bh.mall.dao.base.ABaseDO;

/**
 * 账户流水订单
 * @author: xieyj 
 * @since: 2016年11月10日 下午5:48:27 
 * @history:
 */
public class Jour extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1255747682967604091L;

    // 流水编号
    private String code;

    // 订单分组组号（信息代表）---核心字段1
    private String payGroup;

    // 流水分组组号（橙账本代表）---核心字段2
    private String refNo;

    // 支付渠道单号（支付渠道代表）---核心字段3
    private String channelOrder;

    // 流水所属账号---核心字段4
    private String accountNumber;

    // 变动金额（有正负之分）---核心字段5
    private Long transAmount;

    // 流水所属用户编号
    private String userId;

    // 流水所属真实姓名
    private String realName;

    // 类型(B B端账号，C C端账号，P 平台账号)
    private String type;

    // 币种
    private String currency;

    // 业务类型
    private String bizType;

    // 业务说明
    private String bizNote;

    // 变动前金额
    private Long preAmount;

    // 变动后金额
    private Long postAmount;

    // 状态
    private String status;

    // 备注
    private String remark;

    // 创建时间
    private Date createDatetime;

    // 支付渠道（线下/招商代付/支付宝/内部转账）
    private String channelType;

    // ***********************db properties *************************
    // 业务类型列表
    private List<String> bizTypeList;

    private Order orderInformation;

    private User userInformation;

    // 查询条件1：创建起始时间
    private Date createDatetimeStart;

    // 查询条件2：创建终止时间
    private Date createDatetimeEnd;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getBizTypeList() {
        return bizTypeList;
    }

    public void setBizTypeList(List<String> bizTypeList) {
        this.bizTypeList = bizTypeList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDatetimeStart() {
        return createDatetimeStart;
    }

    public void setCreateDatetimeStart(Date createDatetimeStart) {
        this.createDatetimeStart = createDatetimeStart;
    }

    public Date getCreateDatetimeEnd() {
        return createDatetimeEnd;
    }

    public void setCreateDatetimeEnd(Date createDatetimeEnd) {
        this.createDatetimeEnd = createDatetimeEnd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizNote() {
        return bizNote;
    }

    public void setBizNote(String bizNote) {
        this.bizNote = bizNote;
    }

    public Long getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Long transAmount) {
        this.transAmount = transAmount;
    }

    public Long getPreAmount() {
        return preAmount;
    }

    public void setPreAmount(Long preAmount) {
        this.preAmount = preAmount;
    }

    public Long getPostAmount() {
        return postAmount;
    }

    public void setPostAmount(Long postAmount) {
        this.postAmount = postAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getChannelOrder() {
        return channelOrder;
    }

    public void setChannelOrder(String channelOrder) {
        this.channelOrder = channelOrder;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getPayGroup() {
        return payGroup;
    }

    public void setPayGroup(String payGroup) {
        this.payGroup = payGroup;
    }

    public Order getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(Order orderInformation) {
        this.orderInformation = orderInformation;
    }

    public User getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(User userInformation) {
        this.userInformation = userInformation;
    }

}
