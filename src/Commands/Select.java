package Commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Select extends Command implements Serializable {

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

    public void gravarEmBanco(Select select) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("testeTable.dat"));
        out.writeObject(select);
        out.close();
    }
    
    public void LerBancoSelect() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("testeTable.dat"));
        Select u = (Select) in.readObject();
        System.out.println(u);
        in.close();
    }
}
