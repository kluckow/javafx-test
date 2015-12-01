package application.components.pageobjects.windows;

import application.components.pageobjects.windows.configuration.WindowConfiguration;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BasicWindow implements WindowConfiguration {

	protected Stage window;
	
	private static final String APPLICATION_TITLE = "My Application";
	
	public BasicWindow(String title, double width, double height) {
		window = new Stage();
		window.setTitle(APPLICATION_TITLE + " - " + title);
		window.setWidth(width);
		window.setHeight(height);
	}
	
	public void terminate() {
		window.close();
	}
	public Stage getStage() {
		return window;
	}
	public void updateScene(Scene scene) {
		window.setScene(scene);
	}
	public void setTitle(String title) {
		window.setTitle(title);
	}
	public void setWidth(double width) {
		window.setWidth(width);
	}
	public void setHeight(double height) {
		window.setHeight(height);
	}

}
