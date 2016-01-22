package control;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class setSelectController {
	@FXML protected Button cmdRefresh;
	@FXML protected Button cmdLoad;
	@FXML protected ListView<String> lvwSets;
	
	public static String user;
	final ObservableList<String> listItems = FXCollections.observableArrayList("Add Items here");
	
	public static void main(String userName, String[] args) throws Exception{
		user = userName;
	}
	
	@FXML protected void RefreshSets(ActionEvent event){
		String[] sets = ReadSets.main(user);
	
		for(String set : sets){
			lvwSets.add(set);
		}
	}
	
	@FXML protected void LoadSet(ActionEvent event) throws IOException{
		String selectedElement = lvwSets.getSelectionModel().getSelectedItem();
		ReadCard.main(user, selectedElement);
	
		Stage stage = new Stage();
		StackPane page = (StackPane) FXMLLoader.load(getClass().getResource("card.fxml"));
		Scene scene = new Scene(page);
		stage.setScene(scene);
		stage.setTitle("Card");
		stage.show();
	}
}