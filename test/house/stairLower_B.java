public class  stairLower_B extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public stairLower_B(double x, double y, double z){
		start = new vector(x,y,z);
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		this.start = start;

		vector temp = start.myClone();
		start .add(0.5,  0, 0);

		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		start = temp;

		makePolygons();
	}

	public void makeBoundary(){
		double x = 4.49; double y = 30; double  z = 20;
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
		polygons = new polygon3D[18];
		vector[] t;



		for(int i = 0; i < 9; i ++){
			t = new vector[]{put(0.51, i, 18.5 - i*1.6), put(4.99,  i, 18.5 - i*1.6), put(4.99,  i+1, 18.5 - i*1.6), put(0.51, i+1, 18.5 - i*1.6)};
			polygons[0+i] = new polygon3D(t, t[3],  t[0], t[2], house.textures[25]);
			polygons[0+i].scaleX = 2;
			polygons[0+i].scaleY = 2;
			polygons[0+i].ambient_I = 2;

		}

		for(int i = 0; i < 8; i++){
			t = new vector[]{put(0.51, i+1, 18.5 - i*1.6), put(4.99,  i+1, 18.5 - i*1.6), put(4.99,  i+1, 18.5 - i*1.6 -1.6), put(0.51, i+1, 18.5 - i*1.6 - 1.6)};
			polygons[9+i] = new polygon3D(t, t[3],  t[0], t[2], house.textures[25]);
			polygons[9+i].scaleX = 2;
			polygons[9+i].scaleY = 2;
			polygons[9+i].ambient_I = 2;
		}

		t = new vector[]{put(4.99, 9, 5.7), put(4.99, 9, 0), put(0.51, 9, 0), put(0.51, 9, 5.7)};
		polygons[17] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[17].scaleX = 1;
		polygons[17].scaleY = 2;
		polygons[17].ambient_I = 2;

		for(int i = 0; i < 18; i++)
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