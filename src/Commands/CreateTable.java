package Commands;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public void run() throws Exception {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(tableName + ".dat"));

        for (int i = 0; i < columns.size(); i++) {
            String aux = columns.get(i);
            out.writeUTF(aux);
            System.out.println(columns.get(i));
        }
        /*out.writeBoolean(true);
        out.writeByte(10); // 1 byte
        out.writeChar('A'); // 2 bytes
        out.writeDouble(100.36); // 8 bytes
        out.writeFloat(100.36f); // 4 bytes
        out.writeInt(100); // 4 bytes
        out.writeLong(100); // 8 bytes
        out.writeUTF("testando"); // 10 bytes
        out.close();

        // 1 byte
        byte data[] = {1, 1, 1, 1};
        Path file = Paths.get("C:/Users/tasso/Desktop/teste.dat");
        try {
            Files.write(file, data);

        } catch (IOException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }  */
    }

    @Override
    public String toString() {
        return "CreateTable{" + "tableName=" + tableName + ", columns=" + columns + ", types=" + types + '}';
    }
}
