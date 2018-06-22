package com.iot.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
@Controller
public class ManygeSystem {
    @RequestMapping("/Login")
    public ModelAndView login(@RequestParam("username") String userName,
                              @RequestParam("password") String passWord) {
        ModelAndView mv = new ModelAndView("menu");//指定视图
        mv.addObject("name", userName);
        return mv;
    }
}