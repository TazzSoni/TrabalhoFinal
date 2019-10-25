package Commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Insert extends Command implements Serializable {

    private String tableName;
    private ArrayList<String> columns = new ArrayList<String>();
    private ArrayList<String> values = new ArrayList<String>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void addColumn(String column) {
        this.columns.add(column);
    }

    public void addValue(String value) {
        this.values.add(value);
    }

    public void gravarEmBanco(Insert esse) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("testeTable.dat"));
        out.writeObject(esse);
        out.close();
    }

    public void LerBancoInsert() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("testeTable.dat"));
        Insert u = (Insert) in.readObject();
        System.out.println(u);
        in.close();
    }

    @Override
    public String toString() {
        return "Insert{" + "tableName=" + tableName + ", columns=" + columns + ", values=" + values + '}';
    }

}
