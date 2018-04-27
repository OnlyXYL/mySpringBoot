package com.bmsmart.spring.boot.springboot.controller;

import com.bmsmart.spring.boot.springboot.model.neo4j.ResultData;
import com.bmsmart.spring.boot.springboot.model.neo4j.node.Type;
import com.bmsmart.spring.boot.springboot.repository.TypeRepository;
import com.bmsmart.spring.boot.springboot.service.neo4j.CityAndTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@Slf4j
@RequestMapping(value = "/neo4j")
public class neo4jController {

    @Resource
    TypeRepository typeRepository;

    @Resource
    CityAndTypeService cityAndTypeService;

    /**
     * 根据城市分类名，查询城市分类信息
     *
     * @param CityTypeName
     * @return java.lang.String
     * @author XiaYaLing
     * @date 2018/4/26
     */
    @RequestMapping(value = "/{param}", method = RequestMethod.GET)
    public ResultData getByCityTypeName(@PathVariable("param") String CityTypeName) {

        log.info(":::inter " + this.getClass().getName() + ":::方法:::" + Thread.currentThread().getStackTrace()[1].getMethodName() + ":::参数:::" + CityTypeName);

        Type type = typeRepository.findByCityTypeName(CityTypeName);

        Collection<Type> types = typeRepository.findByNameContaining(CityTypeName);

        ResultData resultData = cityAndTypeService.queryAllData("City", "", false, "1");

        System.out.println(types);

        return resultData;
    }

    /**
     * 查询所有数据
     *
     * @param
     * @return java.lang.String
     * @author XiaYaLing
     * @date 2018/4/26
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllData() {

        Collection<ResultData> allData = typeRepository.findAllData();

        System.out.println(allData);

        return "";
    }


}
