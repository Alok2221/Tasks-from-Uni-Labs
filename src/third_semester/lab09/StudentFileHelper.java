package third_semester.lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFileHelper {

    public static List<Student> read() {
        List<Student> studentList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("resources/studentsGroupAssignment.txt"))) {
            while (scanner.hasNext()) {
                List<String> fields = List.of(scanner.next().split("/"));
                studentList.add(new Student(fields.get(0), fields.get(1), fields.get(2), Group.valueOf(fields.get(3))));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return studentList;
    }
}
