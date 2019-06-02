import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.image.*;

public class house extends Applet implements KeyListener, ActionListener{
	public Image offScreenImage;
	public Ticker t;
	public int sleepTime;
	public BufferedImage doubleBuffer;
	public static int[] screen;
	public static boolean[] screenBuffer;
	public static boolean[] transparentBuffer;
	public camera Camera;
	public static texture[] textures;
	public model world;
	public static polygon3D[] polygons;

	

	public static long lastTime;
	public static long tm;
	public int fps;
	public static int counter;
	public static int visiblePolygon;
	public String message;

    @Override
	public void init(){
		Camera = new camera(new vector(10,8,-9));
		doubleBuffer =  new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
		DataBuffer dest = doubleBuffer.getRaster().getDataBuffer();
		screen = ((DataBufferInt)dest).getData();
		screenBuffer = new boolean[640*480];
		transparentBuffer = new boolean[640*480];

		addKeyListener(this);
		requestFocus();

		t = new Ticker(sleepTime);
		sleepTime = 30;
		tm = System.currentTimeMillis();
		counter = 0;	
		t.addActionListener(this);
		t.start();
	}

	public final void actionPerformed(ActionEvent e){
		if(textures == null){
			loadTexture();
		}

		if(counter == 0){
			Camera = new camera(new vector(0,0,0));
			gameData.makeData();
			LightSource.init();
			loadModels();
		}
		
		counter++;
		tm+=sleepTime;	
		long temp = Math.max(0, tm - System.currentTimeMillis());
		if(temp == 0)
			temp = (long)(lastTime*0.5);
		if(temp > 28)
			temp = 28;
		t.setDelay((int)temp);
		lastTime = temp;

		gameData.update();
		visiblePolygon = 0;
		

		clearScreen();
		camera.update();
		LightSource.update();

		world.update();
		
		
		world.sort();
		
		world.draw();

		message = "FPS: " + fps + "      " + "visible polygons: " + visiblePolygon;

		myPaint(this.getGraphics());
	}

	public final void clearScreen(){
			if(counter == 0){
			screen[0] = -134250;
			for(int i = 1; i < 307200; i+=i)
				System.arraycopy(screen, 0, screen, i, 307200 - i >= i ? i : 307200 - i);
			}
			if(polygon3D.emptyPixel == true){
				polygon3D.emptyPixel = false;
			}else{
				polygon3D.emptyPixel = true;
			}

	}

	public final void myPaint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(doubleBuffer, null, 0, 0);

