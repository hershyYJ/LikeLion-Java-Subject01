package main.java.ex01;
import java.util.Scanner;

public class Factorial {
    public static int fact(int n){
        if(n <= 1) return n;
        else return fact(n-1)*n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        n = in.nextInt();
        System.out.println(fact(n));
    }
}
