package com.bmsmart.spring.boot.springboot.dao.neo4j;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;

import java.util.List;

public interface CityAndTypeDao {

    List<Record> queryAllData(String label, String condition, boolean isDirection, String level);
}
