package lab1;

/*
  5.Napisz program, który oblicza, jak daleko od osoby, która usłyszała grom, uderzył piorun.
    Prędkość dźwięku w powietrzu wynosi około 330metrów na sekundę. Zatem znając odstęp
    czasu pomiędzy chwilą, w której zobaczyliśmy błyskawicę, a momentem, w którym dotarł do
    nas dźwięk gromu, możemy obliczyć, jak daleko uderzył piorun. Na potrzeby tego programu
    załóżmy, że zmierzony odstęp wyniósł 7,2 sekundy
*/

public class HowFarFromLightning {

    public static void main(String[] args) {
        System.out.println("Piorun uderzył " + (distance(330, 7.2)) + "m od tej osoby.");
    }

    public static double distance(int speed, double time) {
        return speed * time;
    }
}
