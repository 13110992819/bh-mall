package com.bh.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bh.mall.ao.IChargeAO;
import com.bh.mall.bo.IAccountBO;
import com.bh.mall.bo.IChargeBO;
import com.bh.mall.bo.IUserBO;
import com.bh.mall.bo.base.Paginable;
import com.bh.mall.common.CalculationUtil;
import com.bh.mall.common.PhoneUtil;
import com.bh.mall.domain.Account;
import com.bh.mall.domain.Charge;
import com.bh.mall.domain.User;
import com.bh.mall.enums.EBizType;
import com.bh.mall.enums.EBoolean;
import com.bh.mall.enums.EChannelType;
import com.bh.mall.enums.EChargeStatus;
import com.bh.mall.enums.ECurrency;
import com.bh.mall.enums.ESystemCode;
import com.bh.mall.exception.BizException;

@Service
public class ChargeAOImpl implements IChargeAO {
    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IChargeBO chargeBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String applyOrder(String accountNumber, String jourBizType,
            Long amount, String payCardInfo, String payCardNo,
            String applyUser, String applyNote) {
        if (amount <= 0) {
            throw new BizException("xn000000", "充值金额需大于零");
        }
        Account account = accountBO.getAccount(accountNumber);
        Account payAccount = accountBO.getAccount(ESystemCode.BH.getCode());
        // 生成充值订单
        String code = chargeBO.applyOrderOffline(account, payAccount, EBizType
            .getBizTypeMap().get(jourBizType), amount, payCardInfo, payCardNo,
            applyUser, applyNote);
        return code;
    }

    @Override
    public String applyOrder(String accountNumber, String payAcountNumber,
            String jourBizType, Long amount, String payCardInfo,
            String payCardNo, String applyUser, String applyNote) {
        if (amount <= 0) {
            throw new BizException("xn000000", "申请转赠金额需大于零");
        }
        Account account = accountBO.getAccount(accountNumber);
        Account payAccount = accountBO.getAccount(payAcountNumber);
        // 生成充值订单
        String code = chargeBO.applyOrderOffline(account, payAccount, EBizType
            .getBizTypeMap().get(jourBizType), amount, payCardInfo, payCardNo,
            applyUser, applyNote);
        return code;
    }

    @Override
    @Transactional
    public void payOrder(String code, String payUser, String payResult,
            String payNote, String systemCode) {
        Charge data = chargeBO.getCharge(code);
        if (!EChargeStatus.toPay.getCode().equals(data.getStatus())) {
            throw new BizException("xn000000", "申请记录状态不是待支付状态，无法支付");
        }
        if (EBoolean.YES.getCode().equals(payResult)) {
            payOrderYES(data, payUser, payNote);
        } else {
            payOrderNO(data, payUser, payNote);
        }
    }

    private void payOrderNO(Charge data, String payUser, String payNote) {
        chargeBO.payOrder(data, false, payUser, payNote);
    }

    private void payOrderYES(Charge data, String payUser, String payNote) {
        chargeBO.payOrder(data, true, payUser, payNote);
        Account account = accountBO.getAccount(data.getAccountNumber());
        Account payAccount = accountBO.getAccount(data.getPayAccountNumber());
        User user = userBO.getCheckUser(account.getUserId());
        String toBizNote = null;
        if (ESystemCode.BH.getCode().equals(data.getPayAccountNumber())) {
            toBizNote = "平台向您转赠了" + CalculationUtil.diviDown(data.getAmount())
                    + "橙券";
        } else {
            User payUse = userBO.getCheckUser(payAccount.getUserId());
            toBizNote = "业务员(" + PhoneUtil.hideMobile(payUse.getMobile())
                    + ")向您转赠了" + CalculationUtil.diviDown(data.getAmount())
                    + "橙券";
        }
        // 账户加钱
        accountBO.changeAmount(data.getAccountNumber(), EChannelType.Offline,
            null, null, data.getCode(), EBizType.AJ_CZ, toBizNote,
            data.getAmount());
        if (!ESystemCode.BH.getCode().equals(data.getPayAccountNumber())) {
            // 支付账户减钱
            accountBO.changeAmount(data.getPayAccountNumber(),
                EChannelType.Offline, null, null, data.getCode(),
                EBizType.AJ_CZ,
                "您向业务员(" + PhoneUtil.hideMobile(user.getMobile()) + ")转赠了"
                        + CalculationUtil.diviDown(data.getAmount()) + "橙券",
                -data.getAmount());
        } else {
            if (ECurrency.YJ_CNY.getCode().equals(account.getCurrency())
                    || ECurrency.MK_CNY.getCode().equals(account.getCurrency())) {
                // 托管账户加钱
                accountBO
                    .changeAmount(
                        ESystemCode.BH.getCode(),
                        EChannelType.Offline,
                        null,
                        null,
                        data.getCode(),
                        EBizType.AJ_CZ,
                        "您向业务员(" + PhoneUtil.hideMobile(user.getMobile())
                                + ")转赠了"
                                + CalculationUtil.diviDown(data.getAmount())
                                + "橙券", data.getAmount());
            }
        }
    }

    @Override
    public Paginable<Charge> queryChargePage(int start, int limit,
            Charge condition) {
        Paginable<Charge> page = chargeBO.getPaginable(start, limit, condition);
        if (CollectionUtils.isNotEmpty(page.getList())) {
            List<Charge> list = page.getList();
            for (Charge charge : list) {
                User user = userBO.getCheckUser(charge.getApplyUser());
                charge.setUser(user);
                if (!"admin".equals(charge.getPayUser())
                        && charge.getPayUser() != null) {
                    User payUser = userBO.getCheckUser(charge.getPayUser());
                    charge.setPayUser(payUser.getLoginName());
                }
            }
        }
        return page;
    }

    @Override
    public List<Charge> queryChargeList(Charge condition) {
        List<Charge> list = chargeBO.queryChargeList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Charge charge : list) {
                User user = userBO.getCheckUser(charge.getApplyUser());
                charge.setUser(user);
                if (!"admin".equals(charge.getPayUser())
                        && charge.getPayUser() != null) {
                    User payUser = userBO.getCheckUser(charge.getPayUser());
                    charge.setPayUser(payUser.getLoginName());
                }
            }
        }
        return list;
    }

    @Override
    public Charge getCharge(String code, String systemCode) {
        Charge charge = chargeBO.getCharge(code);
        User user = userBO.getCheckUser(charge.getApplyUser());
        charge.setUser(user);
        if (!"admin".equals(charge.getPayUser()) && charge.getPayUser() != null) {
            User payUser = userBO.getCheckUser(charge.getPayUser());
            charge.setPayUser(payUser.getLoginName());
        }
        return charge;
    }

}
