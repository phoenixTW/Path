class Paths {
	public static void main(String[] args) {
		RouteMap map = new RouteMap();

		String source = new String(args[0]);
		String destination = new String(args[1]);
		
		map.insertPath("Bangalore", "Singapore");
		map.insertPath("Singapore", "Seoul");
		map.insertPath("Singapore", "Dubai");
		map.insertPath("Seoul", "Beijing");
		map.insertPath("Beijing", "Tokyo");
		try{
			System.out.println(map.hasPossiblePath(source, destination));
		}

		catch(CityNotFoundException e) {
			System.out.println(e.message);
		}
	}
}