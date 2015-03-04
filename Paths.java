class Paths {
	public static void main(String[] args) {
		RouteMap map = new RouteMap();

		City source = new City(new String(args[0]));
		City destination = new City(new String(args[1]));
		
		map.insertPath("Bangalore", "Singapore");
		map.insertPath("Singapore", "Seoul");
		map.insertPath("Singapore", "Dubai");
		map.insertPath("Seoul", "Beijing");
		map.insertPath("Beijing", "Tokyo");
		
		try{
			System.out.println(map.searchPath(source, destination));
		}

		catch(CityNotFoundException e) {
			System.out.println(e.message);
		}
	}
}