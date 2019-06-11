import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class WonScreen extends JFrame
{
	private JPanel millionaireScreen = new JPanel(new BorderLayout());// Creating j panel called millionaire screen
	private JPanel congrat = new JPanel(new BorderLayout());//group jbutton
	private JPanel button = new JPanel(new FlowLayout());//group jbutton
	private JPanel cgr = new JPanel(new FlowLayout());
	private JPanel cgr2 = new JPanel(new FlowLayout());
	private JLabel congratText = new JLabel();// Creating j label to congratulate the winner
	private JLabel congratImage = new JLabel();
	private JButton exitbutn = new JButton(); // Creating a button to close the screen 
	private JButton nextPlayer = new JButton(); // Setting next player 2 turn
	private MainScreenGUI main; // Getting informations (objects) from the main class GUI
	private SelectCategoryScreen selectCatScrn ;
	private BufferedImage card;

	public BufferedImage getCard() {
		return card;
	}

	public void setCard(BufferedImage card) throws IOException {
		this.card =resize(card,700,500);
	}

	private BufferedImage resize(BufferedImage img, int i, int j) {
		 Image tmp = img.getScaledInstance(j, i, Image.SCALE_SMOOTH);
	        BufferedImage resized = new BufferedImage(j, i, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = resized.createGraphics();
	        g2d.drawImage(tmp, 0, 0, null);
	        g2d.dispose();
	        return resized;
	}
	
	
	public WonScreen()
	{	
		selectCatScrn =  new SelectCategoryScreen();
		try {
			setCard(ImageIO.read(new File("C:\\Users\\WIKI\\eclipse-workspace\\quizgame\\src\\Image\\won.jpg")));
			main = new MainScreenGUI();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Create new main screen gui called main 
		main.setVisible(false); // Setting the screen's visibility to false
		
		setTitle("Millionaire"); // Set screen title millionaire
		setSize(1024,720);// Size of the page (width and height)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Adding the close and minimize button to the window
		//millionaireScreen.setLayout(null); //Adding layout to the j panel
	
		millionaireScreen.setBackground(Color.gray); // Setting back ground color to gray
		add(millionaireScreen); // Add millionaire screen to the j frame
		
		
		// Congratulation text 
		
		congratText.setText(NumberOfPlayers.P1+" Well Done !!! You have just became a Millionaire"); // Text to be display as a j label
		congratText.setFont(new Font("Dialog", 1,24)); // Setting font and text size
		congratText.setBounds(70,150,900,150); // Setting location for this j label X,Y,Width,Height
		cgr.add(congratText); 
		congrat.add(cgr,BorderLayout.NORTH) ;// Adding this j label to the panel
		
		//End of congratulation text 
		congratImage.setIcon(new ImageIcon(this.getCard()));
		cgr2.add(congratImage); 
		//congratImage.setBounds(470,300 ,700, 500);
		congrat.add(cgr2,BorderLayout.CENTER);
		millionaireScreen.add(this.congrat,BorderLayout.CENTER);
		
		// Exit button

		exitbutn.setText("Exit"); // Set text for button
		exitbutn.setFont(new Font("Dialog", 1,30)); // Set font and text sizes
		exitbutn.setBounds(500,250,200,100); // Set button location X,Y,Width,Height
		
		exitbutn.addActionListener(new ActionListener() // Adding action listener to my exit button
		{
		     public void actionPerformed(ActionEvent e) // Add actions that it will need to perform
		     { 
		        jButtonClose(); // This method will be ran when button is clicked
		     }
		});
		
		button.add(exitbutn);// Adding exit button to millionaire screen
	

		//End of exit button
	
	
	// Player 2 start button
	
	nextPlayer.setText("Play Again"); // Set text for button
	nextPlayer.setFont(new Font("Dialog", 1,30)); // Set font and text sizes
	nextPlayer.setBounds(70,250,350,100); // Set button location X,Y,Width,Height
	button.add(nextPlayer); 
	nextPlayer.addActionListener(new ActionListener() // Adding action listener to my exit button
	{
	     public void actionPerformed(ActionEvent e) // Add actions that it will need to perform
	     { 
	    	 dispose(); 
	    	 selectCatScrn.setVisible(true); 
	     }
	});
	
	
	
	this.millionaireScreen.add(button,BorderLayout.SOUTH);
	millionaireScreen.setBackground(Color.gray); // Setting back ground color to gray
}

	// End of Player 2 start button
	
	private void jButtonClose() // Exit button method
		{
			this.dispose(); // Closes the WonScreen
			main.setVisible(true); // Opens main page by setting it to visible
		}
			
				
}

	
