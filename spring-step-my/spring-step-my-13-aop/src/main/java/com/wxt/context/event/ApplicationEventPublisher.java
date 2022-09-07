package com.wxt.context.event;

/**
 * 事件发布者接口
 */
public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of an
     * application event
     * @param event
     */

    void publishEvent(ApplicationEvent event);


}
