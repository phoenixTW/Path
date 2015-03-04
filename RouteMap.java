import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class RouteMap {
	Map<City, List> routes = new HashMap<City, List>();

	public void insertPath (String source, String destination) {

		if(routes.get(new City(source)) == null)
			routes.put(new City(source), new ArrayList<String>());

		if(routes.get(new City(destination)) == null)
			this.routes.put(new City(destination), new ArrayList<String>());

		routes.get(new City(source)).add(new String(destination));
		routes.get(new City(destination)).add(new String(source));
	}

	public boolean hasPath (String source, String destination) {
		if(routes.get(new City(source)) == null) return false;
		return routes.get(new City(source)).indexOf(destination) >= 0;
	}
}