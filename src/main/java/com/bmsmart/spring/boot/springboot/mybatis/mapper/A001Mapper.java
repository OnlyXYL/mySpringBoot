package com.bmsmart.spring.boot.springboot.mybatis.mapper;

import com.bmsmart.spring.boot.springboot.model.SCUser;

import java.util.Map;

public interface A001Mapper {

	/**
	 *    查询用户
	 * @author XiaYaLing
	 * @date 2018/4/23
	 * @param map
	 * @return com.bmsmart.spring.boot.springboot.model.SCUser
	 */
	public SCUser getUser(Map<String,String> map);

}
