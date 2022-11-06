import java.util.Arrays;
import java.util.Scanner;

public class SkyIslands {
    static int[] islands;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int m = sc.nextInt();
        int a, b;
        islands = new int[n];
        Arrays.fill(islands, -1);

        for (int i = 0; i < m; i++) {
            a = sc.nextInt() - 1; // Offset de -1 par rapport au tableau
            b = sc.nextInt() - 1;
            union(a, b);
        }

        for (int ile : islands) {
            if (ile < 0) {
                if (-ile == n) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                break;
            }
        }

        sc.close();
    }

    private static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        if (parentA != parentB) {
            if (islands[parentA] >= islands[parentB]) {
                islands[parentB] += islands[parentA];
                islands[parentA] = parentB;
            } else {
                islands[parentA] += islands[parentB];
                islands[parentB] = parentA;
            }
        }
    }

    private static int findParent(int k) {
        int index = k;
        while (islands[index] > 0) {
            index = islands[index];
        }
        return index;
    }
}
