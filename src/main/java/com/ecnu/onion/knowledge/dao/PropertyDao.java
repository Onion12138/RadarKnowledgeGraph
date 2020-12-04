package com.ecnu.onion.knowledge.dao;

import com.ecnu.onion.knowledge.domain.Property;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author onion
 * @date 2020/12/4 -9:32 上午
 */
public interface PropertyDao extends Neo4jRepository<Property, Long> {
}
