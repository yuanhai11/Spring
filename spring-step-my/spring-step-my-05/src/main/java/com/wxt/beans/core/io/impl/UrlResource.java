package com.wxt.beans.core.io.impl;

import cn.hutool.core.lang.Assert;
import com.wxt.beans.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "url cannot be null");
        this.url = url;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        try {
            return urlConnection.getInputStream();

        } catch (IOException o) {
            if (urlConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) urlConnection).disconnect();
            }
            throw o;
        }
    }
}
