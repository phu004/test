//this class decode the instruction-string from the server program, then translate the string to real instructions that is
//readable by the client program
public class instructionHandler{
	public static void handleInstruction(ClientModel gameModel, String instruction){
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

			//instruction start with "L" is to load a level, the number followed by "L" is the level index
			if(perInstruction.substring(0,1).equals("L")){
				level.loadLevel(gameModel, Integer.parseInt(perInstruction.substring(1,2)));
				return;
			}

			//instruction start with "w" means some thing has changed  in a wall object, (i.e  the wall has just been damaged)
			if(perInstruction.substring(0,1).equals("w")){
				int xPos = 0; int yPos = 0; boolean[] shape = new boolean[16];
				String temp = "";
				int j = 1;
				//get x position of the wall
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				xPos =  Integer.parseInt(temp);

				//get y position of the wall
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				yPos = Integer.parseInt(temp);

				//get the detailed border of the wall
				for(int k = 0; k < 16; k++){
					if(perInstruction. substring(j, j+1).equals("1"))
						shape[k] = true;
					else
						shape[k] = false;
					j++;
				}

				//perform the instructions
				for(int k = 0; k < gameModel.drawingList.length; k++){
					if(gameModel.drawingList[k] != null){
						if(gameModel.drawingList[k].getxPos() == xPos && gameModel.drawingList[k].getyPos() == yPos){
							wall tempWall = new wall(xPos, yPos, 4, gameModel);
							tempWall.shape = shape;
							gameModel.drawingList[k] = tempWall;
						}
					}
				}
			}

			//instruction start with "s" means some thing has changed  in a Steelwall object, (i.e  the Steelwall has just been damaged)
			if(perInstruction.substring(0,1).equals("s")){
				int xPos = 0; int yPos = 0; boolean[] shape = new boolean[4];
				String temp = "";
				int j = 1;
				//get x position of the Steelwall
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				xPos =  Integer.parseInt(temp);

				//get y position of the Steelwall
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				yPos = Integer.parseInt(temp);

				//get the detailed border of the Steelwall
				for(int k = 0; k < 4; k++){
					if(perInstruction. substring(j, j+1).equals("1"))
						shape[k] = true;
					else
						shape[k] = false;
					j++;
				}

				//perform the instructions
				for(int k = 0; k < gameModel.drawingList.length; k++){
					if(gameModel.drawingList[k] != null){
						if(gameModel.drawingList[k].getxPos() == xPos && gameModel.drawingList[k].getyPos() == yPos){
							Steelwall tempWall = new Steelwall(xPos, yPos, 4, gameModel);
							tempWall.shape = shape;
							gameModel.drawingList[k] = tempWall;
						}
					}
				}
			}

			//instruction start with "b" means base has been destroyed
			if(perInstruction.substring(0,1).equals("b")){
				gameModel.drawingList[4] = new normalObject(260, 498,  gameModel, "base", 1);
			}

			//instruction start with "n" indicates normal objects, such as tanks, powerUp symbols
			if(perInstruction.substring(0,1).equals("n")){
				int xPos = 0; int yPos = 0; int textureIndex = -1;
				String temp = "";
				int j = 1;
				//get x position of the object
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				xPos =  Integer.parseInt(temp);

				//get y position of the object
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				yPos = Integer.parseInt(temp);

				//get texture index of the object
				temp = "";
				while(j < perInstruction.length()){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				textureIndex = Integer.parseInt(temp);

				//perform instruction;
				gameModel.addActor(new normalObject(xPos, yPos, gameModel, "normal", textureIndex));
			}


			//instruction start with "t" indicates bullet
			if(perInstruction.substring(0,1).equals("t")){
				int xPos = 0; int yPos = 0; int direction = -1;
				String temp = "";
				int j = 1;
				//get x position of the bullet
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				xPos =  Integer.parseInt(temp);

				//get y position of the bullet
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				yPos = Integer.parseInt(temp);

				//get direction of the bullet
				temp = "";
				while(j < perInstruction.length()){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				direction = Integer.parseInt(temp);

				//perform instruction;
				gameModel.addActor(new bullet(xPos, yPos, gameModel, direction));
			}

			//instruction start with "o" indicates a bomb
			if(perInstruction.substring(0,1).equals("o")){
				int xPos = 0; int yPos = 0; int size = -1;
				String temp = "";
				int j = 1;
				//get x position of the bomb
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				xPos =  Integer.parseInt(temp);

				//get y position of the bomb
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				yPos = Integer.parseInt(temp);

				//get the size of the bomb
				temp = "";
				while(j < perInstruction.length()){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				if(temp.equals("small"))
					size = 1;
				else
					size = 0;
				//perform instruction;
				gameModel.addActor(new bomb(xPos, yPos, size, gameModel));
			}

			//instruction start with "i" indicates tank shield
			if(perInstruction.substring(0,1).equals("i")){
				int xPos = 0; int yPos = 0;
				String temp = "";
				int j = 1;
				//get x position of the shield
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				xPos =  Integer.parseInt(temp);

				//get y position of the shield
				temp = "";
				while(j < perInstruction. length()){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				yPos = Integer.parseInt(temp);

				//perform instruction;
				gameModel.addActor(new shield(xPos, yPos, gameModel));
			}

			//instruction start with "p" indicates level and player information
			if(perInstruction.substring(0,1).equals("p")){
				//int P1Life, P2Life, P1Score, P2Score, EnemyLeft,  LevelIndex;
				String temp = "";
				int j = 1;
				//get number of Enemy Left;
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				gameModel.view.mainPanel.EnemyLeft =  Integer.parseInt(temp);

				//get level Index
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				gameModel.view.mainPanel.LevelIndex =  Integer.parseInt(temp);

				//get player 1's life amount
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				gameModel.view.mainPanel.P1Life =  Integer.parseInt(temp);

				//get player 1's score
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				gameModel.view.mainPanel.P1Score =  Integer.parseInt(temp);

				//get player 2's life amount
				temp = "";
				while(!perInstruction. substring(j, j+1).equals(",")){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				gameModel.view.mainPanel.P2Life =  Integer.parseInt(temp);

				//get player 2's score
				temp = "";
				while(j < perInstruction.length()){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				j++;
				gameModel.view.mainPanel.P2Score =  Integer.parseInt(temp);
			}

			//instruction start with "g" indicates winning count number
			if(perInstruction.substring(0,1).equals("g")){
				String temp = "";
				int j = 1;
				//get number of Enemy Left;
				while(j < perInstruction.length()){
					temp+=perInstruction. substring(j, j+1);
					j++;
				}
				level.winningCount = Integer.parseInt(temp);
			}

			//instruction start with "m" indicates message from the server player
			if(perInstruction.substring(0,1).equals("m")){
				gameModel.addMessage("Server player says£º" + perInstruction.substring(1,perInstruction.length()));
			}

			//instruction start with "a" indicates game over
			if(perInstruction.substring(0,1).equals("a")){
				if(!gameModel.gameOver){
					gameModel.addMessage("GAME OVER ! ¡¡Try again ( y / n ) ?");
					gameModel.gameOver = true;
				}
			}
			//instruction start with "j" indicates server player want to play again
			if(perInstruction.substring(0,1).equals("j")){
				if(gameModel.gameOver)
					gameModel.serverVoteYes = true;
			}

			//instruction start with "x" indicates server player paused/unPaued the game
			if(perInstruction.substring(0,1).equals("x")){
				int temp = Integer.parseInt(perInstruction.substring(1,2));
				if(temp == 0){
					if(gameModel.gamePaused){
						gameModel.addMessage("Server player has paused the game.");
						gameModel.gamePaused = false;
					}
				}else{
					if(!gameModel.gamePaused){
						gameModel.addMessage("Server player has resumed the game.");
						gameModel.gamePaused = true;
					}
				}
			}
			i++;
		}
	}
}