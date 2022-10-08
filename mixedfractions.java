import java.util.Scanner;

public class mixedfractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        while (b != 0 && a != 0) {
            System.out.println(a / b + " " + a % b + " / " + b);
            a = sc.nextInt();
            b = sc.nextInt();
        }

        sc.close();
    }
}
