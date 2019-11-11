package Commands;

import Entities.Database;
import Entities.Metadata;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Insert extends Command {

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

    @Override
    public void run(Database database) {
        Metadata metadata = database.findMetadata(this.tableName);
        File table = database.findTable(this.tableName);

        try {

            if (metadata.getColumns().size() != this.values.size()) {
                ArrayList<String> fixedValues = new ArrayList<String>(metadata.getColumns().size());

                for (String column : metadata.getColumns()) {
                    fixedValues.add(null);
                }

                for (String column : this.columns) {
                    String value = this.values.get(this.columns.indexOf(column));
                    int columnIndex = metadata.findColumnIndex(column);
                    fixedValues.set(columnIndex, value);
                }
                this.values = fixedValues;
            }

            RandomAccessFile raf = new RandomAccessFile(table, "rw");

            System.out.println(metadata.toString());

            for (String column : metadata.getColumns()) {
                raf.seek(raf.length());
                int columnIndex = metadata.findColumnIndex(column);

                String value = this.values.get(columnIndex);

                if (!metadata.hasColumn(column)) {
                    JOptionPane.showMessageDialog(null, "Coluna inexistente");
                    break;
                }

                if (value == null) {
                    int byteSize = metadata.getByteSize()[columnIndex];

                    for (int i = 0; i < byteSize / 2; i++) {
                        raf.writeChars(" ");
                    }

                } else if (metadata.getTypes().get(columnIndex).contains("char")) {
                    int byteSize = metadata.getByteSize()[columnIndex];

                    if (value.contains("'")) {
                        value = value.substring(1, value.length() - 1);
                    }

                    raf.writeChars(String.format("%1$" + (byteSize / 2) + "s", value));

                } else if (metadata.getTypes().get(columnIndex).contains("int")) {
                    raf.writeInt(Integer.parseInt(value));
                }
                System.out.println("table length: " + raf.length());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return "Insert{" + "tableName=" + tableName + ", columns=" + columns + ", values=" + values + '}';
    }

}
