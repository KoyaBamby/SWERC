import java.util.*;

public class Sort {

    private static class Number {
        int index;
        int occurence;
        int nombre;

        public Number(int i, int n){
            index = i;
            occurence = 0;
            nombre = n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Integer, Number> valeurs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int suivant = sc.nextInt();
            Number number = valeurs.getOrDefault(suivant, new Number(i,suivant));
            number.occurence++;
            valeurs.put(suivant, number);
        }

        List<Number> listNumber = new ArrayList<>(valeurs.values());
        Comparator<Number> byOccurence = (n1, n2) -> {
            if(n1.occurence != n2.occurence) return n2.occurence - n1.occurence;
            return n1.index - n2.index;
        };
        listNumber.sort(byOccurence);
        
        StringBuilder sb = new StringBuilder();
        for (Number number : listNumber) {
            for (int i = 0; i < number.occurence; i++) {
                sb.append(number.nombre).append(" ");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

        sc.close();
    }
}
