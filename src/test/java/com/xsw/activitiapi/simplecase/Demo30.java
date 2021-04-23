package com.xsw.activitiapi.simplecase;

import java.util.Stack;

/**
 * @author xueshengwen
 * @since 2021/4/22 11:09
 */
public class Demo30 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("张三");
        stack.push("李四");
        stack.push("王五");

        System.out.println(stack);

        stack.pop();

        System.out.println("返回栈顶的元素，并且将该栈顶元素出栈:" + stack);

//        stack.peek();
//
//        System.out.println("返回栈顶的元素，但不弹出该栈顶元素:" + stack);

        System.out.println(stack.search("李四"));

        System.out.println(stack.size());

        stack.stream().forEach(System.out::print);
    }
}
