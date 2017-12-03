package com.lyc.web;

import com.lyc.dao.FormModel;
import com.lyc.model.po.TestDate;
import com.lyc.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Digits;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    private BService bService;
    @RequestMapping("hello")
    public @ResponseBody List hello(@FormModel String a){
        System.out.println(a);

       return bService.findList();
    }

    @RequestMapping("hello1")
    public @ResponseBody TestDate hello1(){
        TestDate testDate =new TestDate();
        testDate.setB(new Date());
        testDate.setName("hello");

        return testDate;
    }
}
