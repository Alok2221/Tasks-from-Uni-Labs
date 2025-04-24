package third_semester.lab01.exe02;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Wagon {
    private final int maxMiejsc;
    private final List<Pasazer> listaPasazerow;

    public Wagon(int maxMiejsc, List<Pasazer> listaPasazerow) {
        this.maxMiejsc = maxMiejsc;
        this.listaPasazerow = listaPasazerow;
    }

    public int getMaxMiejsc() {
        return maxMiejsc;
    }

    public List<Pasazer> getListaPasazerow() {
        return listaPasazerow;
    }

    public void setListaPasazerow(Pasazer... pasazerowie) {
        listaPasazerow.addAll(Arrays.asList(pasazerowie));
    }

    public boolean dodajPasazera(Pasazer nowyPasazer) {
        if (listaPasazerow.size() <= maxMiejsc) {
            System.out.println("Brak miejsc");
            return false;
        }
        listaPasazerow.add(nowyPasazer);
        return true;
    }

    public void wyswietlPasazerow() {
        listaPasazerow.forEach(Pasazer::wyswietl);
    }

    public void wyswietlInfoWagonu() {
        int liczbaPasazerow = listaPasazerow.size();
        int wolneMiejsca = maxMiejsc - listaPasazerow.size();
        AtomicInteger index = new AtomicInteger(1);
        System.out.printf("""
                Liczba miejsc w wagonie: %d
                Liczba pasażerów: %d
                Wolne miejsca: %d
                Imiona i nazwiska pasażerów:
                """, maxMiejsc, liczbaPasazerow, wolneMiejsca);
        listaPasazerow.forEach(p -> System.out.println(index.getAndIncrement() + ". " + p.getImie() + " " + p.getNazwisko()));
    }

    public long ileZeznizkaSeniora() {
        return listaPasazerow.stream()
                .filter(p -> p.getWiek() >= 65)
                .count();
    }


    public static void main(String[] args) {
        Pasazer p1 = new Pasazer("Jan", "Kowalski", 43);
        Pasazer p2 = new Pasazer("Piotr", "Nowak", 26);
        Pasazer p3 = new Pasazer("Jakub", "Glin", 20);
        Pasazer p4 = new Pasazer("Iwona", "Rzepa", 36);

        Wagon wagon = new Wagon(10, List.of(p1, p2, p3, p4));
        wagon.wyswietlPasazerow();

        wagon.wyswietlInfoWagonu();
        System.out.println(wagon.ileZeznizkaSeniora());
    }
}