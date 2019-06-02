import java.awt.image.PixelGrabber;
import java.awt.*;


//only represents power of 2 textures
public class texture{
	public Image img;

	public int[] Texture_;

	public short[] Texture;

	public int height;

	public int width;

	public int heightMask;

	public int widthMask;

	public int widthBits;

	public int heightBits;

	public PixelGrabber pg;



	public texture(Image img, int widthBits , int heightBits){
		this.img = img;

		this.widthBits = widthBits;
		this.heightBits = heightBits;

		height = (int)Math.pow(2, heightBits);
		width = (int)Math.pow(2, widthBits);

		Texture = new short[width*height];

		Texture_ = new int[width*height];

		heightMask = height -1;
		widthMask = width - 1;

		PixelGrabber pg = new PixelGrabber(img, 0, 0, width, height, Texture_, 0, width);
		try {
			pg.grabPixels();
		}catch(Exception e){}

		double r, g, b;
		for(int i = 0; i < width*height; i ++){
			r = (Texture_[i] & 0x00ff0000)>>16;
			g = (Texture_[i] & 0x0000ff00)>>8;
			b = (Texture_[i] & 0x000000ff);
			r = r/8;
			g = g/8;
			b = b/8;
			Texture[i] = (short)((int)r <<10 | (int)g << 5 | (int)b);
		}

		Texture_ = null;
	}

	public texture(short[] Texture, int widthBits , int heightBits){
		this.Texture = Texture;

		this.widthBits = widthBits;
		this.heightBits = heightBits;

		height = (int)Math.pow(2, heightBits);
		width = (int)Math.pow(2, widthBits);

		heightMask = height -1;
		widthMask = width - 1;

	}

}