package com.itheima.studentsystem;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        table:
        while (true) {
            System.out.println("---------------------------------一个低级的学生系统---------------------------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.println("请输入你的选择");
            //选择
            Scanner sc1 = new Scanner(System.in);
            String choose = sc1.next();
            ///-----------------------------------------------------
            switch (choose) {
                case "1":
                    System.out.println("添加学生");
                    students.add(addstudednt());
                    break;
                case "2":
                    System.out.println("删除学生");
                    System.out.println("输入要删除的学生数据的编号");
                    int testid = sc1.nextInt();
                    deletestudent(students, testid);
                    break;
                case "3":
                    System.out.println("修改学生");
                    System.out.println("输入要修改的学生的编号");
                    int id = sc1.nextInt();
                    updatestudent(students, id);
                    break;
                case "4":
                    System.out.println("查询学生");
                    System.out.println("输入要查询的学生姓名");
                    String selname = sc1.next();
                    selectstudent(students, selname);
                    break;
                case "5":
                    System.out.println("退出");
                    break table;
                default:
                    System.out.println("没有该服务，请重新选择");
                    break;
            }
        }
    }

    /// ----------------------------------------------------------------------------------
    //添加学生的方法
    public static Student addstudednt() {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        //添加编号
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("请输入要添加的学生编号");
            int id = sc.nextInt();
            if (id > 0) {
                stu.setId(id);//存入对象中-->存到集合中
                break;
            } else {
                System.out.println("无效数据，请重新输入");
            }
        }
        //添加姓名
        System.out.println("请输入要添加的学生姓名");
        String name = sc.next();
        stu.setName(name);
        //添加年龄
        while (true) {
            System.out.println("请输入要添加的学生年龄");
            int age = sc.nextInt();
            if (age > 0) {
                stu.setAge(age);//存入对象中-->存到集合中
                break;
            } else {
                System.out.println("无效数据，请重新输入");
            }
        }
        //添加地址
        System.out.println("输入学生家庭地址");
        String address = sc.next();
        stu.setAddress(address);
        System.out.println("添加成功!正在跳转主页面...");
        return stu;
    }

    /// ---------------------------------------------------------------------
    //查询学生的方法
    public static void selectstudent(ArrayList<Student> students, String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                System.out.println("----查询结果----");
                System.out.println(students.get(i).getId() + "," + students.get(i).getName() + "," + students.get(i).getAge() + "," + students.get(i).getAddress());
                System.out.println("查询成功!正在跳转主界面...");
                return;
            }
        }
        System.out.println("暂无数据");
    }

    /// --------------------------------------------------------------------------
    //删除学生的方法
    public static void deletestudent(ArrayList<Student> students, int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(students.get(i));
                System.out.println("删除成功!正在跳转主界面...");
                return;
            }
        }
        System.out.println("暂无数据");
    }

    /// --------------------------------------------------------------------------
    //修改学生信息的方法
    public static void updatestudent(ArrayList<Student> students, int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.修改名字/2.修改年龄/3.修改地址/4.退出");
        String needid = sc.next();
        table:
        while (true) {
            //System.out.println("1.修改名字/2.修改年龄/3.修改地址/4.退出");
            switch (needid) {
                case "1":
                    if (students.get(id - 1).getId() == id) {
                        System.out.println("请输入新姓名");
                        String name = sc.next();
                        students.get(id - 1).setName(name);
                        System.out.println("修改成功");
                        return;
                    } else {
                        System.out.println("暂无数据");
                        break;
                    }
                case "2":
                    if (students.get(id - 1).getId() == id) {
                        System.out.println("请输入新年龄");
                        int age = sc.nextInt();
                        students.get(id - 1).setAge(age);
                        System.out.println("修改成功");
                        return;
                    } else {
                        System.out.println("暂无数据");
                        break;
                    }
                case "3":
                    if (students.get(id - 1).getId() == id) {
                        System.out.println("请输入新地址");
                        String address = sc.next();
                        students.get(id - 1).setAddress(address);
                        System.out.println("修改成功");
                        return;
                    }else{
                        System.out.println("暂无数据");
                    }
                case "4":
                    break table;
                default:
                    System.out.println("重新输入");
                    break;
            }
        }
    }
}



