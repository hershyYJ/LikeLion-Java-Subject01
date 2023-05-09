package main.java.ex03;

import java.util.Scanner;

public class LegoBlock {
    public static void lego(int n, int from, int to, int other){
        if(n==0){
            return;
        }

        lego(n-1, from, other, to);
        System.out.println(n+"번 레고를 "+from+"에서 " +to+"로 옮깁니다.");
        lego(n-1, other, to, from);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n, i, j;
        n = in.nextInt();
        i = in.nextInt();
        j = in.nextInt();

        lego(n, i, j, 6-i-j);
    }
}
