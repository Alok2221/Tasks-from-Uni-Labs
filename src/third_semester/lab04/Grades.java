package third_semester.lab04;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Grades {
    private static final Set<Double> VALID_GRADES = Set.of(2d, 3d, 3.5, 4d, 4.5, 5d);
    private static final String EMPTY_LIST_ERR = "List cannot be empty";
    private static final String VALID_GRADES_ERROR = "Grade list should contain only valid grades from 2 to 5";

    public static int countNumberOfFive(List<Double> gradeList) {
        if (gradeList == null || gradeList.isEmpty()) {
            System.err.println(EMPTY_LIST_ERR);
            return 0;
        }
        if (isValidGrade(gradeList)) {
            return (int) gradeList.stream().filter(p -> p == 5).count();
        }
        System.err.println(VALID_GRADES_ERROR);
        return 0;
    }

    public static List<Double> getTheBestGrade(List<Double> gradeList) {
        if (gradeList == null || gradeList.isEmpty()) {
            System.err.println(EMPTY_LIST_ERR);
            return List.of();
        }
        if (isValidGrade(gradeList)) {
            return gradeList.stream().filter(p -> p >= 4).toList();
        }
        System.err.println(VALID_GRADES_ERROR);
        return List.of();
    }

    public static void checkGrade(List<Double> gradeList, double askedGrade) {
        if (gradeList == null || gradeList.isEmpty()) {
            System.err.println(EMPTY_LIST_ERR);
            return;
        }
        if (isValidGrade(gradeList)) {
            boolean contains = gradeList.contains(askedGrade);
            System.out.println(contains ? "List contains: " + askedGrade : "List doesn't have: " + askedGrade);
        } else {
            System.err.println(VALID_GRADES_ERROR);
        }
    }

    public static List<Double> getGradesSet() {
        return new ArrayList<>(VALID_GRADES);
    }

    public static List<Double> getUniqueGrades(List<Double> grades) {
        if (grades == null || grades.isEmpty()) {
            System.err.println(EMPTY_LIST_ERR);
            return List.of();
        }
        if (isValidGrade(grades)) {
            return grades.stream().distinct().toList();
        }
        System.err.println(VALID_GRADES_ERROR);
        return List.of();
    }

    private static boolean isValidGrade(List<Double> value) {
        return VALID_GRADES.containsAll(value);
    }
}
