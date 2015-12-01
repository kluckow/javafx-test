package application.components.pageobjects.windows.main;


import application.components.pageobjects.windows.BasicWindow;
import application.components.pageobjects.windows.general.CloseDialogWindow;
import application.components.pageobjects.windows.general.NotificationWindow;
import application.components.theme.Theme;
import javafx.geometry.Insets;
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
import javafx.scene.layout.VBox;

public class MainWindowOld extends BasicWindow {

	private static final String TITLE = "Main";
	
	private static final int WIDTH_MAIN_WINDOW = 800;
	
	private static final int HEIGHT_MAIN_WINDOW = 600;
	
	private Scene scene;
	
	private MenuBar menubar;
	
	public MainWindowOld() {
		super(TITLE, WIDTH_MAIN_WINDOW, HEIGHT_MAIN_WINDOW);
		setupScene();
		setupConfig();
		window.show();
	}

	@Override
	public void setupConfig() {
		window.setResizable(true);
		window.setOnCloseRequest(e -> {
			e.consume();
			new CloseDialogWindow(window);
		});		
	}
	
	@Override
	public void setupScene() {
		this.scene = getMainScene();
		window.setScene(this.scene);
	}
	
	private Scene getMainScene() {
		
		// main layout, containing everything
		// mainLayout
		VBox mainLayout = new VBox();
		mainLayout.prefWidthProperty().bind(window.widthProperty());
		
		// menubarLayout
		HBox menubarLayout = new HBox();
		menubarLayout.prefWidthProperty().bind(mainLayout.widthProperty());
		
		// File menu
		Menu fileMenu = new Menu("_File");
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a new file..."));
		fileMenu.getItems().add(newFile);
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit..."));
		
		// Edit menu
		Menu editMenu = new Menu("_Edit");
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		MenuItem paste = new MenuItem("Paste");
		paste.setOnAction(e -> System.out.println("Pasting some crap"));
		paste.setDisable(true);
		editMenu.getItems().add(paste);
		
		// Main menu bar
		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(fileMenu, editMenu);
		
		menubar.prefWidthProperty().bind(menubarLayout.widthProperty());
		
		menubarLayout.getChildren().add(menubar);
		
		// toolbar right below main menubar
		// toolbarLayout
		HBox toolbarLayout = new HBox();
		toolbarLayout.prefWidthProperty().bind(mainLayout.widthProperty());
		
		// containing all the content, except menubar and toolbar
		// contentLayout
		HBox contentLayout = new HBox();
		contentLayout.setPadding(new Insets(5, 5, 5, 5));
		contentLayout.prefWidthProperty().bind(window.widthProperty());
		contentLayout.prefHeightProperty().bind(window.heightProperty().subtract(toolbarLayout.getHeight()));;
		
		ToolBar toolbar = new ToolBar();
		toolbar.prefWidthProperty().bind(mainLayout.widthProperty());
		
		// Does not HAVE to be a grid pane, but good for layouting
		GridPane grid = new GridPane();
		grid.prefWidthProperty().bind(mainLayout.widthProperty());
		
		Button btn1 = new Button("Call a notification window");
		btn1.setOnAction(e -> new NotificationWindow("Notification title", "You clicked a button that calls a notification window!"));
		Button btn2 = new Button("Go to Second Scene");
		btn2.setOnAction(e -> updateScene(getSecondScene()) );
		toolbar.getItems().addAll(btn1, btn2);
		toolbarLayout.getChildren().add(toolbar);
		
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setStyle(Theme.CSS_STYLE_APPLICATION_BACKGROUND);
		
		// TODO: create some form
		Label label = new Label("Now we are on the main scene!");
		grid.add(label, 0, 0);
		
		contentLayout.getChildren().add(grid);
		mainLayout.getChildren().addAll(menubarLayout, toolbarLayout, contentLayout);
		
		return new Scene(mainLayout);
	}
	private Scene getSecondScene() {
		
		// TODO: maybe put those VBox, that contains both HBoxes into the main app window setup
		// in order to reduce lines of code for setting up another scene
		VBox verticalLayout = new VBox();
		verticalLayout.prefWidthProperty().bind(window.widthProperty());
		
		HBox toolbarLayout = new HBox();
		toolbarLayout.prefWidthProperty().bind(window.widthProperty());
		
		HBox parentGridLayout = new HBox();
		parentGridLayout.setPadding(new Insets(10, 10, 10, 10));
		parentGridLayout.prefWidthProperty().bind(window.widthProperty());
		parentGridLayout.prefHeightProperty().bind(window.heightProperty().subtract(toolbarLayout.getHeight()));;
		
		ToolBar toolbar = new ToolBar();
		toolbar.prefWidthProperty().bind(window.widthProperty());
		
		Button btn1 = new Button("Call a notification window");
		btn1.setOnAction(e -> new NotificationWindow("Notification title", "You clicked a button that calls a notification window!"));
		Button btn2 = new Button("Go to Main Scene");
		btn2.setOnAction(e -> updateScene(getMainScene()) );
		toolbar.getItems().addAll(btn1, btn2);
		toolbarLayout.getChildren().add(toolbar);
		
		GridPane grid = new GridPane();
		grid.prefWidthProperty().bind(window.widthProperty());
		
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setStyle(Theme.CSS_STYLE_CONTENT_BACKGROUND);
		
		// TODO: create some form
		Label label = new Label("Now we are on the second scene!");
		grid.add(label, 0, 0);
		
		
		parentGridLayout.getChildren().add(grid);
		verticalLayout.getChildren().addAll(toolbarLayout, parentGridLayout);
		
		return new Scene(verticalLayout);
	}

	public MenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(MenuBar menubar) {
		this.menubar = menubar;
	}

}
