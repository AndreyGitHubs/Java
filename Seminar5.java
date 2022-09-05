import java.util.HashMap;
import java.util.Map;

public class Seminar5 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map = map.of("+", 5, "-", 5);
        String text = "a b c d";

        for (String word : text.split(" ")) {
            // if (!map.containsKey(word)) {
            // map.put(word, 0);
            // }
            // аналог ифа выше
            // map.putIfAbsent(word, 0);

            // map.put(word, map.get(word) + 1);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (var entry : map.entrySet()) {

        }
    }

}
