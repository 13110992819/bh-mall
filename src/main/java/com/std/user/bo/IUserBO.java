/**
 * @Title IUserBO.java 
 * @Package com.ibis.pz 
 * @Description 
 * @author miyb  
 * @date 2015-3-7 上午9:17:37 
 * @version V1.0   
 */
package com.std.user.bo;

import java.util.List;

import com.std.user.bo.base.IPaginableBO;
import com.std.user.domain.User;
import com.std.user.enums.EBizType;
import com.std.user.enums.EUserStatus;

/** 
 * @author: miyb 
 * @since: 2015-3-7 上午9:17:37 
 * @history:
 */
public interface IUserBO extends IPaginableBO<User> {
    /**
     * 验证交易密码:拿tradePwd进行MD5后与数据库中userId得数据库交易密码比对
     * @param userId
     * @param tradePwd 
     * @create: 2015年11月1日 下午4:47:48 myb858
     * @history:
     */
    public void checkTradePwd(String userId, String tradePwd);

    /**
     * 验证登录密码:拿loginPwd进行MD5后与数据库中userId得数据库交易密码比对
     * @param userId
     * @param loginPwd 
     * @create: 2015年11月2日 下午1:18:57 myb858
     * @history:
     */
    public void checkLoginPwd(String userId, String loginPwd);

    /**
     *  判断前端用户手机号是否存在
     * @param mobile
     * @return 
     * @create: 2015-5-16 下午4:08:06 miyb
     * @history:
     */
    public void isMobileExist(String mobile);

    /**
     * 根据手机号和类型判断手机号是否存在
     * @param mobile
     * @param kind 
     * @create: 2016年7月27日 下午3:45:39 xieyj
     * @history:
     */
    public void isMobileExist(String mobile, String kind);

    /**
     * 判断登录名是否存在
     * @param loginName
     * @param kind 
     * @create: 2016年7月28日 下午8:16:37 xieyj
     * @history:
     */
    public void isLoginNameExist(String loginName, String kind);

    /**
     *  判断推荐人是否存在(手机号)
     * @param userReferee 推荐人
     * @return 
     * @create: 2015-5-16 下午4:08:06 miyb
     * @history:
     */
    public void checkUserReferee(String userReferee);

    public String doRegister(String loginName, String nickname, String mobile,
            String loginPwd, String loginPwdStrength, String userReferee,
            Long amount, String companyCode, String openId);

    public int refreshIdentity(String userId, String realName, String idKind,
            String idNo);

    public int refreshRealName(String userId, String realName);

    public int refreshLoginPwd(String userId, String loginPwd,
            String loginPwdStrength);

    public int refreshTradePwd(String userId, String tradePwd,
            String tradePwdStrength);

    public int refreshMobile(String userId, String mobile);

    public User getUser(String userId);

    public User getUserByMobile(String mobile);

    public User getUserByMobileAndKind(String mobile, String kind);

    public User getUserByLoginName(String loginName);

    public List<User> queryUserList(User condition);

    public String doAddUser(String loginName, String mobile, String loginPsd,
            String userReferee, String realName, String idKind, String idNo,
            String tradePsd, String kind, String level, String remark,
            String updater, String pdf, String roleCode);

    public void refreshStatus(String userId, EUserStatus normal,
            String updater, String remark);

    public void refreshRole(String userId, String roleCode, String updater,
            String remark);

    public void refreshPdf(String userId, String pdf, String updater,
            String remark);

    public void refreshLoginName(String userId, String loginName);

    public void refreshNickname(String userId, String nickname);

    public void refreshAmount(String accountNumber, Long transAmount,
            String refNo, EBizType bizType, String remark);
}
