import java.util.Map;
import java.util.HashMap;

public class Path {
	private Map<Source, Destination> routes = new HashMap<Source, Destination>();

	public void insertPath (String source, String destination) {
		this.routes.put(new Source(source), new Destination(destination));
	}

	public boolean checkPath(String source, String destination) {
		Source src = new Source(source);
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + routes.get(src).getName());
		return destination == this.routes.get(src).getName();
	}
}