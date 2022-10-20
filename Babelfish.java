import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Babelfish {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        Map<String, String> angFor = new HashMap<>();

        while (sc.hasNext()) {
            final String[] a = sc.nextLine().split(" ");

            if (a.length == 2) {
                angFor.put(a[1], a[0]);
            } else {
                System.out.println(angFor.getOrDefault(sc.next(), "eh"));
            }
        }
        sc.close();
    }
}
