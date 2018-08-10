package com.lyc.daotest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyc.dao.BMapper;
import com.lyc.dao.DatafileDao;
import com.lyc.dao.UserMapper;
import com.lyc.model.po.B;
import com.lyc.model.po.BExample;
import com.lyc.model.po.Dept;
import com.lyc.model.query.DatafileQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class DatafileDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private DatafileDao datafileDao;
    @Autowired
    private BMapper bMapper;

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testquery(){
        DatafileQuery query = new DatafileQuery();
        query.setId(45);
        //datafileDao.query(query);
        System.out.println(datafileDao.query(query).get(0).getFilename());
    }
    @Test
    public void test(){
        List list = userMapper.findAll();
        System.out.println(list.size()+">>>>>>>>>>>>>>>");

        Dept dept = userMapper.dept1(11);

        System.out.println(dept);
    }
    @Test
    public void test2(){
        List list = userMapper.findAll2();
        System.out.println(list.size()+">>>>>>>>>>>>>>>");
    }
    @Test
    public void testquery1(){
        BExample example = new BExample();
        BExample.Criteria criteria = example.createCriteria();
        PageHelper.startPage(1,10);
        criteria.andNameLike("中国%");
        List<B> list = bMapper.selectByExample(example);
        //分页信息
        PageInfo pageInfo = new PageInfo(list);
        logger.info(pageInfo.getPageNum()+"");
        try{
            //int i = 1/0;
            String string = null;
            string.length();
        }catch (Exception e){
            logger.error("error",e);
        }
        //System.out.println(pageInfo.getTotal());
    }
}
