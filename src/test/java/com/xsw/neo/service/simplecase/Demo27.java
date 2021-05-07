package com.xsw.neo.service.simplecase;


import cn.hutool.bloomfilter.BloomFilter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xueshengwen
 * @since 2021/4/14 15:15
 */
public class Demo27 {

    @Autowired
    private BloomFilter bloomFilter;

    public boolean contains(String s) {
        return bloomFilter.contains(s);
    }

    public static void main(String[] args) {

        Demo27 demo27 = new Demo27();
        System.out.println(demo27.contains("zhangsan"));
    }
}
