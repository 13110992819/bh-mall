package com.bh.mall.enums;

public enum EResult {

    Result_NO("0", "不通过"), Result_YES("1", "通过");

    EResult(String code, String value) {
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
