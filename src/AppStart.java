
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;	
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStart extends Application{

	public static void main(String[] args){
		Application.launch();
	}
		
	@Override
	public void start(Stage stage) throws Exception {
		Parent page = FXMLLoader.load(getClass().getResource("view/login.fxml"));
		Scene scene = new Scene(page);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
	}
}
