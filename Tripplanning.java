import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Tripplanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        StringBuilder ordre = new StringBuilder();

        Map<Pair, Integer> setP = new HashMap<>();

        //Mettre les paires et leur contraire dans la hashtable
        for (int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a <= N && b <= N) {
                setP.put(new Pair(a, b), i);
                setP.put(new Pair(b, a), i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i == N) {
                //trajet retour maison
                Pair k = new Pair(i, 1);
                if (!setP.containsKey(k)) {
                    System.out.println("impossible");
                    return;
                } else {
                    ordre.append(setP.get(k));
                }
            } else {
                //trajet de n ville à n+1
                Pair k = new Pair(i, i + 1);
                if (!setP.containsKey(k)) {
                    System.out.println("impossible");
                    return;
                } else {
                    ordre.append(setP.get(k) + "\n");
                }
            }
        }
        System.out.println(ordre.toString());
        sc.close();
    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
