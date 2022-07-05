package com.wxt.beans.resource;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader {
    /**
     * 默认资源加载类，选择具体的实例化对象
     * @param path
     * @return
     */
    @Override
    public Resource getResource(String path) {
        Assert.notNull(path, "path cannot be null");
        if (path.startsWith(CLASSPATH_URL_PREFIX))
            return new ClassPathResource(path.substring(CLASSPATH_URL_PREFIX.length()));
        try {
            URL url = new URL(path);
            return new UrlResource(url);
        } catch (MalformedURLException e) {
            return new FileSystemResource(path);
        }
    }
}
