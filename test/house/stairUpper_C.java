public class  stairUpper_C  extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public stairUpper_C(double x, double y, double z){
		start = new vector(x,y,z);
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		this.start = start;
		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();

	}

	public void makeBoundary(){
		double x = 25.1; double y = 32; double  z = 9.69;
		boundary = new polygon3D[6];
		vector[] a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[37];
		vector[] t;

		t = new vector[]{put(0, 16.5, 0), put(0, 16.5, 10), put(25, 16.5, 10), put(25, 16.5, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[3], t[1], house.textures[1]);
		polygons[0].scaleX = 3;
		polygons[0].ambient_I = 6;

		t = new vector[]{put(0,16.5, 0), put(25, 16.5, 0), put(25,15, 0 ), put(0, 15, 0)};
		polygons[1] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[1].scaleY = 6;
		polygons[1].ambient_I = 6;

		t = new vector[]{put(25, 15, 0), put(25, 15, 10), put(0, 15, 10), put(0, 15, 0)};
		polygons[2] = new polygon3D(t, t[0],  t[3], t[1], house.textures[27]);
		polygons[2].scaleX = 5;
		polygons[2].scaleY = 2;
		polygons[2].ambient_I = 5;

		t = new vector[]{put(0, 21.05, 0), put(0, 21.4, 0), put(20, 21.4, 0), put(20, 21.05, 0)};
		polygons[3] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[3].scaleX = 6;
		polygons[3].scaleY = 0.2;
		polygons[3].ambient_I = 7;

		t = new vector[]{put(0,21.4, 0), put(0,21.4,0.5), put(20.5, 21.4, 0.5), put(20.5, 21.4, 0)};
		polygons[4] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[4].scaleX = 6;
		polygons[4].scaleY = 0.2;
		polygons[4].ambient_I = 7;

		t = new vector[]{put(20.5, 21.05, -0.05), put(20.5, 21.05, 0.5), put(0,21.05,0.5) ,put(0,21.05, -0.05)};
		polygons[5] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[5].scaleX = 6;
		polygons[5].scaleY = 0.2;

		t = new vector[]{put(20.5, 21.05, 0.5), put(20.5, 21.4, 0.5), put(0, 21.4, 0.5), put(0, 21.05, 0.5)};
		polygons[6] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[6].scaleX = 6;
		polygons[6].scaleY = 0.2;
		polygons[6].ambient_I = 5;

		t = new vector[]{put(20.5,21.4, 0), put(20.5, 21.4, 0.5), put(20.5, 21.05, 0.5), put(20.5, 21.05, 0)};
		polygons[7] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[7].ambient_I = 3;

		t = new vector[]{put(0, 21.05, 0), put(0, 21.05, 0.5), put(0, 21.4, 0.5), put(0,21.4, 0)};
		polygons[8] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[8].ambient_I = 3;


		for(int i = 0; i < 7; i ++){
			t = new vector[]{put(2, 21.04, 0.1), put(2.3, 21.04, 0.1), put(2.3, 16.51, 0.1), put(2, 16.51, 0.1)};
			polygons[9+i*4] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
			polygons[9+i*4].scaleY = 0.2;
			polygons[9].ambient_I = 3;

			t = new vector[]{ put(2.3, 16.51, 0.1),put(2.3, 21.04, 0.1), put(2.3, 21.04, 0.4),put(2.3, 16.51, 0.4)};
			polygons[10 + i*4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
			polygons[10 + i*4].scaleY = 0.2;
			polygons[10 + i*4].ambient_I = 3;

			t = new vector[]{ put(2, 16.51, 0.4), put(2, 21.04, 0.4),put(2, 21.04, 0.1),put(2, 16.51, 0.1)};
			polygons[11+ i*4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
			polygons[11+ i*4].scaleY = 0.2;
			polygons[11].ambient_I = 3;

			t = new vector[]{put(2, 16.51, 0.4), put(2.3, 16.51, 0.4), put(2.3, 21.04, 0.4), put(2, 21.04, 0.4)};
			polygons[12 + i*4] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
			polygons[12 + i*4].scaleY = 0.2;
			polygons[12 + i*4].ambient_I = 3;
			start.add(2.7, 0,0);
		}

		for(int i = 0; i < 37;i++)
				polygons[i].setLightSource( LightSource.s1);


	}

	public vector put(double i, double j, double k){
		vector temp = new vector(0,0,0);
		temp.set(start);
		temp.add(iDirection, i);
		temp.add(jDirection, j);
		temp.add(kDirection, k);
		return temp;
	}
}