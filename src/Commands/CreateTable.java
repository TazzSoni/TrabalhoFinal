package Commands;

import Entities.Table;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public void run() throws IOException {
        Table table = new Table(this.tableName, this.columns, this.types);
        table.persist();
    }

    public void LerBancoCreate() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("testeTable.dat"));
        Table u = (Table) in.readObject();
        System.out.println("leu isso:" + u);
        in.close();
    }

}
