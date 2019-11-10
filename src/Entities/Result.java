
package Entities;

public class Result {
    private String column;
    private String value;

    public Result(String column, String value) {
        this.column = column;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result{" + "column=" + column + ", value=" + value + '}';
    }
}
