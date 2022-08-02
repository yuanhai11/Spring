package com.wxt.context.event;

/**
 * 事件广播器
 */
public interface ApplicationEventMulticaster {


    /**
     * 添加监听器
     * Add a listener to be notified of all events.
     * @param listener add a listener
     */
    void addApplicationListener(ApplicationLister<?> listener);

    /**
     * 去除监听器
     * Remove a listener from the notification list.
     * @param listener remove a listener
     */
    void removeApplicationListener(ApplicationLister<?> listener);

    /**
     * 将事件广播到合适的监听器
     * Multicast the given application event to appropriate listeners.
     *
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);

}
