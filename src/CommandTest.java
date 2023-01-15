

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {



    @Test
    public void testExit(){
        Command exit = new Exit();
        Assertions.assertNotNull(exit);

    }
    @Test
    public void testGetInput(){
        AddStudent addStudent = new AddStudent();

        ByteArrayInputStream in = new ByteArrayInputStream("Jan Landwehr test@test.de".getBytes());
        System.setIn(in);
        String[] input = addStudent.readInput();
        String[] expectedInput = {"Jan", "Landwehr", "test@test.de"};

        assertArrayEquals(input,expectedInput);

    }

    @Test
    public void testCheckCorrectInputs(){
        AddStudent addStudent = new AddStudent();

        boolean actualInput = addStudent.checkCorrectInput("true", "true asd", "true@email.cd");
        boolean exprected = true;
        assertEquals(actualInput,exprected);



    }
    @ParameterizedTest
    @CsvSource({ "tru312e, rue asd, true@email.cd", "true, rue 123 asd, true@email.cd","true, rue asd, true@emailcd" })
    public void  testCheckFalsetUserData(String first, String second, String third){
        AddStudent addStudent = new AddStudent();

        boolean actualInput = addStudent.checkCorrectInput(first,second, third);
        boolean exprected = false;
        assertEquals(actualInput,exprected);
    }

    @Test
    public void testAddPoints(){
        UserList userList = new UserList();
        AddPoints addPonts = new AddPoints();
        User user1 = new User("asd","asd","asd@asd.de");
        User user2 = new User("asd","asd","user2@asd.de");
        userList.listOfUsers.put(user1.hashCode(),user1);
        userList.listOfUsers.put(user2.hashCode(),user2);


        //ByteArrayInputStream in = new ByteArrayInputStream("10 1 2 3 4 5\n".getBytes());
        //System.setIn(in);
        String data = "10 1 2 3 4 \r\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().split(" ");
        addPonts.readPoints(userList, input);

        int isDB = userList.listOfUsers.get(10).dBPoints.get(0);
        int expectedDB = 3;

        assertEquals(expectedDB,isDB);


    }

}
