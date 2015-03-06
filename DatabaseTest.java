import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class DatabaseTest {
	
	@Test
	public void readFile_should_read_contents_from_the_file () throws IOException{
		Database database = new Database("one.txt");
		String data = database.readFile();
		assertEquals(data, "Bangalore, Mumbai\r\nBangalore, Chennai");
	}

	@Test
	public void getPaths_should_give_source_and_destination_path_list () throws IOException {
		Database database = new Database("one.txt");
		String data = database.readFile();
		List<String> paths = database.getPaths(data);

		assertEquals(paths.get(0), "Bangalore, Mumbai");
		assertEquals(paths.get(1), "Bangalore, Chennai");
	}
}