package control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteUser {
	public static Boolean main(String[] user) throws IOException{
		if(user != null){
			String writingString = user[0] + ":" + user[1] + ":" + user[2] + ":" + user[3] + ":" + user[4] + "\r\n";
			Files.write(Paths.get("C:/Users/vmadmin/workspace/M120/src/data/users.txt") //Temporär
					,writingString.getBytes(), StandardOpenOption.APPEND
			);
			
			return true;
		}else{
			return false;
		}
	}
	
	public static Boolean CreateFolders(String username) throws IOException{
		File directory = new File("C:/Users/vmadmin/workspace/M120/src/data/" + username);
		Boolean CreateSuc = directory.mkdir();
		
		if(CreateSuc){
			return true;
		}else{
			return false;
		}
	}
}
