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
            RandomAccessFile raf = new RandomAccessFile(table, "rw");

            for (String value : this.values) {
                int index = this.values.indexOf(value);
                raf.write(value.getBytes(), 0, metadata.getByteSize()[index]);
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
