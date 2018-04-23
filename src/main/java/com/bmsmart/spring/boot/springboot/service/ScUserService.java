package com.bmsmart.spring.boot.springboot.service;

import com.bmsmart.spring.boot.springboot.model.SCUser;

import java.util.Map;

public interface ScUserService {
    /**
     * 查询用户
     *
     * @param map
     * @return com.bmsmart.spring.boot.springboot.model.SCUser
     * @author XiaYaLing
     * @date 2018/4/23
     */
    public SCUser getUser(Map<String, String> map);
}
