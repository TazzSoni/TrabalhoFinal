package Entities;

import java.io.File;
import java.util.ArrayList;

public class Database {
    private ArrayList<File> tables = new ArrayList<File>();
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

    public void addTable(File file){
        this.tables.add(file);
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
