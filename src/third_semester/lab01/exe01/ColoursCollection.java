package third_semester.lab01.exe01;

import java.util.*;

public class ColoursCollection {
    public static void main(String[] args) {
        String colours = "Red,Green,Orange,White,Black";
        List<String> coloursList = new ArrayList<>(List.of(colours.split(",")));

        for (String s : coloursList) {
            System.out.println(s);
        }
        System.out.println();

        for (int i = 1; i < coloursList.size(); i++) {
            System.out.println(coloursList.get(i));
        }
        System.out.println();

        for (int i = coloursList.size() - 1; i >= 0; i--) {
            System.out.println(coloursList.get(i));
        }
        System.out.println();

        Iterator<String> iterator = coloursList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(coloursList.get(0));
        System.out.println(coloursList.get(2));

        coloursList.set(1, "Blue");
        coloursList.remove(1);
        System.out.println(coloursList.contains("Red"));
        coloursList.sort(String::compareTo);

        List<String> colour_list = new ArrayList<>(List.of("Red", "Blue", "Green"));
        coloursList.addAll(colour_list);
        List<String> subList = coloursList.subList(0, 3);

        subList.removeAll(colour_list);
        System.out.println();

        String linkedColours = "Red,Green,Black,White,Pink,Yellow";
        LinkedList<String> linkedList = new LinkedList<>(List.of(linkedColours.split(",")));
        linkedList.addFirst("Black");
        linkedList.addLast("Black");
        System.out.println(linkedList);
        System.out.println(linkedList.peekFirst());
        System.out.println();
        String[] array = linkedList.toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }
}