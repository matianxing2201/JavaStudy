package com.mtx.spring.factory;

import com.mtx.spring.bean.Monster;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

public class MyFactoryBean implements FactoryBean<Monster> {
    private String keyVal;
    private Map<String, Monster> monster_map;

    {
        monster_map = new HashMap<String, Monster>();
        monster_map.put("monster_1", new Monster(01, "monster01", "shill01"));
        monster_map.put("monster_2", new Monster(02, "monster02", "shill02"));
    }

    public void setKeyVal(String keyVal) {
        this.keyVal = keyVal;
    }

    @Override
    public Monster getObject() throws Exception {
        return monster_map.get(keyVal);
    }

    @Override
    public Class<?> getObjectType() {
        return Monster.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
