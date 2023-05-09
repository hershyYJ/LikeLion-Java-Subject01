package ex03;
import java.util.Scanner;

public class LegoBlock {
    public static void hanoi(int n, int from, int to) {
        if(n == 1) {
            System.out.println(n + "번 레고를 " + from + "에서 " + to + "로 옮깁니다.");
        }
        if(n > 1) {
            hanoi(n-1, from, 6-from-to);
        }
        System.out.println(n + "번 레고를 " + from + "에서 " + to + "로 옮깁니다.");
        if(n > 1) {
            hanoi(n-1, 6-from-to, to);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n을 입력하시오 : ");
        int n = sc.nextInt();
        System.out.print("i를 입력하시오 : ");
        int i = sc.nextInt();
        System.out.print("j를 입력하시오 : ");
        int j = sc.nextInt();

        hanoi(n, i, j);
    }
}
