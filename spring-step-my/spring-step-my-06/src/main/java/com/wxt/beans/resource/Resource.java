package com.wxt.beans.resource;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
    // 读取资源 -- > 输入流
    InputStream getInputStream() throws IOException;

}
