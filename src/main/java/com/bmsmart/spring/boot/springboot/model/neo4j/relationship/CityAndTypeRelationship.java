package com.bmsmart.spring.boot.springboot.model.neo4j.relationship;

import com.bmsmart.spring.boot.springboot.model.neo4j.node.City;
import com.bmsmart.spring.boot.springboot.model.neo4j.node.Type;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * 城市和类型关系
 *
 * @param
 * @author XiaYaLing
 * @date 2018/4/26
 * @return
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "BELONG_TO")
@Data
public class CityAndTypeRelationship {

    @GraphId
    private Long id;

    @StartNode
    private City city;

    @EndNode
    private Type type;
}
