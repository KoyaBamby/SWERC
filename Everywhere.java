import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Everywhere{
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int t = sc.nextInt();
        int k = 0;
        for (int i = 0; i < t; i++) {
            k = sc.nextInt();
            final Set<String> set = new HashSet<>();
            for (int j = 0; j < k; j++) {
                set.add(sc.next());
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}