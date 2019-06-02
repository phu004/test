import java.awt.*;

public class gameData{
	public static int[] screenTable;
	public static int[][] colorTable;
	public static texture glass1, glass2;
	public static short[] randomNumber;

	public static void makeData(){
		screenTable = new int[480];

		for(int i = 0; i < 480; i++)
			screenTable[i] = 640*i;

		int[][] colorTable_ = new int[32768][32];
		colorTable = new int[32][32768];
		double ambient = (double)(LightSource.ambient)/100;

		double r, g, b, dr, dg, db;
		int r_, g_, b_;

		for(int i = 0; i < 32768; i++){
			r = (double)((i & 31744) >> 10) * ambient * 8;
			g = (double)((i & 992) >> 5) * ambient * 8;
			b = (double)((i & 31)) * ambient * 8;

			dr = r*0.1;
			dg = g*0.1;
			db = b*0.1;

			for(int j = 0; j < 32; j++){
				r_ = (int)(r+dr*j);
				g_ = (int)(g+dg*j);
				b_ = (int)(b+db*j);
				if(r_ > 255)
					r_ = 255;
				if(g_ > 255)
					g_ = 255;
				if(b_ > 255)
					b_ = 255;
				colorTable_[i][j] = b_ + (g_<<8)+ (r_<<16);
					dr*=1.05; dg*=1.05; db*=1.05;
			}
		}
		for(int i = 0; i < 32; i++){
			for(int j = 0; j <32768; j++ )
				colorTable[i][j] = colorTable_[j][i];
		}
		 colorTable_ = null;


		short[] glass_1 = new short[16384];
		for(int j = 0; j < 128; j++){
			for(int k = 0; k < 128; k++)
				glass_1[j*128 + k] = (short)(Math.sin(Math.PI/64*k)*10);
		}
		glass1 = new texture(glass_1, 7, 7);
		
		randomNumber = new short[4096];
		for(int i = 0; i < randomNumber.length; i++){
			randomNumber[i] = (short)((int)(Math.random()*6) + (int)(Math.random()*6)*8);
		}

		glass2 = new texture(randomNumber, 6, 6);
		

	}

	public static void update(){

	}


}