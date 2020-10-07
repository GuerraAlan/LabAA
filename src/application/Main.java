package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			TabPane root = null;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ViewPrincipal.fxml"));
			
			root = loader.load();
				
			Scene scene = new Scene(root,400,200);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Suite LAA 2020.2");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
