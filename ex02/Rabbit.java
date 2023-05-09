package ex02;
import java.util.Scanner;

public class Rabbit {
    public static int fibo(int n) {
        if(n <= 2) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오 : ");
        int n = sc.nextInt();

        System.out.println(n + "개월 차에 존재하는 토끼의 수 : " + fibo(n) + "마리");
    }
}
