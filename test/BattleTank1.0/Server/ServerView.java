//	battle tank 1.0 server
//	author£ºphu004
//	description: freeware

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//this class represents the graphic interface of the server
public class ServerView extends JFrame{
	public drawingPanel mainPanel;
	public JButton createServer, exit, pauseAndResume, help;
	public JTextField messageField;
	public JButton sendMessage;

	public ServerControler controler;
	public ServerModel model;

	public ServerView(){

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

		//make option buttons
		createServer = new JButton("Create Server");
		createServer.setBounds(0, 0,120,22);
		getContentPane().add(createServer);
		createServer.setFocusable(false);

		pauseAndResume = new JButton("pause/resume");
		pauseAndResume.setBounds(120, 0,120,22);
		getContentPane().add(pauseAndResume);
		pauseAndResume.setFocusable(false);

		help = new JButton("Help");
		help.setBounds(240, 0,120,22);
		getContentPane().add(help);
		help.setFocusable(false);

		exit = new JButton("Exit");
		exit.setBounds(360, 0,120,22);
		getContentPane().add(exit);
		exit.setFocusable(false);

		//setup the mian frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 130, 640, 590);
    	setVisible(true);
    	setResizable( false );

		//setup server model
		model = new ServerModel(this);

		//setup server controller
		controler = new ServerControler(this, model);


	}


	public static void main(String[] args){
		new ServerView();
	}



}