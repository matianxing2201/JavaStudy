package com.mtx.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在 bean 初始化之前完成某些任务
     * @param bean : 就是 ioc 容器返回的 bean 对象, 如果这里被替换会修改，则返回的 bean 对象也会被修改
     * @param beanName: 就是 ioc 容器配置的 bean 的名称
     * @return Object: 就是返回的 bean 对象
     */

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization 被调用了" + beanName + " bean 对象=" +  bean.getClass().getName());
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization 被调用了" + beanName + " bean 对象=" +  bean.getClass().getName()   );
        return bean;
    }
}
