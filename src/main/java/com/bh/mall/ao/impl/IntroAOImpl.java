package com.bh.mall.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bh.mall.ao.IIntroAO;
import com.bh.mall.bo.IIntroBO;
import com.bh.mall.bo.base.Paginable;
import com.bh.mall.core.StringValidater;
import com.bh.mall.domain.Intro;
import com.bh.mall.dto.req.XN627241Req;

@Service
public class IntroAOImpl implements IIntroAO {

    @Autowired
    private IIntroBO introBO;

    @Override
    public String addIntro(Intro data) {
        return introBO.saveIntro(data);
    }

    @Override
    public void editIntro(XN627241Req req) {
        Intro data = introBO.getIntro(req.getCode());
        data.setPercent(StringValidater.toDouble(req.getPercent()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        introBO.refreshIntro(data);
    }

    @Override
    public void dropIntro(String code) {
        introBO.removeIntro(code);
    }

    @Override
    public Paginable<Intro> queryIntroPage(int start, int limit, Intro condition) {
        return introBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Intro> queryIntroList(Intro condition) {
        return introBO.queryIntroList(condition);
    }

    @Override
    public Intro getIntro(String code) {
        return introBO.getIntro(code);
    }
}
