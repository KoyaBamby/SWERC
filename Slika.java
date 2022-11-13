import java.util.*;
import java.util.stream.IntStream;

public class Slika {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int k = sc.nextInt();
        final int m = sc.nextInt();
        int [][] canevas = new int[n][n];
        for (int [] a: canevas) {
            Arrays.fill(a,1);
        }
        int numberOfSave = 0;
        final int [][][] saves = new int[m][n][n];

        for (int i = 0; i <m ; i++) {
               final String command = sc.next();
               switch (commandEnum.valueOf(command)){
                   case PAINT : {
                       final int c = sc.nextInt();
                       final int x1 = sc.nextInt();
                       int y1 = sc.nextInt();
                       final int x2 = sc.nextInt();
                       final int y2 = sc.nextInt();
                       boolean b = false;
                       for (int j = x1; j <= x2 ; j++) {
                           for (int l = y1; l <= y2; l+=2) {
                                canevas[j][l] = c;
                           }
                           if(!b){
                               y1++;
                               b=true;
                           } else {
                               b = false;
                               y1--;
                           }
                       }
                       break;
                   }
                   case LOAD :
                       canevas = saves[sc.nextInt()];
                       break;
                   case SAVE :
                       final int [] [] newArray = new int [n][n];
                       for (int j = 0; j < n; j++) {
                           for (int l = 0; l < n; l++) {
                               newArray [j][l] = canevas [j] [l];
                           }
                       }
                       saves[++numberOfSave] = newArray;
               }
        }

        StringBuilder sb = new StringBuilder();
        for (int [] lines: canevas ) {
            for (int i : lines) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


    public enum commandEnum{
       PAINT,LOAD,SAVE
    }
}
