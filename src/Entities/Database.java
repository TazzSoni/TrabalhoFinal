package Entities;

import java.io.File;
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

    public void addMetadata(Metadata metadata) {
        this.tablesMeta.add(metadata);
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
