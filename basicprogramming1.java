import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class basicprogramming1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] tabA = new int[n];

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
                int[] tabA3 = { tabA[0], tabA[1], tabA[2] };
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
                for (int i : tabA) {
                    sb.append((char) ((i % 26) + 97));
                }
                System.out.println(sb.toString());
                break;
            case 7:
                int index = 0;
                Set<Integer> indexs = new HashSet<>();
                while (true) {
                    index = tabA[index];
                    if (!indexs.add(index)) {
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
