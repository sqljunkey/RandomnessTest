import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandsTest {

@Test
    void testPassingArguments(){

    ParseCommandLine parser = new ParseCommandLine();

    String[] command =new String[]{"-f","big","-s","10","-i","2000000"};


    Exception thrown = Assertions.assertThrows(Exception.class, () -> {
        parser.parse(command);
    });

    Assertions.assertEquals("Usage: java -jar perturbations -f file.bits -s 10 -i 100000000"
            , thrown.getMessage());

}




}
