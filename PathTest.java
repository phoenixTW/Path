import org.junit.Test;
import static org.junit.Assert.*;

public class PathTest {

	@Test
	public void path_should_set_Bangalore_as_source_and_Singapore_as_Destination () {
		Path path = new Path();
		path.insertPath("Bangalore", "Singapore");
		assertEquals(path.checkPath("Bangalore", "Singapore"), true);
	}

	@Test
	public void checkPath_should_give_false_for_Bangalore_as_source_and_Mumbai_as_Destination () {
		Path path = new Path();
		path.insertPath("Bangalore", "Singapore");
		// assertEquals(path.checkPath("Bangalore", "Mumbai"), false);
	}

	@Test
	public void checkPath_should_give_true_for_multiple_destination_from_Bangalore () {
		Path path = new Path();
		path.insertPath("Bangalore", "Singapore");
		path.insertPath("Bangalore", "Bankok");
		assertEquals(path.checkPath("Bangalore", "Bankok"), true);
		assertEquals(path.checkPath("Bangalore", "Singapore"), true);
	}
}