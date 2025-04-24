package third_semester.lab04;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordsHelper {
    public static int countUniqueCharacters(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return getUniqueCharactersToSet(text).size();
    }

    public static Set<Character> getUniqueCharactersToSet(String text) {
        if (text == null || text.isEmpty()) {
            return Set.of();
        }
        return text.chars().distinct()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void main(String[] args) {
        String text = "hdhdhdks892823902";
        System.out.println(countUniqueCharacters(text));
        System.out.println(getUniqueCharactersToSet(text));
    }
}