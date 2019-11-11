package Entities;

import java.util.ArrayList;

public class ResultSet {

    private ArrayList<Result> results = new ArrayList<Result>();
    private int numColumns;

    public ResultSet() {
    }

    public ArrayList<Result> getValues() {
        return results;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    public String imprimeResultado() {
        String result = "";
        int cont = 0;
        for (int i = 0; i < results.size() / numColumns; i++) {
            for (int j = 0; j < numColumns; j++) {
                result += results.get(cont).toString();
                cont++;
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public String toString() {
        return imprimeResultado();
    }
}
