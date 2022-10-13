import java.util.Arrays;
import java.util.IllegalFormatWidthException;
import java.util.Map;
import java.util.Scanner;

public final class moneymatters {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        int[] tabDette = new int[n];
        for (int i = 0; i < n; i++) {
            tabDette[i] = sc.nextInt();
        }

        MapRembourse mapRembourse = new MapRembourse(tabDette);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            mapRembourse.rembourse(a,b);
        }

            System.out.println(mapRembourse.estPossible() ? "POSSIBLE":"IMPOSSIBLE");

        sc.close();
    }

    private static class MapRembourse{

        private int[] tabDette;
        private int[] rembourseMap;

        public MapRembourse(int[] tabDette) {
            this.tabDette = tabDette;
            rembourseMap = new int[tabDette.length];
            for (int i = 0; i < tabDette.length; i++) {
                rembourseMap[i] = i;
            }
        }

        public boolean estPossible(){
            return Arrays.stream(tabDette).allMatch(v -> v==0);
        }

        private int getIndexDeRemboursement(int indexPersonne){
            int indexPersonneEnCours = indexPersonne;

            while(rembourseMap[indexPersonneEnCours] != indexPersonneEnCours){
                indexPersonneEnCours = rembourseMap[indexPersonneEnCours];
            }
            rembourseMap[indexPersonne] = indexPersonneEnCours;

            return indexPersonneEnCours;
        }

        public void rembourse(int a, int b){
            int bMoney = getIndexDeRemboursement(a);
            int aMoney = getIndexDeRemboursement(b);

            egalise(bMoney, aMoney);
            rembourseMap[bMoney] = aMoney;
        }

        private void egalise(int a, int b){
            int argent = tabDette[a];

            tabDette[a] -= argent;
            tabDette[b] += argent;
        }
    }

}