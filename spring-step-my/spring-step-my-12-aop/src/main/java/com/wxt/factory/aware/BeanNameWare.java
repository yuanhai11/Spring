package com.wxt.factory.aware;

public interface BeanNameWare extends Aware {
    /**
     * 实现此接口，既能感知到所属的 BeanName
     * @param name
     */

    void setBeanName(String name);
}
