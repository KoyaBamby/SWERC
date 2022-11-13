import java.util.*;

public class Slika {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int k = sc.nextInt();
        final int m = sc.nextInt();
        final Map<Integer,Integer> saveNumberWithCommandIndex = new HashMap<>(100);
        final int [][] instructions = new int[m][6];
        int [][] canvas = new int[n][n];

        // fill all case with 1
        for (int [] a: canvas) {
            Arrays.fill(a,1);
        }

        int numberOfSave = 0;

        for (int i = m - 1; i >= 0 ; i--) {
            final String command = sc.next();
            final CommandEnum commandEnum = CommandEnum.valueOf(command);
            switch (commandEnum) {
                case SAVE: {
                    saveNumberWithCommandIndex.put(++numberOfSave, i);
                    instructions[i] = new int[]{2};
                    break;
                }
                case LOAD: {
                    instructions[i] = new int[]{1,sc.nextInt()};
                    break;
                }
                case PAINT: {
                    instructions[i] = new int[]{0, sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
                }
            }
        }
        sc.close();
        final boolean [][] caseEdited = new boolean[n][n];
        int countNumberOfCaseEdited = 0;
        int i = 0;
        while (countNumberOfCaseEdited < n*n && i < m){
//            System.out.println(i);
            int command = instructions[i][0];
            switch (command){
                case 0:{
                    int c = instructions[i][1];
                    int x1 = instructions[i][2];
                    int y1 = instructions[i][3];
                    int x2 = instructions[i][4];
                    int y2 = instructions[i][5];
//                    System.out.println(c + " " + x1 + " " + y1 + " " + x2 + " " + y2);
                    boolean shift = true;
                    for (int j = x1; j <= x2 ; j++) {
                        for (int l = shift ? y1 : y1 + 1; l <= y2; l+=2) {
                            if(!caseEdited[j][l]){
                                countNumberOfCaseEdited++;
                                caseEdited[j][l] = true;
                                canvas[j][l] = c;
                            }
                        }
                        shift = !shift;
                    }
                    break;
                }
                case 1:{
                    i = saveNumberWithCommandIndex.get(instructions[i][1]);
//                    System.out.println(i);
                }
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int [] lines: canvas ) {
            for (int line : lines) {
                sb.append(line).append(' ');
            }
            sb.append('\n');
        }
//        System.out.println("dd");
        System.out.println(sb);
    }

    public enum CommandEnum {
       PAINT,LOAD,SAVE
    }
}
