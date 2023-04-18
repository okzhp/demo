package com.example.demo.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class Test<E> extends ArrayList<E>{
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }

    public static void main(String[] args) {

        Test<Object> list = new Test();
        list.add("1");
        list.add(null);
        list.add("2");

        List<Object> objects = list.subList(0, 2);

        System.out.println(list);


//        List<Stu> list = new ArrayList();
//        list.add(new Stu(1,"a"));
//        list.add(new Stu(1,"b"));
//        list.add(new Stu(1,"c"));
//
//
//        tomap方法两参的方法，如果key重复将会抛异常，三参可以指定冲突策略
//        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Stu::getId, Stu::getName, (a,b)->b));
//
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println(entry);
//        }
//
//        map.forEach((k,v)->{
//            System.out.println(k+":"+v);
//        });



//        List<String> list = new ArrayList<>(); list.add("1");
//        list.add("2");
//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item); }
//        }
//        System.out.println(list);
    }








    static class Stu{
        private int id;
        private String name;

        public Stu(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

