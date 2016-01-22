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
import javafx.stage.Stage;

import control.ReadUser;

public class loginController {
	@FXML protected TextField txtUser;
	@FXML protected PasswordField txtPass;
	
	@FXML protected void LoginAction(ActionEvent event) throws Exception{	
		if(txtUser.getText() != null && txtPass.getText() != null){
			if(ReadUser.UserandPassExist(txtUser.getText(), txtPass.getText())){
				Stage stage = (Stage) txtUser.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/card.fxml"));
				stage.setScene(new Scene((Parent)loader.load()));
				stage.setTitle("Welcome");

				cardController card = loader.<cardController>getController();
				card.set(txtUser.getText());
			}
		}else{
			Alert alert = new Alert(AlertType.ERROR, "Username and/or password are wrong");
			alert.show();
		}
	}
	
	@FXML protected void SwitchToRegister(ActionEvent event) throws Exception{
		Stage stage = (Stage) txtUser.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/register.fxml"));
		stage.setScene(new Scene((Parent)loader.load()));
		stage.setTitle("Register");
	}
}
