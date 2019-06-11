import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainScreenGUI extends JFrame
{
	private JPanel jpanel = new JPanel(); // MainScreen user interface
	private JLabel Millionaireimage = new JLabel(); // Main picture
	private JButton playbutn = new JButton(); // Start game button
	private JButton exitbutn = new JButton(); // Exit game button
	public static Clip clip;
	private static URL sound = (MainScreenGUI.class.getResource("Music/intro.wav")); // Getting the sound url from music folder

	
	private BufferedImage card;
	public void setCard(BufferedImage card) throws IOException {
		this.card =resize(card,325,340);
	}

	private BufferedImage resize(BufferedImage img, int i, int j) {
		 Image tmp = img.getScaledInstance(j, i, Image.SCALE_SMOOTH);
	        BufferedImage resized = new BufferedImage(j, i, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = resized.createGraphics();
	        g2d.drawImage(tmp, 0, 0, null);
	        g2d.dispose();
	        return resized;
	}
	
	public MainScreenGUI() throws IOException
	{
		setCard(ImageIO.read(new File("C:\\Users\\WIKI\\eclipse-workspace\\quizgame\\src\\Image\\Millionaire logo.png")));
		setTitle("Millionaire"); // Set panel title to Millionaire
		setVisible(true); // Showing the created screen after it has been created
		setSize(600,800);// Size of the page (width and height)

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Adding the close and minimize button to the window 
		
		jpanel.setLayout(null); // Setting the layout to absolute
        jpanel.setBackground(Color.gray); // J panel uses and sets the background to a gray color
		
		Millionaireimage.setIcon(new ImageIcon(this.getCard()));
		// Getting the millionaire image from the image folder and using it in the j panel
		Millionaireimage.setBounds(135,25,340,340); //Using set bounds, i can position the the picture where i wanted
		jpanel.add(Millionaireimage); // This adds the zillionaire image to the j panel
		
		add(jpanel); // Adds the j panel to the j frame
		
		playbutn.setText("Play"); // Sets the button text to the String
		playbutn.setFont(new Font("Dialog", 1,30)); // Setting fonts and sizes on the button
		playbutn.setBounds(134,355,342,100); // X,Y,Width,Height
		jpanel.add(playbutn); // Adding play button into the j panel
		
		playbutn.addActionListener (new ActionListener() // Adding action to the button so the play button performs a action
		{
			public void actionPerformed (ActionEvent evt) // Perform the following actions
			{
				NumberOfPlayers Numberofplayersdialog = new NumberOfPlayers(); // Setting the name dialog to the number of players screen 
				dispose(); // Close the current J panel
				Numberofplayersdialog.setVisible(true); // Open the number of players screen 
				//clip.stop(); // Sttop the music from player when you click the play button
			
			}
		}); // This main menu screen will close when the user clicks on the play button and the next page will show
		
		exitbutn.setText("Exit"); // Sets the button text to the String
		exitbutn.setFont(new Font("Dialog", 1,30)); // Setting fonts and sizes on the button
		exitbutn.setBounds(134,480,342,100); // X,Y,Width,Height
		
		
		exitbutn.addActionListener(new ActionListener() //Using exit button to create new action listener 
		{ 
		     public void actionPerformed(ActionEvent e)
		     {
		         jButtonClose();// Call another method in the same class which will close this J frame
		    }
		});

		jpanel.add(exitbutn); // Adding play button into the j panel
		
		validate(); // Validates the image before putting on to the JPanel
	}

	public BufferedImage getCard() {
		return card;
	}

	public static void sound (URL sound) // Method for zillionaire sound
	{
		try 
		{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start(); // Play the music
			clip.loop(999999999); // Looping the music until it reaches the given number
		}
		
		catch (Exception excep)
		{
			excep.printStackTrace(System.out);
		}
}
		
		public static void main (String[]args) // This is the method to set a new main screen
									   // Only the main screen will have this method
			{
				try {
					MainScreenGUI M = new MainScreenGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sound(sound);
				
				}	

			public void jButtonClose() // When the exit button is clicked/called, it will activate this method
				{						   
					this.dispose(); // Closes the main screen 
	                clip.stop(); // Stopping the music when the you click the cloes button
				}
			
			
	
}

