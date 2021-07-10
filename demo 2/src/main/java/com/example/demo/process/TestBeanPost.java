package com.example.demo.process;

import com.example.demo.help.PlaceholderHelper;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Configuration
public class TestBeanPost implements BeanPostProcessor {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("demo")){
            String value = "${test}";
          Object value1 = new PlaceholderHelper()
                    .resolvePropertyValue(beanFactory, beanName, value);
           TypeConverter converter = beanFactory.getTypeConverter();
           Field field = ReflectionUtils.findField(bean.getClass(),"test");

           Integer value3 = converter
                    .convertIfNecessary(value1, Integer.class, field);
           System.out.println(value3);
        }
        return bean;
    }


}
