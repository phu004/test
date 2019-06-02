import java.awt.*;
import javax.swing.*;

//the drawing panel class belong to the client program
public class drawingPanel extends JPanel{
	public Image offScreenImage;

	public String[] messageQueue;
	public Actor[] drawingList;
	public boolean gameStarted;
	public int green, red, blue;
	public int P1Life, P2Life, P1Score, P2Score, EnemyLeft,  LevelIndex;
	public Image P1Image, P2Image;

	public drawingPanel() {
		P1Image = Toolkit.getDefaultToolkit().getImage("image\\" +  55 + ".jpg");
		P2Image = Toolkit.getDefaultToolkit().getImage("image\\" +  73 + ".jpg");
	}



	public void paintComponent(Graphics g) {
		Graphics offScreenGraphics;
		if (offScreenImage == null) {
				offScreenImage = createImage(640, 550);
		}
		offScreenGraphics = offScreenImage.getGraphics();
		myPaint(offScreenGraphics);
		g.drawImage(offScreenImage, 0, 0, this);
		g.drawImage(offScreenImage, 0, 0, this);


	}

	public void myPaint(Graphics g) {
		super.paintComponent(g);

		if(gameStarted){
			//draw game information
			g.setColor(new Color(81,111, 230));
			g.drawString("Level " + LevelIndex, 527, 39);
			g.drawString("Enemies =  " + EnemyLeft, 527, 79);

			g.setColor(Color.yellow);
			g.drawImage(P1Image,  520, 380, null );
			g.drawString("x", 555, 395);
			g.drawString(P1Life + "", 565, 396);
			String SCORE = "000000000" + P1Score;
			g.drawString("P1" +" score:" + "", 515, 370);
			g.drawString(SCORE.substring(SCORE.length() - 7, SCORE.length()) + "", 566, 370);

			g.setColor(Color.green);
			g.drawImage(P2Image,  520, 460, null );
			g.drawString("x", 555, 475);
			g.drawString(P2Life + "", 565, 476);
			SCORE = "000000000" + P2Score;
			g.drawString("P2" +" score:" + "", 515, 450);
			g.drawString(SCORE.substring(SCORE.length() - 7, SCORE.length()) + "", 566, 450);



			//draw back ground
			g.setColor(Color.blue);
			g.drawRect(10, 10, 501, 501);

			//draw tanks, terren, etc...
			if(drawingList != null)
				for(int i = 0; i < drawingList.length; i++)
					if(drawingList[i] != null)
						drawingList[i].draw(g);

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
					g.drawString("Level clear  £¡", 240, 250);
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