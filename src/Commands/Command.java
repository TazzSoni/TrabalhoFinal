package Commands;

import Entities.Database;

public abstract class Command {

    public Command() {
    }

    public abstract void run(Database database) throws Exception;
}
