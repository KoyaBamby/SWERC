import java.util.Arrays;
import java.util.Scanner;

public class SkyIsland {
    static int [] island;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int numberIsland = sc.nextInt();
        int numberOfBridges = sc.nextInt();
//        if(numberOfBridges < numberIsland && numberIsland > 2) {
//            System.out.println("NO");
//            return;
//        }

        island = new int[numberIsland];

        for (int i = 0; i < numberIsland ; i++) {
            island[i] = i;
        }

        for (int i = 0; i < numberOfBridges ; i++) {
            union(sc.nextInt()-1,sc.nextInt()-1);
        }
        int firstValue = island.length == 0 ? 0 : island[0];
        if(Arrays.stream(island).allMatch(value -> value == firstValue)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void union(int x,int y){
        link(find(x),find(y));
    }

    private static void link(int islandA, int islandB){
        island[islandA] = islandB;
    }

    private static int find(int indexIsland){

        int indexCurrentIsland = indexIsland;

        while(island[indexCurrentIsland] != indexCurrentIsland){
            indexCurrentIsland = island[indexCurrentIsland];
        }
        island[indexIsland] = indexCurrentIsland; // collapse

        return indexCurrentIsland; // on retourne l'island chef
    }
}
