
package Entities;

import Commands.Command;
import Commands.Insert;
import Commands.Select;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Table implements Serializable{
    private final File instance = null;
    private final String name;
    private final ArrayList<String> columns;
    private final ArrayList<String> types;

    public Table(String name, ArrayList<String> columns, ArrayList<String> types) {
        this.name = name;
        this.columns = columns;
        this.types = types;
    }
    
    public void persist() throws FileNotFoundException, IOException {
        // o testeTable.dat vai ser substituido por instance, a ideia eh criar um File, que esteja contigo no diretorio do database
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("testeTable.dat"));
        out.writeObject(this);
        out.close();
    }    
    
    public void LerBancoCreate() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("testeTable.dat"));
        Table u = (Table) in.readObject();
        System.out.println(u);
        in.close();
    }
    
    // verificar o comando e rodar ele
    public void runCommand(Command command){
        if (command instanceof Insert) {
            Insert insert = (Insert) command;
            //inplementar 

        } else if (command instanceof Select) {
            Select select = (Select) command;
            //implementar
           
        }
        
    }

    @Override
    public String toString() {
        return "Table{" + "instance=" + instance + ", name=" + name + ", columns=" + columns + ", types=" + types + '}';
    }
    
}
           