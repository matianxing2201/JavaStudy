package com.mtx.spring.test;

import com.mtx.spring.bean.Car;
import com.mtx.spring.bean.House;
import com.mtx.spring.bean.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringBeanTest {
    public static void main(String[] args) {
        getBeanByAnnotation();
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

    public static void getBeanByPrototype() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        for (int i = 0; i < 3; i++) {
//            Car car = ioc.getBean("car", Car.class);
//            System.out.println(car);
//        }
    }

    public static void getBeanByPostProcessor() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans02.xml");
//        House house = ioc.getBean("house", House.class);
//        System.out.println(house);
//
//        // 关闭容器
//        ((ConfigurableApplicationContext) ioc).close();
    }

    public static void getBeanByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        UserAction userAction = ioc.getBean(UserAction.class);
        System.out.println("userAction=" + userAction);

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println("userDao=" + userDao);

        MyComponent myComponent = ioc.getBean(MyComponent.class);
        System.out.println("myComponent=" + myComponent);

        UserService userService = ioc.getBean(UserService.class);
        System.out.println("userService=" + userService);
    }
}
