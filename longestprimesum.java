import java.util.Scanner;

public class longestprimesum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long nombre = sc.nextLong();
        if (nombre % 2 == 0)
            System.out.println(nombre / 2);
        else
            System.out.println(((nombre - 3) / 2) + 1);
        sc.close();
    }
}
