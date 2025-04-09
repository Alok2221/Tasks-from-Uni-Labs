package second_semester.lab1;

import java.math.BigDecimal;
import java.math.RoundingMode;

//  6. Napisz program do konwersji temperatury ze stopni Fahrenheita na stopnie Celsjusza.
//     Wykorzystaj następującą zależność: C/5=(F – 32)/9, gdzie C – stopnie Celsjusza, F – Fahrenheita.
//     Sprawdź działanie dla 150 °F.

public class FahrenheitToCelsius {

    private final int f;

    public FahrenheitToCelsius(int f) {
        this.f = f;
    }

    public double degreeConversion() {
        BigDecimal conversion = BigDecimal.valueOf(((f - 32.0) / 9) * 5);
        conversion = conversion.setScale(1, RoundingMode.UP);
        return conversion.doubleValue();
    }

    public static void main(String[] args) {

        FahrenheitToCelsius result = new FahrenheitToCelsius(150);

        System.out.println(result.degreeConversion());
    }
}
