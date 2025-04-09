package second_semester.lab1;

//     3. Napisz program, który
//        a) Liczbę 3456 zwiększy o 5.
//        b) Następnie podzieli powyższą sumę przez 3.
//        c) Obliczy resztę z dzielenia ilorazu przez 5.
//        d) Na koniec wymnoży wynik z dzielenia modulo razy 7.

public class Calculation {
    public static void main(String[] args) {
        System.out.println(calculate(432874));
    }

    public static int calculate(int num) {
        return (((num + 5) / 3) % 5 * 7);
    }
}
