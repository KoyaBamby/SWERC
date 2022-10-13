import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class MountainBiking {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            final int N = sc.nextInt();
            final double g = sc.nextDouble();

            int[] distance = new int[N];
            double[] angleD = new double[N];

            for (int i = 0; i < N; i++) {
                distance[i] = sc.nextInt();
                angleD[i] = sc.nextInt();
            }

            double v = 0;

            List<Double> listeV = new ArrayList<>();

            for (int i = N-1; i >= 0; i--) {
                //v+1 = sqrt(v*v + 2*g*cos(O)*d)
                v = Math.sqrt(v*v + 2*g*Math.cos(Math.toRadians(angleD[i]))*distance[i]);
                listeV.add(v);
            }

            for (int i = listeV.size()-1; i >= 0; i--) {
                System.out.println(listeV.get(i));
            }
            sc.close();
        }
    }
