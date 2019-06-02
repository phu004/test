public class wall_N_F extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public wall_N_F(double x, double y, double z){
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
		double x = 19.5; double y = 15; double  z = 1;
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
		polygons = new polygon3D[6];
		vector[] t;

		t = new vector[]{put(0.3, 0.5, 0.5), put(19.2, 0.5, 0.5), put(19.2, 0.5, 0.2), put(0.3, 0.5, 0.2)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[0].scaleX = 5;
		polygons[0].ambient_I = -1;

		t = new vector[]{put(0.3, 0.5, 0.2), put(19.2, 0.5, 0.2), put(19.2, 0, 0.2), put(0.3, 0, 0.2)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[1].scaleX = 5;
		polygons[1].ambient_I = -1;

		t = new vector[]{put(0, 6, 0.5), put(19.5, 6, 0.5), put(19.5, 0.49, 0.5), put(0, 0.49, 0.5)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[29]);
		polygons[2].scaleX = 4;
		polygons[2].scaleY = 2;
		polygons[2].ambient_I = 5;

		t = new vector[]{put(0, 15, 0.5), put(19.5, 15, 0.5), put(19.5, 12, 0.5), put(0, 12, 0.5)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[29]);
		polygons[3].scaleX = 4;
		polygons[3].scaleY = 0.9;
		polygons[3].ambient_I = 5;

		t = new vector[]{put(0, 12.1, 0.5), put(6, 12.1, 0.5), put(6, 5.9, 0.5), put(0, 5.9, 0.5)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[29]);
		polygons[4].scaleX = 1.27;
		polygons[4].scaleY = 2;
		polygons[4].ambient_I = 5;

		t = new vector[]{put(14, 12.1, 0.5), put(19.5, 12.1, 0.5), put(19.5, 5.9, 0.5), put(14, 5.9, 0.5)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[29]);
		polygons[5].scaleX = 1.27;
		polygons[5].scaleY = 2;
		polygons[5].ambient_I = 5;

		for(int i = 0; i < 6; i++)
			polygons[i].setLightSource( LightSource.s6);

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