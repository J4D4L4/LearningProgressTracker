

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

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

}
