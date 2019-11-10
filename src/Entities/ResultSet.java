package Entities;

import java.util.ArrayList;

public class ResultSet {

    private ArrayList<Result> results = new ArrayList<Result>();

    public ResultSet() {
    }

    public ArrayList<Result> getValues() {
        return results;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    @Override
    public String toString() {
        return "ResultSet{" + "results=" + results.toString() + '}';
    }
}
