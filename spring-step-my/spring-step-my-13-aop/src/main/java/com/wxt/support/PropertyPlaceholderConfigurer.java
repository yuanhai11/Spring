package com.wxt.support;

import com.wxt.config.BeanDefinition;
import com.wxt.exception.BeansException;
import com.wxt.factory.BeanFactoryPostProcessor;
import com.wxt.factory.ConfigurableListableBeanFactory;
import com.wxt.property.PropertyValue;
import com.wxt.property.PropertyValues;
import com.wxt.resource.DefaultResourceLoader;
import com.wxt.resource.Resource;

import java.util.Properties;

/**
 * 可以将xxx.properties中的初始化值填充到Definition中。
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
            Resource resource = defaultResourceLoader.getResource(location);

            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) continue;
                    String strVal = (String) value;
                    StringBuilder stringBuilder = new StringBuilder();
                    int start = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int end = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (start != -1 && end != -1 && end > start) {
                        String propKey = strVal.substring(start + 2, end);
                        String propValue = properties.getProperty(propKey);
                        stringBuilder.replace(start, end + 1, propValue);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), stringBuilder.toString()));
                    }
                }
            }

        } catch (Exception e) {
            throw new BeansException("Could not load properties" + e);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
