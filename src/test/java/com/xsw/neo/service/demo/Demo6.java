package com.xsw.neo.service.demo;

import cn.hutool.core.lang.Console;
import com.google.common.collect.Lists;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/5/25 15:37
 */
public class Demo6 {

    private static void unboundedWildcard(List<? extends Person> persons) {
        persons.forEach(person -> {
            System.out.println(person.getName());
        });
    }

    private static void upperBoundWildcard(List<? extends T> args1, List<T> args2) {
        for (T t : args1) {
            args2.add(t);
        }
        Console.log(args2);
    }

    private static void netherWildcard(List<? super T> args1, List<T> args2) {
        for (T t : args2) {
            args1.add(t);
        }
        Console.log(args1);
    }

    private static <T> T createClass(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Man man = new Man();
        man.setName("男人");

        Women women = new Women();
        women.setName("女人");

        List<Man> manList = Lists.newArrayList();
        manList.add(man);

        List<Women> womenList = Lists.newArrayList();
        womenList.add(women);

        // unboundedWildcard(manList);

        List<Person> personList = Lists.newArrayList();
        // upperBoundWildcard(womenList, personList);

        // netherWildcard(manList, personList);

        Man createDefault = createClass(Man.class);
        Person person = createClass(Person.class);
        createDefault.setName("man");
        System.out.println("----->" + createDefault.getName());
    }
}
