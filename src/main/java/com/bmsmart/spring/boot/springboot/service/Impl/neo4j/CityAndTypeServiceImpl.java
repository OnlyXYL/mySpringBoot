package com.bmsmart.spring.boot.springboot.service.Impl.neo4j;

import com.bmsmart.spring.boot.springboot.dao.neo4j.CityAndTypeDao;
import com.bmsmart.spring.boot.springboot.model.neo4j.ResultData;
import com.bmsmart.spring.boot.springboot.service.neo4j.CityAndTypeService;
import com.bmsmart.spring.boot.springboot.util.CypherResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CityAndTypeServiceImpl implements CityAndTypeService {

    @Resource
    CityAndTypeDao cityAndTypeDao;

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
    @Override
    public ResultData queryAllData(String label, String condition, boolean isDirection, String level) {

        log.info(":::inter " + this.getClass().getName() + ":::方法:::" + Thread.currentThread().getStackTrace()[1].getMethodName() + ":::");

        List<Record> records = cityAndTypeDao.queryAllData(label, condition, isDirection, level);
        ResultData resultData = new ResultData();
        if (records.size() > 0) {
            resultData = CypherResultUtil.dealwithResult(records);
        }
        return resultData;
    }
}
