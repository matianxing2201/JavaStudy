package com.mtx.spring.mapplicationcontext;

import com.mtx.spring.bean.Monster;

public class MApplicationContextTest {
    public static void main(String[] args) throws Exception {
        MApplicationContext ioc = new MApplicationContext("beans.xml");

        Monster monster = (Monster)ioc.getBean("monster01");
        System.out.println(monster);
    }
}
