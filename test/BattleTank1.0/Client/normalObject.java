import java.awt.*;

//this class represents all other objects except wall and Steelwall
public class normalObject implements Actor{
	public String Type;
	public Image image;
	public int xPos;
	public int yPos;
	public ClientModel gameModel;

	public normalObject(int xPos, int yPos,  ClientModel gameModel, String Type, int imageIndex){
		this.xPos = xPos;
		this.yPos = yPos;
		this.gameModel = gameModel;
		this.Type = Type;
		if(imageIndex != -1)
			image = gameModel.textures[imageIndex];
	}

	public void draw(Graphics g){
		if(image != null)
			g.drawImage(image, xPos - 12, yPos - 12, null);
		else{
			g.setColor(new Color(0, 225, 0));
			for(int i = yPos - 11; i <= yPos + 12; i+=5)
				g.drawLine(xPos - 12, i, xPos + 12, i);
			for(int i = xPos - 11; i <= xPos + 12; i+=5)
				g.drawLine(i, yPos - 12, i, yPos + 12);
			g.setColor(new Color(0, 128, 0));
			for(int i = yPos - 10; i <= yPos + 12; i+=5)
				g.drawLine(xPos - 12, i, xPos + 12, i);
			for(int i = xPos - 10; i <= xPos + 12; i+=5)
				g.drawLine( i, yPos - 12, i, yPos + 12);
		}

		if(!Type.equals("river") && !Type.equals("grass") && !Type.equals("base"))
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