package week4.lab4.exercise3.clientapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represent the window for the client side TCP application.
 * It display the word count of a text from the server.
 * 
 * @author haziqhapiz
 *
 */
public class ClientTextFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	// Private frame components
	private JLabel lblServerWordCounter;
	private JLabel lblStatusValue;

	// Private attributes for frame size
	private int width = 700;
	private int height = 200;

	private String text;
	private int count;

	/**
	 * The constructor that initialize and organize the Swing components on
	 * the frame.
	 */
	public ClientTextFrame() {

		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side");
		this.setSize(width, height);

		// Center the frame on the screen
		this.setLocationRelativeTo(null);

		// Initialize default value for label
		lblServerWordCounter = new JLabel("-");
		lblStatusValue = new JLabel("-");

		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Organize components
		loadComponent();

	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	/**
	 * This method update the value of count on the frame
	 * 
	 * @param count: Count of the word in the text
	 */
	public void updateCount(int count) {
		this.lblServerWordCounter.setText("" + count);
	}

	/**
	 * This method set the value of count on the frame
	 * 
	 * @param count: Count of the word in the text
	 */
	public void setCount(int count) {
		this.count = count;
		updateCount(count);
	}

	/**
	 * This method update the status of connection to the server.
	 * 
	 * @param connStatus: Connection status (true/false)
	 */
	public void updateConnectionStatus(boolean connStatus) {

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";

		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";

		// Update the status on frame
		this.lblStatusValue.setText(status);
	}

	/**
	 * This method creates and arrange Swing components to display status of
	 * client's connection to the server.
	 * 
	 * @param font
	 * @return Swing components organized in a panel.
	 */
	private JPanel getConnectionStatusPanel(Font font) {

		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel("Connection status: ");

		// Style the component
		lblConnStatus.setFont(font);
		lblStatusValue.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);

		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);

		return panel;

	}

	/**
	 * This method creates and arrange Swing components to date retrieve from
	 * the server.
	 *
	 * @param font
	 * @return Swing components organized in panel
	 */
	private JPanel getServerWordCountPanel(Font font) {

		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblDate = new JLabel("The word count: ");

		// Style the component
		lblDate.setFont(font);
		lblServerWordCounter.setFont(font);
		lblDate.setBackground(Color.WHITE);
		lblDate.setOpaque(true);
		lblServerWordCounter.setBackground(Color.WHITE);
		lblServerWordCounter.setOpaque(true);

		// Organize components into panel
		panel.add(lblDate);
		panel.add(lblServerWordCounter);

		return panel;
	}

	/**
	 * This method arrange the Swing components on the frame.
	 */
	private void loadComponent() {

		// Get font
		Font font = this.getFontStyle();

		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);
		this.add(northPanel, BorderLayout.NORTH);

		// Get server date's panel and add to frame
		JPanel center = getServerWordCountPanel(font);
		this.add(center, BorderLayout.CENTER);

	}

	/**
	 * This method define a font to a generic style.
	 * 
	 * @return font object
	 */
	private Font getFontStyle() {

		Font font = new Font("Serif", Font.PLAIN, 30);

		return font;

	}

}
