import org.junit.Test;
import static org.junit.Assert.*;

public class PathUnitTest {

	@Test
	public void source_should_insert_Delhi_as_source_value () {
		Source src = new Source("Delhi");
		assertEquals(src.getName(), "Delhi");
	}

	@Test
	public void Destination_should_insert_Delhi_as_source_value () {
		Destination src = new Destination("Raipur");
		assertEquals(src.getName(), "Raipur");
	}
}