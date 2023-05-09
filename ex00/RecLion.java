package ex00;

public class RecLion {
    static int i = 0;
    public static void HelloLion(int n) {
        if(n == 0) return;
        System.out.print("Hello Baby Lion ");
        System.out.format("%02d\n", i);
        i++;
        HelloLion(n -1);
    }

    public static void main(String[] args) {
        HelloLion(11);
    }
}
