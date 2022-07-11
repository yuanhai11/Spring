package com.wxt.config;

import com.wxt.exception.BeansException;

public interface DisposableBean {

    void destroy() throws Exception;

}
