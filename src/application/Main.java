package application;


import application.components.pageobjects.windows.login.LoginWindow;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The Class Main.
 */
public class Main extends Application {

	/** The primary stage. */
	Stage primaryStage;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
//		DatabaseConnection conn = new DatabaseConnection();
//		AuthManager authManager = new AuthManager();
//		authManager.createUser("username", "password");
//		authManager.login("username", "password");
		initApplication(primaryStage);		
	}
	
	/**
	 * Inits the application.
	 *
	 * @param primaryStage2 the primary stage2
	 */
	private void initApplication(Stage primaryStage2) {
		primaryStage = new LoginWindow().getStage();
		
	}

}
