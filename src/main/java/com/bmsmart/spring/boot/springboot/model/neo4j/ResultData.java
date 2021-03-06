package com.bmsmart.spring.boot.springboot.model.neo4j;

import lombok.Data;

import java.util.List;

@Data
public class ResultData {

    private List<Node> nodes;

    private List<Relationship> edges;

    private List<String> relationShips;

}
