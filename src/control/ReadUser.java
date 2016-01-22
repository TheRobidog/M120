package control;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadUser {
	public static void main(String[] args) throws IOException{

	}
	
	public static Boolean UserExists(String username) throws IOException{
		String[] users = getAll();
		
		for(String user : users){
			String[] userArray = user.split(":");
			if(username.equals(userArray[0])){
				return true;
			}
		}
		
		return false;
	}
	
	public static Boolean UserandPassExist(String username, String password) throws IOException{
		String[] users = getAll();
		
		for(String user : users){
			String[] userArray = user.split(":");
			if(username.equals(userArray[0]) && password.equals(userArray[4])){
				return true;
			}
		}
		
		return false;
	}
	
	private static String[] getAll() throws IOException{
		String fileName = "C:/Users/vmadmin/workspace/M120/src/data/users.txt"; //Temporär
		//System.out.println(Paths.get(fileName));
		List<String> usersList = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
		
		String[] usersArray = usersList.toArray(new String[0]);
		
		return usersArray;
	}
}
