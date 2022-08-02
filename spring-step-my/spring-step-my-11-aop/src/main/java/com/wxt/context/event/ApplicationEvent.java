package com.wxt.context.event;

import com.wxt.utils.EventObject;

/**
 * 具备事件功能的抽象类，别人继承此类获取事件能力
 */

public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }

}
