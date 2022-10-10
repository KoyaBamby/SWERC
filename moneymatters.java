import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class moneymatters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dette = new int[n];

        List<Set<Integer>> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dette[i] = sc.nextInt();
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            for (Set<Integer> setInt : s) {
                if (setInt.contains(a) || setInt.contains(b)) {
                    setInt.add(a);
                    setInt.add(b);
                }
            }
        }

        for (Set<Integer> set : s) {
            for (Set<Integer> set2 : s) {
                if (set.containsAll(set2) && !set.equals(set2)) {
                    set.addAll(set2);
                    set2.clear();
                }
            }
        }

        boolean poss = true;

        for (Set<Integer> set : s) {
            if (set.stream().mapToInt(v -> dette[v]).sum() != 0) {
                System.out.println("IMPOSSIBLE");
                poss = false;
            }
        }
        if(poss) System.out.println("POSSIBLE");
        sc.close();
    }
}
