package com.wxt.beans.core.io.impl;

import cn.hutool.core.lang.Assert;
import com.wxt.beans.core.io.Resource;
import com.wxt.beans.core.io.ResourceLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader {

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
