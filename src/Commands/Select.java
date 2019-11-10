package Commands;

import Entities.Database;
import Entities.Metadata;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Select extends Command {

    private ArrayList<String> columns = new ArrayList<String>();
    private ArrayList<String> values = new ArrayList<String>();
    private String from;
    private String where;
    private boolean containsAsterisk;

    //criei uma lógica para não adicionar a mesma coluna duas vezes, pq no where ele 
    //chama novamente o método enterColumn_name no listener e adiciona denovo a mesma 
    public void addColumn(String column) {
        int aux = columns.size();
        if (columns.size() == 0) {
            this.columns.add(column);
        } else if (this.columns.get(this.columns.size() - 1).equals(column)) {

        }
    }

    public void addValue(String value) {
        this.values.add(value);
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<String> columns) {
        this.columns = columns;
    }

    public String getFrom() {
        return from;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(ArrayList<String> values) {
        this.values = values;
    }

    public boolean isContainsAsterisk() {
        return containsAsterisk;
    }

    public void setContainsAsterisk(boolean containsAsterisk) {
        this.containsAsterisk = containsAsterisk;
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

    @Override
    public void run(Database database) {
        Metadata metadata = database.findMetadata(this.from);
        File table = database.findTable(this.from);
        try {
            RandomAccessFile raf = new RandomAccessFile(table, "r");

            if (this.containsAsterisk) {
                Long tableLengthLong = raf.length();
                int tableLength = Integer.valueOf(tableLengthLong.toString());

                int recordCount = tableLength / metadata.getRecordSize();

                System.out.println(metadata.toString());

                for (int i = 0; i < recordCount; i++) {
                    // move o pointeiro no arquivo, de registro em registro
                    raf.seek(i * metadata.getRecordSize());

                    //itera de coluna em coluna
                    for (int j = 0; j < metadata.getColumns().size(); j++) {
                        // atributos das colunas
                        String column = metadata.getColumns().get(j);
                        String type = metadata.getTypes().get(j);
                        int byteSize = metadata.getByteSize()[j];

                        byte[] value = new byte[byteSize];

                        raf.read(value);
                        if (type.contains("char")) {
                            this.values.add(new String(value, 0, byteSize));
                        } else if(type.contains("int")){
                            this.values.add(ByteBuffer.wrap(value).getInt() + "");
                        }
                    }
                }
                System.out.println("columns: " + metadata.getColumns().toString());
                System.out.println("values: " + this.values.toString());
                raf.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        if (columns.size() == 0) {
            return "Select{" + " from=" + from + ", where=" + where + '}';
        } else {
            return "Select{" + getColumns().toString() + " from=" + from + ", where=" + where + '}';
        }
    }
}
