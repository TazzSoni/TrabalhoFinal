package Entities;

public class Result {

    private String column;
    private String value;

    public Result(String column, String value) {
        this.column = column;
        verifValue(value);
    }

    public void verifValue(String value) {
        if (value.contains("&")) {
            this.value = "";
        } else if (value.equals("3.489802E-39")) {
            this.value = "";
        } else if (value.equals("2490406")) {
            this.value = "";
        } else {
            this.value = value;
        }
    }

    public String toString() {
        if (value.length() == 0) {
            value = "null";
        }
        return "\n" + column + ": " + value;
    }
}
