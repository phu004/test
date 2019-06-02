import java.awt.*;

public class Steelwall implements Actor{
	public final String Type = "Steelwall";
	public Image Steelwall;
	public int xPos;
	public int yPos;
	public boolean[] shape;
	public ClientModel gameModel;

	public  Steelwall(int xPos, int  yPos, int orientation,  ClientModel gameModel){
		this.xPos = xPos;
		this.yPos = yPos;
		this.gameModel = gameModel;
		shape = new boolean[4];
		Steelwall = gameModel.textures[53];

		if(orientation == 0){
				shape[2] = true;
				shape[3] = true;
		}
		if(orientation == 1){
				shape[0] = true;
				shape[1] = true;
		}
		if(orientation == 2){
				shape[1] = true;
				shape[3] = true;
		}
		if(orientation == 3){
				shape[0] = true;
				shape[2] = true;
		}
	}

	public void draw(Graphics g){
		boolean walldestoried = true;
		for(int i = 0; i < shape.length; i++)
			if(!shape[i]){
				walldestoried = false;
				break;
			}
		if(walldestoried)
			return;

		g.drawImage(Steelwall, xPos - 12, yPos - 12, null);
		g.setColor(new Color(128, 64, 0));
		if(shape[0])
			g.fillRect(xPos - 12, yPos - 12, 13, 13);
		if(shape[1])
			g.fillRect(xPos, yPos - 12, 13, 13);
		if(shape[2])
			g.fillRect(xPos - 12, yPos, 13, 13);
		if(shape[3])
			g.fillRect(xPos, yPos, 13, 13);
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