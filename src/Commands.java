public enum Commands {
    EXIT("exit", new Exit());

    String strCommand;
    Command command;
    Commands(String strCommand, Command classCommand){
        this.strCommand =strCommand;
        this.command = classCommand;

    }
}
