package com.bmsmart.spring.boot.springboot.service.neo4j;

import com.bmsmart.spring.boot.springboot.model.neo4j.ResultData;
import org.neo4j.driver.v1.Driver;

public interface CityAndTypeService {

    /**
     * 返回所有结果
     *
     * @param label
     * @param condition
     * @param isDirection
     * @param level
     * @return java.lang.String
     * @author XiaYaLing
     * @date 2018/4/26
     */
    ResultData queryAllData(String label, String condition, boolean isDirection, String level);
}
