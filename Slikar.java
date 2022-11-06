import java.util.Scanner;
import java.util.Set;

public class Slikar {
    static char[][] map;
    static Set<Integer> flooded;
    static Set<Integer> S;
    static int D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int step = 0;
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] tmp = sc.next().toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] == '*') {
                    flooded.add(i * c + j);
                } else if (tmp[j] == 'D') {
                    D = (i * c + j);
                }
                
            }
            map[i] = tmp;
        }
        sc.close();

        while (!finished()) {
            step++;
        }
        if(S.isEmpty()) System.out.println("KAKTUS");
        else System.out.println(step);
    }

    
    static public void flood() {
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0: // haut

                    break;
                case 1: // bas

                    break;
                case 2: // gauche

                    break;
                case 3: // droite

                    break;
            }
        }
    }

    static public boolean isFloodable(int x, int y) {
        switch (map[x][y]) {
            case '.':
            case 'S':
                return true;
            default:
                return false;
        }
    }

    static public boolean finished() {
        return S.contains(D) || !S.isEmpty();
    }
}
