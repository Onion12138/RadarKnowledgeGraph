package com.ecnu.onion.knowledge.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author onion
 * @date 2020/12/4 -9:30 上午
 */
@NodeEntity(label = "value")
public class PropertyValue {
    @Id
    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
