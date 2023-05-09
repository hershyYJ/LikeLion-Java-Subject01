package main.java.ex02;

import java.util.Scanner;

public class Rabbit {
    public static int rabbit(int n){
        if(n==1) return 1;
        else if(n==2) return 1;
        else return rabbit(n-2)+rabbit(n-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        n = in.nextInt();

        System.out.println(rabbit(n) +"쌍");
    }
}
