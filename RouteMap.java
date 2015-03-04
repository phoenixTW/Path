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

	public boolean hasPath (String source, String destination) {
		if(routes.get(new City(source)) == null) return false;
		return routes.get(new City(source)).indexOf(destination) >= 0;
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

	public boolean hasPossiblePath (String source, String destination) {
		initStorage(source);
		boolean hasAnyPath = trackPath(source, destination);
		possiblePath = reversePath(source);
		return hasAnyPath;
	}

	public boolean trackPath(String source, String destination) {
		if(hasPath(source, destination)) {
			possiblePath.add(destination);
			return true;
		}

		for (String city : routes.get(new City(source))) {
			if((!(possiblePath.indexOf(city) >= 0)) && trackPath(city,destination)) {
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