package third_semester.lab09;

import java.io.*;
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
            System.err.println(e.getMessage());
        }

        return studentList;
    }

    public static void write() {
        List<Student> studentList = read();
        String basePath = "resources/studentsGroup";

        for (Student student : studentList) {
            String fileName = basePath + student.getGroup() + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(student + "\n");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
