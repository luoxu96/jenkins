package com.example.study.controller;

import com.example.study.entity.Test;
import com.example.study.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AngularController {

    @Autowired
    public TestService testService;

    @RequestMapping(value = "AngulaerHtml",method = RequestMethod.GET)
    public String AngularHtml(){
        System.out.println("跳转该界面了");
        return "Angular";
    }

    @RequestMapping(value = "Angular",method = RequestMethod.GET)
    public @ResponseBody List<Test> Angular(){
        System.out.println("来拿数据了");
        List<Test> list=testService.findall();

        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }
        return testService.findall();
    }

}
