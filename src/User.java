
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    String firstName;
    String lastName;
    String eMail;

    User(String firstName, String lastName, String eMail){

        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;

    }
    User(){

        this.firstName = "Empty";
        this.lastName = "Empty";
        this.eMail = "Empty";

    }
    boolean checkEMail(String eMail) {
        //Email pattern : Starts with word then @ then word than . then word
        String patternStr = "\\w+@\\w+\\.\\w";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(eMail);
        return matcher.find();

    }

    boolean checkName(String name) {
        //Email pattern : Starts with word then @ then word than . then word
        String specialChar = "[~!@#$%^&*()_+{}\\[\\]:;,.<>/?]|\\d";
        String latinChar = "(?=\\pL)(?![a-zA-Z])";
        String firstAndLastChar = "^-|^'|-$|'$";

        Pattern specialCharPattern = Pattern.compile(specialChar);
        Pattern latinCharPattern = Pattern.compile(latinChar);
        Pattern firstAndLastCharPattern = Pattern.compile(firstAndLastChar);

        Matcher firstAndLastCharMatcher = firstAndLastCharPattern.matcher(name);
        Matcher specialCharMatcher = specialCharPattern.matcher(name);
        Matcher latinCharMatcher = latinCharPattern.matcher(name);

        boolean specialCharPatternB = specialCharMatcher.find();
        boolean firstAndLastCharB = firstAndLastCharMatcher.find();
        boolean latinCharB = latinCharMatcher.find();

        boolean isCorrect = !(specialCharPatternB || firstAndLastCharB || latinCharB);

        return isCorrect;

    }

    String getLastName(String[] in){
        String lastName="";
        for (int i =1; i< in.length-1;i++){
            lastName+=" "+in[i];
        }
        lastName = lastName.substring(1);
        return lastName;
    }

    @Override
    public int hashCode() {
        int hash =0;
        for (int i =0; i< this.eMail.length();i++)
            hash += eMail.charAt(i)%5;
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        /* Check this and other refer to the same object */
        if (this == other) {
            return true;
        }

        /* Check other is Person and not null */
        if (!(other instanceof User)) {
            return false;
        }

        User person = (User) other;

        /* Compare all required fields */
        return eMail == person.eMail;
    }
}
