package application.components.pageobjects.windows;

public abstract class ConfirmDialogWindow extends BasicWindow {

	private static final int WIDTH_CONFIRM_DIALOG = 400;
	
	private static final int HEIGHT_CONFIRM_DIALOG = 200;
	
	private String label;
	
	public ConfirmDialogWindow(String title, String label) {
		super(title, WIDTH_CONFIRM_DIALOG, HEIGHT_CONFIRM_DIALOG);
		this.setLabel(label);
	}

	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
