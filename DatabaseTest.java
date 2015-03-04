import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseTest {
	@Test
	public void check_direct_path_between_two_cities () {
		RouteMap map = new RouteMap();
		map.insertPath("Bangalore", "Chennai");

		assertEquals(map.hasPath(new City("Bangalore"), new City("Chennai")), true);
		assertEquals(map.hasPath(new City("Bangalore"), new City("Delhi")), false);

		map.insertPath("Bangalore", "Delhi");
		assertEquals(map.hasPath(new City("Bangalore"), new City("Delhi")), true);
	}

	// @Test
	// public void check_any_possible_path_between_two_cities_01 () throws CityNotFoundException  {
	// 	RouteMap map = new RouteMap();
	// 	map.insertPath("Bangalore", "Chennai");
	// 	map.insertPath("Bangalore", "Delhi");
	// 	map.insertPath("Delhi", "Singapore");

	// 	assertEquals(map.hasPossiblePath("Bangalore", "Chennai"), true);
	// 	assertEquals(map.hasPossiblePath("Bangalore", "Singapore"), true);
	// 	assertEquals(map.hasPossiblePath("Singapore", "Delhi"), true);
	// }

	// @Test
	// public void check_any_possible_path_between_two_cities_02 () throws CityNotFoundException  {
	// 	RouteMap map = new RouteMap();
	// 	map.insertPath("Bangalore", "Chennai");
	// 	map.insertPath("Bangalore", "Delhi");
	// 	map.insertPath("Delhi", "Singapore");

	// 	assertEquals(true,map.hasPossiblePath("Singapore", "Bangalore"));
	// }
}