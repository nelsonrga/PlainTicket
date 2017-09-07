import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
public class events extends JFrame
{
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JButton button1;
	private JButton button2;
	private JButton exitButton;
	private JButton restartButton;
	private JTextArea TextWindow;
	private int x = 0, y = 0;
	private static int[] seats = new int[12];
	private int seatnumber;
	private Icon image1;
	private JLabel image1Label;
	private Icon image2;
	private JLabel image2Label;
	private int seatCount1 = 0;
	private int seatCount2 = 6;


	public events ()
	{
	  setLayout(new FlowLayout());

	for (int i = 0; i < 12; i++) {
			seats[i] = 0;

		}


	button1 = new JButton ("Click for window seat");
	add(button1);

	label1 = new JLabel ("");
	add(label1);

	button2 = new JButton ("Click for aisle seat");
	add(button2);

	label2 = new JLabel ("");
	add(label2);

	exitButton = new JButton ("Click to exit");
	add(exitButton);

	label3 = new JLabel ("");
	add(label3);

	restartButton = new JButton("Clear");
	add(restartButton);

	image1 = new ImageIcon(getClass().getResource("boardingPassWindow.png"));

	image2 = new ImageIcon(getClass().getResource("boardingPassAisle.png"));

		image1Label = new JLabel(image1);
	add(image1Label);

		image2Label = new JLabel(image2);
	add(image2Label);


	image1Label.setVisible(false);
	image2Label.setVisible(false);


	event e = new event();
	button1.addActionListener(e);
	button2.addActionListener(e);

	event3 e3 = new event3();
	exitButton.addActionListener(e3);

	restartButton.addActionListener(e);


	TextWindow = new JTextArea (15,25);
	add(TextWindow);

	}

	public class event implements ActionListener {

	public void actionPerformed(ActionEvent e) {

	if (e.getSource() == restartButton)
	{
		label1.setText("");
		label2.setText("");
		TextWindow.setText("");
		image1Label.setVisible(false);
		image2Label.setVisible(false);
	}

	if (e.getSource() == button1)
		{
			image1Label.setVisible(true);
			label2.setText("");
			image2Label.setVisible(false);

			if(seatCount1 == 5){
				TextWindow.setText("Sorry, there are no window seats available"+ "\n" + "Please try booking aisle seats");
			}
			else{


			for (int i = 1; i  <= 5; i++) {

			if(seats[i] == 0)
			{
				seatnumber = i;
				seatCount1++;
			System.out.println("Seat: " + i);
				seats [i] = 1;
				break;

			}
		}
		label1.setText("Window seat was selected"); // this is what the button does
		Date timenow = new Date();
		TextWindow.setText("Date Booked: " + timenow + "\n");
		TextWindow.append("Boarding pass for seat number: " + seatnumber + "A" + "\n" +
		"Present your booking ticket to the front counter in the airport." + "\n" +
		"Thank you for choosing NG Airlines! Enjoy your trip.");
		}
	}
		if (e.getSource() == button2)
				{

				image2Label.setVisible(true);
				label1.setText("");
				image1Label.setVisible(false);

				if(seatCount2 == 12){
				TextWindow.setText("Sorry, there are no aisle seats available" + "\n" + "Please try booking window seats");
			}
			else{

					for (int i = 6; i  <= 12; i++) {

					if(seats[i] == 0)
					{
						seatnumber = i;
						seatCount2++;
					System.out.println("Seat: " + i);
						seats [i] = 1;
						break;

					}
				}


				label2.setText("Aisle seat was selected"); // this is what the button does
				Date timenow = new Date();
				TextWindow.setText("Date Booked: " + timenow + "\n");
				TextWindow.append("Boarding pass for seat number: " + seatnumber + "B" + "\n" +
				"Present your reservation ticket to the front counter in the airport." + "\n" +
				"Thank you for choosing NG Airlines! Enjoy your trip.");
			}
		}
	}
	}

	public class event2 implements ActionListener{

		public void actionPerformed(ActionEvent e2){
			if (y == 0) {

		label2.setText("Aisle seat was selected");
		Date timenow = new Date();
		TextWindow.setText("Date Booked: " + timenow + "\n");
		TextWindow.append("Boarding pass for seat number: " + seatnumber + "B" + "\n" +
		"Present your reservation ticket to the front counter in the airport." + "\n" +
		"Thank you for choosing NG Airlines! Enjoy your trip.");
		y = 1;
		} else if (y == 1) {
			label2.setText("");
			y = 0;
		}
	}
}

	public class event3 implements ActionListener{

		public void actionPerformed(ActionEvent e3){
		System.exit(0);

	}
}


	public static void main(String[] args)
	{
		events gui = new events();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(700, 700);
		gui.setVisible(true);
		gui.setTitle("Ticket Reservation");

	}
}