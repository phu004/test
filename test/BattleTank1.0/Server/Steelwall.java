import java.awt.*;

public class Steelwall implements Actor{
	private int xPos;
	private int yPos;
	private Rectangle[] border = new Rectangle[4];
	public boolean[] shape = new boolean[4];
	public boolean walldestoried;
	public boolean bulletdestoried;
	public ServerModel gameModel;
	public Image steelWall;
	public Rectangle generalBorder;

	public Steelwall(int a, int b, ServerModel gameModel){
		this.gameModel = gameModel;
		steelWall = gameModel.textures[53];
		xPos = a;
		yPos = b;
		generalBorder = new Rectangle(xPos - 12, yPos - 12, 25, 25);
		border[0] = new Rectangle(xPos - 11, yPos - 11, 11, 11);
		border[1] = new Rectangle(xPos + 1, yPos - 11, 11, 11);
		border[2] = new Rectangle(xPos - 11, yPos + 1, 11, 11);
		border[3] = new Rectangle(xPos + 1, yPos + 1, 11, 11);
	}

	public Steelwall(int a, int b, int orientation, ServerModel gameModel){
		xPos = a;
		yPos = b;
		this.gameModel = gameModel;
		steelWall = gameModel.textures[53];
		generalBorder = new Rectangle(xPos - 12, yPos - 12, 25, 25);
		if(orientation == 0){
			border[0] = new Rectangle(xPos - 11, yPos - 11, 11, 11);
			border[1] = new Rectangle(xPos + 1, yPos - 11, 11, 11);
				shape[2] = true;
				shape[3] = true;
		}
		if(orientation == 1){
			border[2] = new Rectangle(xPos - 11, yPos + 1, 11, 11);
			border[3] = new Rectangle(xPos + 1, yPos + 1, 11, 11);
				shape[0] = true;
				shape[1] = true;
		}
		if(orientation == 2){
			border[0] = new Rectangle(xPos - 11, yPos - 11, 11, 11);
			border[2] = new Rectangle(xPos - 11, yPos + 1, 11, 11);
				shape[1] = true;
				shape[3] = true;
		}
		if(orientation == 3){
			border[1] = new Rectangle(xPos + 1, yPos - 11, 11, 11);
			border[3] = new Rectangle(xPos + 1, yPos + 1, 11, 11);
				shape[0] = true;
				shape[2] = true;
		}
	}


	public void damageWall(Rectangle bullet, int bulletpower, int bulletdirection){
		bulletdestoried = false;
		if(bulletpower == 2){
			for(int i = 0; i < 4; i++){
				if(border[i] != null){
					if(bullet.intersects(border[i])){
						bulletdestoried = true;
						border[i] = null;
						shape[i] = true;
					}
				}
			}
		}
		if(bulletpower == 1){
			for(int i = 0; i < 4; i++){
				if(border[i] != null){
					if(bullet.intersects(border[i]))
						bulletdestoried = true;
				}
			}
		}

		//write changes to the outputline
		gameModel.outputLine+="s" + xPos + ","+ yPos+",";
		for(int i = 0; i < shape.length; i++){
			if(shape[i])
				gameModel.outputLine+="1";
			else
				gameModel.outputLine+="0";
		}
		gameModel.outputLine+=";";

	}

	public boolean walldestoried(){
		if(walldestoried)
			return true;
		boolean walldestory = false;
		if(border[0] == null && border[1] == null && border[2] == null && border[3] == null)
			walldestory = true;
		return walldestory;
	}

	public Rectangle getBorder(){
		return generalBorder;
	}

	public Rectangle[] getDetailedBorder(){
			return border;
	}

	public void draw(Graphics g) {
		if(walldestoried)
			return;

		g.drawImage(steelWall, xPos - 12, yPos - 12, null);
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

	public String getType(){
		return "steelWall";
	}


	//unused method
	public void move(){}
}