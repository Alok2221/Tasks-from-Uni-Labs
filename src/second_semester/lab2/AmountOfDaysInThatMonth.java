package second_semester.lab2;

//   4. Napisz program pobierający numer miesiąca od użytkownika i wyświetlający komunikat
//      informujący, czy dany miesiąc ma 30 , 31, 28 lub 29 dni.


import java.util.Scanner;

public class AmountOfDaysInThatMonth {
    public static void main(String[] args) {
        Scanner monthNumber = new Scanner(System.in);
        int inputMonth;

        do {
            System.out.println("Podaj numer miesiąca");
            inputMonth = monthNumber.nextInt();
        } while (inputMonth < 1 || inputMonth > 12);

        System.out.println("Liczba dni w miesiącu: " + getNumberOfDays(inputMonth));

        monthNumber.close();
    }

    public static int getNumberOfDays(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> 29;
        };
    }
}
