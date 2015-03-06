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
}