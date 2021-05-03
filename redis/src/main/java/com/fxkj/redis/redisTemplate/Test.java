package com.fxkj.redis.redisTemplate;

import com.google.common.primitives.Ints;
import com.sun.corba.se.spi.activation.TCPPortHelper;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        int[] ints = {2, 2, 1, 1, 1, 2, 2};
//        System.out.println(majorityElement(ints));
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
//        merge(nums1, 3, nums2, 3);
        String s =  "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            if (count > length / 2) {
                return i;
            }
            map.put(i, count);
        }
        return -1;
    }

    public static int majorityElement2(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.putIfAbsent(i, 0);
            int times = map.get(i) + 1;
            // System.out.printf("%d:%d\n", i, times);
            if (times > length / 2) {
                return i;
            }
            map.put(i, times);
        }
        return 0;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        List<Integer> list1 = IntStream.of(nums1).boxed().collect(Collectors.toList());
        list1.addAll(IntStream.of(nums2).boxed().collect(Collectors.toList()));
        list1.sort((o1, o2) -> o1 - o2);
        while (list1.remove(Integer.valueOf(0))) {
        }
        ;
        System.out.println(list1);
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
//        System.out.println(nums1);
    }

    public static boolean isPalindrome(String s) {
        String s1 = s.replaceAll(" ", "");
        String s2 = s1.replaceAll(",", "");
        String s3 = s2.replaceAll(":", "");
        String s4 = s3.toLowerCase();
        String reverse = new StringBuffer(s4).reverse().toString();
        return (reverse.equals(s4));
    }
}
