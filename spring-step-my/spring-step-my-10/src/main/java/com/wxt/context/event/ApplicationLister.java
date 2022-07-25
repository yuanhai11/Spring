package com.wxt.context.event;

import java.util.EventListener;

/**
 * 由应用程序监听器实现
 *
 * 以观察者模式实现的标准
 *
 * @param <E>
 */
public interface ApplicationLister<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.处理一个应用事件
     * @param event the event to respond to 。需要响应的事件
     */
    void onApplicationEvent(E event);

}
