import javax.swing.*;
import java.awt.event.*;

//this class deal with  the input from the Server view
public class ServerControler{
	public ServerView view;
	public ServerModel model;
	public int helpMessageCount = 1;

	//a reference to player's tank

	public ServerControler(ServerView thisview,  ServerModel thismodel){
		view = thisview;
		model = thismodel;

		//handel sendMessage button actions
		view.sendMessage.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!model.gameStarted){
						model.addMessage("Cannot send message, the connection isn't established");
						return;
					}

					if(!view.messageField.getText().equals("")){
						model.addMessage("Server says£º" + view.messageField.getText());
						model.playerTypedMessage += "m" + view.messageField.getText() + ";";
						view.messageField.setText("");
					}else{
						model.addMessage("Message content cannot be empty.");
					}
				}
			}
		);

		//handel createServer button actions
		view.createServer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!model.serverCreated)
						model.t.start();
				}
			}
		);

		//handel pauseAndResume button actions
		view.pauseAndResume.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					model.pausePressed = true;;
					if(!model.gameOver && model.gameStarted){
						if(!model.gamePaused){
							model.gamePaused = true;
							model.addMessage("Server player has paused the game.");
						}else{
							model.gamePaused = false;
							model.addMessage("Server Player has resumed the game");
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
						model.addMessage("Server player says£º" + view.messageField.getText());
						model.playerTypedMessage += "m" + view.messageField.getText() + ";";
						view.messageField.setText("");
					}else{
						model.addMessage("Message content cannot be empty");
					}
				}
			}
		});

		JPanel temp = view.mainPanel;
		temp.addKeyListener( new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(model.P1 != null){
						if(e.getKeyCode() == KeyEvent.VK_UP){
							model.P1.moveUp = true;
							model.P1.moveDown = false;
							model.P1.moveLeft = false;
							model.P1.moveRight = false;
						}
						if(e.getKeyCode() == KeyEvent.VK_DOWN ){
							model.P1.moveDown = true;
							model.P1.moveUp = false;
							model.P1.moveLeft = false;
							model.P1.moveRight = false;
						}
						if(e.getKeyCode() == KeyEvent.VK_LEFT ){
							model.P1.moveLeft = true;
							model.P1.moveUp = false;
							model.P1.moveDown = false;
							model.P1.moveRight = false;
						}
						if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
							model.P1.moveLeft = false;
							model.P1.moveUp = false;
							model.P1.moveDown = false;
							model.P1.moveRight = true;
						}
						if(e.getKeyChar() == 's')
							model.P1.fire = true;

						if(e.getKeyCode()==e.VK_ENTER){
							if(!view.messageField.getText().equals("")){
								model.addMessage("Server player says£º" + view.messageField.getText());
								model.playerTypedMessage += "m" + view.messageField.getText() + ";";
								view.messageField.setText("");
							}
						}

						if(e.getKeyChar() == 'y' && model.gameOver && !model.serverVoteYes){
							model.serverVoteYes = true;
							model.addMessage("Waiting for the client...");
						}

						if(e.getKeyChar() == 'n'  && model.gameOver)
							model.serverVoteNo = true;
					}
				}

				public void keyReleased(KeyEvent e){
						if(model.P1 != null){
							if(e.getKeyCode() == KeyEvent.VK_UP)
								model.P1.moveUp = false;
							if(e.getKeyCode() == KeyEvent.VK_DOWN )
								model.P1.moveDown = false;
							if(e.getKeyCode() == KeyEvent.VK_LEFT )
								model.P1.moveLeft = false;
							if(e.getKeyCode() == KeyEvent.VK_RIGHT )
								model.P1.moveRight = false;
							if(e.getKeyChar() == 's')
								model.P1.fire = false;
					}
				}
			}
		);

	}
}