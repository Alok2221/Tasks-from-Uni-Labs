package lab1;

//  2.  Napisz program obliczający obwód trójkąta o bokach 6,3 cm, 6,7 cm oraz 7,1 cm.

public class PerimeterOfTriangle {

    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;

    public PerimeterOfTriangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double perimeterOfTriangle() {
        return firstSide + secondSide + thirdSide;
    }

    public static void main(String[] args) {
        PerimeterOfTriangle perimeter = new PerimeterOfTriangle(6.3, 6.7, 7.1);
        System.out.println(perimeter.perimeterOfTriangle() + "cm");
    }
}
