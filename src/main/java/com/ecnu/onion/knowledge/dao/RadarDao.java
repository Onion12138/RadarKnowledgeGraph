package com.ecnu.onion.knowledge.dao;

import com.ecnu.onion.knowledge.domain.Radar;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author onion
 * @date 2020/12/3 -10:38 下午
 */
public interface RadarDao extends Neo4jRepository<Radar, Long> {
}
