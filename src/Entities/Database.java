package Entities;

import java.io.File;

public class Database {

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

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String toString() {
        return "Database{" + "instance=" + instance + ", name=" + name + ", rootPath=" + rootPath + '}';
    }
    
}
