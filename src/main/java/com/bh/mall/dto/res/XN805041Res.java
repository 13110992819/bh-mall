package com.bh.mall.dto.res;

public class XN805041Res {
    private String userId;

    private Long amount;

    public XN805041Res() {
    }

    public XN805041Res(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
