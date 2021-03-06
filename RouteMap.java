import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class RouteMap {
	Map<City, List<String>> routes = new HashMap<City, List<String>>();
	List<String> possiblePath = new ArrayList<String>();
	Map<City, Country> location = new HashMap<City, Country>();

	public void insertPath (String source, String destination) {
		addSource(source, destination);
		routes.get(new City(source)).add(new String(destination));
		routes.get(new City(destination)).add(new String(source));
	}

	public boolean hasPath (City source, City destination) {
		if(routes.get(source) == null) return false;
		return routes.get(source).indexOf(destination.getName()) >= 0;
	}

	private void addSource (String place1, String place2) {
		if(routes.get(new City(place1)) == null)
			routes.put(new City(place1), new ArrayList<String>());		

		if(routes.get(new City(place2)) == null)
			this.routes.put(new City(place2), new ArrayList<String>());
	}

	private void initStorage (String source) {		
		possiblePath = new ArrayList<String>();
		possiblePath.add(source);
	}

	public boolean hasPossiblePath (City source, City destination, List<String> visitedPaths) throws CityNotFoundException {
		if(!areCitiesPresent(source, destination)) return false;
	
		initStorage(source.getName());
		boolean hasAnyPath = trackPath(source, destination, visitedPaths);
		possiblePath = reversePath(source.getName());
		return hasAnyPath;
	}

	private boolean areCitiesPresent(City source, City destination) throws CityNotFoundException {
		if(!isCityPresent(source))
			throw new CityNotFoundException(source.getName());

		if(!isCityPresent(destination))
			throw new CityNotFoundException(destination.getName());

		return true;
	}

	public boolean trackPath(City source, City destination, List<String> visitedPaths) {
		visitedPaths.add(source.getName());

		if(hasPath(source, destination))
			return possiblePath.add(destination.getName()) && true;

		for (String city : routes.get(source))
			if((!(possiblePath.indexOf(city) >= 0))
				&& (!(visitedPaths.indexOf(city) >= 0)) 
				&& trackPath(new City(city),destination, visitedPaths))
				return possiblePath.add(city) && true;

		return false;
	}

	public void showPossiblePath() {
		System.out.println(possiblePath);
	}

	private List<String> reversePath(String source) {
		List<String> path = new ArrayList<String>();
		path.add(source);
		for (int counter = (possiblePath.size() - 1); counter > 0; counter--) {
			path.add(possiblePath.get(counter));
		}

		return path;
	}

	public boolean isCityPresent (City city) {
		return routes.get(city) != null;
	}

	public String searchPath (City source, City destination) throws CityNotFoundException {
		List<String> visitedPaths = new ArrayList<String>();
		return manupulatePath(source, destination, visitedPaths);
	}

	private String manupulatePath(City source, City destination, List<String> visitedPaths) throws CityNotFoundException {
		hasPossiblePath(source, destination, visitedPaths);
		String path = stringifyPath();
		return path;
	}

	private String stringifyPath () {
		String path = "";
		for (int counter = 0; counter < possiblePath.size(); counter++) {
			String cityName = possiblePath.get(counter);
			String cityLocation = cityName;
			
			if (location.get(new City(cityName)) != null) {
				String country = location.get(new City(cityName)).getName() ;
				cityLocation = cityName + "[" + country + "]";				
			}
			

			if(counter < possiblePath.size() - 1)
				path += cityLocation + "->";
			else
				path += cityLocation;
		}

		return path;
	}

	public void addCountry(String[] countryList) {
		for (String list : countryList) {
			String[] place = splitByComma(list);
			location.put(new City(place[0]), new Country(place[1]));
		}
	}

	private String[] splitByComma (String line) {
		String[] words = line.split(",");

		for (int count = 0; count < words.length; count++) {
			words[count] = words[count].trim();
		}

		return words;
	}

	public List<String> findAllPaths(City source, City destination) throws CityNotFoundException {
		List<String> allPaths = new ArrayList<String>();
		String city_name = source.getName();
		String countryOfSource = location.get(source).getName();

		for (String city : routes.get(source)) {
			List<String> visitedPaths = new ArrayList<String>();
			visitedPaths.add(city_name);
			String path = city_name + "[" + countryOfSource + "]->" + manupulatePath(new City(city), destination, visitedPaths);
			// initStorage(source.getName());
			allPaths.add(path);
		}

		return allPaths;
	}
	// public String searchPath (City source, City destination) throws CityNotFoundException {
	// 	List<String> visitedPaths = new ArrayList<String>();
	// 	hasPossiblePath(source, destination, visitedPaths);
	// 	String path = stringifyPath();
	// 	return path;
	// }

}