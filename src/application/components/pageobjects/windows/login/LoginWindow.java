package application.components.pageobjects.windows.login;

import application.components.pageobjects.windows.BasicWindow;
import application.components.pageobjects.windows.main.MainWindow;
import application.components.theme.Theme;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class LoginWindow extends BasicWindow {

	private static final String TITLE = "Login";
	
	private static final String LABEL_USERNAME = "Username";
	
	private static final String LABEL_PASSWORD = "Password";
	
	private static final String BUTTON_LABEL_LOGIN = "Login";
	
	private static final int WIDTH_LOGIN_WINDOW = 400;
	
	private static final int HEIGHT_LOGIN_WINDOW = 300;
	
	public LoginWindow() {
		super(TITLE, WIDTH_LOGIN_WINDOW, HEIGHT_LOGIN_WINDOW);
		setupScene();
		setupConfig();
		window.show();
	}
	
	public void setupConfig() {
		window.setResizable(false);
	}

	public void setupScene() {
		
		
		// GridPane
		GridPane grid = new GridPane();
		grid.setStyle(Theme.CSS_STYLE_LOGIN_BACKGROUND);
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(Theme.CSS_CONTENT_INSETS);
		grid.setHgap(50);
		grid.setVgap(20);
		
		// Label: username
		Label usernameLabel = new Label(LABEL_USERNAME);
		grid.add(usernameLabel, 0, 0);
		
		// TextField: username
		TextField usernameField = new TextField();
		grid.add(usernameField, 1, 0);
		
		// Label: password
		Label passwordLabel = new Label(LABEL_PASSWORD);
		grid.add(passwordLabel, 0, 1);
		
		// PasswordField: password
		PasswordField passwordField = new PasswordField();
		grid.add(passwordField, 1, 1);
		
		// Button: loginButton
		Button loginButton = new Button(BUTTON_LABEL_LOGIN);
		loginButton.setOnAction(e -> {
//			AuthManager authManager = new AuthManager();
			System.out.println("Starting Authentification...");
//			authManager.login(usernameField.getText(), passwordField.getText());
			window.close();
			new MainWindow();
		});
		grid.add(loginButton, 1, 2);
		
		StackPane pane = new StackPane();
		pane.setPadding(Theme.CSS_CONTENT_INSETS);
		pane.setStyle(Theme.CSS_STYLE_APPLICATION_BACKGROUND);
		pane.getChildren().add(grid);
		
		// Add grid to scene
		Scene scene = new Scene(pane);
		// Add scene to window
		super.window.setScene(scene);
	}


}
