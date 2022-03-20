import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class CMDMainTest  {//this is the java test class

    @Test
    void main() throws Exception{
        String contProgram = "y";
        String newData = contProgram.toUpperCase(Locale.ROOT);
        assertEquals("Y",newData);


    }

    @Test
    void acceptCommand() {
        String contProgram = "8";
        String newData = contProgram.toUpperCase(Locale.ROOT);
        assertEquals(newData,8);
    }

    @Test
    void validateCommand() {
        String userOption ="1";

        int userCommand = Integer.parseInt( userOption );

        if( userCommand > 0 && userCommand <= 9 )
        {
          System.out.println("Success");
      }
       else {
           System.out.println("Enter an integer from 1 to 9");
        }

        assertEquals(1,userCommand);

    }

    @Test
    void executeUserCommand() {
    }
}