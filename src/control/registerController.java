package control;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

import control.WriteUser;
import control.ReadUser;

public class registerController {
	@FXML protected TextField txtUser;
	@FXML protected TextField txtEmail;
	@FXML protected TextField txtName;
	@FXML protected TextField txtFirstname;
	
	@FXML protected PasswordField txtPass;
	@FXML protected PasswordField txtPassRepeat;
	
	@FXML protected void RegisterAction(ActionEvent event) throws Exception{
		Boolean userVer = UsernameCheck(txtUser.getText());
		Boolean emailVer = EmailCheck(txtEmail.getText());
		Boolean nameVer = NameCheck(txtName.getText());
		Boolean firstnameVer = FirstNameCheck(txtFirstname.getText());
		Boolean passVer = PasswordCheck(txtPass.getText());
		Boolean passRepVer = PasswordRepeatCheck(txtPass.getText(), txtPassRepeat.getText());
		
		if(userVer && emailVer && nameVer && firstnameVer && passVer && passRepVer){
			String[] userData = new String[]{txtUser.getText()
					,txtEmail.getText()
					,txtName.getText()
					,txtFirstname.getText()
					,txtPass.getText()
			};
				
			Boolean userSuccess = WriteUser.main(userData);
				
			if(userSuccess){
				Boolean folderSuccess = WriteUser.CreateFolders(userData[0]);
				if(folderSuccess){
					Alert alert = new Alert(AlertType.INFORMATION, "Account has been created");
					Optional<ButtonType> result = alert.showAndWait();
					if(result.isPresent() && result.get() == ButtonType.OK){
						OpenLogin();
					}
				}else{
					Alert alert = new Alert(AlertType.ERROR, "Error while creating folders for account");
					alert.show();
				}
			}else{
				Alert alert = new Alert(AlertType.ERROR, "Error while creating account");
				alert.show();
			}
		}
	}
	
	@FXML protected void BacktoLogin(ActionEvent event) throws Exception{
		OpenLogin();
	}
	
	private Boolean UsernameCheck(String username) throws IOException{
		if(ReadUser.UserExists(txtUser.getText())){
			Alert alert = new Alert(AlertType.ERROR, "User already exists");
			alert.show();
			return false;
		}else{
			Pattern userPat = Pattern.compile("^[a-zA-Z0-9]*$");
			Matcher userMat = userPat.matcher(username);
			Boolean patConf = userMat.matches();
		
			return patConf;
		}
	}
	
	private Boolean EmailCheck(String email){
		Pattern emailPat = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher emailMat = emailPat.matcher(email);
		Boolean patConf = emailMat.matches();
		
		return patConf;
	}
	
	private Boolean NameCheck(String name){
		Pattern namePat = Pattern.compile("^[a-zA-Z0-9]*$");
		Matcher nameMat = namePat.matcher(name);
		Boolean patConf = nameMat.matches();
		
		return patConf;
	}
	
	private Boolean FirstNameCheck(String firstname){
		Pattern fNamePat = Pattern.compile("^[a-zA-Z0-9]*$");
		Matcher fNameMat = fNamePat.matcher(firstname);
		Boolean patConf = fNameMat.matches();
		
		return patConf;
	}
	
	private Boolean PasswordCheck(String password){
		if(password.contains(":")){
			return false;
		}else{
			return true;
		}
	}
	
	private Boolean PasswordRepeatCheck(String password, String passwordRepeat){
		return password.equals(passwordRepeat);
	}
	
	private void OpenLogin() throws Exception{
		Stage stage = (Stage) txtUser.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/login.fxml"));
		stage.setScene(new Scene((Parent)loader.load()));
		stage.setTitle("Login");
		stage.show();
	}
}
