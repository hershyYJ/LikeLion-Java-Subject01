package main.java.ex00;

public class RecLion {
    public static void Reclion(int n){
        if(n > 10) {
            return;
        }
        System.out.println("Hello Baby Lion "+ String.format("%02d",n));
        Reclion(++n);
    }
    public static void main(String[] args) {
        Reclion(0);
    }
}
