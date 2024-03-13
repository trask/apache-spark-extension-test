package com.github.trask;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("before");
        Class.forName("org.apache.spark.scheduler.LiveListenerBus");
        System.out.println("after");
    }
}
