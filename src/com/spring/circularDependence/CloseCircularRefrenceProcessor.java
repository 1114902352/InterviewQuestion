package com.spring.circularDependence;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CloseCircularRefrenceProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory)beanFactory;
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Z.class);
        factory.registerBeanDefinition("z",builder.getBeanDefinition());
//        factory.setAllowCircularReferences(false);
    }
}
