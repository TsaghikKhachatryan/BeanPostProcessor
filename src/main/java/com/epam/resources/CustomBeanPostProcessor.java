package com.epam.resources;

import com.epam.AddAge;
import com.epam.model.Employee;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Annotation[] annotations = bean.getClass().getAnnotations();
        for (Annotation anno : annotations) {
            if (anno instanceof AddAge) {
                if (bean instanceof Employee) {
                    Employee employee = (Employee) bean;
                    employee.setAge(employee.getAge() + ((AddAge) anno).value());
                }
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
