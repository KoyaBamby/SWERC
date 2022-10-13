import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BasicProgramming1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        long[] tabA = new long[n];

        for (int j = 0; j < n; j++) {
            tabA[j] = sc.nextInt();
        }

        switch (t) {
            case 1:
                System.out.println(7);
                break;
            case 2:
                if (tabA[0] > tabA[1])
                    System.out.println("Bigger");
                else if (tabA[0] == tabA[1])
                    System.out.println("Equal");
                else
                    System.out.println("Smaller");
                break;
            case 3:
                long[] tabA3 = { tabA[0], tabA[1], tabA[2] };
                Arrays.sort(tabA3);
                System.out.println(tabA3[1]);
                break;
            case 4:
                System.out.println(Arrays.stream(tabA).sum());
                break;
            case 5:
                System.out.println(Arrays.stream(tabA).filter(v -> v % 2 == 0).sum());
                break;
            case 6:
                StringBuilder sb = new StringBuilder();
                for (long i : tabA) {
                    sb.append((char) ((i % 26) + 97));
                }
                System.out.println(sb);
                break;
            case 7:
                long index = 0;
                Set<Integer> indexs = new HashSet<>();
                while (true) {
                    index = tabA[(int) index];
                    if (!indexs.add((int) index)) {
                        System.out.println("Cyclic");
                        break;
                    }
                    if (index >= n) {
                        System.out.println("Out");
                        break;
                    }
                    if (index == n - 1) {
                        System.out.println("Done");
                        break;
                    }
                }
                break;
            default:
                break;
        }
        sc.close();
    }
}
