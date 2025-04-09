package second_semester.lab1;


//  4.  Napisz program, którego zadaniem będzie zamiana galonów na litry. Jeden galon odpowiada
//      3,7854 litra. (Aby zamienić galony na litry, wystarczy pomnożyć ich liczbę przez 3,7854.)


import java.math.BigDecimal;
import java.math.RoundingMode;

public class GallonToLiterConversion {
    public static void main(String[] args) {
        System.out.println(converter(8));
    }

    public static double converter(int galons) {
        final double diff = 3.7854;
        BigDecimal conversion = BigDecimal.valueOf(galons * diff);
        conversion = conversion.setScale(1, RoundingMode.UP);
        return conversion.doubleValue();
    }
}
