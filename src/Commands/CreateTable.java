package Commands;

import Entities.Database;
import Entities.Metadata;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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

    @Override
    public void run(Database database) throws Exception {
        String path = database.getPath() + tableName + ".dat";
        File table = new File(path);
        database.addTable(table);
        table.createNewFile();

        int[] byteSize = new int[this.columns.size()];

        for (int i = 0; i < columns.size(); i++) {
            if (this.types.get(i).contains("char")) {
                String str = this.types.get(i);
                String length = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
                byteSize[i] = Integer.parseInt(length);
            } else {
                byteSize[i] = 8;
            }
        }

        Metadata metadata = new Metadata(this.columns, this.types, byteSize, tableName);
        database.addMetadata(metadata);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(database.getPath() + tableName + ".meta")));
        oos.writeObject(metadata);

        //RandomAccessFile raf = new RandomAccessFile(file, "rw" ); 
//        for (int i = 0; i < columns.size(); i++) {
//            String aux = columns.get(i);
//            out.writeUTF(aux);
//            System.out.println(columns.get(i));
//        }
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
