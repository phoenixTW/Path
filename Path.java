import java.util.Map;
import java.util.HashMap;

public class Path {
	private Map<Source, Destination> routes = new HashMap<Source, Destination>();

	public void insertPath (String source, String destination) {
		this.routes.put(new Source(source), new Destination(destination));
	}

	public boolean checkPath(String source, String destination) {
		return routes.get(new Source(source)).equals(new Destination(destination));
	}

	public void showMap() {
		for (Source source : routes.keySet() ) {
			System.out.println("" + source + routes.get(source));
		}
	}
}
