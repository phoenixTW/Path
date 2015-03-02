class Program {
	public static void main(String[] args) {
		String source = args[0];
		String destination = args[1];
		Path path = new Path();

		path.insertPath("Bangalore", "Singapore");
		path.insertPath("Bangalore", "Tokyo");

		System.out.println(path.checkPath(source, destination));
	}
}