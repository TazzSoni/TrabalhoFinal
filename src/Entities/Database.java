package Entities;

import java.io.File;

public class Database {
    private File instance;
    private String name;
    private String rootPath;

    public Database(String rootPath, String name) {
        this.name = name;
        this.rootPath = rootPath;
    }

    public void persist() {
        String directoryPath = this.rootPath;
        File directory = new File(directoryPath);
        directory.mkdir();
        this.instance = directory;
    }
}
