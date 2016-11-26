package com.std.user.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.user.ao.ICompanyAO;
import com.std.user.bo.ICNavigateBO;
import com.std.user.bo.ICPasswordBO;
import com.std.user.bo.ICompanyBO;
import com.std.user.bo.ISmsOutBO;
import com.std.user.bo.base.Paginable;
import com.std.user.common.MD5Util;
import com.std.user.domain.Company;
import com.std.user.enums.EBoolean;
import com.std.user.enums.EPasswordType;
import com.std.user.enums.EXiaoMi;
import com.std.user.exception.BizException;
import com.std.user.util.PinYin;

@Service
public class CompanyAOImpl implements ICompanyAO {

    @Autowired
    private ICompanyBO companyBO;

    @Autowired
    private ICNavigateBO cNavigateBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private ICPasswordBO cPasswordBO;

    @Override
    public String addCompany(Company data) {
        if (StringUtils.isNotBlank(data.getUserId())) {
            checkCompanyUserId(null, data.getUserId());
        }
        if (StringUtils.isNotBlank(data.getLoginName())) {
            companyBO.checkLoginName(data.getLoginName());
        }
        String code = companyBO.saveCompany(data);
        if (EBoolean.YES.getCode().equals(data.getIsNeedInitPwd())) {
            cPasswordBO
                .saveCPassword(EPasswordType.company.getCode(),
                    EXiaoMi.APPKEY.getCode(), null, EXiaoMi.APPKEY.getValue(),
                    code);
            cPasswordBO.saveCPassword(EPasswordType.company.getCode(),
                EXiaoMi.TO.getCode(), null, EXiaoMi.TO.getValue(), code);
            cPasswordBO.saveCPassword(EPasswordType.company.getCode(),
                EXiaoMi.TENANTID.getCode(), null, EXiaoMi.TENANTID.getValue(),
                code);
        }
        return code;
    }

    @Override
    @Transactional
    public String addGWCompany(Company data) {
        String code = companyBO.saveCompany(data);
        // addMenu("ind", "首页", code);
        // addMenu("inw", "微信首页", code);
        // addMenu("com", "公司简介", code);
        // addMenu("cin", "我要合作", code);
        // addMenu("wei", "微信顶级菜单", code);
        return code;
    }

    // private void addMenu(String prefix, String name, String companyCode) {
    // String code = null;
    // CNavigate cn = new CNavigate();
    // code = OrderNoGenerater.generate(prefix);
    // cn.setCode(code);
    // cn.setName(name);
    // cn.setType(ECNavigateType.CAIDAN.getCode());
    // cn.setStatus(EBoolean.YES.getCode());
    // cn.setOrderNo(1);
    // cn.setParentCode(EBoolean.NO.getCode());
    // cn.setCompanyCode(companyCode);
    // cNavigateBO.saveCNavigate(cn);
    // }

