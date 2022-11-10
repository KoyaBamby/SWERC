import java.util.Scanner;

public class ShatteredCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int w = sc.nextInt();
        final int n = sc.nextInt();
        int totalArea = 0;
        for (int i = 0; i < n; i++) {
            totalArea += sc.nextInt() * sc.nextInt();
        }
        sc.close();
        System.out.println(totalArea/w);
    }
}
