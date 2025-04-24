package third_semester.lab09;

public class Student {
    private final String name;
    private final String surname;
    private final String index;
    private final Group group;


    public Student(String name, String surname, String index, Group group) {
        this.name = name;
        this.surname = surname;
        this.index = index;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return """
                Student
                Imię: %s
                Nazwisko: %s
                Index: %s
                Grupa: %s
                """.formatted(name, surname, index, group);
    }
}
