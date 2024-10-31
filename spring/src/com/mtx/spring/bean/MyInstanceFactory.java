package com.mtx.spring.bean;

import java.util.HashMap;
import java.util.Map;

public class MyInstanceFactory {
    private Map<String, Monster> monsterMap;

    {
        monsterMap = new HashMap<String, Monster>();
        monsterMap.put("monster1", new Monster(1, "黑熊", " "));
        monsterMap.put("monster2", new Monster(2, "白虎", " "));
    }

    public Monster getMonster(String key) {
        return monsterMap.get(key);
    }

}
