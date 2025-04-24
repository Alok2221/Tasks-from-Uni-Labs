package third_semester.lab09;

public enum Group {
    A("A"), B("B"), C("C"), D("D");

    private final String code;

    Group(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
