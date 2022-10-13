import java.util.Scanner;

public class AReal {
    public static void main(String[] args) throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        
        double a = Math.sqrt(sc.nextDouble()) * 4;
        System.out.println(a);

        sc.close();
    }
}
