import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class DatabaseTest {
	
	@Test
	public void readFile_should_read_contents_from_the_file () throws IOException{
		Database database = new Database("one.txt");
		String data = database.readFile();
		assertEquals(data, "Hello World");
	}	
}