		if(message != null)
			g2.drawString(message, 10,10);
	}

	public final void paint(Graphics g){
		clearScreen();
		myPaint(this.getGraphics());
	}
    public final void update(Graphics g){}


	public void loadTexture(){
		textures = new texture[51];
		clearScreen();
        String fs = java.io.File.separator;
		textures[0] = new texture(getImage(getDocumentBase(), "Image" + fs + "0.jpg"), 9, 8);
		textures[1] = new texture(getImage(getDocumentBase(), "Image" + fs + "1.jpg"), 9, 9);
		textures[2] = new texture(getImage(getDocumentBase(), "Image" + fs + "2.jpg"),8, 8);
		textures[3] = new texture(getImage(getDocumentBase(), "Image" + fs + "3.jpg"),8, 4);
		textures[4] = new texture(getImage(getDocumentBase(), "Image" + fs + "4.jpg"),8, 8);
		textures[5] = new texture(getImage(getDocumentBase(), "Image" + fs + "5.jpg"),1, 1);
		textures[6] = new texture(getImage(getDocumentBase(), "Image" + fs + "6.jpg"),1, 1);
		textures[7] = new texture(getImage(getDocumentBase(), "Image" + fs + "7.jpg"),1, 1);
		textures[8] = new texture(getImage(getDocumentBase(), "Image" + fs + "8.jpg"),1, 1);
		textures[9] = new texture(getImage(getDocumentBase(), "Image" + fs + "9.jpg"),1, 1);
		textures[10] = new texture(getImage(getDocumentBase(), "Image" + fs + "10.jpg"),1, 1);
		textures[11] = new texture(getImage(getDocumentBase(), "Image" + fs + "11.jpg"),7, 7);
		textures[12] = new texture(getImage(getDocumentBase(), "Image" + fs + "12.jpg"),7, 7);
		textures[13] = new texture(getImage(getDocumentBase(), "Image" + fs + "13.jpg"),6, 6);
		textures[14] = new texture(getImage(getDocumentBase(), "Image" + fs + "14.jpg"),8, 8);
		textures[15] = new texture(getImage(getDocumentBase(), "Image" + fs + "15.gif"),9, 8);
		textures[16] = new texture(getImage(getDocumentBase(), "Image" + fs + "sky2.jpg"),9, 9);
		textures[17] = new texture(getImage(getDocumentBase(), "Image" + fs + "sky3.jpg"),9, 9);
		textures[18] = new texture(getImage(getDocumentBase(), "Image" + fs + "sky4.jpg"),9, 9);
		textures[19] = new texture(getImage(getDocumentBase(), "Image" + fs + "sky5.jpg"),9, 9);
		textures[20] = new texture(getImage(getDocumentBase(), "Image" + fs + "sky1.jpg"),9, 9);
		textures[21] = new texture(getImage(getDocumentBase(), "Image" + fs + "sky6.jpg"),9, 9);
		textures[22] = new texture(getImage(getDocumentBase(), "Image" + fs + "22.jpg"),8, 8);
		textures[23] = new texture(getImage(getDocumentBase(), "Image" + fs + "23.jpg"),8, 8);
		textures[24] = new texture(getImage(getDocumentBase(), "Image" + fs + "24.jpg"),8, 8);
		textures[25] = new texture(getImage(getDocumentBase(), "Image" + fs + "25.jpg"),8, 8);
		textures[26] = new texture(getImage(getDocumentBase(), "Image" + fs + "26.jpg"),8, 8);
		textures[27] = new texture(getImage(getDocumentBase(), "Image" + fs + "27.jpg"),8, 8);
		textures[28] = new texture(getImage(getDocumentBase(), "Image" + fs + "28.jpg"),8, 8);
		textures[29] = new texture(getImage(getDocumentBase(), "Image" + fs + "29.jpg"),8, 8);
		textures[30] = new texture(getImage(getDocumentBase(), "Image" + fs + "30.jpg"),7, 4);
		textures[31] = new texture(getImage(getDocumentBase(), "Image" + fs + "31.jpg"),4, 4);
		textures[32] = new texture(getImage(getDocumentBase(), "Image" + fs + "32.jpg"),7, 7);
		textures[33] = new texture(getImage(getDocumentBase(), "Image" + fs + "33.jpg"),7, 7);
		textures[34] = new texture(getImage(getDocumentBase(), "Image" + fs + "34.jpg"),8, 7);
		textures[35] = new texture(getImage(getDocumentBase(), "Image" + fs + "35.jpg"),8, 7);
		textures[36] = new texture(getImage(getDocumentBase(), "Image" + fs + "36.jpg"),6, 6);
		textures[37] = new texture(getImage(getDocumentBase(), "Image" + fs + "37.jpg"),6, 6);
		textures[38] = new texture(getImage(getDocumentBase(), "Image" + fs + "38.jpg"),6, 6);
		textures[39] = new texture(getImage(getDocumentBase(), "Image" + fs + "39.jpg"),6, 6);
		textures[40] = new texture(getImage(getDocumentBase(), "Image" + fs + "40.jpg"),6, 6);
		textures[41] = new texture(getImage(getDocumentBase(), "Image" + fs + "41.jpg"),8, 8);
		textures[42] = new texture(getImage(getDocumentBase(), "Image" + fs + "42.jpg"),8, 8);
		textures[43] = new texture(getImage(getDocumentBase(), "Image" + fs + "43.jpg"),9, 8);
		textures[44] = new texture(getImage(getDocumentBase(), "Image" + fs + "44.jpg"),1, 1);
		textures[45] = new texture(getImage(getDocumentBase(), "Image" + fs + "45.jpg"),8, 8);
		textures[46] = new texture(getImage(getDocumentBase(), "Image" + fs + "46.jpg"),6, 6);
		textures[47] = new texture(getImage(getDocumentBase(), "Image" + fs + "47.jpg"),6, 6);
		textures[48] = new texture(getImage(getDocumentBase(), "Image" + fs + "48.jpg"),8, 8);
		textures[49] = new texture(getImage(getDocumentBase(), "Image" + fs + "49.jpg"),8, 8);
		textures[50] = new texture(getImage(getDocumentBase(), "Image" + fs + "50.jpg"),1, 1);
	}


	public void loadModels(){
		modelBuilder.build();
		world = modelBuilder.world;
	}

	public void keyTyped(KeyEvent e){

	}

	public void keyReleased(KeyEvent e){
	 	if(e.getKeyChar() == 'w')
			camera.MOVE_FORWARD = false;
		else if(e.getKeyChar() == 's')
			camera.MOVE_BACKWARD = false;
		else if(e.getKeyChar() == 'a')
			camera.SLIDE_LEFT = false;
		else if(e.getKeyChar() == 'd')
			camera.SLIDE_RIGHT = false;

		if(e.getKeyCode() == KeyEvent.VK_UP)
			Camera.UP_TYPED= false;
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			Camera.DOWN_TYPED = false;
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			Camera.LEFT_TYPED = false;
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			Camera.RIGHT_TYPED = false;



	}

	public void keyPressed(KeyEvent e){
        if(e.getKeyChar() == 'w')
			camera.MOVE_FORWARD = true;
		else if(e.getKeyChar() == 's')
			camera.MOVE_BACKWARD = true;
		else if(e.getKeyChar() == 'a')
			camera.SLIDE_LEFT = true;
		else if(e.getKeyChar() == 'd')
			camera.SLIDE_RIGHT = true;



		if(e.getKeyCode() == KeyEvent.VK_UP)
			Camera.UP_TYPED= true;
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			Camera.DOWN_TYPED = true;
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			Camera.LEFT_TYPED = true;
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			Camera.RIGHT_TYPED = true;
	}

}