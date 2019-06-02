import java.awt.*;

public class base implements Actor{
	private Rectangle border;
	public Image base;
	public int xPos, yPos;
	public ServerModel gameModel;
	public int steelWallTime;
	public boolean baseKilled;

	public base(ServerModel gameModel){
		this.gameModel = gameModel;
		xPos = 260;
		yPos = 498;
		base = gameModel.textures[0];
		border = new Rectangle(xPos - 11, yPos - 11, 23, 23);

	}

	public Rectangle getBorder(){
		return border;
	}

	public void doom(){
		base = gameModel.textures[1];
		if(!baseKilled)
			gameModel.addActor(new bomb(xPos, yPos, "big", gameModel));
		baseKilled = true;

		//write changes to outputLine
		gameModel.outputLine+="b"+ xPos + "," + yPos + "," + "1;";

	}

	public void move(){
		if(steelWallTime == 600){
			Steelwall temp = new Steelwall(248, 498, 2, gameModel);
			gameModel.actors[0] = temp;
			writeToOutputLine("s", temp.shape, 248, 498);

			temp = new Steelwall(273, 498, 3, gameModel);
			gameModel.actors[1] = temp;
			writeToOutputLine("s", temp.shape, 273, 498);

			temp = new Steelwall(248, 473, 1, gameModel);
			gameModel.actors[2] = temp;
			writeToOutputLine("s", temp.shape, 248, 473);

			temp = new Steelwall(273, 473, 1, gameModel);
			gameModel.actors[3] = temp;
			writeToOutputLine("s", temp.shape, 273, 473);
		}
		if(steelWallTime> 0)
			steelWallTime--;
		if(steelWallTime == 1){
			wall temp = new wall(248, 498, 2, gameModel);
			gameModel.actors[0] = temp;
			writeToOutputLine("w", temp.shape, 248, 498);

			temp = new wall(273, 498, 3, gameModel);
			gameModel.actors[1] = temp;
			writeToOutputLine("w", temp.shape, 273, 498);

			temp = new wall(248, 473, 1, gameModel);
			gameModel.actors[2] = temp;
			writeToOutputLine("w", temp.shape, 248, 473);

			temp = new wall(273, 473, 1, gameModel);
			gameModel.actors[3] = temp;
			writeToOutputLine("w", temp.shape, 273, 473);
		}

	}

	public void writeToOutputLine(String type, boolean[] shape, int  xPos, int  yPos){
		//write changes to the outputline
		gameModel.outputLine+=type + xPos + ","+ yPos+",";
		for(int i = 0; i < shape.length; i++){
			if(shape[i])
				gameModel.outputLine+="1";
			else
				gameModel.outputLine+="0";
		}
		gameModel.outputLine+=";";
	}

	public String getType(){
		return "base";
	}

	public void draw(Graphics g){
		g.drawImage(base, xPos - 12, yPos - 12, null );
	}

	//unused method
	public Rectangle[] getDetailedBorder(){return null;}
	public boolean walldestoried(){return false;}

}