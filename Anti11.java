import java.util.Scanner;

public class Anti11 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int numberOfTest = sc.nextInt();
        final int [] array = new int [numberOfTest];
        for (int i = 0; i < numberOfTest ; i++) {
            array[i] = sc.nextInt();
        }
        final long modulo = (long) Math.pow(10,9) + 7;

        for (int i = 0; i < numberOfTest; i++) {
            final int length = array[i];
            long  a = 1;
            long  b =  1;
            for (int j = 0; j < length - 1; j++) {
                final long temp = a;
                a = a > modulo ? a % modulo + b : a + b;
                b = temp;
            }
            System.out.println((a + b) % modulo);
        }
        sc.close();
    }

}