

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserTest {

    @Test
    public void testCheckName(){
        User testUser = new User("test", "test", "test");
        boolean actualStatus = testUser.checkName("Goodname");
        boolean expectedStatus = true;

        Assertions.assertEquals(actualStatus,expectedStatus);

        actualStatus = testUser.checkName("Jean-Claude");
        expectedStatus = true;

        Assertions.assertEquals(expectedStatus, actualStatus);

        actualStatus = testUser.checkName("O'Neill");
        expectedStatus = true;

        Assertions.assertEquals(expectedStatus, actualStatus);

        actualStatus = testUser.checkName(" Jemison Van de Graaff");
        expectedStatus = true;

        Assertions.assertEquals(expectedStatus, actualStatus);


        actualStatus = testUser.checkName("Badname12");
        expectedStatus = false;

        //assertEquals(expectedStatus, actualStatus);

        actualStatus = testUser.checkName("Oğuz");
        expectedStatus = false;

        Assertions.assertEquals(expectedStatus, actualStatus);

        actualStatus = testUser.checkName("-Badname");
        expectedStatus = false;

        Assertions.assertEquals(expectedStatus, actualStatus);

        actualStatus = testUser.checkName("Badname'");
        expectedStatus = false;

        Assertions.assertEquals(expectedStatus, actualStatus);

    }

    @Test
    public void testCheckEmail(){
        User testUser = new User("test", "test", "test");

        boolean actualStatus = testUser.checkEMail("BadEmail123");
        boolean expectedStatus = false;

        Assertions.assertEquals(actualStatus,expectedStatus);

        actualStatus = testUser.checkEMail("GoodEmail@abs.de");
        expectedStatus = true;

        Assertions.assertEquals(expectedStatus, actualStatus);


    }

    public void testGetLastname(){
        User testUser = new User("test", "test", "test");
        String[] in = {"Not","Last"," Name", " not"};
        String actualStatus = testUser.getLastName(in);
        String expectedStatus = "Last Name";

        Assertions.assertEquals(actualStatus,expectedStatus);

        String[] in2 = {"Not","not"};
        actualStatus = testUser.getLastName(in2);
        expectedStatus = "";

        Assertions.assertEquals(expectedStatus, actualStatus);


    }
}
