package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhp
 * @date 2023/5/19 10:44
 **/
public class TTest {
    public static void main(String[] args) {
        List<Test.Stu> list = new ArrayList();
        list.add(new Test.Stu(1, "a"));
        list.add(new Test.Stu(2, "b"));
        list.add(new Test.Stu(3, "c"));

        List<Test.Stu> list2 = new ArrayList() {{
            list.stream().forEach(stu -> {
                stu.setName("测试");
            });
        }};
        System.out.println("---");
        System.out.println(list2);
    }
}
