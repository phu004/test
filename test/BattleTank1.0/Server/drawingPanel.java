import java.awt.*;
import javax.swing.*;

//the drawing panel class belong to the server program
public class drawingPanel extends JPanel{
	public Image offScreenImage;

	//these are all reference that point to the real thing in serverModel
	public String[] messageQueue;
	public Actor[] actors;
	public boolean gameStarted;
	public int green, red, blue;

	public drawingPanel() {}

	public void paintComponent(Graphics g) {
		Graphics offScreenGraphics;
		if (offScreenImage == null) {
				offScreenImage = createImage(640, 550);
		}
		offScreenGraphics = offScreenImage.getGraphics();
		myPaint(offScreenGraphics);
		g.drawImage(offScreenImage, 0, 0, this);
	}

	public void myPaint(Graphics g) {
		super.paintComponent(g);

		if(gameStarted){
			//draw back ground
			g.setColor(Color.blue);
			g.drawRect(10, 10, 501, 501);

			//draw tanks, terren, etc...
			if(actors != null)
				for(int i = 0; i < actors.length; i++)
					if(actors[i] != null)
						actors[i].draw(g);

			//draw level information
			g.setColor(new Color(81,111, 230));
			g.drawString("Level " + level.currentLevel, 527, 39);
			g.drawString("Enemies Left =  " + level.enemyLeft, 527, 79);

			//draw winning scene
			if(level.winningCount > 150){
				int temp = level.winningCount - 150;
				if(temp*10 >  300)
					temp = 30;
				if(level.winningCount  > 470)
					temp = 500 - level.winningCount;
				g.setColor(Color.gray);
				g.fillRect(11,11, 500, temp*10);
				g.fillRect(11, 500 - temp*10, 500, (1+temp)*10 + 2);

				if(level.winningCount  > 190  &&level.winningCount  < 470){
					if(level.winningCount > 400 ){
						red+=(int)((128-red)*0.2);
						green+=(int)((128-green)*0.2);
					}
					g.setColor(new Color(red, green, blue));
					g.drawString("Level clear £¡", 240, 250);
				}
			}else{
				green = 23; red = 34; blue = 128;
			}

		}

		//draw messages
		g.setColor(new Color(255, 255, 255));
		if(messageQueue  != null){
			for(int i = 0 ; i < 8; i++){
				if(messageQueue[i] != null)
					g.drawString(messageQueue[i] , 5,  12 +i*16);
				else
					break;
			}
		}
	}
}