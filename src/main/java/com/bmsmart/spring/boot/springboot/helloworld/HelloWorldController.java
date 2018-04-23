package com.bmsmart.spring.boot.springboot.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 *    spring boot demo
 * @author XiaYaLing
 * @date 2018/4/12
 * @param
 * @return
 */
/**
 * @RestController
 *就是@Controller+@ResponseBody组合，支持RESTful访问方式，返回结果都是json字符串
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello1")
    public String hello1() {
        return "Hello World";
    }

    @RequestMapping("/hello2")
    public List<String> hello2() {
        return Arrays.asList(new String[] { "A", "B", "C" });
    }

}
