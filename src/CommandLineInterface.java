

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
        UserList userList = new UserList();
        //Itterate over enums to find command
        for (Commands c: Commands.values()) {
            if (c.strCommand.equals(input)){
                c.command.mainFunction(userList);
                foundCommand= true;
            }
        }
        if(input.isBlank()&&foundCommand == false) System.out.println("No input.");
        else if(foundCommand == false) System.out.println("Error: unknown command!");
        return foundCommand;
    }

    public void runCLI(){
        welcomeUser();
        while (true){
            readUserInput();
        }
    }

}


