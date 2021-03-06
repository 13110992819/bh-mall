package com.bh.mall.dto.req;

/**
 * 提现回录
 * @author: xieyj 
 * @since: 2017年5月12日 上午10:02:36 
 * @history:
 */
public class XN627504Req {
    // 针对账号（必填）
    private String accountNumber;

    // 取现金额（必填）
    private String amount;

    // 支付时间（必填）
    private String payDatetime;

    // 支付渠道账号信息（如开户支行）（必填）
    private String payCardInfo;

    // 支付渠道账号（如银行卡号）（必填）
    private String payCardNo;

    // 申请人（必填）
    private String applyUser;

    // 申请说明（选填）
    private String applyNote;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayCardInfo() {
        return payCardInfo;
    }

    public void setPayCardInfo(String payCardInfo) {
        this.payCardInfo = payCardInfo;
    }

    public String getPayCardNo() {
        return payCardNo;
    }

    public void setPayCardNo(String payCardNo) {
        this.payCardNo = payCardNo;
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

    public String getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(String payDatetime) {
        this.payDatetime = payDatetime;
    }
}
