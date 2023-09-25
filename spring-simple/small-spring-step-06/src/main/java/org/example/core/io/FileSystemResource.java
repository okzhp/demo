package org.example.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhp
 * @date 2023/9/14 10:55
 **/
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(File file){
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path){
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    public final String getPath(){
        return this.path;
    }
}
