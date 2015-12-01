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
import javafx.stage.Stage;

/**
 * The Class CloseDialogWindow.
 */
public class CloseDialogWindow extends ConfirmDialogWindow {

	/** The Constant TITLE_EXIT_WINDOW. */
	private static final String TITLE_EXIT_WINDOW = "Close Program";
	
	/** The Constant LABEL_WANT_TO_CLOSE. */
	private static final String LABEL_WANT_TO_CLOSE = "Really want to close the program?";
	
	/** The Constant YES_BUTTON_TEXT. */
	private static final String YES_BUTTON_TEXT = "Yes";
	
	/** The Constant NO_BUTTON_TEXT. */
	private static final String NO_BUTTON_TEXT = "No";
	
	/** The caller. */
	private Stage caller;
	
	/**
	 * Instantiates a new close dialog window.
	 *
	 * @param caller the caller
	 */
	public CloseDialogWindow(Stage caller) {
		super(TITLE_EXIT_WINDOW, LABEL_WANT_TO_CLOSE);
		this.setCaller(caller);
		setupScene();
		setupConfig();
	}

	/* (non-Javadoc)
	 * @see application.components.pageobjects.windows.BasicWindow#setupConfig()
	 */
	@Override
	public void setupConfig() {
		window.initModality(Modality.APPLICATION_MODAL);
		window.setResizable(false);
		window.showAndWait();
	}
	
	/* (non-Javadoc)
	 * @see application.components.pageobjects.windows.BasicWindow#setupScene()
	 */
	@Override
	public void setupScene() {
		
		Label label = new Label(this.getLabel());
		HBox topHorizontalBox = new HBox();
		topHorizontalBox.getChildren().add(label);
		topHorizontalBox.setAlignment(Pos.CENTER);
		
		Button yesButton = new Button(YES_BUTTON_TEXT);
		yesButton.setPrefWidth(50);
		yesButton.setOnAction(e -> {
			System.out.println("Closing Program...");
			e.consume();
			close(true);
		});
		Button noButton = new Button(NO_BUTTON_TEXT);
		noButton.setPrefWidth(50);
		noButton.setOnAction(e -> {
			System.out.println("Returning to Main Page...");
			e.consume();
			close(false);
		});
		HBox bottomHorizontalBox = new HBox();
		bottomHorizontalBox.getChildren().addAll(yesButton, noButton);
		bottomHorizontalBox.setSpacing(20);
		bottomHorizontalBox.setAlignment(Pos.CENTER);
		
		
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(20);
		vBox.getChildren().addAll(topHorizontalBox, bottomHorizontalBox);
		vBox.setStyle(Theme.CSS_STYLE_CLOSE_DIALOG_BACKGROUND);
		
		StackPane pane = new StackPane();
		pane.setPadding(Theme.CSS_CONTENT_INSETS);
		pane.setStyle(Theme.CSS_STYLE_APPLICATION_BACKGROUND);
		pane.getChildren().add(vBox);
		
		Scene scene = new Scene(pane);
		window.setScene(scene);
	}

	/**
	 * Close.
	 *
	 * @param answer the answer
	 */
	private void close(boolean answer) {
		
		if (answer) {
			window.close();
			if (this.caller != null) {
				this.caller.close();
			}
		} else {
			window.close();
		}
	}

	/**
	 * Gets the caller.
	 *
	 * @return the caller
	 */
	public Stage getCaller() {
		return caller;
	}

	/**
	 * Sets the caller.
	 *
	 * @param caller the new caller
	 */
	public void setCaller(Stage caller) {
		this.caller = caller;
	}

}
