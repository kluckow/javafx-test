package application.components.pageobjects.windows;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Class BasicWindow.
 */
public abstract class BasicWindow {

	/** The window. */
	protected Stage window;
	
	/** The Constant APPLICATION_TITLE. */
	private static final String APPLICATION_TITLE = "My Application";
	
	/**
	 * Instantiates a new basic window.
	 *
	 * @param title the title
	 * @param width the width
	 * @param height the height
	 */
	public BasicWindow(String title, double width, double height) {
		window = new Stage();
		window.setTitle(APPLICATION_TITLE + " - " + title);
		window.setWidth(width);
		window.setHeight(height);
	}
	
	/**
	 * Setup config.
	 */
	public abstract void setupConfig();
	
	/**
	 * Setup scene.
	 */
	public abstract void setupScene();
	
	/**
	 * Terminate.
	 */
	public void terminate() {
		window.close();
	}
	
	/**
	 * Gets the stage.
	 *
	 * @return the stage
	 */
	public Stage getStage() {
		return window;
	}
	
	/**
	 * Update scene.
	 *
	 * @param scene the scene
	 */
	public void updateScene(Scene scene) {
		window.setScene(scene);
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		window.setTitle(title);
	}
	
	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(double width) {
		window.setWidth(width);
	}
	
	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(double height) {
		window.setHeight(height);
	}

}
