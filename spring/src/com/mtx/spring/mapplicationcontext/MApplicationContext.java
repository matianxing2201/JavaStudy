package com.mtx.spring.mapplicationcontext;

import com.mtx.spring.bean.Monster;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mtx
 * 1. 实现pring的一个简单容器机制 理解Spring容器
 * 2. 如何将beans.xml文件进行解析，生成对象，放入容器
 * 3. 提供一个方法getBean(String beanName)来获取bean对象
 */
public class MApplicationContext {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 构造器
    // 接收一个容器的配置文件 如beans.xml， 文件地址在src下
    public MApplicationContext(String iocBeanXmlFile) throws Exception {
        // 1. 得到类加载路径
        String classPath = this.getClass().getResource("/").getPath();

        // 2. 创建 SaxReader 对象
        SAXReader saxReader = new SAXReader();

        // 3. 得到Document对象
        Document document = saxReader.read(new File(classPath + iocBeanXmlFile));

        // 4. 得到rootElement
        Element rootElement = document.getRootElement();

        // 5. 得到第一个bean元素 bean-monster
        Element bean = (Element)rootElement.elements("bean").get(0);

        // 6. 获取第一个bean-monster的相关属性
        String id = bean.attributeValue("id");
        String classFullPath = bean.attributeValue("class");

        List<Element> property =  bean.elements("property");
        Integer firstId = Integer.parseInt(property.get(0).attributeValue("value"));
        String firstName = property.get(1).attributeValue("value");
        String skill = property.get(2).attributeValue("value");

        // 7. 使用反射创建对象
        Class<?> aClass = Class.forName(classFullPath);
        // o 对象就是Monster对象
        Monster object = (Monster)aClass.newInstance();
        // 反射赋值

        object.setId(firstId);
        object.setName(firstName);
        object.setShill(skill);

        // 8. 将对象放入容器
        singletonObjects.put(id, object);
    }

    public Object getBean(String id) {
        return singletonObjects.get(id);
    }
}
