
package Entities;

import java.io.File;
import java.util.ArrayList;

public class Table{
    private final File instance;
    private final String name;
    private final ArrayList<String> columns;
    private final ArrayList<String> types;

    public Table(File instance, String name, ArrayList<String> columns, ArrayList<String> types) {
        this.name = name;
        this.instance = instance;
        this.columns = columns;
        this.types = types;
    }


}
