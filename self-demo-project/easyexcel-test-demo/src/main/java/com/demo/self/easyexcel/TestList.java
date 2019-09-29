package com.demo.self.easyexcel;

import java.util.ArrayList;
import java.util.List;

public class TestList {



    public static void main(String[] args) {
        User a = new User("123", "123");
        User b = new User("111", "111");
        List<User> list = new ArrayList<User>();
        list.add(a);
        list.add(b);
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            change(u);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

    }

    public static void change(User u){
        String s = "2019-09-27 15:41:19.0";
        System.out.println(s.substring(0,18));
    }


}

class User{
    private String id;
    private String name;

    public User(String s, String s1) {
        this.id = s;
        this.name = s1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}