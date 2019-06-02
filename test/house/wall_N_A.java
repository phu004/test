public class wall_N_A extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;

	public wall_N_A(double x, double y, double z){
		start = new vector(x,y,z);
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
		sortedPolygons = true;
	}

	public void makeBoundary(){
		double x = 25; double y = 14.9; double  z = 0.3;
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
		polygons = new polygon3D[16];
		vector[] t;

		t = new vector[]{put(4.5,12.5, 0.3), put(20.5,12.5, 0.3), put(20.5,12.5, 0), put(4.5,12.5, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[0].ambient_I = 2;

		t = new vector[]{put(4.5, 12.5, 0.3), put(4.5, 12.5, 0), put(4.5, 0.5, 0), put(4.5, 0.5, 0.3)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[1].ambient_I = 2;

		t = new vector[]{put(20.5, 0.5, 0.3), put(20.5, 0.5, 0), put(20.5, 12.5, 0), put(20.5, 12.5, 0.3)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[2].ambient_I = 2;

		t = new vector[]{put(4.5, 12.5, 0), put(20.5, 12.5, 0), put(20.5, 12, 0), put(4.5, 12, 0)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[3].ambient_I = -2;

		t = new vector[]{put(4.5, 12, 0), put(5, 12, 0), put(5, 0, 0), put(4.5, 0, 0)};
		polygons[4] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);
		polygons[4].ambient_I = -1;
		polygons[4].scaleX = 4;

		t = new vector[]{put(20, 12, 0), put(20.5, 12, 0), put(20.5, 0, 0), put(20, 0, 0)};
		polygons[5] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);
		polygons[5].ambient_I = -1;
		polygons[5].scaleX = 4;

		t = new vector[]{put(5, 12, -0.01), put(20, 12, -0.01), put(20, 12, 0.3), put(5, 12, 0.3)};
		polygons[6] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);
		polygons[6].ambient_I = -1;

		t = new vector[]{put(5, 12, 0), put(5, 12, 0.3), put(5, 0, 0.3), put(5, 0, 0)};
		polygons[7] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);

		t = new vector[]{put(20, 0, 0), put(20, 0, 0.3), put(20, 12, 0.3), put(20, 12, 0)};
		polygons[8] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);


		t = new vector[]{put(0, 0.5, 0.3), put(4.5, 0.5, 0.3), put(4.5, 0.5, 0), put(0, 0.5, 0)};
		polygons[9] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[9].ambient_I = -3;

		t = new vector[]{put(20.5, 0.5, 0.3), put(25, 0.5, 0.3), put(25, 0.5, 0), put(20.5, 0.5, 0)};
		polygons[10] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[10].ambient_I = -3;

		t = new vector[]{put(0, 0.5, 0), put(4.5, 0.5, 0), put(4.5, 0, 0), put(0, 0, 0)};
		polygons[11] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);


		t = new vector[]{put(20.5, 0.5, 0), put(25, 0.5, 0), put(25, 0, 0), put(20.5, 0, 0)};
		polygons[12] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);

		t = new vector[]{put(0, 15, 0.3), put(25, 15, 0.3), put(25, 12.4, 0.3), put(0, 12.4, 0.3)};
		polygons[13] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[13].scaleX = 3;
		polygons[13].scaleY = 0.3;
		polygons[13].ambient_I = -5;

		t = new vector[]{put(0, 12.41, 0.3), put(4.6, 12.41, 0.3), put(4.6, 0.5, 0.3), put(0, 0.5, 0.3)};
		polygons[14] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[14].scaleX = 0.5;
		polygons[14].ambient_I = -4;

		t = new vector[]{put(20.4, 12.41, 0.3), put(25, 12.41, 0.3), put(25, 0.5, 0.3), put(20.4, 0.5, 0.3)};
		polygons[15] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[15].scaleX = 0.5;
		polygons[15].ambient_I = -3;
		
		for(int i = 0; i < 16; i++)
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