package Commands;

import java.util.ArrayList;

public class Select extends Command {

    private ArrayList<String> columns = new ArrayList<String>();
    private String from;
    private String where;

    public ArrayList<String> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<String> columns) {
        this.columns = columns;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void addColumn(String column) {
        this.columns.add(column);
    }
    
    @Override
    public void run(){
    
    }
}
