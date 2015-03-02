class Program {
	public static void main(String[] args) {
		String source = args[0];
		String destination = args[1];
		Path path = new Path();

		path.insertPath("Bangalore", "Singapore");
		path.insertPath("Bangalore", "Tokyo");

		boolean hasPath = path.checkPath(source, destination);
		
		if (hasPath == false) {
			if(!path.hasSource(destination)) System.out.println("No city named '" + source + "' in database");
			else System.out.println("No city named '" + destination + "' in database");
			return;
		}

		System.out.println(hasPath);
	}
}