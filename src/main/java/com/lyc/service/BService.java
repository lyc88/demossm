package com.lyc.service;

import com.github.pagehelper.PageHelper;
import com.lyc.dao.BMapper;
import com.lyc.model.po.B;
import com.lyc.model.po.BExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@Service
public class BService {
    @Autowired
    private BMapper bMapper;
    public List<B> findList(){
        BExample example = new BExample();
        BExample.Criteria criteria = example.createCriteria();
        PageHelper.startPage(1,10);

        criteria.andNameLike("中国%");
        List<B> list = bMapper.selectByExample(example);

        return list;
    }
}
