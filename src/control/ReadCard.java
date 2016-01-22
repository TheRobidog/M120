package control;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadCard {
	
	public static String[] main(String username, String setName) throws IOException{
		String fileName = "C:/Users/vmadmin/workspace/M120/src/data/" + username + "/" + setName + ".txt"; //Temporär
		//System.out.println(Paths.get(fileName));
		List<String> setList = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
		String[] setArray = setList.toArray(new String[0]);
		return setArray;
	}
	
}
