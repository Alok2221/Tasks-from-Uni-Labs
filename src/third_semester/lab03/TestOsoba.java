package third_semester.lab03;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestOsoba {
    public static void main(String[] args) {

        Osoba o1 = new Osoba("55012428711", "Jan", "Kowal");
        Osoba o2 = new Osoba("71073113434", "Adam", "Nowak");
        Osoba o3 = new Osoba("95051886426", "Maks", "Bien");
        Osoba o4 = new Osoba("95051886426", "Kuba", "Miech");

        Set<Osoba> osobaHashSet = new HashSet<>(Set.of(o1, o2, o3));
        // nie dodaje nowej osoby o tym samym PESELU
        osobaHashSet.add(o4);
        System.out.println(osobaHashSet);

        Set<Osoba> osobaTreeSet = new TreeSet<>(osobaHashSet);
        System.out.println(osobaTreeSet);

        Set<Osoba> osobaSetNazwisko = new TreeSet<>(Comparator.comparing(Osoba::getNazwisko));

        osobaSetNazwisko.addAll(osobaHashSet);
        // teraz można dodać osobę z tym samym PESELEM
        osobaSetNazwisko.add(o4);
        System.out.println(osobaSetNazwisko);


        Student s1 = new Student("53051273572", "Paweł", "Zdun", 1, 4);
        Student s2 = new Student("67043032142", "Gus", "Fring", 2, 3);
        Student s3 = new Student("72082289598", "Wiktor", "Domowy", 3, 3.5);
        Student s4 = new Student("95051958112", "Michał", "Zan", 4, 5);
        Set<Student> studentHashSet = new HashSet<>(Set.of(s1, s2, s3, s4));


        Set<Student> studentTreeSet = new TreeSet<>(studentHashSet);
        System.out.println(studentTreeSet);

        Set<Student> studentTreeAvg = new TreeSet<>(Comparator.comparing(Student::getSrednia));
        studentTreeAvg.addAll(studentHashSet);

        // nie doda osoby z tą samą średnią
        studentTreeAvg.add(new Student("93081862982", "Zbigniew", "Biel", 4, 5));

        System.out.println(studentTreeAvg);

        String text = "123455552w2389838889392932n3df3302";
        System.out.println(countDistinctCharacter(text));
    }

    //zad3
    //używając stream
//    private static int countDistinctCharacter(String text) {
//        return text.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.toSet())
//                .size();
//    }
    // używając HashSet
    private static int countDistinctCharacter(String text) {
        Set<Integer> uniqueChars = new HashSet<>();
        text.chars().forEach(uniqueChars::add);
        return uniqueChars.size();
    }

    // używając pętli
//    private static int countDistinctCharacter(String text) {
//        boolean[] symbol = new boolean[Character.MAX_VALUE];
//        int count = 0;
//
//        for (char c : text.toCharArray()) {
//            if (!symbol[c]) {
//                symbol[c] = true;
//                count++;
//            }
//        }
//        return count;
//    }
}
