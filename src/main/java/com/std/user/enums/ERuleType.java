/**
 * @Title EDirection.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午3:37:06 
 * @version V1.0   
 */
package com.std.user.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午3:37:06 
 * @history:
 */
public enum ERuleType {
    ZC("A", "注册送积分"), MRQD("B", "每日签到送积分"), SCTX("C1", "上传头像"), ZLWS("C2",
            "资料完善送积分"), FT("D", "发帖送积分"), PL("E", "评论送积分"), JH("F", "加精华送积分"), JB(
            "G", "帖子被举报扣积分"), PLJB("H", "评论被举报扣积分");
    public static Map<String, ERuleType> getRuleTypeMap() {
        Map<String, ERuleType> map = new HashMap<String, ERuleType>();
        for (ERuleType direction : ERuleType.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    ERuleType(String code, String value) {
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
