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

	public void addSource (String place1, String place2) {
		if(routes.get(new City(place1)) == null)
			routes.put(new City(place1), new ArrayList<String>());		

		if(routes.get(new City(place2)) == null)
			this.routes.put(new City(place2), new ArrayList<String>());
	}

	public void initStorage (String source) {		
		possiblePath = new ArrayList<String>();
		possiblePath.add(source);
	}

	public boolean hasPossiblePath (City source, City destination) throws CityNotFoundException {
		if(!areCitiesPresent(source, destination)) return false;
		initStorage(source.getName());
		boolean hasAnyPath = trackPath(source, destination);
		possiblePath = reversePath(source.getName());
		return hasAnyPath;
	}

	public boolean areCitiesPresent(City source, City destination) throws CityNotFoundException {
		if(!isCityPresent(source)) {
			throw new CityNotFoundException(source.getName());
		}

		if(!isCityPresent(destination)) {
			throw new CityNotFoundException(destination.getName());
		}

		return true;
	}

	public boolean trackPath(City source, City destination) {
		if(hasPath(source, destination)) {
			possiblePath.add(destination.getName());
			return true;
		}

		for (String city : routes.get(source)) {
			if((!(possiblePath.indexOf(city) >= 0)) && trackPath(new City(city),destination)) {
				possiblePath.add(city);
				return true;
			}
		}
		return false;

	}

	public void showPossiblePath() {
		System.out.println(possiblePath);
	}

	public List<String> reversePath(String source) {
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
}