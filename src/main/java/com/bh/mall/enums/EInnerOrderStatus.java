package com.bh.mall.enums;

public enum EInnerOrderStatus {

    toPay("0", "待支付"), Paid("1", "已支付待发货"), TO_Deliver("2", "待收货"), Delivered(
            "3", "已收货"), TO_Cancel("4", "申请取消"), Canceled("5",
                    "已取消"), NO_CallOFF("1,2,3,5", "无法取消代理授权");

    EInnerOrderStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
