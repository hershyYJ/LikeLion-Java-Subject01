package ex01;
import java.util.Scanner;

public class Factorial {
    public static int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오 : ");
        int n = sc.nextInt();

        System.out.println(n + "! = " + factorial(n));
    }
}
