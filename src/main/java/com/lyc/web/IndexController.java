package com.lyc.web;

import com.lyc.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Digits;
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
    public @ResponseBody List hello(){
       return bService.findList();
    }
}
