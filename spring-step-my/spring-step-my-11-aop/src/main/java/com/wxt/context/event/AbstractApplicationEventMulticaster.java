package com.wxt.context.event;

import com.wxt.exception.BeansException;
import com.wxt.factory.BeanFactory;
import com.wxt.factory.aware.BeanFactoryWare;
import com.wxt.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * providing the basic listener registration facility.
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryWare {

    public final Set<ApplicationLister<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationLister<?> listener) {
        applicationListeners.add((ApplicationLister<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationLister<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public final void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * Return a Collection of ApplicationListeners matching the given
     * event type. Non-matching listeners get excluded early.

     * * @param event the event to be propagated. Allows for excluding
     * * non-matching listeners early, based on cached matching information.
     * * @return a Collection of ApplicationListeners
     * 返回给定事件类型匹配的applicationLister集合，不匹配的排除
     */
    protected Collection<ApplicationLister> getApplicationListeners(ApplicationEvent event) {
        LinkedList<ApplicationLister> allListeners = new LinkedList<>();
        for (ApplicationLister<ApplicationEvent> listener : applicationListeners) {
            if (supportsEvent(listener, event)) allListeners.add(listener);
        }
        return allListeners;
    }

    /**
     * 判断监听器是否对事件感兴趣
     */
    protected boolean supportsEvent(ApplicationLister<ApplicationEvent> applicationListener, ApplicationEvent event) {
        Class<? extends ApplicationLister> listenerClass = applicationListener.getClass();

        // 按照 CglibSubclassingInstantiationStrategy、SimpleInstantiationStrategy 不同的实例化类型，需要判断后获取目标 class
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];
        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
        // 判定此 eventClassName 对象所表示的类或接口与指定的 event.getClass() 参数所表示的类或接口是否相同，或是否是其超类或超接口。
        // isAssignableFrom是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，默认所有的类的终极父类都是Object。如果A.isAssignableFrom(B)结果是true，证明B可以转换成为A,也就是A可以由B转换而来。
        return eventClassName.isAssignableFrom(event.getClass());

    }


}
