package com.fxkj.redis.redisTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class RedisConfiguration {

    public static void main(String[] args) {
        Function<Integer, Integer> f = s -> s++;
        Function<Integer, Integer> g = s -> s * 2;

        System.out.println(f.apply(2));
        System.out.println(g.apply(2));
        System.out.println("______________________________________________");
        Predicate<String> p = o -> o.equals("test");
        Predicate<String> j = o -> o.startsWith("t");
        boolean res = p.negate().test("test");
        System.out.println(res);

        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

}