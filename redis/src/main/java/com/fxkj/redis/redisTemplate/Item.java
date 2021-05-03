package com.fxkj.redis.redisTemplate;

public class Item {

    private String name;

    private String key;

    private String value;

    public Item() {
        this.name = "测试";
        this.key = "关键字";
        this.value = "对应的值";
    }

    @FunctionalInterface
    public interface PalindromeChecker {
        boolean isPalindromeChecker(String s);
    }


}
