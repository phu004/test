import java.awt.*;

public class bullet implements Actor{
	public int xPos;
	public int yPos;
	public ClientModel gameModel;
	public int direction;
	public String Type = "bullet";

	public bullet(int xPos, int yPos,  ClientModel gameModel, int direction){
		this.xPos = xPos;
		this.yPos = yPos;
		this.gameModel = gameModel;
		this.direction = direction;
	}

	public void draw(Graphics g){
		g.setColor(Color.lightGray);
		if(direction == 0 || direction == 1)
			g.fillRect(xPos - 1,yPos - 4, 3, 9);
		if(direction == 2 || direction == 3)
			g.fillRect(xPos - 4,  yPos - 1, 9, 3);
		gameModel.removeActor(this);
	}

	public int getxPos(){
		return xPos;
	}

	public int getyPos(){
		return yPos;
	}

	public String getType(){
		return Type;
	}
}
