package com.bmsmart.spring.boot.springboot.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityAndTypeRelationshipRelationship extends GraphRepository<CityAndTypeRelationshipRelationship> {

    @Query("match node=(label:Type)-[r]-(first) return node")
    List<CityAndTypeRelationshipRelationship> queryCityAndTypeRelationshipsBy();
}
