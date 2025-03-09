import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloTest {

    @Test
    public void testHelloWorldOutput() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        HelloWorld.main(new String[]{});

        // Assert
        assertEquals("Hello World!\n", outContent.toString());
    }
}