package application.components.pageobjects.windows;

/**
 * The Class ConfirmDialogWindow.
 */
public abstract class ConfirmDialogWindow extends BasicWindow {

	/** The Constant WIDTH_CONFIRM_DIALOG. */
	private static final int WIDTH_CONFIRM_DIALOG = 400;
	
	/** The Constant HEIGHT_CONFIRM_DIALOG. */
	private static final int HEIGHT_CONFIRM_DIALOG = 200;
	
	/** The label. */
	private String label;
	
	/**
	 * Instantiates a new confirm dialog window.
	 *
	 * @param title the title
	 * @param label the label
	 */
	public ConfirmDialogWindow(String title, String label) {
		super(title, WIDTH_CONFIRM_DIALOG, HEIGHT_CONFIRM_DIALOG);
		this.setLabel(label);
	}

	
	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}
