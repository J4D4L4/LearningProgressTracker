import java.util.LinkedHashMap;

public class UserList {
    //List<User> listOfUsers = new ArrayList<User>();
    LinkedHashMap<Integer, User> listOfUsers = new LinkedHashMap<>();

    boolean eMailAlreadyTaken( User user){
        if (listOfUsers.get(user.hashCode())!=null)
            return true;
        else return false;
    }

}
