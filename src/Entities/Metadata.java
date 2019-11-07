package Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Metadata implements Serializable {

    private String tableName;
    private int recordSize;
    private ArrayList<String> columns;
    private ArrayList<String> types;
    private int[] byteSize;

    public Metadata(ArrayList<String> columns, ArrayList<String> types, int[] byteSize, String tableName) {
        this.tableName = tableName;
        this.columns = columns;
        this.types = types;
        this.byteSize = byteSize;
        this.recordSize = 0;
       
        for (int i : this.byteSize) {
            this.recordSize += i;
        }
        System.out.println(this.toString()); 
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<String> columns) {
        this.columns = columns;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public int[] getByteSize() {
        return byteSize;
    }

    public void setByteSize(int[] byteSize) {
        this.byteSize = byteSize;
    }

    @Override
    public String toString() {
        return "Metadata{" + "tableName=" + tableName + ", recordSize=" + recordSize + ", columns=" + columns + ", types=" + types + ", byteSize=" + byteSize + '}';
    }

}
