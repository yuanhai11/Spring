package com.wxt.config;

public interface InitializingBean {
    /**
     *初始化bean
     */
    // 执行
    void afterPropertiesSet() throws Exception;

}
