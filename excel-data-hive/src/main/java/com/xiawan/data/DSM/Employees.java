package com.xiawan.data.DSM;

/**
 *
 * @author wenkai li
 */
public class Employees {
    private static int id;
    private static String name;
    private static int age;
    private static String gender;
    private static double salary;

    public Employees(int id, String name, int age, String gender, double salary) {
        Employees.id = id;
        Employees.name = name;
        Employees.age = age;
        Employees.gender = gender;
        Employees.salary = salary;
    }

    public Employees() {
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        Employees.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        Employees.name = name;
    }

    public static int getAge() {
        return age;
    }

    public void setAge(int age) {
        Employees.age = age;
    }

    public static String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        Employees.gender = gender;
    }

    public static double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        Employees.salary = salary;
    }
}
