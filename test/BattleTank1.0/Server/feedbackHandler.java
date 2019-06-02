//this class decode the instruction-string from the client program, then translate the string to real instructions that is
//readable by the server program

public class feedbackHandler{
	public static void handleInstruction(ServerModel gameModel, String instruction){
		if(instruction.length() == 0)
			return;

		int i = 0;
		while(i < instruction.length()){
			String perInstruction = "";

			//instructions are seperated by ";"  inside the instruction-string
			while(!instruction.substring(i, i+1).equals(";")){
				perInstruction+=instruction.substring(i, i+1);
				i++;
			}

			//instruction start with "m" indicate movement information from the client
			if(perInstruction.substring(0,1).equals("m")){
				gameModel.P2.moveUp = false;
				gameModel.P2.moveDown = false;
				gameModel.P2.moveLeft = false;
				gameModel.P2.moveRight = false;
				gameModel.P2.fire = false;

				String temp = perInstruction.substring(1,2);
				if(temp.equals("1"))
					gameModel.P2.moveUp = true;
				temp = perInstruction.substring(2,3);
				if(temp.equals("1"))
					gameModel.P2.moveDown = true;
				temp = perInstruction.substring(3,4);
				if(temp.equals("1"))
					gameModel.P2.moveLeft = true;
				temp = perInstruction.substring(4,5);
				if(temp.equals("1"))
					gameModel.P2.moveRight = true;
				temp = perInstruction.substring(5,6);
				if(temp.equals("1"))
					gameModel.P2.fire = true;
			}

			//instruction start with "m" indicates message from the server player
			if(perInstruction.substring(0,1).equals("e")){
				gameModel.addMessage("Client player says£º" + perInstruction.substring(1,perInstruction.length()));
			}

			//instruction start with "j" indicates client player want to play again
			if(perInstruction.substring(0,1).equals("j")){
				if(gameModel.gameOver)
					gameModel.clientVoteYes = true;
			}

			//instruction start with "x" indicates server player paused/unPaued the game
			if(perInstruction.substring(0,1).equals("x")){
				if(gameModel.gamePaused){
					gameModel.addMessage("Client player has paused the game");
					gameModel.gamePaused = false;
				} else if(!gameModel.gamePaused){
					gameModel.addMessage("Client player has resumed the game");
					gameModel.gamePaused = true;
				}
			}
			i++;
		}
	}

}