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
            //roda o comando Insert com RandomAccessFile
            for (String value : this.values) {
                //para cara valor no insert, faça:
                //coloca o pointer no final do arquivo
                raf.seek(raf.length());
                //busca o indice do valor
                int index = this.values.indexOf(value);
                // (considerando que é tudo char(n)) formata a string a ser escrita
                // portanto:
                // char(8) -> [ , , l,u,c,a,s]
                // cada: char = 2 bytes

                if (metadata.getTypes().get(index).contains("char")) {
                    int byteSize = metadata.getByteSize()[index];
                    // corta a String no tamanho máximo necessário
                    // e se for menor, preenche o restante com espaços em branco

                    if (value.length() > byteSize / 2) {
                        value = value.substring(0, byteSize / 2);
                    }
                    // remove as aspas informadas no insert
                    if (value.contains("'")) {
                        value = value.substring(1, value.length() - 1);
                    }

                    raf.writeChars(String.format("%1$" + byteSize / 2 + "s", value));

                } else if (metadata.getTypes().get(index).contains("int")) {
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
