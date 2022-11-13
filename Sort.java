import java.util.*;

public class Sort {

    private static class Nombre {
        int index;
        int occurence;
        int nombre;

        public Nombre(int i,int n){
            index = i;
            occurence = 0;
            nombre = n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        Map<Integer,Nombre> valeurs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int suivant = sc.nextInt();
            Nombre nombre = valeurs.getOrDefault(suivant, new Nombre(i,suivant));
            nombre.occurence++;
            valeurs.put(suivant, nombre);
        }

        List<Nombre> listNombre = new ArrayList<>(valeurs.values());
        Comparator<Nombre> byOccurence = (n1,n2) -> {
            if(n1.occurence != n2.occurence) return n2.occurence - n1.occurence;
            return n1.index - n2.index;
        };
        listNombre.sort(byOccurence);

        final StringBuilder sb = new StringBuilder();
        for (Nombre nombre : listNombre) {
            for (int i = 0; i < nombre.occurence; i++) {
                sb.append(nombre.nombre).append(" ");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        sc.close();
    }
}