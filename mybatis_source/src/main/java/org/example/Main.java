package org.example;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhp
 * @date 2023/7/27 16:32
 **/
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Hello world!");

        String config = "mybatis-config.xml";
        InputStream is = null;
        try {
             is = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();


    }
}