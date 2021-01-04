package com.xsw.activitiapi.simplecase;

import cn.hutool.core.lang.Console;
import com.xsw.activitiapi.simplecase.model.Employee;
import com.xsw.activitiapi.simplecase.model.SexEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Java stream
 */
public class Demo5 {

    public static void main(String[] args) {
        List<Employee> employeeArrayList = new ArrayList<>();
        Employee employee1 = new Employee("tom1", SexEnum.MALE.toString(), 11, 122d, "上海666区");
        Employee employee2 = new Employee("tom2", SexEnum.FEMALE.toString(), 22, 156d, "上海666区");
        Employee employee3 = new Employee("tom3", SexEnum.MALE.toString(), 32, 589d, "上海666区");
        Employee employee4 = new Employee("tom4", SexEnum.FEMALE.toString(), 45, 289d, "上海666区");
        Employee employee5 = new Employee("tom5", SexEnum.MALE.toString(), 43, 1000d, "上海666区");
        Employee employee6 = new Employee("tom6", SexEnum.MALE.toString(), 56, 1999d, "上海666区");
        Employee employee7 = new Employee("tom7", SexEnum.FEMALE.toString(), 99, 3452d, "上海666区");
        Employee employee8 = new Employee("tom8", SexEnum.MALE.toString(), 99, 6666d, "上海666区");
        Employee max = new Employee("Tom", SexEnum.FEMALE.toString(), 78, 9999d, "上海666区");
        Employee min = new Employee("Jerry", SexEnum.FEMALE.toString(), 10, 100d, "上海1区");
        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);
        employeeArrayList.add(employee4);
        employeeArrayList.add(employee5);
        employeeArrayList.add(employee6);
        employeeArrayList.add(employee7);
        employeeArrayList.add(employee8);
        employeeArrayList.add(max);
        employeeArrayList.add(min);
        Console.log("初始集合大小：{}", employeeArrayList.size());

        //从员工集合中筛选出salary大于8000的员工，并放置到新的集合里。
        List<Employee> collect = employeeArrayList.stream().filter(employee -> employee.getSalary() > 8000).collect(Collectors.toList());
        Console.log("salary大于8000的员工：{}", collect);
        //统计员工的最高薪资、平均薪资、薪资之和。
        Employee maxEmployee = employeeArrayList.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        Employee minEmployee = employeeArrayList.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
        Console.log("最高薪资:{}", maxEmployee);
        Console.log("最低薪资:{}", minEmployee);

        Double avg = employeeArrayList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        Console.log("平均薪资:{}", avg);

        Optional<Double> reduce = employeeArrayList.stream().map(Employee::getSalary).reduce(Double::sum);
        Console.log("薪资之和:{}", reduce.get());

        // 将所有员工的薪资+1000
        List<Double> addSalaryList = employeeArrayList.stream().map(x -> x.getSalary() + 1000).collect(Collectors.toList());
        Console.log("将所有员工的薪资+1000:{}", addSalaryList);

        //将员工按薪资从高到低排序，同样薪资者年龄小者在前。
        List<Employee> sortEmployeeList = employeeArrayList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
        Console.log("员工按薪资从高到低排序,{}", sortEmployeeList);

        //将员工按性别分类，将员工按性别和地区分类，将员工按薪资是否高于8000分为两部分
    }
}
