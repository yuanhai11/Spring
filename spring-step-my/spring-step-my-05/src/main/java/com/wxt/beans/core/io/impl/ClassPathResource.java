package com.wxt.beans.core.io.impl;

import cn.hutool.core.lang.Assert;
import com.wxt.beans.core.io.Resource;
import com.wxt.beans.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream stream = classLoader.getResourceAsStream(path);
        if (stream == null) throw new FileNotFoundException(path + "cannot be opened because it does exits");
        return stream;
    }
}
