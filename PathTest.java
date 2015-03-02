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
		assertEquals(path.checkPath("Bangalore", "Mumbai"), false);
	}

	@Test
	public void checkPath_should_give_true_for_multiple_destination_from_Bangalore () {
		Path path = new Path();
		path.insertPath("Bangalore", "Singapore");
		path.insertPath("Bangalore", "Bankok");
		assertEquals(path.checkPath("Bangalore", "Bankok"), true);
		assertEquals(path.checkPath("Bangalore", "Singapore"), true);
	}

	@Test
	public void checkPath_should_give_true_for_multiple_destination_from_Different_location () {
		Path path = new Path();
		path.insertPath("Bangalore", "Singapore");
		path.insertPath("Bangalore", "Bankok");
		path.insertPath("Hyderabad", "Kolkata");
		path.insertPath("Kolkata", "Hyderabad");

		assertEquals(path.checkPath("Bangalore", "Bankok"), true);
		assertEquals(path.checkPath("Bangalore", "Singapore"), true);
		assertEquals(path.checkPath("Hyderabad", "Kolkata"), true);
		assertEquals(path.checkPath("Kolkata", "Hyderabad"), true);
		assertEquals(path.checkPath("Bankok", "Hyderabad"), false);
	}

	@Test
	public void checkPath_should_give_true_for_Bangalore_to_Chennai_and_viceversa_for_a_single_call () {
		Path path = new Path();
		path.insertPath("Bangalore", "Chennai");
		assertEquals(path.checkPath("Bangalore", "Chennai"), true);
		assertEquals(path.checkPath("Chennai", "Bangalore"), true);
	}

	@Test
	public void checkPath_should_give_true_for_multiple_destination_from_Different_location_for_single_insertion () {
		Path path = new Path();
		path.insertPath("Bangalore", "Singapore");
		path.insertPath("Bangalore", "Bankok");
		path.insertPath("Hyderabad", "Kolkata");

		assertEquals(path.checkPath("Bangalore", "Bankok"), true);
		assertEquals(path.checkPath("Bangalore", "Singapore"), true);
		assertEquals(path.checkPath("Bankok", "Bangalore"), true);
		assertEquals(path.checkPath("Singapore", "Bangalore"), true);
		assertEquals(path.checkPath("Hyderabad", "Kolkata"), true);
		assertEquals(path.checkPath("Kolkata", "Hyderabad"), true);
		assertEquals(path.checkPath("Bankok", "Hyderabad"), false);
	}
}