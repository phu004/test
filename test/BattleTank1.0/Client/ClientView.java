

import javax.swing.*;
import java.awt.*;

//this class represents the graphic interface of the server
public class ClientView extends JFrame{
	public drawingPanel mainPanel;
	public JButton sendMessage, connectServer, exit, pauseAndResume, help;
	public JTextField messageField, IPfield;
	public JLabel enterIP;
	public Image offScreenImage;

	public ClientControler controler;
	public ClientModel model;


	public ClientView(){
		super("Battle Tank");

		getContentPane().setLayout(null);

		//make main panel where the animation will be drawn
		mainPanel = new drawingPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,  22, 679, 605);
		mainPanel.setBackground(new Color(128, 64, 0));

		messageField = new JTextField();
		messageField.setBounds(0,519, 560,22);
		messageField.setEnabled(false);
		sendMessage = new JButton("Send");
		sendMessage.setBounds(570,518, 62,24);
		sendMessage.setFocusable(false);
		mainPanel.add(messageField);
		mainPanel.add(sendMessage);
		getContentPane().add(mainPanel);
		mainPanel.setFocusable(true);

		//make option buttons and IP text field
		enterIP = new JLabel("Enter IP");
		enterIP.setBounds(10, 0,60,22);
		getContentPane().add(enterIP);

		IPfield = new JTextField();
		IPfield.setBounds(65, 0,90,22);
		getContentPane().add(IPfield);

		connectServer = new JButton("Connect server");
		connectServer.setBounds(160, 0,100,22);
		getContentPane().add(connectServer);
		connectServer.setFocusable(false);

		pauseAndResume = new JButton("Pause/Resume");
		pauseAndResume.setBounds(260, 0,100,22);
		getContentPane().add(pauseAndResume);
		pauseAndResume.setFocusable(false);

		help = new JButton("Help");
		help.setBounds(360, 0,100,22);
		getContentPane().add(help);
		help.setFocusable(false);

		exit = new JButton("Exit");
		exit.setBounds(460, 0,100,22);
		getContentPane().add(exit);
		exit.setFocusable(false);

		//setup the mian frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 130, 640, 590);
    	setVisible(true);
    	setResizable( false );

		//setup client model
		model = new ClientModel(this);

		//setup client controller
		controler = new ClientControler(this, model);
	}

	public static void main(String[] args){
		new ClientView();
	}

}