package org.example.util;

/**
 * @author zhp
 * @date 2023/9/21 10:05
 **/
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Exception e){

        }
        if (cl == null){
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
