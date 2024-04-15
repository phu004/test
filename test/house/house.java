import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class house extends JFrame implements KeyListener, ActionListener{
	public Image offScreenImage;
	public Ticker t;
	public BufferedImage doubleBuffer;
	public static int[] screen;
	public static boolean[] screenBuffer;
	public static boolean[] transparentBuffer;
	public camera Camera;
	public static texture[] textures;
	public model world;
	public static polygon3D[] polygons;

	public double lastTime;
	public int fps;
	public int counter;
	public static int visiblePolygon;
	public String message;
	
	public static JPanel panel;
	public static int screen_w = 1920;
	public static int screen_h = 1080;
	public static int half_screen_w = screen_w/2;
	public static int half_screen_h = screen_h/2;
	public static int screen_pixel_count = screen_w * screen_h;

    public static void main(String[] args){
    	new house();
    	
	}
    
    public house() {
    	panel= (JPanel) this.getContentPane();
		panel.setPreferredSize(new Dimension(screen_w, screen_h));
		panel.setMinimumSize(new Dimension(screen_w,screen_h));
		panel.setLayout(null);     
		
		setResizable(false); 
		pack();
		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
		Camera = new camera(new vector(10,8,-9));
		doubleBuffer =  new BufferedImage(screen_w, screen_h, BufferedImage.TYPE_INT_RGB);
		DataBuffer dest = doubleBuffer.getRaster().getDataBuffer();
		screen = ((DataBufferInt)dest).getData();
		screenBuffer = new boolean[screen_pixel_count];
		transparentBuffer = new boolean[screen_pixel_count];

		addKeyListener(this);
		requestFocus();

		t = new Ticker(0);
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
		gameData.update();
		visiblePolygon = 0;
		
		double thisTime = System.currentTimeMillis();
		int delta = 35 - (int)(thisTime - lastTime);
		if(counter%30 ==0)
			fps = (int)(1000.0/(thisTime - lastTime));
		if(delta > 0) {
			try {
				Thread.sleep(delta);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		lastTime = thisTime;
		
		
		
		
		

		clearScreen();
		camera.update();
		LightSource.update();

		world.update();
		world.sort();
		world.draw();

		message = "FPS: " + fps + "      " + "visible polygons: " + visiblePolygon;
		
		paintComponent(panel.getGraphics());

		//myPaint(this.getGraphics());
	}

	public final void clearScreen(){
			if(counter == 0){
			screen[0] = -134250;
			for(int i = 1; i < screen_pixel_count; i+=i)
				System.arraycopy(screen, 0, screen, i, screen_pixel_count - i >= i ? i : screen_pixel_count - i);
			}
			if(polygon3D.emptyPixel == true){
				polygon3D.emptyPixel = false;
			}else{
				polygon3D.emptyPixel = true;
			}

	}

	
	public void paintComponent(Graphics g){		
		
		//copy the pixel information to the video memory
		Graphics2D g2 =(Graphics2D)doubleBuffer.getGraphics(); //(Graphics2D)g;
		//display polygon count and frame rate
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SimSun", Font.PLAIN, 16));
		
		setTitle(message);
		
		g.drawImage(doubleBuffer, 0, 0, this);
	}
	
	
    public final void update(Graphics g){}


	public void loadTexture(){
		textures = new texture[51];
		clearScreen();
		
   
        String imageFolder = "Image/";
        
		try {
			//textures[0] = new texture(ImageIO.read(getClass().getResource(imageFolder + "0.jpg")), 9, 8);
			textures[1] = new texture(ImageIO.read(getClass().getResource(imageFolder + "1.jpg")), 9, 9);
			textures[2] = new texture(ImageIO.read(getClass().getResource(imageFolder + "2.jpg")), 8, 8);
			textures[3] = new texture(ImageIO.read(getClass().getResource(imageFolder + "3.jpg")), 8, 4);
			textures[4] = new texture(ImageIO.read(getClass().getResource(imageFolder + "4.jpg")), 8, 8);
			textures[5] = new texture(ImageIO.read(getClass().getResource(imageFolder + "5.jpg")), 1, 1);
			textures[6] = new texture(ImageIO.read(getClass().getResource(imageFolder + "6.jpg")), 1, 1);
			textures[7] = new texture(ImageIO.read(getClass().getResource(imageFolder + "7.jpg")), 1, 1);
			textures[8] = new texture(ImageIO.read(getClass().getResource(imageFolder + "8.jpg")), 1, 1);
			textures[9] = new texture(ImageIO.read(getClass().getResource(imageFolder + "9.jpg")), 1, 1);
			textures[10] = new texture(ImageIO.read(getClass().getResource(imageFolder + "10.jpg")), 1, 1);
			textures[11] = new texture(ImageIO.read(getClass().getResource(imageFolder + "11.jpg")), 7, 7);
			textures[12] = new texture(ImageIO.read(getClass().getResource(imageFolder + "12.jpg")), 7, 7);
			textures[13] = new texture(ImageIO.read(getClass().getResource(imageFolder + "13.jpg")), 6, 6);
			textures[14] = new texture(ImageIO.read(getClass().getResource(imageFolder + "14.jpg")), 8, 8);
			//textures[15] = new texture(ImageIO.read(getClass().getResource(imageFolder + "15.gif")), 9, 8);
			textures[16] = new texture(ImageIO.read(getClass().getResource(imageFolder + "sky2.jpg")), 9, 9);
			textures[17] = new texture(ImageIO.read(getClass().getResource(imageFolder + "sky3.jpg")), 9, 9);
			textures[18] = new texture(ImageIO.read(getClass().getResource(imageFolder + "sky4.jpg")), 9, 9);
			textures[19] = new texture(ImageIO.read(getClass().getResource(imageFolder + "sky5.jpg")), 9, 9);
			textures[20] = new texture(ImageIO.read(getClass().getResource(imageFolder + "sky1.jpg")), 9, 9);
			textures[21] = new texture(ImageIO.read(getClass().getResource(imageFolder + "sky6.jpg")), 9, 9);
			textures[22] = new texture(ImageIO.read(getClass().getResource(imageFolder + "22.jpg")), 8, 8);
			textures[23] = new texture(ImageIO.read(getClass().getResource(imageFolder + "23.jpg")), 8, 8);
			textures[24] = new texture(ImageIO.read(getClass().getResource(imageFolder + "24.jpg")), 8, 8);
			textures[25] = new texture(ImageIO.read(getClass().getResource(imageFolder + "25.jpg")), 8, 8);
			textures[26] = new texture(ImageIO.read(getClass().getResource(imageFolder + "26.jpg")), 8, 8);
			textures[27] = new texture(ImageIO.read(getClass().getResource(imageFolder + "27.jpg")), 8, 8);
			textures[28] = new texture(ImageIO.read(getClass().getResource(imageFolder + "28.jpg")), 8, 8);
			textures[29] = new texture(ImageIO.read(getClass().getResource(imageFolder + "29.jpg")), 8, 8);
			textures[30] = new texture(ImageIO.read(getClass().getResource(imageFolder + "30.jpg")), 7, 4);
			textures[31] = new texture(ImageIO.read(getClass().getResource(imageFolder + "31.jpg")), 4, 4);
			textures[32] = new texture(ImageIO.read(getClass().getResource(imageFolder + "32.jpg")), 7, 7);
			textures[33] = new texture(ImageIO.read(getClass().getResource(imageFolder + "33.jpg")), 7, 7);
			textures[34] = new texture(ImageIO.read(getClass().getResource(imageFolder + "34.jpg")), 8, 7);
			textures[35] = new texture(ImageIO.read(getClass().getResource(imageFolder + "35.jpg")), 8, 7);
			textures[36] = new texture(ImageIO.read(getClass().getResource(imageFolder + "36.jpg")), 6, 6);
			textures[37] = new texture(ImageIO.read(getClass().getResource(imageFolder + "37.jpg")), 6, 6);
			textures[38] = new texture(ImageIO.read(getClass().getResource(imageFolder + "38.jpg")), 6, 6);
			textures[39] = new texture(ImageIO.read(getClass().getResource(imageFolder + "39.jpg")), 6, 6);
			textures[40] = new texture(ImageIO.read(getClass().getResource(imageFolder + "40.jpg")), 6, 6);
			textures[41] = new texture(ImageIO.read(getClass().getResource(imageFolder + "41.jpg")), 8, 8);
			textures[42] = new texture(ImageIO.read(getClass().getResource(imageFolder + "42.jpg")), 8, 8);
			textures[43] = new texture(ImageIO.read(getClass().getResource(imageFolder + "43.jpg")), 9, 8);
			textures[44] = new texture(ImageIO.read(getClass().getResource(imageFolder + "44.jpg")), 1, 1);
			textures[45] = new texture(ImageIO.read(getClass().getResource(imageFolder + "45.jpg")), 8, 8);
			textures[46] = new texture(ImageIO.read(getClass().getResource(imageFolder + "46.jpg")), 6, 6);
			textures[47] = new texture(ImageIO.read(getClass().getResource(imageFolder + "47.jpg")), 6, 6);
			textures[48] = new texture(ImageIO.read(getClass().getResource(imageFolder + "48.jpg")), 8, 8);
			textures[49] = new texture(ImageIO.read(getClass().getResource(imageFolder + "49.jpg")), 8, 8);
			textures[50] = new texture(ImageIO.read(getClass().getResource(imageFolder + "50.jpg")), 1, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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