package org.example.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zhp
 * @date 2023/9/14 11:02
 **/
public class UrlResource implements Resource{

    private final URL url;

    public UrlResource(URL url){
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection co = url.openConnection();
        try {
            return co.getInputStream();
        } catch (IOException e) {
            if (co instanceof HttpURLConnection){
                ((HttpURLConnection) co).disconnect();
            }
            throw e;
        }
    }
}
