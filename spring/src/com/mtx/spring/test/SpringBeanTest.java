package com.mtx.spring.test;

import com.mtx.spring.bean.Monster;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {
    public static void main(String[] args) {

    }

    public void getMonster() {
        // 1. 创建容器 ApplicationContext
        // 2. 该容器和容器配置文件关联

        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        // 3. 通过getBean()方法获取对应的对象
        //    默认返回Object类型， 运行类型Monster
//        Object monster01 = ioc.getBean("monster01");
        Monster monster01 = (Monster)ioc.getBean("monster01");

        // 4. 输出
        System.out.println("monster01=" + monster01 + "运行类型：" + monster01.getClass().getName());
        System.out.println("monster01=" + monster01 + "name:" + monster01.getName() + " id:" + monster01.getId());

        // 5. 也可以在获取的时候 直接指定class类型  可以多次获取同一个bean
        Monster monster02 = ioc.getBean("monster01", Monster.class);
        System.out.println("name:" + monster02.getName() + " id:" + monster02.getId());

        // 6. 查看容器侏儒了那些bean对象，输出bean的名称
        String[] beanDefinitonsNames = ioc.getBeanDefinitionNames();
        for (String beanName : beanDefinitonsNames) {
            System.out.println("beanDefinitonsName=" + beanName);
        }

    }
}
