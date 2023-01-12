import java.util.Scanner;

public class CommandLineInterface {

    public CommandLineInterface(){

    }

    public void welcomeUser(){
        System.out.println("Learning Progress Tracker");
    }
    public boolean readUserInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean foundCommand = false;
        //Itterate over enums to find command
        for (Commands c: Commands.values()) {
            if (c.strCommand.equals(input)){
                c.command.mainFunction();
                foundCommand= true;
            }
        }
        if(foundCommand == false) System.out.println("Error: unknown command!");
        return foundCommand;
    }

    public void runCLI(){
        welcomeUser();
        while (true){
            readUserInput();
        }
    }

}


