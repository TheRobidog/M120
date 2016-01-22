package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import control.ReadUser;

public class editController {	
	@FXML protected TextField txtSearch;
	@FXML protected TextField txtQuestion;
	@FXML protected TextField txtAnswer;
	@FXML protected ListView<String> lvwCards;
	
	public Integer id;
	public static String user;
	public static String setName;
	
	public static void main(String username, String setSetName, String[] args) throws Exception{
		user = username;
		setName = setSetName;
	}
	
	public void getSet() throws IOException{
		ReadCard.main(user, setName);
	}
	
	@FXML protected String[] SearchEntry(ActionEvent event){
		List<String> entryList = new List<>();
		for(String entry : lvwCards.getItems()){
			if(entry.contains(txtSearch.getText())){
				entryList.add(entry);
			}
		}
	
		String[] returnArray = new String[entryList.size()];
		entryList.toArray(returnArray);
	
		return returnArray;
	}
	
	@FXML protected Boolean SaveEntry(ActionEvent event) throws IOException{
		String[] fullSet = ReadCard.main(user, setName);
		String saveString = id + ":" + txtQuestion.getText() + ":" + txtAnswer.getText() + "/r/n";
		fullSet[id] = saveString;
		WriteCard.main(user, setName, fullSet);
		return null;
	}
}