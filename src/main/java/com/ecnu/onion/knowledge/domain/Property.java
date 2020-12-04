package com.ecnu.onion.knowledge.domain;

import org.neo4j.ogm.annotation.*;

/**
 * @author onion
 * @date 2020/12/4 -8:52 上午
 */
@RelationshipEntity
public class Property {
    @StartNode
    private Radar radar;
    @EndNode
    private PropertyValue value;
    @Id
    @GeneratedValue
    private Long id;
    private String key;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    public PropertyValue getValue() {
        return value;
    }

    public void setValue(PropertyValue value) {
        this.value = value;
    }
}