    @Override
    public int editCompany(Company data) {
        if (!companyBO.isCompanyExist(data.getCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        if (StringUtils.isNotBlank(data.getUserId())) {
            checkCompanyUserId(data.getCode(), data.getUserId());
        }
        return companyBO.refreshCompany(data);
    }

    // 判断用户是否唯一负责一个公司
    private void checkCompanyUserId(String companyCode, String userId) {
        // 判断负责人是否已经存在
        Company condition = new Company();
        condition.setUserId(userId);
        List<Company> companyList = companyBO.queryCompanyList(condition);
        if (CollectionUtils.isNotEmpty(companyList)) {
            if (StringUtils.isBlank(companyCode)) {
                throw new BizException("xn0000", "该负责人已负责其他站点，请选择其他人");
            } else {
                Company data = companyList.get(0);
                if (data.getUserId().equals(userId)
                        && !data.getCode().equals(companyCode)) {
                    throw new BizException("xn0000", "该负责人已负责其他站点，请选择其他人");
                }
            }
        }
    }

    @Override
    public int dropCompany(String code) {
        if (!companyBO.isCompanyExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return companyBO.removeCompany(code);
    }

    @Override
    public Paginable<Company> queryCompanyPage(int start, int limit,
            Company condition) {
        Paginable<Company> page = null;
        if (null != condition.getCertificateType()) {
            page = companyBO.getPaginableJJ(start, limit, condition);
        } else {
            page = companyBO.getPaginable(start, limit, condition);
        }
        return page;
    }

    @Override
    public List<Company> queryCompanyList(Company condition) {
        List<Company> list = companyBO.queryCompanyList(condition);
        // 将结果按首字母排序
        return sortByFirstLetter(list);
    }

    // 将结果按首字母排序
    private List<Company> sortByFirstLetter(List<Company> list) {
        List<Company> result = new ArrayList<>();
        // 用来记录result的长度
        int i = 0;
        // 用来判断该元素是否已添加
        boolean isAdd = false;
        // 遍历待排序数组
        for (Company company : list) {
            isAdd = false;
            if (i == 0) {
                result.add(company);
                i++;
            } else {
                // 遍历已排序数组
                for (int j = 0; j < i; j++) {
                    // 若待排序元素的首字母小于其元素，则将待排序元素插入到其位置
                    if (PinYin.cn2py(company.getName()).charAt(0) < PinYin
                        .cn2py(result.get(j).getName()).charAt(0)) {
                        result.add(j, company);
                        isAdd = true;
                        i++;
                        break;
                    }
                }
                if (!isAdd) {
                    result.add(company);
                }
            }
        }
        return result;
    }

    @Override
    public Company getCompany(String code) {
        return companyBO.getCompany(code);
    }

    @Override
    public int editCompanyLocation(String code, String updater) {
        int count = 0;
        if (!companyBO.isCompanyExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        Company company = companyBO.getCompany(code);
        if (company.getLocation().equals(EBoolean.NO.getCode())) {
            count = companyBO.refreshCompanyLocation(code, 
                EBoolean.YES.getCode(),updater);
        } else {
            count = companyBO.refreshCompanyLocation(code, 
                EBoolean.NO.getCode(),updater);
        }
        return count;
    }

    @Override
    public int editCompanyDefault(String code) {
        if (!companyBO.isCompanyExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return companyBO.refreshCompanyDefault(code);
    }

    @Override
    public int editCompanyHot(String code, String isHot, String orderNo,
            String updater) {
        if (!companyBO.isCompanyExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        Company data = companyBO.getCompany(code);
        data.setIsHot(isHot);
        if (StringUtils.isBlank(orderNo)) {
            orderNo = "0";
        }
        data.setOrderNo(Integer.valueOf(orderNo));
        data.setUpdater(updater);
        return companyBO.refreshCompanyHot(data);
    }

    @Override
    public int editCompanyHotLocation(String code, String action) {
        Company data = companyBO.getCompany(code);
        Integer location = data.getOrderNo();
        if (null == location) {
            location = 2;
        }
        if (EBoolean.YES.getCode().equalsIgnoreCase(action)) {
            if (location > 0) {
                location--;
            } else {
                throw new BizException("xn0000", "次序不可小于零");
            }
        } else {
            location++;
        }
        data.setOrderNo(location);
        return companyBO.refreshCompanyHot(data);
    }

    @Override
    public Company getCompanyByUserId(String userId) {
        return companyBO.getCompanyByUserId(userId);
    }

    @Override
    public Company getCompanyByPCA(String province, String city, String area) {
        Company condition = new Company();
        condition.setProvinceForQuery(province);
        condition.setCityForQuery(city);
        condition.setAreaForQuery(area);
        List<Company> list = companyBO.queryCompanyList(condition);
        Company result = new Company();
        if (CollectionUtils.sizeIsEmpty(list)) {
            result = companyBO.getDefaultCompany();
        } else {
            result = list.get(0);
        }
        return result;
    }

    @Override
    public Company getCompanyByDomain(String domain) {
        if ("".equals(domain) || null == domain) {
            throw new BizException("xn0000", "请输入合法域名");
        }
        Company company = companyBO.getCompanyByDomain(domain);
        if (EBoolean.NO.getCode().equals(company.getLocation())) {
            throw new BizException("xn0000", "该商城违规，正等待系统处理，请稍后再试。");
        }
        return company;
    }

    @Override
    public void editCompanyPsw(String code, String oldPassword,
            String newPassword) {
        Company condition = new Company();
        condition.setCode(code);
        condition.setPassword(MD5Util.md5(oldPassword));
        List<Company> list = companyBO.queryCompanyList(condition);
        if (list == null || list.size() == 0) {
            throw new BizException("xn0000", "密码不正确");
        }
        companyBO.refreshCompanyPsw(code, newPassword);
    }

    @Override
    public String doLogin(String loginName, String password) {
        Company condition = new Company();
        condition.setLoginName(loginName);
        List<Company> companyList1 = companyBO.queryCompanyList(condition);
        if (CollectionUtils.isEmpty(companyList1)) {
            throw new BizException("xn702002", "登录名不存在");
        }
        condition.setPassword(MD5Util.md5(password));
        List<Company> companyList2 = companyBO.queryCompanyList(condition);
        if (CollectionUtils.isEmpty(companyList2)) {
            throw new BizException("xn702002", "登录密码错误");
        }
        Company company = companyList2.get(0);
        return company.getCode();
    }

    @Override
    public void doFindLoginPwd(String loginName, String mobile,
            String smsCaptcha, String newPassword) {
        Company company = null;
        Company condition = new Company();
        condition.setLoginName(loginName);
        List<Company> companyList = companyBO.queryCompanyList(condition);
        if (CollectionUtils.isEmpty(companyList)) {
            throw new BizException("xn000000", "该登录名不存在");
        } else {
            company = companyList.get(0);
            if (!mobile.equals(company.getMobile())) {
                throw new BizException("xn000000", "该公司无此联系电话");
            }
        }
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "806009");
        companyBO.refreshCompanyPsw(company.getCode(), newPassword);
    }

}
