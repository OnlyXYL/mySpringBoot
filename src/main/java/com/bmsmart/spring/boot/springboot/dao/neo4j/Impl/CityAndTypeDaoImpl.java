package com.bmsmart.spring.boot.springboot.dao.neo4j.Impl;

import com.bmsmart.spring.boot.springboot.dao.neo4j.CityAndTypeDao;
import com.bmsmart.spring.boot.springboot.util.CypherQueryUtil;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.driver.v1.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Slf4j
public class CityAndTypeDaoImpl implements CityAndTypeDao {


    @Resource
    Session session;

    @Override
    public List<Record> queryAllData(String label, String condition, boolean isDirection, String level) {

        log.info(":::inter " + this.getClass().getName() + ":::方法:::" + Thread.currentThread().getStackTrace()[1].getMethodName() + ":::参数:::");

        List<Record> greeting;
        try {
            greeting = session.writeTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction tx) {
                    String cypherSql = CypherQueryUtil.dealwithCondition(label, condition, true, level);
                    StatementResult statementResult = tx.run(cypherSql);
                    return statementResult.list();
                }
            });
            //调用方法处理返回结果
            return greeting;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}