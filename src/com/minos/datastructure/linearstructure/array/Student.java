package com.minos.datastructure.linearstructure.array;

/**
 * @Author: minos
 * @Date: 2020/9/15 18:49
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> stu1 = new Array<>();
        stu1.addLast(new Student("minos", 100));
        stu1.addLast(new Student("tang", 100));
        stu1.addLast(new Student("yang", 100));

        System.out.println(stu1);
    }
}
