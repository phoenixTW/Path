import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class RouteMap {
	Map<City, List<String>> routes = new HashMap<City, List<String>>();
	List<String> possiblePath = new ArrayList<String>();

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

	public boolean hasPossiblePath (City source, City destination) throws CityNotFoundException {
		if(!areCitiesPresent(source, destination)) return false;
	
		initStorage(source.getName());
		List<String> visitedPaths = new ArrayList<String>();
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

	public String searchPath (City source, City destination) throws CityNotFoundException	 {
		boolean hasPath = hasPossiblePath(source, destination);
		String path = stringifyPath();
		return path;
	}

	private String stringifyPath () {
		String path = "";
		for (int counter = 0; counter < possiblePath.size(); counter++) {
			if(counter < possiblePath.size() - 1)
				path += possiblePath.get(counter) + "->";
			else
				path += possiblePath.get(counter);
		}

		return path;
	}
}