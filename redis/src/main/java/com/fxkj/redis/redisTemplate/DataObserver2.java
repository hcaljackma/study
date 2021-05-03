package com.fxkj.redis.redisTemplate;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataObserver2 {

    @Subscribe
    public void func(Integer msg) throws InterruptedException {
        log.info("Integer msg" + msg);
    }

}
