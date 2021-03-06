package com.bh.mall.enums;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:07:50 
 * @history:
 */
// 状态变化路径共4条：1-3;1-4-5;1-4-3;6
public enum EJourStatus {
    todoCheck("1", "待对账"), Checked_YES("3", "已对账且账已平"), Checked_NO("4",
            "帐不平待调账审批"), Adjusted("5", "已对账且账不平"), noAdjust("6", "无需对账");
    EJourStatus(String code, String value) {
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
