package Entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Database {

    private ArrayList<File> tables = new ArrayList<File>();
    private ArrayList<Metadata> tablesMeta = new ArrayList<Metadata>();
    private File instance;
    private String name;
    private String rootPath;

    public Database(String rootPath, String name) {
        this.name = name;
        this.rootPath = rootPath;
        File directory = new File(this.rootPath + this.name);
        directory.mkdir();
        this.instance = directory;
    }

    public void loadTables() throws FileNotFoundException, IOException, ClassNotFoundException {
        for (final File file : new File(this.rootPath + this.name).listFiles()) {
            if (!file.isDirectory()) {
                String extension = "";

                int i = file.getPath().lastIndexOf('.');
                if (i > 0) {
                    extension = file.getPath().substring(i + 1);
                }
                if (extension.equals("meta")) {

                    FileInputStream fis = new FileInputStream(file);

                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Metadata metadata = (Metadata) ois.readObject();
                    
                    this.addMetadata(metadata);
                    ois.close();
                    fis.close();

                } else if (extension.equals("dat")) {
                    this.addTable(file);
                }
            }
        }
    }

    public File getInstance() {
        return instance;
    }

    public void setInstance(File instance) {
        this.instance = instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTable(File file) {
        this.tables.add(file);
    }

    public void addMetadata(Metadata metadata) {
        this.tablesMeta.add(metadata);
    }

    private int findMetadataIndex(String tableName) {
        for (Metadata metadata : this.tablesMeta) {
            if (metadata.getTableName().equals(tableName)) {
                return this.tablesMeta.indexOf(metadata);
            }
        }
        return -1;
    }

    public Metadata findMetadata(String tableName) {
        return this.tablesMeta.get(this.findMetadataIndex(tableName));
    }

    public File findTable(String tableName) {
        return this.tables.get(this.findMetadataIndex(tableName));
    }

    public ArrayList<Metadata> getTablesMeta() {
        return tablesMeta;
    }

    public void setTablesMeta(ArrayList<Metadata> tablesMeta) {
        this.tablesMeta = tablesMeta;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public ArrayList<File> getTables() {
        return tables;
    }

    public void setTables(ArrayList<File> tables) {
        this.tables = tables;
    }

    public String getPath() {
        return this.instance.getAbsolutePath() + "\\";
    }

    @Override
    public String toString() {
        return "Database{" + "instance=" + instance + ", name=" + name + ", rootPath=" + rootPath + '}';
    }

}
