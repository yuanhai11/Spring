package com.wxt.context;

import com.wxt.context.event.ApplicationEventPublisher;
import com.wxt.factory.HierarchicalBeanFactory;
import com.wxt.factory.ListableBeanFactory;
import com.wxt.resource.ResourceLoader;

/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running,but may be
 * reloaded if the implementation supports this.
 * * 应用上下文
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {


}
