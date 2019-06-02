import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class ClientModel implements ActionListener{
	public ClientView view;

	//connection variables
	public Socket clientSocket;
	public PrintWriter out;
	public BufferedReader in;
	public String fromServer,  fromUser;
	public String serverIP;

	//client status
	public boolean serverConnected;
	public boolean gameStarted;
	public boolean gamePaused;
	public boolean gameOver;
	public boolean serverVoteYes, serverVoteNo;
	public boolean clientVoteYes, clientVoteNo;
	public boolean pausePressed;

	//ingame message
	public String[] messageQueue;
	public int messageIndex;
	public String playerTypedMessage = "";


	//textures
	public Image[] textures;

	//the actual game is running on this thread, while the main thread listen to user's input
	public Ticker t;

	//gameVariables
	public static int gameFlow;
	public Actor[] drawingList;
	public boolean moveUp;
	public boolean moveDown;
	public boolean moveLeft;
	public boolean moveRight;
	public boolean fire;


	public ClientModel(ClientView thisview){
		view = thisview;
		messageQueue = new String[8];
		view.mainPanel.messageQueue = messageQueue;
		addMessage("Welcome to Battle Tank£¡Please enter server's ip then click connect server button to start the game.");

		t = new Ticker(1000);
		t.addActionListener(this);

	}

	public void connectServer(){
		addMessage("Connecting server...");

		try{
		 	serverIP = view.IPfield.getText();
		 	InetAddress addr = InetAddress.getByName(serverIP);
			clientSocket = new Socket(addr, 4321);

			out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		}catch(Exception e){
			t.stop();
			System.out.println(e);
			addMessage("Error£¬ please make sure 1. the ip you entered is correct,   2. the server exisits");
			return;
		}

		serverConnected = true;
		addMessage("Connected£¬start loading game...");
		view.IPfield.setFocusable(false);
		view.IPfield.setEnabled(false);

		//load game texture
		textures = new Image[88];
		for(int i = 1; i < textures.length+1; i++)
			textures[i-1] = Toolkit.getDefaultToolkit().getImage("image\\" + i + ".jpg");


		drawingList = new Actor[400];

		gameStarted = true;
		view.mainPanel.gameStarted = gameStarted;;
		view.mainPanel.drawingList = drawingList;
		view.messageField.setEnabled(true);
		addMessage("Loading complete£¬game started£¡");
	}

	public void actionPerformed(ActionEvent e){
		connectServer();

		//if the program fail to connect to the server then do nothing
		if(!serverConnected)
				return;

		//game logic loop, the client program actually dont perform any logic calculation, it only accepts the drawing-instructions
		//from the server
		try{
			while ((fromServer = in.readLine()) != null) {
                fromUser = "";

                gameFlow++;

				if(pausePressed){
					fromUser+= "x;";
					pausePressed = false;
				}

				if(gameOver){
					if(clientVoteNo)
						System.exit(0);

					if(clientVoteYes){
						fromUser+="j;";
						if(serverVoteYes){
							addMessage("Server player wanted rematch£¬restarting game...");
							gameOver = false;
							clientVoteYes = false;
							serverVoteYes = false;
						}
					}
				}

				//make feedback instruction-string, tell the server what the client is doing
				fromUser +="m";
				if(moveUp)
					fromUser+= "1";
				else
					fromUser+= "0";
				if(moveDown)
					fromUser+="1";
				else
					fromUser+= "0";
				if(moveLeft)
					fromUser+="1";
				else
					fromUser+= "0";
				if(moveRight)
					fromUser+="1";
				else
					fromUser+= "0";
				if(fire)
					fromUser+="1";
				else
					fromUser+= "0";
				fromUser+=";";

				//process instruction from server
				instructionHandler.handleInstruction(this, fromServer);

				//delete one message from the message queue every 10 secs, (if there is any)
				if(gameFlow%300 == 0)
					removeMessage();

				//wtire player typed message to the outputLine
				if(!playerTypedMessage.equals("")){
					fromUser+=playerTypedMessage;
					playerTypedMessage = "";
				}

				//send feedback instructions
				out.println(fromUser);

				//call view to repaint itself
				view.mainPanel.repaint();

				//if the player switch to dialoge mode, then stop all tank actions
				if(!view.mainPanel.hasFocus()){
					moveLeft = false;
					moveUp = false;
					moveDown = false;
					moveRight = false;
					fire = false;
				}
        	}
		}catch(Exception ex){
			ex.printStackTrace();
			t.stop();
			view.messageField.setEnabled(false);
			serverConnected = false;
			gameStarted = false;
			view.mainPanel.gameStarted = false;
			gameOver = false;
			addMessage("Server player quit the game.");
			view.IPfield.setFocusable(true);
			view.IPfield.setEnabled(true);

			//when something goes wrong, shut down any thing that has been created
			try{
				out.close();
				in.close();
				clientSocket.close();
			}catch(Exception exc){
				System.out.println(exc);
			}
		}
	}

	//display a line of message on the screen
	public void addMessage(String message){
		if(messageIndex < 8){
			messageQueue[messageIndex] = message;
			messageIndex++;
		}
		else{
			for(int  i = 0; i < 7; i++)
				messageQueue[i] = messageQueue[i+1];
			messageQueue[7] = message;
		}

		//call view to repaint the screen if game not started
		if(!gameStarted)
			view.mainPanel.repaint();
	}

	//remove the earliest message on the screen
	public void removeMessage(){
		if(messageIndex == 0)
			return;

		messageIndex--;
		for(int  i = 0; i < messageIndex; i++)
			messageQueue[i] = messageQueue[i+1];
		messageQueue[messageIndex] = null;

		//call view to repaint the screen if game not started
		if(!gameStarted)
			view.mainPanel.repaint();
	}

	//add a game object (eg, tanks, bullet etc...) to the drawing list
	public void addActor(Actor actor){
		for(int i = 0; i < drawingList.length; i ++ )
			if(drawingList[i] == null){
				drawingList[i] = actor;
				break;
			}
	}

	//remove a game object from the drawing list
	public void removeActor(Actor actor){
			for(int i = 0; i < drawingList.length; i ++ )
					if(drawingList[i] == actor){
						drawingList[i] = null;
						break;
			}
	}


}
