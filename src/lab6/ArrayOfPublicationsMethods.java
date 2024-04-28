package lab6;

//  Zdefiniuj klasę ArrayOfPublicationsMethods w której zaimplementujemy funkcje statyczne:
//        a.   showPublications- która, wypisuje w kolejnych wierszach dane publikacji- elementy przekazanej parametrem  tablicy
//        b.   showPublicationsTitles- która, wypisuje w kolejnych wierszach
//                  tytuły publikacji- elementy przekazanej parametrem  tablicy
//        c.    calculateTotalIncome- która, dla będącej parametrem metody tablicy  obiektów Publication
//                  zwraca dochód jaki można uzyskać ze sprzedaży wszystkich publikacji w tablicy.
//        d.    countNumberOfCheaper- która, dla danej parametrem tablicy  obiektów Publication
//                  zwraca liczbę publikacji tańszych niż wartość przekazana drugim parametrem
//        e.    countAlmostSoldOut- która, dla danej parametrem tablicy  obiektów Publication
//                  zwraca liczbę publikacji będących na wyczerpaniu (liczba sztuk<=3)
//        f.    printAlmostSoldOut  - która, dla danej parametrem tablicy  obiektów Publication
//                  wyswietla publikacje będące na wyczerpaniu (liczba sztuk<=3)
//        g.    getPublicationsWithId  - która, dla danej parametrem tablicy  obiektów Publication
//                  zwraca Publikację o przekazanym drugim parametrem ident, lub null jeśli nie ma takiej publikacji
//        h.    findTitleFirstIndex - która, dla danej parametrem tablicy  obiektów Publication
//                  zwraca indeks pierwszego wystąpienia publikacji o tytule przekazanym drugim parametrem, lub -1 jeśli nie ma takiej publikacji
//        i.    findTitleLastIndex  - która, dla danej parametrem tablicy  obiektów Publication
//                  zwraca indeks pierwszego wystąpienia publikacji o tytule przekazanym drugim parametrem, lub -1 jeśli nie ma takiej publikacji
//        j.    getArrayOfTitles - która, dla danej parametrem tablicy  obiektów Publication
//                  zwróci tablicę tytułów publikacji
//        k.    increasePricesByPercentage , dla danej parametrem tablicy  obiektów Publication
//                  podwyższy ceny wszystkich jej publikacji o procent przekazany przez drugi parametr
//        l.    calculateTotalPriceTitle  która, dla danej parametrem tablicy  obiektów
//                  Publication i tytułu publikacji – drugi parametr, policzy całkowity koszt danego tytułu

import java.util.Arrays;
import java.util.Random;

public class ArrayOfPublicationsMethods {

    public static void showPublications(Publication[] arr) {
        for (Publication p : arr) {
            p.display();
        }
    }

    public static void showPublicationsTitles(Publication[] arr) {
        for (Publication p : arr) {
            System.out.println(p.getTitle());
        }
    }

    public static double calculateTotalIncome(Publication[] arr) {
        double income = 0.00;
        for (Publication p : arr) {
            income += p.getPrice() * p.getQuantity();
        }
        return income;
    }

    public static int countNumberOfCheaper(Publication[] arr, double cena) {
        int ileTanszych = 0;
        for (Publication p : arr) {
            if (p.getPrice() < cena) ileTanszych++;
        }
        return ileTanszych;
    }

    public static int countAlmostSoldOut(Publication[] arr) {
        int amount = 0;
        for (Publication p : arr) {
            if (p.getQuantity() <= 3) {
                amount++;
            }
        }
        return amount;
    }

    public static void printAlmostSoldOut(Publication[] arr) {
        System.out.println("Publikacje na wyczerpaniu:");
        for (Publication p : arr) {
            if (p.getQuantity() <= 3) {
                p.display();
                System.out.println();
            } else System.out.println("Brak!");
        }
    }

    public static Publication getPublicationsWithId(Publication[] arr, String ident) {
        for (Publication p : arr)
            if (p.getIdent().equals(ident)) return p;
        return null;
    }

    public static int findTitleFirstIndex(Publication[] arr, String title) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getTitle().equals(title)) return i;
        }
        return -1;
    }

    public static int findTitleLastIndex(Publication[] arr, String title) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].getTitle().equals(title)) return i;
        }
        return -1;
    }

    public static String[] getArrayOfTitles(Publication[] arr) {
        String[] titleArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            titleArr[i] = arr[i].getTitle();
        }
        return titleArr;
    }

    public static void increasePricesByPercentage(Publication[] arr, int proc) {
        for (Publication p : arr)
            p.raise(proc);
    }

    public static double calculateTotalPriceTitle(Publication[] arr, String title) {
        double totalPrice = 0.00;
        for (Publication p : arr) {
            if (p.getTitle().equals(title)) {
                totalPrice = p.getPrice() * p.getQuantity();
            }
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        Publication[] tablicaPublikacji = new Publication[3];
        System.out.println(Arrays.toString(tablicaPublikacji));

        Publication p1 = new Publication("sasdsd", "343345", 67, 78);
        Publication p2 = new Publication("xxxxx", "56563345", 87, 100);
        Publication p3 = new Publication("eeee", "7878745", 12, 56);
        tablicaPublikacji[0] = p1;
        tablicaPublikacji[1] = p2;
        tablicaPublikacji[2] = p3;

        ArrayOfPublicationsMethods.showPublications(tablicaPublikacji);

        System.out.println("TAB2");

        Publication[] tab2 = {p2, p3, new Publication("ssss", "9945", 92, 756)};
        ArrayOfPublicationsMethods.showPublications(tab2);
        System.out.println("calkowity dochod " + ArrayOfPublicationsMethods.calculateTotalIncome(tab2));
        System.out.println("ile tanszych od 50 " + ArrayOfPublicationsMethods.countNumberOfCheaper(tab2, 50));
        ArrayOfPublicationsMethods.increasePricesByPercentage(tab2, 30);
        ArrayOfPublicationsMethods.showPublications(tab2);
        Publication pub = ArrayOfPublicationsMethods.getPublicationsWithId(tab2, "99945");
        if (pub == null) System.out.println("nie ma publikacji o tym numerze");
        else {
            System.out.println("publikacja o indent \"99945\" to ");
            pub.display();
        }

//        Napisać program, który utworzy tablicę 20 losowych liczb całkowitych z przedziału 0 . . . 10,
//        a następnie wypisze na ekranie ile razy każda z liczb z tego przedziału powtarza się w tablicy.


        int[] arr = generujTablice();
        System.out.println(Arrays.toString(arr));
        zliczWystapienia(arr);
    }

    public static int[] generujTablice() {
        Random rand = new Random();
        int[] tablica = new int[20];
        for (int i = 0; i < 20; i++) {
            tablica[i] = rand.nextInt(11);
        }
        return tablica;
    }

    public static void zliczWystapienia(int[] tablica) {
        int[] wystapienia = new int[11];
        for (int liczba : tablica) {
            wystapienia[liczba]++;
        }
        for (int i = 0; i <= 10; i++) {
            System.out.println("Liczba " + i + " powtarza się " + wystapienia[i] + " razy.");
        }
    }

}
