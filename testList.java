package java_1027.java;

import java.util.List;
import java.util.ArrayList;

public class testList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("java");
        list.add("C");
        list.add("C++");
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.subList(0,2));

    }



}
