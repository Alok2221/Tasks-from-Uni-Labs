package lab5;

//      Klasa Statystyki powinna posiadać trzy pola całkowite dodatnie, ujemne oraz zera, które przechowują liczbę elementów
//      dodatnich, ujemnych i zer odpowiednio. Ponadto klasa ta powinna zawierać konstruktor pusty, gettery, oraz metody
//      umożliwiające zwiększenie o 1 wartości poszczególnych pól:
//      - zwiekszDodatnie – zwiększa o 1 liczbę elementów dodatnich
//      - zwiekszUjemne – zwiększa o 1 liczbę elementów ujemnych
//      - zwiekszZera – zwiększa o 1 liczbę zer

public class Statystyki {
    private int dodatnie;
    private int ujemne;
    private int zera;

    public Statystyki() {
        this.dodatnie = 0;
        this.ujemne = 0;
        this.zera = 0;
    }

    public int getDodatnie() {
        return dodatnie;
    }

    public int getUjemne() {
        return ujemne;
    }

    public int getZera() {
        return zera;
    }

    public void zwiekszDodatnie() {
        dodatnie++;
    }

    public void zwiekszUjemne() {
        ujemne++;
    }

    public void zwiekszZera() {
        zera++;
    }
}
