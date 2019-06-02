import java.awt.*;

public class bomb implements Actor{
	public int xPos, yPos;
	public ClientModel gameModel;
	public int size;
	public int inner, middle, outer;

	public bomb(int a, int b, int size, ClientModel gameModel){
		this.size = size;
		this.gameModel = gameModel;
		xPos = a;
		yPos = b;

		if(size == 0 ){
				inner = 6;  middle = 9; outer = 14;
			}else if(size == 1){
				inner = 2;  middle = 4; outer = 7;
			}
	}

	public void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(xPos-outer, yPos-outer, 2*outer, 2*outer);
		g.setColor(Color.orange);
		g.fillOval(xPos-middle, yPos-middle, 2*middle, 2*middle);
		g.setColor(Color.yellow);
		g.fillOval(xPos-inner, yPos-inner, 2*inner, 2*inner);

		gameModel.removeActor(this);
	}

	public int getxPos(){
		return xPos;
	}

	public int getyPos(){
		return yPos;
	}
}