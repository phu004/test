public class wall_S_A extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;


	public wall_S_A(double x, double y, double z){
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
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(25, 31.5, 0), put(0, 31.5, 0), put(0, 0, 0), put(25, 0, 0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(25, 31.5, 0), put(0, 31.5, 0), put(0, 0, 0), put(25, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(25, 31.5, 0), put(0, 31.5, 0), put(0, 0, 0), put(25, 0, 0)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(25, 31.5, 0), put(0, 31.5, 0), put(0, 0, 0), put(25, 0, 0)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(25, 31.5, 0), put(0, 31.5, 0), put(0, 0, 0), put(25, 0, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(25, 31.5, 0), put(0, 31.5, 0), put(0, 0, 0), put(25, 0, 0)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[20];
		vector[] t;

		t = new vector[]{put(5, 0, 0.3), put(5, 12, 0.3), put(4.5, 12, 0.3), put(4.5, 0, 0.3)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[0].scaleX = 5;


		t = new vector[]{put(10.5, 0, 0.3), put(10.5, 12, 0.3), put(10, 12, 0.3), put(10, 0, 0.3)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[1].scaleX = 5;

		t = new vector[]{put(10.5, 12.5, 0.3), put(4.5, 12.5, 0.3), put(4.5, 12, 0.3), put(10.5, 12, 0.3)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[2].scaleX = 5;
		polygons[2].ambient_I = -2;

		t = new vector[]{put(4.5, 12.5, 0.3), put(10.5, 12.5, 0.3), put(10.5, 12.5, 0), put(4.5, 12.5, 0)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[3].scaleX = 5;
		polygons[3].ambient_I = 2;

		t = new vector[]{put(10.5, 12.5, 0), put(10.5, 12.5, 0.3), put(10.5, 0.5, 0.3), put(10.5, 0.5, 0)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[4].scaleY = 5;
		polygons[4].ambient_I = 4;

		t = new vector[]{put(4.5, 0.5, 0), put(4.5, 0.5, 0.3), put(4.5, 12.5, 0.3), put(4.5, 12.5, 0)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[5].scaleY = 5;
		polygons[5].ambient_I = 8;

		t = new vector[]{put(5, 12, 0), put(5, 12, 0.3), put(5, 0, 0.3), put(5, 0, 0)};
		polygons[6] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[6].scaleY = 5;

		t = new vector[]{put(10, 0, 0), put(10, 0, 0.3), put(10, 12, 0.3), put(10, 12, 0)};
		polygons[7] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[7].scaleY = 5;
		polygons[7].ambient_I = 4;


		t = new vector[]{put(5, 12, 0), put(10, 12, 0), put(10, 12, 0.3), put(5, 12, 0.3)};
		polygons[8] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[8].scaleX = 5;
		polygons[8].ambient_I = 2;


		t = new vector[]{put(0, 0.5, 0.3), put(4.5, 0.5, 0.3), put(4.5, 0.5, 0), put(0, 0.5, 0)};
		polygons[9] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[9].scaleX = 2;

		t = new vector[]{put(4.5, 0.5, 0.3), put(0, 0.5, 0.3), put(0, 0, 0.3), put(4.5, 0, 0.3)};
		polygons[10] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[10].scaleX = 2;

		t = new vector[]{put(10.5, 0.5, 0.3), put(15, 0.5, 0.3), put(15, 0.5, 0), put(10.5, 0.5, 0)};
		polygons[11] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[11].scaleX = 2;


		t = new vector[]{put(15, 0.5, 0.3), put(10.5, 0.5, 0.3), put(10.5, 0, 0.3), put(15, 0, 0.3)};
		polygons[12] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[12].scaleX = 2;

		t = new vector[]{put(4.9,16, 0), put(0,16, 0), put(0,0, 0), put(4.9,0, 0)};
		polygons[13] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[13].scaleX = 0.5;

		t = new vector[]{put(25,16, 0), put(10.1,16, 0), put(10.1,0, 0), put(25,0, 0)};
		polygons[14] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[14].scaleX = 1.5;

		t = new vector[]{put(10.1,16, 0), put(4.9,16, 0), put(4.9,12, 0), put(10.1,12, 0)};
		polygons[15] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[15].scaleX = 0.5;
		polygons[15].scaleY = 0.25;
		polygons[15].ambient_I = -3;

		t = new vector[]{put(25, 31.5, 0), put(17, 31.5, 0), put(17, 15.9, 0), put(25, 15.9, 0)};
		polygons[16] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[16].scaleX = 0.7;
		polygons[16].ambient_I = -1;

		t = new vector[]{put(8, 31.5, 0), put(0, 31.5, 0), put(0, 15.9, 0), put(8, 15.9, 0)};
		polygons[17] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[17].scaleX = 0.7;
		polygons[17].ambient_I = -2;

		t = new vector[]{put(17, 31.5, 0), put(8, 31.5,0), put(8, 27, 0), put(17, 27,0)};
		polygons[18] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[18].scaleX = 0.7;
		polygons[18].scaleY = 0.5;
		polygons[18].ambient_I = -1;

		t = new vector[]{put(17.1, 21, 0), put(8, 21,0), put(8, 15.9, 0), put(17.1, 15.9,0)};
		polygons[19] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[19].scaleX = 0.7;
		polygons[19].scaleY = 0.5;
		polygons[19].ambient_I = -4;

		for(int i = 0; i < 20; i++)
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
