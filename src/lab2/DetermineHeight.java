package lab2;

/*
     1. Napisz program, który w zależności od podanego przez użytkownika wzrostu w
        cm wypisze odpowiedni tekst :
        Wzrost <= 150 Niski
        150 < Wzrost <= 170 Średni
        170 < Wzrost Wysoki
        W każdym innym przypadku program ma wypisać : “Czy na pewno podałeś
        poprawna liczbę?”
*/

import java.util.Scanner;

public class DetermineHeight {

    private final int h;

    public DetermineHeight(int h) {
        this.h = h;
    }

    public String getHeight() {
        if (h <= 150 && h > 0) return ("Niski");
        if (h > 150 && h <= 170) return ("Średni");
        if (h > 170) return ("Wysoki");
        else return ("Czy na pewno podałeś poprawna liczbę?");
    }

    public static void main(String[] args) {
        System.out.println("Podaj swój wzost ");
        DetermineHeight determineHeight = new DetermineHeight(new Scanner(System.in).nextInt());
        System.out.println(determineHeight.getHeight());
    }
}

