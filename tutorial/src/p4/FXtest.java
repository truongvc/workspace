package p4;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class FXtest extends Application{

	public void start(Stage primaryStage) throws Exception {
		Button btnOK = new Button("OK");
		Scene scene = new Scene(btnOK, 200,200);
		primaryStage.setTitle("MY javaFX");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
