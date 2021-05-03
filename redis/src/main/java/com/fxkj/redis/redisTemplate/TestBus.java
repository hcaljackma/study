package com.fxkj.redis.redisTemplate;


import com.google.common.eventbus.EventBus;

public class TestBus {

    /**
     * Google Guaua 实现Event Bus
     * 默认使用PreThreadQueueDispatcher分发器
     * (该分发器内部维护的Executor是执行线程run方法,既使用主线程执行监听方法)
     * 该分发器是每个线程内部维护的一个queue
     * 每个线程互不干扰(都利于本身线程去串行的执行观察者方法)
     */
    public static void testPerThreadQueueDispather() {
        EventBus eventBus = new EventBus();

        //观察者1
        DataObserver1 dataObserver1 = new DataObserver1();
        //观察者2
        DataObserver2 dataObserver2 = new DataObserver2();

        eventBus.register(dataObserver2);
        eventBus.register(dataObserver1);

        Thread t1 = new Thread(() -> {
            eventBus.post("信息1;");
            eventBus.post("信息3;");
        });

        Thread t2 = new Thread(() -> {
            eventBus.post("信息2；");
        });

        Thread t3 = new Thread(() -> {
            eventBus.post(123);
        });

        t1.start();
        t2.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
    }

    public static void main(String[] args) {
        testPerThreadQueueDispather();
    }
}
