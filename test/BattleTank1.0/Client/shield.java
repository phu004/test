import java.awt.*;
public class shield implements Actor{
	public int xPos;
	public int yPos;
	public ClientModel gameModel;
	public String Type = "shield";

	public shield(int xPos, int yPos,  ClientModel gameModel){
		this.xPos = xPos;
		this.yPos = yPos;
		this.gameModel = gameModel;
	}

	public void draw(Graphics g){
		g.setColor(Color.red);
		g.drawRect(xPos - 12, yPos - 12, 25,25);
		g.drawRect(xPos - 11, yPos - 11, 23,23);
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