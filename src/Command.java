public abstract class Command {
    String strCommand;

    Command(String strCommand){
        this.strCommand=strCommand;
    }
    public String getStrCommand(){
        return strCommand;
    }
    abstract void mainFunction();

}

class Exit extends Command{

    Exit(){
        super("exit");
    }
    boolean exit(){
        return true;
    }

    void mainFunction(){
        System.out.println("Bye!");
        System.exit(0);
    }
}
