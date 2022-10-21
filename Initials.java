import java.util.*;

public class Initials {
    //https://open.kattis.com/problems/initials

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        final String [] names = new String[sc.nextInt()];
        final String [] initials = new String [names.length];
        for (int i = 0; i < names.length; i++) {
            final String[] s = sc.nextLine().split(" ");
            names[i] = s[1].toLowerCase() + s[0].toLowerCase();
        }
        sc.close();

        Arrays.sort(names); // we could sort the array directly when adding people
    }
}
