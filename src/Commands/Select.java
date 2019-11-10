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

                        System.out.println("OUTPUT: " + new String(value, 0, byteSize));
                    }
                }
                raf.close();
            }

            //roda o comando Insert com RandomAccessFile
            for (String value : this.values) {
                //para cara valor no insert, faça:
                //coloca o pointer no final do arquivo
                System.out.println("aqui: " + value);

                /* raf.seek(raf.length());
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
                 */
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
