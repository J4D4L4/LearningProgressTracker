

public enum Commands {
    EXIT("exit", new Exit()),
    ADDSTUDENT("add students", new AddStudent()),
    LIST("list", new ListC())
    ;

    String strCommand;
    Command command;
    Commands(String strCommand, Command classCommand){
        this.strCommand =strCommand;
        this.command = classCommand;

    }
}
