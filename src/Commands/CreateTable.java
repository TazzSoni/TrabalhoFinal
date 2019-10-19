package Commands;

import java.util.ArrayList;

public class CreateTable extends Command {

    private String tableName;
    private ArrayList<String> columns = new ArrayList<String>();
    private ArrayList<String> types = new ArrayList<String>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public void addColumn(String column) {
        this.columns.add(column);
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void addType(String type) {
        this.types.add(type);
    }

    public String toString() {
        return "CreateTable{" + "tableName=" + tableName + ", columns=" + columns + ", types=" + types + '}';
    }

}
