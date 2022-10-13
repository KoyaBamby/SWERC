import java.util.*;
import java.util.stream.Collectors;

public class EngineeringEnglish {
    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        List<String> text = new ArrayList<>();

        while (s.hasNextLine()){
            final String string = s.nextLine();
            if(string.isEmpty()) break;
            text.addAll(Arrays.stream(string.split(" ")).collect(Collectors.toList()));
        }

        final Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String s1 : text) {
            if(!set.add(s1.toLowerCase())){
                sb.append(".").append(" ");
            } else {
                sb.append(s1).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
