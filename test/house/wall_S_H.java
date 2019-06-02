public class wall_S_H extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;

	public wall_S_H(double x, double y, double z){
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
		sortedPolygons = true;
	}

	public void makeBoundary(){
		double x = 50; double y = 15; double  z = 0.8;
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
		polygons = new polygon3D[19];
		vector[] t;

		t = new vector[]{put(9.5,12.5, 0.8), put(25.5,12.5, 0.8), put(25.5,12.5, 0.5), put(9.5,12.5, 0.5)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[0].ambient_I = 3;

		t = new vector[]{put(9.5, 12.5, 0.8), put(9.5, 12.5, 0.5), put(9.5, 0.5, 0.5), put(9.5, 0.5, 0.8)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[1].ambient_I = 3;

		t = new vector[]{put(25.5, 0.5, 0.8), put(25.5, 0.5, 0.5), put(25.5, 12.5, 0.5), put(25.5, 12.5, 0.8)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[2].ambient_I = 3;

		t = new vector[]{put(9.5, 12, 0.8), put(25.5, 12, 0.8), put(25.5, 12.5, 0.8), put(9.5, 12.5, 0.8)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[3].ambient_I = -2;

		t = new vector[]{put(9.5, 0, 0.8), put(10, 0, 0.8), put(10, 12, 0.8), put(9.5, 12, 0.8)};
		polygons[4] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);
		polygons[4].ambient_I = -1;
		polygons[4].scaleX = 4;

		t = new vector[]{put(25, 0, 0.8), put(25.5, 0, 0.8), put(25.5, 12, 0.8), put(25, 12, 0.8)};
		polygons[5] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);
		polygons[5].ambient_I = -1;
		polygons[5].scaleX = 4;

		t = new vector[]{put(10, 12, 0.5), put(25, 12, 0.5), put(25, 12, 0.81), put(10, 12, 0.81)};
		polygons[6] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);
		polygons[6].ambient_I = -1;

		t = new vector[]{put(10, 12, 0.5), put(10, 12, 0.8), put(10, 0, 0.8), put(10, 0, 0.5)};
		polygons[7] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);

		t = new vector[]{put(25, 0, 0.5), put(25, 0, 0.8), put(25, 12, 0.8), put(25, 12, 0.5)};
		polygons[8] = new polygon3D(t, t[0],  t[3], t[1], house.textures[3]);



		t = new vector[]{put(0.3, 0, 0.8), put(9.51, 0, 0.8), put(9.51, 0.5, 0.8), put(0.3, 0.5, 0.8)};
		polygons[9] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[9].ambient_I = 1;


		t = new vector[]{put(25.5, 0, 0.8), put(49.7, 0, 0.8), put(49.7, 0.5, 0.8), put(25.5, 0.5, 0.8)};
		polygons[10] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[10].ambient_I = 1;

		t = new vector[]{put(0, 12.4, 0.5), put(50, 12.4, 0.5), put(50, 15, 0.5), put(0, 15, 0.5)};
		polygons[11] = new polygon3D(t, t[0],  t[1], t[3], house.textures[41]);
		polygons[11].scaleX = 8;
		polygons[11].scaleY = 0.5;
		polygons[11].ambient_I = -1;

		t = new vector[]{put(0, 0.5, 0.5), put(9.6, 0.5, 0.5), put(9.6, 12.45, 0.5), put(0, 12.45, 0.5)};
		polygons[12] = new polygon3D(t, t[0],  t[1], t[3], house.textures[41]);
		polygons[12].scaleX = 2;
		polygons[12].scaleY = 3;
		polygons[12].ambient_I = 1;

		t = new vector[]{put(25.4, 0.5, 0.5), put(50, 0.5, 0.5), put(50, 12.45, 0.5), put(25.4, 12.45, 0.5)};
		polygons[13] = new polygon3D(t, t[0],  t[1], t[3], house.textures[41]);
		polygons[13].scaleX = 4;
		polygons[13].scaleY = 3;
		polygons[13].ambient_I = 2;

		t = new vector[]{put(10, 12, -0.01), put(25, 12, -0.01), put(25, 12, 0.51), put(10, 12, 0.51)};
		polygons[14] = new polygon3D(t, t[0],  t[1], t[3], house.textures[41]);
		polygons[14].scaleX = 3;

		t = new vector[]{put(10, 12, -0.01), put(10, 12, 0.51), put(10, 0, 0.51), put(10, 0, -0.01)};
		polygons[15] = new polygon3D(t, t[0],  t[1], t[3], house.textures[41]);
		polygons[15].scaleY = 3;
		polygons[15].scaleX = 0.3;

		t = new vector[]{put(25, 0, -0.01), put(25, 0, 0.51), put(25, 12, 0.51), put(25, 12, -0.01)};
		polygons[16] = new polygon3D(t, t[0],  t[1], t[3], house.textures[41]);
		polygons[16].scaleY = 3;
		polygons[16].scaleX = 0.3;



		t = new vector[]{put(0, 0.5, 0.8), put(9.5, 0.5, 0.8), put(9.5, 0.5, 0.5), put(0, 0.5, 0.5)};
		polygons[17] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[17].ambient_I = -3;

		t = new vector[]{put(25.5, 0.5, 0.8), put(50, 0.5, 0.8), put(50, 0.5, 0.5), put(25.5, 0.5, 0.5)};
		polygons[18] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[18].ambient_I = -1;

		for(int i = 0; i < 19; i++)
			polygons[i].setLightSource( LightSource.s8);
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