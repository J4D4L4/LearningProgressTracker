import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


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

    @ParameterizedTest
    @CsvSource({ "asd", "hjgds", "Jean-Claude", "Asfl" })
    public void testGoodFirstName(String firstName){
        User testUser = new User();
        boolean actualStatus = testUser.checkFirstName(firstName);
        boolean expectedStatus = true;

        Assertions.assertEquals(actualStatus,expectedStatus);
    }
    @ParameterizedTest
    @CsvSource({ "asd23", "#hjgds", "/'test", "As-fl45", "A" })
    public void testBadFirstName(String firstName){
        User testUser = new User();
        boolean actualStatus = testUser.checkFirstName(firstName);
        boolean expectedStatus = false;

        Assertions.assertEquals(expectedStatus, actualStatus);
    }

    @ParameterizedTest
    @CsvSource({ "Smith ", "Doolittle ", "test", "O'Connor" })
    public void testGoodLastName(String firstName){
        User testUser = new User();
        boolean actualStatus = testUser.checkLastName(firstName);
        boolean expectedStatus = true;

        Assertions.assertEquals(actualStatus,expectedStatus);
    }
    @ParameterizedTest
    @CsvSource({ "asd23", "#hjgds", "/'test", "Asa487fl", "51666" })
    public void testBadLastName(String firstName){
        User testUser = new User();
        boolean actualStatus = testUser.checkLastName(firstName);
        boolean expectedStatus = false;

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
    @Test
    public void testGetLastname(){
        User testUser = new User("test", "test", "test");
        String[] in = {"Not","Last","Name", " not"};
        String actualStatus = testUser.getLastName(in);
        String expectedStatus = "Last Name";

        Assertions.assertEquals(actualStatus,expectedStatus);

        String[] in2 = {"Not","","not"};
        actualStatus = testUser.getLastName(in2);
        expectedStatus = "";

        Assertions.assertEquals(expectedStatus, actualStatus);


    }

    @Test public void testIsSame(){
        User user1 = new User("da", "da", "asd@asd.de");
        User user2 = new User("dsasd", "asdsfd", "asd@asd.de");
        boolean actualStatus = user1.equals(user2);
        boolean expectedStatus = true;
    }

    @Test public void testNotSame(){
        User user1 = new User("da", "da", "asd@asd.de");
        User user2 = new User("dsasd", "asdsfd", "asdasd@asd.de");
        boolean actualStatus = user1.equals(user2);
        boolean expectedStatus = false;
    }

    @Test public void testHashSame(){
        User user1 = new User("da", "da", "asd@asd.de");
        User user2 = new User("dsasd", "asdsfd", "asd@asd.de");
        boolean actualStatus = user1.hashCode()==user2.hashCode();
        boolean expectedStatus = true;
    }

    @Test public void testHashNotSame(){
        User user1 = new User("da", "da", "asd@asd.de");
        User user2 = new User("dsasd", "asdsfd", "asdsad@asd.de");
        boolean actualStatus = user1.hashCode()==user2.hashCode();
        boolean expectedStatus = false;
    }
}
