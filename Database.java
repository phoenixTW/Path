import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Database{
	String fileLocation = null;
	List<String> paths = new ArrayList<String>();

	Database (String pathName){
		this.fileLocation = pathName;
	}

	public String readFile () throws IOException {
		String text = null;
		File thisFile = new File("./" + fileLocation);
		FileReader fr = null;
		
		try {
			fr = new FileReader(thisFile);
		} catch(Exception e) {
			System.out.println("File Not Found");
		}

		BufferedReader br = new BufferedReader(fr);
		int length = (int)thisFile.length();
		char cbuf[] = new char[length];
		br.read(cbuf,0,length);
		text = new String (cbuf);
		
		return text;
	}

	public List<String> getPaths (String data) {
		String[] lines = data.split("\r\n");

		for (String line : lines)
			paths.add(line);

		return paths;
	}

	public RouteMap insertPath (String data) {
		RouteMap map = new RouteMap();
		List<String> collectionOfPaths = getPaths(data);
		for (String path : collectionOfPaths) {
			String[] words = splitByComma(path);
			map.insertPath(words[0], words[1]);
		}

		return map;
	}

	private String[] splitByComma (String line) {
		String[] words = line.split(",");

		for (int count = 0; count < words.length; count++) {
			words[count] = words[count].trim();
		}

		return words;
	}
}