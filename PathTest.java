import org.junit.Test;
import static org.junit.Assert.*;

public class PathTest {

	@Test
	public void should_return_2_by_adding_1_with_1 () {
		assertEquals(1+1, 2);
	}

	// @Test
	// public void path_should_set_Bangalore_as_source_and_Singapore_as_Destination () {
	// 	Path path = new Path();
	// 	path.insertPath("Bangalore", "Singapore");
	// 	assertEquals(path.checkPath("Bangalore", "Singapore"), true);
	// }

	// @Test
	// public void checkPath_should_give_false_for_Bangalore_as_source_and_Mumbai_as_Destination () {
	// 	Path path = new Path();
	// 	path.insertPath("Bangalore", "Singapore");
	// 	assertEquals(path.checkPath("Bangalore", "Singapore"), true);
	// 	assertEquals(path.checkPath("Bangalore", "Mumbai"), false);
	// }
}