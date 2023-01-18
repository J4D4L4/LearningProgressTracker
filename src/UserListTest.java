import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class UserListTest {
    UserList userList = new UserList();
    User user1 = new User("da", "da", "asd@asd.de");
    User user2 = new User("dsasd", "asdsfd", "asdasd@asd.de");
    User user3 = new User("dsasd", "asdsfd", "asgghjhjj@asd.de");
    User user4 = new User("dsasd", "asdsfd", "asgghjhjasgdsgj@asd.de");


    @Test
    public void testGetCoursePopularity(){
        setUp();
        HashMap<String, Integer> activity = userList.getCoursePopularity();
        String highest = "";
        int highestI = 0;
        for(var i : activity.entrySet()){
            if (i.getValue()>highestI){
                highestI = i.getValue();
                highest = i.getKey();
            }
        }
        String expected ="DSA";
        Assertions.assertEquals(expected,highest);
        //Assertions.assertEquals(expected,userList.getMostPopular());
    }
    @Test
    public void testGetCourseActivity(){
        setUp();
        HashMap<String, Integer> activity = userList.getUserActivity();
        String highest = "";
        int highestI = 0;
        for(var i : activity.entrySet()){
            if (i.getValue()>highestI){
                highestI = i.getValue();
                highest = i.getKey();
            }
        }
        String expected ="Spring";
        Assertions.assertEquals(expected,highest);
    }

    @Test
    public void testGetCourseEasyHard(){
        setUp();
        HashMap<String, Double> activity = userList.getCourseEasiestHardest();
        String highest = "";
        Double highestI = 0.0;
        for(var i : activity.entrySet()){
            if (i.getValue()>highestI){
                highestI = i.getValue();
                highest = i.getKey();
            }
        }
        String expected ="DSA";
        Assertions.assertEquals(expected,highest);
        Assertions.assertEquals(expected,userList.getEasiest());
    }
    public void setUp(){
        addPoints1(user1,1);
        addPoints1(user2,2);
        addPoints1(user3,3);
        addPoints1(user4,0);
        userList.listOfUsers.put(user1.hashCode(),user1);
        System.out.println(user1.hashCode());
        userList.listOfUsers.put(user2.hashCode(),user2);
        System.out.println(user2.hashCode());
        userList.listOfUsers.put(user3.hashCode(),user3);
        System.out.println(user3.hashCode());
        userList.listOfUsers.put(user4.hashCode(),user4);
        System.out.println(user4.hashCode());

    }
    public void addPoints1(User user, int offset){
        for (int i =0; i<offset;i++){
            user.javaPoints.add(i+offset);
        }
        for (int i =0; i<offset+1;i++){
            user.dBPoints.add(i+offset);
        }
        for (int i =0; i<offset+2;i++){
            user.dSAPoints.add(i+offset);
        }
        for (int i =0; i<offset+3;i++){
            user.springPoints.add(i+offset);
        }
    }
}
