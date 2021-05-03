package com.fxkj.redis.redisTemplate;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataObserver1 {

    @Subscribe
    public void func(String msg) throws InterruptedException {
        log.info("消息开始~:" + msg);
        Thread.sleep(2000);
        log.info("消息结束~" + msg);
    }

}
