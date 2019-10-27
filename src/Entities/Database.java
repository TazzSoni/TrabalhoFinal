package Entities;

import java.io.File;
import java.util.HashMap;

public class Database {
    private File instance;
    private String name;
    private String rootPath;
    private final HashMap<String, Table> tables;

    public Database(String rootPath, String name) {
        this.name = name;
        this.rootPath = rootPath;
        this.tables = new HashMap<String, Table>();
    }

    public void persist() {
        String directoryPath = this.rootPath;
        File directory = new File(directoryPath);
        directory.mkdir();
        this.instance = directory;
    }
}
