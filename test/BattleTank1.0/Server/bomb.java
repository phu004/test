import java.awt.*;

public class bomb implements Actor{
	private int xPos, yPos;
	private int animationTime;
	public final Rectangle border = new Rectangle(0,0,0,0);
	public String size;
	public int inner, middle, outer, jumpDistance;
	public ServerModel gameModel;


	public bomb(int a, int b, String size, ServerModel gameModel){
		this.size = size;
		this.gameModel = gameModel;
		if(size.equals("big") ){
			inner = 6;  middle = 9; outer = 14;
			jumpDistance = 8;
			animationTime = 6;
		}else if(size.equals("small")){
			inner = 2;  middle = 4; outer = 7;
			jumpDistance = 4;
			animationTime = 4;
		}

		xPos = a;
		yPos = b;
	}

	public void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(xPos-outer, yPos-outer, 2*outer, 2*outer);
		g.setColor(Color.orange);
		g.fillOval(xPos-middle, yPos-middle, 2*middle, 2*middle);
		g.setColor(Color.yellow);
		g.fillOval(xPos-inner, yPos-inner, 2*inner, 2*inner);
	}

	public void move(){
		if(gameModel.gamePaused){
			gameModel.outputLine+="o"+ xPos + "," + yPos + "," + size + ";" ;
			return;
		}

		animationTime--;
		if(animationTime < 0){
			gameModel.removeActor(this);
			return;
		}
		xPos = xPos + (int)(Math.random()*jumpDistance) - (int)(Math.random()*jumpDistance);
		yPos = yPos + (int)(Math.random()*jumpDistance) - (int)(Math.random()*jumpDistance);

		//write changes to outputLine
		gameModel.outputLine+="o"+ xPos + "," + yPos + "," + size + ";" ;
	}

	public Rectangle getBorder(){
		return border;
	}

	public String getType(){
		return "bomb";
	}


	//unused method
	public Rectangle[] getDetailedBorder(){return null;}
	public boolean walldestoried(){return false;}

}
