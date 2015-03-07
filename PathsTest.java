import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest {
	@Test
	public void check_direct_path_between_two_cities () {
		RouteMap map = new RouteMap();
		map.insertPath("Bangalore", "Chennai");

		assertEquals(map.hasPath(new City("Bangalore"), new City("Chennai")), true);
		assertEquals(map.hasPath(new City("Bangalore"), new City("Delhi")), false);

		map.insertPath("Bangalore", "Delhi");
		assertEquals(map.hasPath(new City("Bangalore"), new City("Delhi")), true);
	}

	@Test
	public void check_any_possible_path_between_two_cities_01 () throws CityNotFoundException  {
		RouteMap map = new RouteMap();
		map.insertPath("Bangalore", "Chennai");
		map.insertPath("Bangalore", "Delhi");
		map.insertPath("Delhi", "Singapore");

		assertEquals(map.hasPossiblePath(new City("Bangalore"), new City("Chennai")), true);
		assertEquals(map.hasPossiblePath(new City("Bangalore"), new City("Singapore")), true);
		assertEquals(map.hasPossiblePath(new City("Singapore"), new City("Delhi")), true);
	}

	@Test
	public void check_any_possible_path_between_two_cities_02 () throws CityNotFoundException  {
		RouteMap map = new RouteMap();
		map.insertPath("Bangalore", "Chennai");
		map.insertPath("Bangalore", "Delhi");
		map.insertPath("Delhi", "Singapore");

		assertEquals(true, map.hasPossiblePath(new City("Singapore"), new City("Bangalore")));
	}

	@Test
	public void display_any_possible_path_between_two_cities () throws CityNotFoundException  {
		RouteMap map = new RouteMap();
		map.insertPath("Bangalore", "Chennai");
		map.insertPath("Bangalore", "Delhi");
		map.insertPath("Delhi", "Singapore");

		String[] cityRespectiveCountry = {"Bangalore, India", "Chennai, India", "Delhi, India", "Singapore, Singapore"};
		map.addCountry(cityRespectiveCountry);
		String path = "Singapore[Singapore]->Delhi[India]->Bangalore[India]";

		assertEquals(path, map.searchPath(new City("Singapore"), new City("Bangalore")));
	}

	@Test
	public void display_any_possible_path_between_Hongkong_and_Bangalore_and_Vice_versa () throws CityNotFoundException {
		RouteMap map = new RouteMap();
		map.insertPath("Bangalore", "Chennai");
		map.insertPath("Bangalore", "Delhi");
		map.insertPath("Delhi", "Singapore");
		map.insertPath("Singapore", "Hongkong");

		String[] cityRespectiveCountry = {"Bangalore, India", 
		"Chennai, India", "Delhi, India", "Singapore, Singapore", "Hongkong, Hongkong"};

		map.addCountry(cityRespectiveCountry);

		String path = "Hongkong[Hongkong]->Singapore[Singapore]->Delhi[India]->Bangalore[India]";
		assertEquals(path, map.searchPath(new City("Hongkong"), new City("Bangalore")));

		path = "Bangalore[India]->Delhi[India]->Singapore[Singapore]->Hongkong[Hongkong]";
		assertEquals(path, map.searchPath(new City("Bangalore"), new City("Hongkong")));		
	}
}