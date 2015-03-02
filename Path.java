import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Path {
	private Map<Source, List> routes = new HashMap<Source, List>();

	public void insertPath (String source, String destination) {
		Path paths = new Path();

		if(routes.get(new Source(source)) == null)
			this.routes.put(new Source(source), new ArrayList<String>());

		// System.out.println(">>>>>>>>>>>>" + routes.get(new Destination(destination)) + " - " + destination);
		if(routes.get(new Source(destination)) == null) this.routes.put(new Source(destination), new ArrayList<String>());

		routes.get(new Source(source)).add(new String(destination));
		routes.get(new Source(destination)).add(new String(source));

		// this.routes.put(new Source(source), new Destination(destination));
	}

	public boolean checkPath(String source, String destination) {
		if(routes.get(new Source(source)) == null) return false;
		return routes.get(new Source(source)).indexOf(destination) >= 0;

		// return routes.get(new Source(source)) == destination;
		// return routes.get(new Source(source)).equals(new Destination(destination));
	}

	public void showMap() {
		for (Source source : routes.keySet() ) {
			System.out.println("" + source + routes.get(source));
		}
	}

	public boolean hasSource (String city) {
		if(routes.get(new Source(city)) == null) return false;
		return true;
	}
}
