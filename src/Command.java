
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Command {
    String strCommand;

    Command(String strCommand){
        this.strCommand=strCommand;
    }
    public String getStrCommand(){
        return strCommand;
    }
    abstract void mainFunction(UserList userList);

}

class Exit extends Command {

    Exit() {
        super("exit");
    }

    boolean exit() {
        return true;
    }

    void mainFunction(UserList userList) {
        System.out.println("Bye!");
        System.exit(0);
    }
}

class AddStudent extends Command {

    AddStudent() {
        super("add student");
    }

    public void askForInput(){
        System.out.println("Enter student credentials or 'back' to return:");
    }

    public String[] readInput(){
        Scanner scanner = new Scanner(System.in);
        List<String> returnS = new ArrayList<String>();
        User user = new User();
        boolean correctInput = false;
        while (!correctInput){
            String[] input = scanner.nextLine().split(" ");
            if (input.length==1){
                if (input[0].equals("back")) {
                    correctInput = true;
                    returnS = Arrays.asList(input);
                }
                else System.out.println("Incorrect credentials.");
            }
            if (input.length==2) System.out.println("Incorrect credentials.");
            if (input.length>=3) {
                String firstName = input[0];
                String lastName = user.getLastName(input);
                String eMail = input[input.length - 1];
                if (checkCorrectInput(firstName, lastName, eMail)) {

                    correctInput = true;
                    returnS = Arrays.asList(input);
                }
            }
        }
        String[] returnArray = new String[returnS.size()];
        returnArray = returnS.toArray(returnArray);
        return returnArray;
    }

    boolean checkCorrectInput(String firstName, String lastName, String eMail){
        boolean correctInput = true;
        User user = new User("","","");
        if(!user.checkName(firstName)) {
            System.out.println("Incorrect first name.");
            correctInput = false;
        }
        if(!user.checkName(lastName)) {
            System.out.println("Incorrect last name.");
            correctInput = false;
        }
        if(!user.checkEMail(eMail)) {
            System.out.println("Incorrect email.");
            correctInput = false;
        }
        return correctInput;

    }

    void mainFunction(UserList userList) {
        boolean back = false;
        User userWorker = new User();
        askForInput();
        int usersAdded = 0;
        while (!back) {
            String input[] = readInput();
            if (input.length == 1) {
                back = true;
                System.out.printf("Total %d students have been added.%n",usersAdded);
            }
            else {
                String firstName = input[0];
                String lastName = userWorker.getLastName(input);
                String eMail = input[input.length - 1];
                User createdUser = new User(firstName, lastName, eMail);
                userList.listOfUsers.add(createdUser);
                System.out.println("The student has been added.");
                usersAdded +=1;
            }
        }
    }
}

