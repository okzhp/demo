package org.example.exception;

/**
 * @author zhp
 * @date 2023/9/14 13:53
 **/
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
