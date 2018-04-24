package com.bmsmart.spring.boot.springboot.controller;

import com.bmsmart.spring.boot.springboot.model.SCUser;
import com.bmsmart.spring.boot.springboot.service.ScUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ThymeLeafController {

    @Resource
    private ScUserService scUserService;

    @RequestMapping(value = "/hello1")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/hello1");
        mv.addObject("title", "欢迎使用Thymeleaf!");
        return mv;
    }

    @RequestMapping(value = "/thymeleaf/{userId}")
    public String hello(HttpServletRequest request, @PathVariable String userId) {

        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("userId", userId);

        SCUser user = scUserService.getUser(hashMap);

        request.setAttribute("user", user);
        request.setAttribute("haha", "哈哈");
        return "hello2";
    }
}
