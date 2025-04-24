package test;

import org.junit.jupiter.api.Test;
import third_semester.lab04.Grades;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GradesTest {
    @Test
    public void testCountNumberOfFive() {
        // Given: lista ocen zawierająca różne oceny, w tym trzy piątki
        List<Double> grades = List.of(5d, 3.5d, 4d, 5d, 2d, 5d);

        // When: liczymy liczbę piątek w tej liście
        int result = Grades.countNumberOfFive(grades);

        // Then: wynik powinien wynosić 3
        assertEquals(3, result, "The number of 5 should be 3");
    }

    @Test
    public void testCountNumberOfFive_NoFives() {
        // Given: lista ocen, która nie zawiera piątek
        List<Double> grades = List.of(4d, 3d, 2d, 3.5d);

        // When: liczymy liczbę piątek w tej liście
        int result = Grades.countNumberOfFive(grades);

        // Then: wynik powinien wynosić 0
        assertEquals(0, result, "The number of 5 should be 0");
    }

    @Test
    public void testCountNumberOfFive_EmptyList() {
        // Given: pusta lista ocen
        List<Double> grades = List.of();

        // When: liczymy liczbę piątek w tej liście
        int result = Grades.countNumberOfFive(grades);

        // Then: wynik powinien wynosić 0, ponieważ lista jest pusta
        assertEquals(0, result, "The list cannot be empty");
    }

    @Test
    public void testCountNumberOfFive_InvalidGrade() {
        // Given: lista ocen, która zawiera niepoprawne wartości
        List<Double> grades = List.of(5d, 6d, 3d);

        // When: liczymy liczbę piątek w tej liście
        int result = Grades.countNumberOfFive(grades);

        // Then: wynik powinien wynosić 0, ponieważ lista zawiera niepoprawne oceny
        assertEquals(0, result, "Grade list should contain only valid grades from 2 to 5");
    }

    @Test
    public void testGetTheBestGrade() {
        // Given: lista ocen, w tym najlepsze oceny (>= 4)
        List<Double> grades = List.of(5d, 4.5d, 3d, 4d, 2d);

        // When: pobieramy najlepsze oceny (>= 4)
        List<Double> bestGrades = Grades.getTheBestGrade(grades);

        // Then: wynikowa lista powinna zawierać oceny >= 4
        assertEquals(List.of(5d, 4.5d, 4d), bestGrades, "The best grades should be >= 4");
    }

    @Test
    public void testGetTheBestGrade_NoBestGrades() {
        // Given: lista ocen, które są mniejsze niż 4
        List<Double> grades = List.of(3d, 2d, 3.5d);

        // When: pobieramy najlepsze oceny (>= 4)
        List<Double> bestGrades = Grades.getTheBestGrade(grades);

        // Then: wynikowa lista powinna być pusta, ponieważ brak ocen >= 4
        assertTrue(bestGrades.isEmpty(), "There should be no best grades");
    }

    @Test
    public void testGetTheBestGrade_EmptyList() {
        // Given: pusta lista ocen
        List<Double> grades = List.of();

        // When: pobieramy najlepsze oceny (>= 4)
        List<Double> bestGrades = Grades.getTheBestGrade(grades);

        // Then: wynikowa lista powinna być pusta, ponieważ lista jest pusta
        assertTrue(bestGrades.isEmpty(), "The list cannot be empty");
    }

    @Test
    public void testCheckGrade() {
        // Given: lista ocen
        List<Double> grades = List.of(5d, 4d, 3d, 2d);

        // When: sprawdzamy, czy lista zawiera ocenę 4
        Grades.checkGrade(grades, 4d); // Spodziewany wynik: "List contains: 4.0"

        // Then: brak asercji, ponieważ wynik jest wypisany na konsolę
    }

    @Test
    public void testCheckGrade_GradeNotFound() {
        // Given: lista ocen
        List<Double> grades = List.of(3d, 2d, 3.5d);

        // When: sprawdzamy, czy lista zawiera ocenę 5
        Grades.checkGrade(grades, 5d); // Spodziewany wynik: "List doesn't have: 5.0"

        // Then: brak asercji, ponieważ wynik jest wypisany na konsolę
    }

    @Test
    public void testCheckGrade_EmptyList() {
        // Given: pusta lista ocen
        List<Double> grades = List.of();

        // When: sprawdzamy, czy lista zawiera ocenę 3
        Grades.checkGrade(grades, 3d); // Spodziewany wynik: "List cannot be empty"

        // Then: brak asercji, ponieważ wynik jest wypisany na konsolę
    }

    @Test
    public void testCheckGrade_InvalidGrades() {
        // Given: lista ocen, która zawiera niepoprawne wartości
        List<Double> grades = List.of(5d, 6d, 3d);

        // When: sprawdzamy, czy lista zawiera ocenę 6
        Grades.checkGrade(grades, 6d); // Spodziewany wynik: "Grade list should contain only valid grades from 2 to 5"

        // Then: brak asercji, ponieważ wynik jest wypisany na konsolę
    }

    @Test
    public void testGetGradesSet() {
        // Given: nie ma potrzeby ustawiania danych, ponieważ zwracamy stały zestaw ocen
        List<Double> expectedGrades = List.of(2d, 3d, 3.5d, 4d, 4.5d, 5d);

        // When: pobieramy zestaw ocen
        List<Double> gradesSet = Grades.getGradesSet();

        // Then: zestaw ocen powinien zawierać oczekiwane wartości
        assertTrue(gradesSet.containsAll(expectedGrades), "The grades set should contain valid grades");
    }

    @Test
    public void testGetUniqueGrades() {
        // Given: lista ocen, która zawiera duplikaty
        List<Double> grades = List.of(5d, 5d, 4d, 4d, 3.5d, 3.5d, 2d);

        // When: pobieramy unikalne oceny
        List<Double> uniqueGrades = Grades.getUniqueGrades(grades);

        // Then: wynikowa lista powinna zawierać tylko unikalne oceny
        assertEquals(List.of(5d, 4d, 3.5d, 2d), uniqueGrades, "The unique grades should not contain duplicates");
    }

    @Test
    public void testGetUniqueGrades_AlreadyUnique() {
        // Given: lista już zawierająca unikalne oceny
        List<Double> grades = List.of(5d, 4d, 3d, 2d);

        // When: pobieramy unikalne oceny
        List<Double> uniqueGrades = Grades.getUniqueGrades(grades);

        // Then: wynikowa lista powinna być taka sama, jak lista wejściowa
        assertEquals(grades, uniqueGrades, "The unique grades should be the same if no duplicates are present");
    }

    @Test
    public void testGetUniqueGrades_EmptyList() {
        // Given: pusta lista ocen
        List<Double> grades = List.of();

        // When: pobieramy unikalne oceny
        List<Double> uniqueGrades = Grades.getUniqueGrades(grades);

        // Then: wynikowa lista powinna być pusta
        assertTrue(uniqueGrades.isEmpty(), "The list cannot be empty");
    }
}