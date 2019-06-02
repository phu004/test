public class  stairUpper_A  extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public stairUpper_A(double x, double y, double z){
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
		double x = 0.49; double y = 30; double  z = 20;
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
		polygons = new polygon3D[34];
		vector[] t;

		t = new vector[]{put(0, 0, 20), put(0, 16.5, 20), put(0, 9, 5.69), put(0, 7, 5.69), put(0, 0, 16.5)};
		polygons[0] = new polygon3D(t, t[4],  t[0], t[2], house.textures[25]);
		polygons[0].scaleX = 2;
		polygons[0].scaleY = 2;
		polygons[0].ambient_I = 2;

		t = new vector[]{put(0, 9, 5.69), put(0, 16.5, 20), put(0.5, 16.5, 20), put(0.5, 9, 5.69)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
		polygons[1].scaleX = 2;
		polygons[1].scaleY = 0.2;
		polygons[1].ambient_I = 2;

		t = new vector[]{put(0.5, 16.5, 20), put(0.5, 15,  20), put(0.5, 9, 9.5 ), put(0.5, 9, 5.69)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
		polygons[2].scaleX = 2;
		polygons[2].scaleY = 2;
		polygons[2].ambient_I = 2;

		t = new vector[]{put(-0.1, 9, 5.71), put(0.51, 9, 5.71), put(0.51, 9, 0), put(-0.1, 9, 0)};
		polygons[3] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[3].scaleY = 0.2;
		polygons[3].ambient_I = 2;

		vector temp = start.myClone();
		start .add(0, -0.015, 0);

		for(int i = 0; i < 6; i ++){
			t = new vector[]{put(0.1, 9.45, 6.5), put(0.1, 13.95, 6.5), put(0.4, 13.95, 6.5), put(0.4, 9.45, 6.5)};
			polygons[4+i*4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
			polygons[4+i*4].scaleX = 2;
			polygons[4+i*4].scaleY = 2;
			polygons[4+i*4].ambient_I = 2;

			t = new vector[]{put(0.4, 9.45, 6.5), put(0.4, 13.95, 6.5), put(0.4, 14.1, 6.8), put(0.4, 9.6, 6.8)};
			polygons[5+i*4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
			polygons[5+i*4].scaleY = 0.2;
			polygons[5+i*4].ambient_I = 2;

			t = new vector[]{put(0.1, 9.6, 6.8), put(0.1, 14.1, 6.8), put(0.1, 13.95, 6.5), put(0.1, 9.45, 6.5)};
			polygons[6+i*4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
			polygons[6+i*4].scaleY = 0.2;
			polygons[6+i*4].ambient_I = 2;

			t = new vector[]{put(0.4, 9.6, 6.8), put(0.4, 14.1, 6.8), put(0.1, 14.1, 6.8), put(0.1, 9.6, 6.8)};
			polygons[7+i*4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
			polygons[7+i*4].scaleY = 0.2;
			polygons[7+i*4].ambient_I = 2;

			start.add(0, 1.26, 2.4);
		}

		start = temp;

		t = new vector[]{put(0, 21.05, 20), put(0, 21.4, 20 ), put(0, 13.9, 5.7), put(0, 13.55, 5.7)};
		polygons[28] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[28].scaleY = 0.2;
		polygons[28].ambient_I = 2;

		t = new vector[]{put(0, 21.05, 20), put(0, 13.55, 5.7), put(0.5, 13.55, 5.7), put(0.5, 21.05, 20)};
		polygons[29] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[29].scaleY = 0.2;
		polygons[29].ambient_I = 2;

		t = new vector[]{put(0.5, 13.55, 5.7), put(0.5, 13.9, 5.7), put(0.5, 21.4, 20 ), put(0.5, 21.05, 20)};
		polygons[30] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[30].scaleY = 0.2;
		polygons[30].ambient_I = 2;

		t = new vector[]{put(0, 13.9, 5.7), put(0, 21.4, 20), put(0.5, 21.4, 20), put(0.5, 13.9, 5.7)};
		polygons[31] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
		polygons[31].scaleY = 0.2;
		polygons[31].ambient_I = 4;

		t = new vector[]{put(0, 13.9, 5.7),put(0.5, 13.9, 5.7), put(0.5, 13.55, 5.7), put(0, 13.55, 5.7)};
		polygons[32] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
		polygons[32].scaleY = 0.2;
		polygons[32].ambient_I = 4;

		t = new vector[]{put(0.5, 15, 20), put(0, 15, 20), put(0, 0, 20), put(0.5, 0, 20)};
		polygons[33] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[33].scaleY = 2;
		polygons[33].ambient_I = 3;


		for(int i = 0; i < 34; i++)
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
