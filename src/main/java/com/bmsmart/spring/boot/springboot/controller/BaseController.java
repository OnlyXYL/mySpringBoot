package com.bmsmart.spring.boot.springboot.controller;

import com.bmsmart.spring.boot.springboot.config.RemoteProperties;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 基础Controller,用来获取controller中公共部分信息
 *
 * @param
 * @author XiaYaLing
 * @date 2018/4/26
 * @return
 */
@Slf4j
public class BaseController {

    @Resource
    RemoteProperties remoteProperties;
}
