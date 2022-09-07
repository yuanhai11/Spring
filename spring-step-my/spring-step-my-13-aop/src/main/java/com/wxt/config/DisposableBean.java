package com.wxt.config;


public interface DisposableBean {
    /**
     * 销毁bean接口
     * @throws Exception
     */

    void destroy() throws Exception;

}
