package com.example.demo.test;

import lombok.Data;
import lombok.val;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

class Test<E> extends ArrayList<E>{
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        List<Future<Result>> list = new ArrayList<>();
        for (int i = 0; i < 1400000; i++) {
            Future<Result> res = executorService.submit(new ProductChild());
            list.add(res);
        }
        int boy = 0,girl = 0;
        for (Future<Result> future : list) {
//            System.out.printf("boy:%4d,girl:%4d \n",future.get().getBoy(),future.get().getGirl());
            boy += future.get().getBoy();
            girl += future.get().getGirl();
        }
        System.out.printf("boy:%d \n",boy);
        System.out.printf("girl:%d \n",girl);

        executorService.shutdown();


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

    static class Result{
        private Integer boy = 0;
        private Integer girl = 0;

        public Integer getBoy() {
            return boy;
        }

        public void setBoy(Integer boy) {
            this.boy = boy;
        }

        public Integer getGirl() {
            return girl;
        }

        public void setGirl(Integer girl) {
            this.girl = girl;
        }

        public void boyInc(){
            boy++;
        }

        public void girlInc(){
            girl++;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "boy=" + boy +
                    ", girl=" + girl +
                    '}';
        }
    }

    static class ProductChild implements Callable<Result> {


        private ThreadLocal<Result> resThreadLocal = new ThreadLocal<>();

        private Random random = new Random();

        @Override
        public Result call() throws Exception {
//            resThreadLocal.set(new Result());
//            Result res = resThreadLocal.get();
            Result res = new Result();
            while (res.getBoy() == 0){
                if (random.nextBoolean()){
                    res.boyInc();
                }else {
                    res.girlInc();
                }
            }
            return res;
        }
    }









}

