import java.io.*;

class Paths {
	public static void main(String[] args) throws IOException {
		if(args.length == 6)
			processWithCity(args);
		else
			processWithoutCity(args);
	}

	private static void processWithoutCity(String[] args) throws IOException  {
		Database database = new Database(args[1]);
		RouteMap map = database.insertPath();

		City source = new City(new String(args[2]));
		City destination = new City(new String(args[3]));
		
		try{
			System.out.println(map.searchPath(source, destination));
		}

		catch(CityNotFoundException e) {
			System.out.println(e.message);
		}		
	}

	private static void processWithCity(String[] args) throws IOException  {
		Database database = new Database(args[1], args[3]);
		RouteMap map = database.insertPath();

		City source = new City(new String(args[args.length - 1]));
		City destination = new City(new String(args[args.length - 2]));
		
		try{
			System.out.println(map.searchPath(source, destination));
		}

		catch(CityNotFoundException e) {
			System.out.println(e.message);
		}		

	}
}