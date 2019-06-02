public class wall_N_B extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public wall_N_B(double x, double y, double z){
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
		double x = 24.5; double y = 15; double  z = 0.3;
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

		int index;

		t = new vector[]{put(17, 12.5, 0.3), put(23, 12.5, 0.3), put(23, 12.5, 0), put(17, 12.5, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[0].ambient_I = 5;

		t = new vector[]{put(17.5, 12.5, 0), put(17.5, 0, 0), put(17, 0, 0), put(17, 12.5, 0)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[1].scaleX = 5;
		polygons[1].ambient_I = 5;

		t = new vector[]{put(23, 12.5, 0), put(23, 0, 0), put(22.5, 0, 0), put(22.5, 12.5, 0)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[2].scaleX = 5;
		polygons[2].ambient_I = 5;

		t = new vector[]{put(17.5, 12.5, 0), put(22.5, 12.5, 0), put(22.5, 12, 0), put(17.5, 12, 0)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[3].scaleX = 2;
		polygons[3].ambient_I = 5;

		t = new vector[]{put(17.5, 12, 0.3), put(17.5, 0, 0.3), put(17.5, 0, 0), put(17.5, 12, 0)};
		polygons[6] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[6].scaleX = 5;
		polygons[6].ambient_I = 5;

		t = new vector[]{put(22.5, 12, 0), put(22.5, 0, 0), put(22.5, 0, 0.3), put(22.5, 12, 0.3)};
		polygons[7] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[7].scaleX = 5;
		polygons[7].ambient_I = 5;

		t = new vector[]{put(17, 12.5, 0), put(17, 0.5, 0), put(17, 0.5, 0.3), put(17, 12.5, 0.3)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[4].scaleX = 5;
		polygons[4].ambient_I = 5;

		t = new vector[]{put(23, 12.5, 0.3), put(23, 0.5, 0.3), put(23, 0.5, 0), put(23, 12.5, 0)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[5].scaleX = 5;
		polygons[5].ambient_I = 5;

		t = new vector[]{put(17.5, 12, 0), put(22.5, 12, 0), put(22.5, 11.95, 0.3), put(17.5, 11.95, 0.3)};
		polygons[8] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[8].scaleX = 5;
		polygons[8].ambient_I = 5;

		t = new vector[]{put(22.9, 0.5, 0), put(24.5, 0.5, 0), put(24.5, 0, 0), put(22.9, 0, 0)};
		polygons[9] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);

		t = new vector[]{put(24.5, 0.5, 0), put(22.9, 0.5, 0), put(22.9, 0.5, 0.3), put(24.5, 0.5, 0.3)};
		polygons[10] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);

		t = new vector[]{put(0, 0.5, 0), put(17, 0.5, 0), put(17, 0, 0), put(0, 0, 0)};
		polygons[11] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[11].scaleX = 5;

		t = new vector[]{put(17, 0.5, 0), put(0, 0.5, 0), put(0, 0.5, 0.3), put(17, 0.5, 0.3)};
		polygons[12] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[12].scaleX = 5;

		index = 13;

		t = new vector[]{put(0,15.01, 0.3), put(24.5,15.01, 0.3), put(24.5,12, 0.3), put(0,12, 0.3)};
		polygons[0+index] = new polygon3D(t, t[0],  t[1], t[3], house.textures[29]);
		polygons[0+index].scaleX = 5;
		polygons[0+index].scaleY = 1;

		t = new vector[]{put(0,12.1, 0.3), put(17.47,12.1, 0.3), put(17.47,0, 0.3), put(0,0, 0.3)};
		polygons[1+index] = new polygon3D(t, t[0],  t[1], t[3], house.textures[29]);
		polygons[1+index].scaleX = 4;
		polygons[1+index].scaleY = 4;

		t = new vector[]{put(22.53,12.1, 0.3), put(24.5,12.1, 0.3), put(24.5,0, 0.3), put(22.53,0, 0.3)};
		polygons[2+index] = new polygon3D(t, t[0],  t[1], t[3], house.textures[29]);
		polygons[2+index].scaleX = 0.4;
		polygons[2+index].scaleY = 0.3;


		for(int i = 0; i < 16; i++)
			polygons[i].setLightSource( LightSource.s3);
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