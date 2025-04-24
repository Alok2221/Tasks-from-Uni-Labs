package third_semester.lab07.exe01;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class MapOfCapitals {
    private final static String capitals = """
            Albania/Tirana
            Andora/Andorra la Vella
            Austria/Wiedeń
            Belgia/Bruksela
            Białoruś/Mińsk
            Bośnia i Hercegowina/Sarajewo
            Bułgaria/Sofia
            Chorwacja/Zagrzeb
            Czarnogóra/Podgorica
            Czechy/Praga
            Dania/Kopenhaga
            Estonia/Tallinn
            Finlandia/Helsinki
            Francja/Paryż
            Grecja/Ateny
            Hiszpania/Madryt
            Holandia/Amsterdam
            Irlandia/Dublin
            Islandia/Reykjavík
            Kosowo/Prisztina
            Liechtenstein/Vaduz
            Litwa/Wilno
            Luksemburg/Luksemburg
            Łotwa/Ryga
            Macedonia/Skopje
            Malta/La Valletta
            Mołdawia/Kiszyniów
            Monako/Monako
            Niemcy/Berlin
            Norwegia/Oslo
            Polska/Warszawa
            Portugalia/Lizbona
            Rosja/Moskwa
            Rumunia/Bukareszt
            San Marino/San Marino
            Serbia/Belgrad
            Słowacja/Bratysława
            Słowenia/Lublana
            Szwajcaria/Berno
            Szwecja/Sztokholm
            Ukraina/Kijów
            Watykan/Watykan
            Węgry/Budapeszt
            Wielka Brytania/Londyn
            Włochy/Rzym
            """;

    public static void main(String[] args) {

        Collator polish = Collator.getInstance(new Locale("pl", "PL"));

        //Wyświetl dane uporządkowane na podstawie kraju
        mapCapitals().entrySet().stream()
                .sorted((e1, e2) -> polish.compare(e1.getKey(), e2.getKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " → " + entry.getValue()));

        System.out.println();
        //Wyświetl dane w odwróconym porządku na podstawie kraju
        mapCapitals().entrySet().stream()
                .sorted((e1, e2) -> polish.compare(e2.getKey(), e1.getKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " → " + entry.getValue()));
    }


    private static Map<String, String> mapCapitals() {
        return Arrays.stream(MapOfCapitals.capitals.split("\n"))
                .map(line -> line.split("/"))
                .filter(part -> part.length == 2)
                .collect(Collectors.toMap(
                        part -> part[0].trim(),
                        part -> part[1].trim()
                ));
    }
}
