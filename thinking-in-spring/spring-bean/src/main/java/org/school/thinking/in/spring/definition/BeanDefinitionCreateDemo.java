package org.school.thinking.in.spring.definition;

import org.school.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreateDemo {
    public static void main(String[] args) {

        //通过beanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        //通过属性设置
        beanDefinitionBuilder
                .addPropertyValue("id",1)
                .addPropertyValue("name","顾言");

        //获取beanDefinition
        // 并非beanDefinition的最终形态，可以自定义修改
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        //通过第二种形式创建
        //通过 AbstractBeanDefinition的派生类来创建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置bean
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("id","1");
        propertyValues.addPropertyValue("name","顾言");

        propertyValues
                .add("id",1)
                .add("name","顾言");
        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
