package application;


import application.components.pageobjects.windows.login.LoginWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
//		DatabaseConnection conn = new DatabaseConnection();
//		AuthManager authManager = new AuthManager();
//		authManager.createUser("username", "password");
//		authManager.login("username", "password");
		initApplication(primaryStage);		
	}
	
	private void initApplication(Stage primaryStage2) {
		primaryStage = new LoginWindow().getStage();
		
	}

}
