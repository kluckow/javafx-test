package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ComponentGenerator {

	private static final String TITLE_MAIN_WINDOW = "Main Window";
	
	private static final String TITLE_EXIT_WINDOW = "Exit  Window";
	
	private static final String LABEL_EXIT_WINDOW = "Really want to close the program?";
	
	private static final String LABEL_USERNAME = "Username";
	
	private static final String LABEL_PASSWORD = "Password";
	
	private static final String BUTTON_LABEL_LOGIN = "Login";
	
	private static final String CSS_STYLE_APPLICATION_BACKGROUND = "-fx-background-color: cadetblue; -fx-border-color: red";
	
	public Stage createMainStage(int width, int height) {
		
		Stage window = createWindow(800, 600, TITLE_MAIN_WINDOW);
		
		GridPane grid = new GridPane();
		grid.setStyle(CSS_STYLE_APPLICATION_BACKGROUND);
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(50);
		grid.setVgap(20);
		
		Label usernameLabel = new Label(LABEL_USERNAME);
		grid.add(usernameLabel, 0, 0);
		
		TextField textField = new TextField();
		grid.add(textField, 1, 0);
		
		Label passwordLabel = new Label(LABEL_PASSWORD);
		grid.add(passwordLabel, 0, 1);
		
		PasswordField passwordField = new PasswordField();
		grid.add(passwordField, 1, 1);

		Button loginButton = new Button(BUTTON_LABEL_LOGIN);
		loginButton.setOnAction(e -> createWindow(800, 600, TITLE_MAIN_WINDOW).show());
		grid.add(loginButton, 1, 2);
		
		Scene scene = new Scene(grid);
		window.setScene(scene);
		
		window.setOnCloseRequest(e -> {
			e.consume();
			createCloseDialog(window);
		});
		
		window.show();
		return window;
	}
	
	public Stage createWindow(int width, int height, String title) {
		
		Stage window = new Stage();
		window.setTitle(title);
		window.setWidth(width);
		window.setHeight(height);
		
		return window;
	}

	private Stage createCloseDialog(Stage window) {
		
		Stage closeWindow = createWindow(400, 200, TITLE_EXIT_WINDOW);
		closeWindow.initModality(Modality.APPLICATION_MODAL);
		Label label = new Label(LABEL_EXIT_WINDOW);
		HBox topHorizontalBox = new HBox();
		topHorizontalBox.getChildren().addAll(label);
		topHorizontalBox.setPadding(new Insets(40, 0, 10, 0));
		topHorizontalBox.setAlignment(Pos.TOP_CENTER);
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		yesButton.setOnAction(e -> closeWindow(window, closeWindow, true));
		noButton.setOnAction(e -> closeWindow(window, closeWindow, false));
		HBox bottomHorizontalBox = new HBox();
		bottomHorizontalBox.getChildren().addAll(yesButton, noButton);
		bottomHorizontalBox.setAlignment(Pos.CENTER);
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(topHorizontalBox, bottomHorizontalBox);
		
		Scene scene = new Scene(stackPane);
		closeWindow.setScene(scene);
		closeWindow.showAndWait();
		return closeWindow;
	}
	
	private void closeWindow(Stage window, Stage closeWindow, boolean answer) {
		
		if (answer) {
			closeWindow.close();
			window.close();
		} else {
			closeWindow.close();
		}
	}
	
}
