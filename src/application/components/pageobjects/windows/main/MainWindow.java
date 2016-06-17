package application.components.pageobjects.windows.main;

import application.components.pageobjects.windows.BasicWindow;
import application.components.pageobjects.windows.general.CloseDialogWindow;
import application.components.pageobjects.windows.general.NotificationWindow;
import application.components.theme.Theme;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * The Class MainWindow.
 */
public class MainWindow extends BasicWindow {

	/** The Constant TITLE. */
	private static final String TITLE = "Main";
	
	/** The Constant WIDTH_MAIN_WINDOW. */
	private static final int WIDTH_MAIN_WINDOW = 1024;
	
	/** The Constant HEIGHT_MAIN_WINDOW. */
	private static final int HEIGHT_MAIN_WINDOW = 768;
	
	/** The scene. */
	private Scene scene;
	
	/** The main v layout. */
	private VBox mainVLayout;
	
	/** The menubar h layout. */
	private HBox menubarHLayout;
	
	/** The menubar. */
	private MenuBar menubar;
	
	/** The file menu. */
	private Menu fileMenu;
	
	/** The edit menu. */
	private Menu editMenu;
	
	/** The toolbar h layout. */
	private HBox toolbarHLayout;
	
	/** The toolbar. */
	private ToolBar toolbar;
	
	/** The content layout. */
	private StackPane contentLayout;
	
	/** The content grid layout. */
	private GridPane contentGridLayout;
	
	
	/**
	 * Instantiates a new main window.
	 */
	public MainWindow() {
		super(TITLE, WIDTH_MAIN_WINDOW, HEIGHT_MAIN_WINDOW);
		setupScene();
		setupConfig();
		window.show();
	}
	
	/* (non-Javadoc)
	 * @see application.components.pageobjects.windows.BasicWindow#setupScene()
	 */
	@Override
	public void setupScene() {
		setupMainLayout();
		setupMenubar();
		setupToolbar();
		setupContent();
		finalizeScene();
		window.setScene(this.scene);
	}
	
	/* (non-Javadoc)
	 * @see application.components.pageobjects.windows.BasicWindow#setupConfig()
	 */
	@Override
	public void setupConfig() {
		window.setResizable(true);
		window.setOnCloseRequest(e -> {
			e.consume();
			new CloseDialogWindow(window);
		});		
	}

	/**
	 * Setup main layout.
	 */
	private void setupMainLayout() {
		this.mainVLayout = new VBox();
		this.mainVLayout.prefWidthProperty().bind(window.widthProperty());		
		this.mainVLayout.setStyle(Theme.CSS_STYLE_APPLICATION_BACKGROUND);
	}
	
	/**
	 * Setup menubar.
	 */
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

	/**
	 * Setup toolbar.
	 */
	private void setupToolbar() {
		this.toolbarHLayout = new HBox();
		this.toolbarHLayout.prefWidthProperty().bind(this.mainVLayout.widthProperty());
		this.toolbar = new ToolBar();
		this.toolbar.prefWidthProperty().bind(this.toolbarHLayout.widthProperty());
		Button btn1 = new Button("Call a notification window");
		btn1.setOnAction(e -> new NotificationWindow("Notification title", "You clicked a button that calls a notification window!"));
		Button btn2 = new Button("Call a close dialog window");
		btn2.setOnAction(e -> new CloseDialogWindow(window) );
		Button btn3 = new Button("Change Background");
		btn3.setOnAction(e -> this.contentLayout.setStyle(Theme.CSS_STYLE_NOTIFICATION_BACKGROUND));
		this.toolbar.getItems().addAll(btn1, btn2, btn3);
		this.toolbarHLayout.getChildren().add(toolbar);
	}

	/**
	 * Setup content.
	 */
	private void setupContent() {
		this.contentLayout = new StackPane();
		this.contentLayout.setStyle(Theme.CSS_STYLE_APPLICATION_BACKGROUND);
		this.contentLayout.prefHeightProperty().bind(this.mainVLayout.heightProperty());
		this.contentLayout.setPadding(Theme.CSS_CONTENT_INSETS);
		
//		this.contentGridLayout = new GridPane();
//		this.contentGridLayout.prefWidthProperty().bind(this.contentLayout.widthProperty());
//		this.contentGridLayout.prefHeightProperty().bind(this.contentLayout.heightProperty());
//		this.contentGridLayout.setPadding(Theme.CSS_CONTENT_INSETS);
//		this.contentGridLayout.setStyle(Theme.CSS_STYLE_CONTENT_BACKGROUND);
		
		// TODO: create some form
		
		HBox usernameLayout = new HBox();
		usernameLayout.setAlignment(Pos.CENTER_LEFT);
		
		Label usernameLabel = new Label("Username:");
		usernameLabel.setPrefWidth(80);
		usernameLayout.getChildren().add(usernameLabel);
		
		TextField usernameInput = new TextField();
		usernameInput.setPrefWidth(150);
		usernameLayout.getChildren().add(usernameInput);
		
		VBox formLayout = new VBox();
		formLayout.setPadding(Theme.CSS_CONTENT_INSETS);
		formLayout.setStyle(Theme.CSS_STYLE_CONTENT_BACKGROUND);
		formLayout.getChildren().add(usernameLayout);
		
		this.contentLayout.getChildren().add(formLayout);
	}
	
	/**
	 * Finalize scene.
	 */
	private void finalizeScene() {
		this.mainVLayout.getChildren().addAll(this.menubarHLayout, this.toolbarHLayout, this.contentLayout);
		this.scene = new Scene(this.mainVLayout);
	}
	
}
