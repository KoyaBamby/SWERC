import java.util.Scanner;

public class ZipLine {
    final int w,g,h,r;

    public ZipLine(int w, int g, int h, int r){
        this.w = w;
        this.g = g;
        this.h = h;
        this.r = r;
    }
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int numberOfTest = sc.nextInt();
        final ZipLine [] zipLines = new ZipLine[numberOfTest];

        for(int i = 0; i < numberOfTest ; i++) {
            zipLines[i] = new ZipLine(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        for (ZipLine zipLine: zipLines) {
            System.out.println(
                    Math.sqrt(Math.pow(Math.abs(zipLine.g - zipLine.h),2) + Math.pow(zipLine.w,2))
            ); // première valeur (cable minimal)

            System.out.println(
                    1d * Math.abs(zipLine.g - zipLine.r) / Math.abs(zipLine.h - zipLine.r) - 1 + Math.sqrt(Math.pow(zipLine.w,2) + Math.pow(zipLine.h,2))
            );
        }



    }
}
