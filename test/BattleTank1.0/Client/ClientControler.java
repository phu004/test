import javax.swing.*;
import java.awt.event.*;

//this class deals with  the input from the Client view frame
public class ClientControler{
	public boolean serverConnected;;
	public boolean gameStarted;
	public boolean gamePaused;
	public ClientView view;
	public ClientModel model;
	public int helpMessageCount = 1;


	public ClientControler(ClientView thisview, ClientModel thismodel){
		view = thisview;
		model = thismodel;

		//handel sendMessage button actions
		view.sendMessage.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!model.gameStarted){
						model.addMessage("Cannot send message, the connection isn't established.");
						return;
					}

					if(!view.messageField.getText().equals("")){
						model.addMessage("Client player says:£º" + view.messageField.getText());
						model.playerTypedMessage += "e" + view.messageField.getText() + ";";
						view.messageField.setText("");
					}else{
						model.addMessage("Message content cannot be empty.");
					}
				}
			}
		);

		//handel connectServer button actions
		view.connectServer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!model.serverConnected){
						model.serverIP = view.IPfield.getText();
						model.t.start();
					}
				}
			}
		);

		//handel pauseAndResume button actions
		view.pauseAndResume.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!model.gameOver && model.gameStarted){
						model.pausePressed = true;
						if(!model.gamePaused){
							model.gamePaused = true;
							model.addMessage("Client player has paused the game.");
						}else{
							model.gamePaused = false;
							model.addMessage("Client player has resumed the game.");
						}
					}
				}
			}
		);

		//handel help button actions
		view.help.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					model.addMessage("-------------------------------Battle Tank 1.0-----------------------------------");
					model.addMessage("Hold s to fire,  press arrow keys to control the movement");
					model.addMessage("If nothing happens please try the following:  ");
					model.addMessage("1. turn off caps lock;");
					model.addMessage("2. press tab to switch back to play mode from conversation mode");
					model.addMessage("--------------------------------------------------------------------------------------");
				}
			}
		);

		//handel exit button actions
		view.exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			}
		);


		//handel input from the keyboard
		view.messageField.addKeyListener( new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(helpMessageCount  > 0){
					model.addMessage("Hint£ºpress tab key to switch bewteen play mode and conversation mode");
					model.addMessage("Hint: you can just press the enter key to send your message");
					helpMessageCount--;
				}

				if(e.getKeyCode()==e.VK_ENTER){
					if(!view.messageField.getText().equals("")){
						model.addMessage("Client player says£º" + view.messageField.getText());
						model.playerTypedMessage += "e" + view.messageField.getText() + ";";
						view.messageField.setText("");
					}else{
						model.addMessage("Message content cannot be empty.");
					}
				}
			}
		});

		JPanel temp = view.mainPanel;
		temp.addKeyListener( new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode() == KeyEvent.VK_UP){
						model.moveUp = true;
						model.moveDown = false;
						model.moveLeft = false;
						model.moveRight = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_DOWN ){
						model.moveDown = true;
						model.moveUp = false;
						model.moveLeft = false;
						model.moveRight = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_LEFT ){
						model.moveLeft = true;
						model.moveUp = false;
						model.moveDown = false;
						model.moveRight = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
						model.moveLeft = false;
						model.moveUp = false;
						model.moveDown = false;
						model.moveRight = true;
					}

					if(e.getKeyChar() == 's')
							model.fire = true;

					if(e.getKeyCode()==e.VK_ENTER){
						if(!view.messageField.getText().equals("")){
							model.addMessage("Client player says:" + view.messageField.getText());
							model.playerTypedMessage += "e" + view.messageField.getText() + ";";
							view.messageField.setText("");
						}
					}

					if(e.getKeyChar() == 'y' && model.gameOver && !model.clientVoteYes){
						model.clientVoteYes = true;
						model.addMessage("Waiting for server's responce...");
					}

					if(e.getKeyChar() == 'n'  && model.gameOver)
						model.clientVoteNo = true;
				}

				public void keyReleased(KeyEvent e){
					if(e.getKeyCode() == KeyEvent.VK_UP)
						model.moveUp = false;
					if(e.getKeyCode() == KeyEvent.VK_DOWN )
						model.moveDown = false;
					if(e.getKeyCode() == KeyEvent.VK_LEFT )
						model.moveLeft = false;
					if(e.getKeyCode() == KeyEvent.VK_RIGHT )
						model.moveRight = false;
					if(e.getKeyChar() == 's')
							model.fire = false;
				}
			}
		);

	}
}

