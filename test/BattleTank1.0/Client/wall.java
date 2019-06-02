import java.awt.*;

public class wall implements Actor{
	public final String Type = "wall";
	public Image wall;
	public int xPos;
	public int yPos;
	public boolean[] shape;
	public ClientModel gameModel;

	public  wall(int xPos, int  yPos,  int orientation, ClientModel gameModel){
		this.xPos = xPos;
		this.yPos = yPos;
		this.gameModel = gameModel;
		shape = new boolean[16];
		wall = gameModel.textures[70];

		if(orientation == 0){
			for(int i = 8; i < 12; i ++)
				shape[i] = true;
			for(int i = 12; i < 16; i ++)
				shape[i] = true;
		}
		if(orientation == 1){
			for(int i = 0; i < 4; i ++)
				shape[i] = true;
			for(int i = 4; i < 8; i ++)
				shape[i] = true;
		}
		if(orientation == 2){
			for(int i = 3; i <= 15; i+=4)
				shape[i] = true;
			for(int i = 2; i <= 14; i+=4)
				shape[i] = true;
		}
		if(orientation == 3){
			for(int i = 1; i <= 13; i+=4)
				shape[i] = true;
			for(int i = 0; i <= 12; i+=4)
				shape[i] = true;
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
		g.drawImage(wall, xPos - 12, yPos - 12, null);
		g.setColor(new Color(128, 64, 0));
		if(shape[0])
			g.fillRect(xPos - 12, yPos - 12, 7, 7);
		if(shape[1])
			g.fillRect(xPos - 6, yPos - 12, 7, 7);
		if(shape[2])
			g.fillRect(xPos, yPos - 12, 7, 7);
		if(shape[3])
			g.fillRect(xPos + 6, yPos - 12, 7, 7);
		if(shape[4])
			g.fillRect(xPos - 12, yPos - 6, 7, 7);
		if(shape[5])
			g.fillRect(xPos - 6, yPos - 6, 7, 7);
		if(shape[6])
			g.fillRect(xPos, yPos - 6, 7, 7);
		if(shape[7])
			g.fillRect(xPos + 6, yPos - 6, 7, 7);
		if(shape[8])
			g.fillRect(xPos - 12, yPos, 7, 7);
		if(shape[9])
			g.fillRect(xPos - 6, yPos, 7, 7);
		if(shape[10])
			g.fillRect(xPos, yPos, 7, 7);
		if(shape[11])
			g.fillRect(xPos + 6, yPos, 7, 7);
		if(shape[12])
			g.fillRect(xPos - 12, yPos + 6, 7, 7);
		if(shape[13])
			g.fillRect(xPos - 6, yPos + 6, 7, 7);
		if(shape[14])
			g.fillRect(xPos, yPos + 6, 7, 7);
		if(shape[15])
			g.fillRect(xPos + 6, yPos + 6, 7, 7);
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