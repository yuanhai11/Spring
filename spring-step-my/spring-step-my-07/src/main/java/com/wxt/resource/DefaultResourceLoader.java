package com.wxt.resource;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader{
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
