package com.bmsmart.spring.boot.springboot.repository;

import com.bmsmart.spring.boot.springboot.model.neo4j.ResultData;
import com.bmsmart.spring.boot.springboot.model.neo4j.node.Type;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TypeRepository extends GraphRepository<Type> {


    /**
     * 根据城市类型名称，查询城市分类信息
     *
     * @param CityTypeName
     * @return com.bmsmart.spring.boot.springboot.model.neo4j.Type
     * @author XiaYaLing
     * @date 2018/4/26
     */
    Type findByCityTypeName(@Param("CityTypeName") String CityTypeName);

    /**
     * 根据城市类型名称，查询城市分类信息
     *
     * @param CityTypeName
     * @return java.util.Collection<com.bmsmart.spring.boot.springboot.model.neo4j.Type>
     * @author XiaYaLing
     * @date 2018/4/26
     */
    @Query("MATCH (t:Type{CityTypeName:$CityTypeName}) RETURN t")
    Collection<Type> findByNameContaining(@Param("CityTypeName") String CityTypeName);

    /**
     * 查询所有
     *
     * @param
     * @return java.util.Collection<java.lang.String>
     * @author XiaYaLing
     * @date 2018/4/26
     */
    @Query("match node=(label:Type)-[r]-(first) return label,first,collect({relationShip:type(r),source:id(startNode(r)),target:id(endNode(r))}) as edges")
    Collection<ResultData> findAllData();


}
