import java.util.Scanner;

public class SecretSanta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if(n>100000) n = 100000;
        double total = 1;
        double nFact = 1;
        for (int i = 2; i <= n; i++) {
            nFact *= i;
            if (i % 2 == 0) {
                total = total - 1 / nFact;
            } else {
                total = total + 1 / nFact;
            }
        }
        System.out.println(total);
        sc.close();
    }
}
