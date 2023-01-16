import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Command {
    String strCommand;

    Command(String strCommand){
        this.strCommand=strCommand;
    }
    public String getStrCommand(){
        return strCommand;
    }
    abstract void mainFunction(UserList userList);
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
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
        if(!user.checkFirstName(firstName)) {
            System.out.println("Incorrect first name.");
            correctInput = false;
        }
        else if(!user.checkLastName(lastName)) {
            System.out.println("Incorrect last name.");
            correctInput = false;
        }
        else if(!user.checkEMail(eMail)) {
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
                if(!userList.eMailAlreadyTaken(createdUser)) {
                    userList.listOfUsers.put(createdUser.hashCode(), createdUser);
                    System.out.println("The student has been added.");
                    usersAdded += 1;
                }
                else System.out.println("This email is already taken.");
            }
        }
    }
}

class ListC extends Command {

    ListC() {
        super("list");
    }
    void mainFunction(UserList userList) {

        if (userList.listOfUsers.size()!=0) {
            System.out.println("Students:");
            for (var student : userList.listOfUsers.entrySet()) {
                System.out.println(student.getKey());
            }
        }
        else System.out.println("No students found");
    }
}

class AddPoints extends Command {

    AddPoints() {
        super("add points");
    }
    void mainFunction(UserList userList) {
        System.out.println("Enter an id and points or 'back' to return");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input[] = scanner.nextLine().split(" ");
            if (input[0].equals("back")) break;
            readPoints(userList,input);
        }
    }

    public void readPoints(UserList userList, String[] input){
        Scanner scanner = new Scanner(System.in);
        //String input[] = scanner.nextLine().split(" ");
        try {
            User user = userList.listOfUsers.get(Integer.parseInt(input[0]));
        }
        catch (NumberFormatException f){
                System.out.printf("No student is found for id=%s", input[0]);
        }
            try {
                if (userList.listOfUsers.get(Integer.parseInt(input[0])) != null && input.length == 5) {
                    if(this.isNumeric(input[1]) && this.isNumeric(input[2]) && this.isNumeric(input[3]) && this.isNumeric(input[4])) {
                        int java = Integer.parseInt(input[1]);
                        int dsa = Integer.parseInt(input[2]);
                        int db = Integer.parseInt(input[3]);
                        int spring = Integer.parseInt(input[4]);
                        if (java < 0 || dsa < 0 || db < 0 || spring < 0) throw new NumberFormatException();

                        User student = userList.listOfUsers.get(Integer.parseInt(input[0]));
                        student.javaPoints += (java);
                        student.dSAPoints += (dsa);
                        student.dBPoints += (db);
                        student.springPoints += (spring);
                        System.out.println("Points updated.");
                    } else  {
                        System.out.println("Incorrect points format.");
                    }
                } else if (userList.listOfUsers.get(Integer.parseInt(input[0])) == null)
                    System.out.printf("No student is found for id=%D", input[0]);
                else System.out.println("Incorrect points format.");

            } catch (NumberFormatException e) {
                System.out.println("Incorrect points format.");
            }






    }
}

class Find extends Command {
    Find() {
        super("find");
    }
    void mainFunction(UserList userList) {
        System.out.println("Enter an id or 'back' to return");
        findUser(userList);

    }

    public void findUser(UserList userList){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if(input.equals("back")) break;
            try {
                if (userList.listOfUsers.get(Integer.parseInt(input)) != null) {
                    User student = userList.listOfUsers.get(Integer.parseInt(input));

                    int java = student.javaPoints;
                    int dsa = student.dSAPoints;
                    int db = student.dBPoints;
                    int spring = student.springPoints;
                    System.out.printf("%s points: Java=%d; DSA=%d; Databases=%d; Spring=%d%n",input, java, dsa, db, spring);


                }
            } catch (NumberFormatException e) {

            }
        }
    }



}