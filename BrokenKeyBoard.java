package java16_1022.java;

import java.util.*;

/**
 * 打印出坏的键盘
 */
public class BrokenKeyBoard {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String actual = scanner.next();
            String expected = scanner.next();
            actual = actual.toUpperCase();
            expected = expected.toUpperCase();

            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                actualSet.add(actual.charAt(i));
            }
            Set<Character> brokenBoard = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (actualSet.contains(c)) {
                    continue;
                }
                if (brokenBoard.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenBoard.add(c);
            }
        }
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String actual = scanner.next();
            String expected = scanner.next();

            actual = actual.toUpperCase();
            expected = expected.toUpperCase();

            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                actualSet.add(actual.charAt(i));
            }
            Set<Character> brokenBoard = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (actualSet.contains(c)) {
                    continue;
                }
                if (brokenBoard.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenBoard.add(c);
            }
            System.out.println();
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String expected = scanner.next();
            String actual = scanner.next();

            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            Set<Character> setActual = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                setActual.add(actual.charAt(i));
            }
            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (setActual.contains(c)) {
                    continue;
                }
                if (brokenKey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKey.add(c);
            }
            System.out.println();
        }
    }


        //用于将矩阵数组打印到屏幕
        public static void display(int[][] m){

                for (int i=0;i<3;i++){
                    for (int j=0;j<3;j++){
                        System.out.printf("%4d",m[i][j]);
                    }
                }
            }

        //用于对两个数组中存储的矩阵进行乘法运算
        public static int[][] multi(int[][] m1, int[][] m2){
        if (m1[0].length!=m2.length){
            return null;
        }
            int[][] m = new int[3][3];
            for(int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    for (int k=0;k<3;k++){
                        m[i][j] +=m1[i][k] * m2[k][j];
                    }
                }
            }
            return m;
        }


        public static void main4(String[] args){
            int[][] arr1 = { {1,2,3}, {1,2,3}, {1,2,3} };
            int[][] arr2 = { {1,2,3}, {1,2,3}, {1,2,3} };
           int[][] m = multi(arr1,arr2);
            display(arr1);
            System.out.println();
            display(arr2);
            System.out.println();
            display(m);
        }


}



