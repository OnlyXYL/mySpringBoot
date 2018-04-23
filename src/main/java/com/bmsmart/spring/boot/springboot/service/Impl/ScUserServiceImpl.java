package com.bmsmart.spring.boot.springboot.service.Impl;

import com.bmsmart.spring.boot.springboot.model.SCUser;
import com.bmsmart.spring.boot.springboot.mybatis.mapper.A001Mapper;
import com.bmsmart.spring.boot.springboot.service.ScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ScUserServiceImpl implements ScUserService{

    @Autowired
    private A001Mapper a001Mapper;

    /**
     * 查询用户
     *
     * @param map
     * @return com.bmsmart.spring.boot.springboot.model.SCUser
     * @author XiaYaLing
     * @date 2018/4/23
     */
    @Override
    public SCUser getUser(Map<String, String> map) {
        return a001Mapper.getUser(map);
    }
}
