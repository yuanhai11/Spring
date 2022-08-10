package com.wxt.context.event;

import com.wxt.factory.BeanFactory;

/**
 * Simple implementation of the {@link ApplicationEventMulticaster} interface
 *
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationLister listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
