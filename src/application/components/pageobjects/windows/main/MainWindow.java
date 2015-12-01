package application.components.pageobjects.windows.main;

import application.components.pageobjects.windows.BasicWindow;
import application.components.pageobjects.windows.general.CloseDialogWindow;
import application.components.pageobjects.windows.general.NotificationWindow;
import application.components.theme.Theme;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainWindow extends BasicWindow {

	private static final String TITLE = "Main";
	
	private static final int WIDTH_MAIN_WINDOW = 1024;
	
	private static final int HEIGHT_MAIN_WINDOW = 768;
	
	private Scene scene;
	
	private VBox mainVLayout;
	
	private HBox menubarHLayout;
	private MenuBar menubar;
	private Menu fileMenu;
	private Menu editMenu;
	
	private HBox toolbarHLayout;
	private ToolBar toolbar;
	
	private StackPane contentLayout;
	private GridPane contentGridLayout;
	
	
	public MainWindow() {
		super(TITLE, WIDTH_MAIN_WINDOW, HEIGHT_MAIN_WINDOW);
		setupScene();
		setupConfig();
		window.show();
	}
	
	@Override
	public void setupScene() {
		setupMainLayout();
		setupMenubar();
		setupToolbar();
		setupContent();
		finalizeScene();
		window.setScene(this.scene);
	}
	
	@Override
	public void setupConfig() {
		window.setResizable(true);
		window.setOnCloseRequest(e -> {
			e.consume();
			new CloseDialogWindow(window);
		});		
	}

	private void setupMainLayout() {
		this.mainVLayout = new VBox();
		this.mainVLayout.prefWidthProperty().bind(window.widthProperty());		
		this.mainVLayout.setStyle(Theme.CSS_STYLE_APPLICATION_BACKGROUND);
	}
	
	private void setupMenubar() {
		this.menubarHLayout = new HBox();
		this.menubarHLayout.prefWidthProperty().bind(this.mainVLayout.widthProperty());
		
		fileMenu = new Menu("_File");
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a new file..."));
		fileMenu.getItems().add(newFile);
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit..."));
		
		editMenu = new Menu("_Edit");
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		MenuItem paste = new MenuItem("Paste");
		paste.setOnAction(e -> System.out.println("Pasting some crap"));
		paste.setDisable(true);
		editMenu.getItems().add(paste);
		
		// Main menu bar
		this.menubar = new MenuBar();
		this.menubar.getMenus().addAll(fileMenu, editMenu);
		this.menubar.prefWidthProperty().bind(this.menubarHLayout.widthProperty());
		this.menubarHLayout.getChildren().add(this.menubar);
	}

	private void setupToolbar() {
		this.toolbarHLayout = new HBox();
		this.toolbarHLayout.prefWidthProperty().bind(this.mainVLayout.widthProperty());
		this.toolbar = new ToolBar();
		this.toolbar.prefWidthProperty().bind(this.toolbarHLayout.widthProperty());
		Button btn1 = new Button("Call a notification window");
		btn1.setOnAction(e -> new NotificationWindow("Notification title", "You clicked a button that calls a notification window!"));
		Button btn2 = new Button("TODO: Switch between scenes");
//		btn2.setOnAction(e -> updateScene(getMainScene()) );
		this.toolbar.getItems().addAll(btn1, btn2);
		this.toolbarHLayout.getChildren().add(toolbar);
	}

	private void setupContent() {
		this.contentLayout = new StackPane();
		this.contentLayout.setStyle(Theme.CSS_STYLE_APPLICATION_BACKGROUND);
		this.contentLayout.prefHeightProperty().bind(this.mainVLayout.heightProperty());
		this.contentLayout.setPadding(Theme.CSS_CONTENT_INSETS);
		
		this.contentGridLayout = new GridPane();
		this.contentGridLayout.prefWidthProperty().bind(this.contentLayout.widthProperty());
		this.contentGridLayout.prefHeightProperty().bind(this.contentLayout.heightProperty());
		this.contentGridLayout.setPadding(Theme.CSS_CONTENT_INSETS);
		this.contentGridLayout.setStyle(Theme.CSS_STYLE_CONTENT_BACKGROUND);
		
		// TODO: create some form
		Label label = new Label("Now we are on the main scene!");
		this.contentGridLayout.add(label, 0, 0);
		this.contentLayout.getChildren().add(contentGridLayout);
	}
	
	private void finalizeScene() {
		this.mainVLayout.getChildren().addAll(this.menubarHLayout, this.toolbarHLayout, this.contentLayout);
		this.scene = new Scene(this.mainVLayout);
	}
	
}
