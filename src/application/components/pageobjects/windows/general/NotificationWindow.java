package application.components.pageobjects.windows.general;

import application.components.pageobjects.windows.ConfirmDialogWindow;
import application.components.theme.Theme;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class NotificationWindow extends ConfirmDialogWindow {
	
	private static final String OK_BUTTON_TEXT = "Ok";

	public NotificationWindow(String title, String label) {
		super(title, label);
		setupScene();
		setupConfig();
	}

	@Override
	public void setupConfig() {
		window.initModality(Modality.APPLICATION_MODAL);
		window.setResizable(false);
		window.showAndWait();
	}
	
	@Override
	public void setupScene() {
		
		Label label = new Label(this.getLabel());
		HBox topHorizontalBox = new HBox();
		topHorizontalBox.getChildren().add(label);
		topHorizontalBox.setAlignment(Pos.CENTER);
		
		Button okButton = new Button(OK_BUTTON_TEXT);
		okButton.setOnAction(e -> {
			e.consume();
			window.close();
		});
		HBox bottomHorizontalBox = new HBox();
		bottomHorizontalBox.getChildren().add(okButton);
		bottomHorizontalBox.setAlignment(Pos.CENTER);
		
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(20);
		vBox.getChildren().addAll(topHorizontalBox, bottomHorizontalBox);
		vBox.setStyle(Theme.CSS_STYLE_NOTIFICATION_BACKGROUND);
		
		StackPane pane = new StackPane();
		pane.setPadding(Theme.CSS_CONTENT_INSETS);
		pane.setStyle(Theme.CSS_STYLE_APPLICATION_BACKGROUND);
		pane.getChildren().add(vBox);
		
		Scene scene = new Scene(pane);
		window.setScene(scene);
	}

}
