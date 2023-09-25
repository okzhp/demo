package org.example.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.example.beans.factory.BeanDefinition;
import org.example.beans.factory.BeanReference;
import org.example.exception.BeansException;
import org.example.core.io.Resource;
import org.example.core.io.ResourceLoader;
import org.example.beans.factory.support.AbstractBeanDefinitionReader;
import org.example.beans.factory.support.BeanDefinitionRegistry;
import org.example.beans.factory.support.PropertyValue;
import org.example.beans.factory.support.PropertyValues;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhp
 * @date 2023/9/14 14:04
 **/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry){
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader){
        super(registry,resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            doLoadBeanDefinition(resource.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resource) throws BeansException {
        for (Resource r : resource) {
            loadBeanDefinitions(r);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        try {
            doLoadBeanDefinition(getResourceLoader().getResource(location).getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void doLoadBeanDefinition(InputStream is) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(is);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            //判断元素
            if (!(childNodes.item(i) instanceof Element))continue;

            if (!"bean".equals(childNodes.item(i).getNodeName()))continue;

            //解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            Class<?> clazz = Class.forName(className);
            //优先级 id > name
            String beanName = StrUtil.isEmpty(id)?name:id;
            if (StrUtil.isEmpty(beanName)){
                beanName = StrUtil.lowerFirst(clazz.getName());
            }

            PropertyValues propertyValues = new PropertyValues();
            for (int j = 0; j <bean.getChildNodes().getLength(); j++) {
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName()))continue;
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                //如果存在ref即为引用类型，否则是值
                Object object = StrUtil.isEmpty(attrRef) ? attrValue : new BeanReference(attrRef);
                propertyValues.addPropertyValue(new PropertyValue(attrName,object));
            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz,propertyValues);
            getRegister().registry(beanName,beanDefinition);
        }
    }
}
