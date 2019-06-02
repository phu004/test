public class wall_W_A extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public wall_W_A(double x, double y, double z){
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
		double x = 0.5; double y = 31.5; double  z = 20;
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
		polygons = new polygon3D[4];
		vector[] t;

		t = new vector[]{put(0, 31.5, 0), put(0, 31.5, 20), put(0, 0, 20), put(0, 0, 0)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[3].scaleX = 2;
		polygons[3].scaleY = 2;
		polygons[3].ambient_I = -2;


		t = new vector[]{put(0, 0.5, 0.3), put(0, 0.5, 20.3), put(0.3, 0.5, 20.3), put(0.3, 0.5, 0.3)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[1].scaleX = 10;

		t = new vector[]{put(0.3, 0.5, 0.3), put(0.3, 0.5, 20.3), put(0.3, 0, 20.3), put(0.3, 0, 0.3)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[0].scaleX = 10;

		t = new vector[]{put(0.3, 0, 20.3), put(0.3, 0.5, 20.3), put(0, 0.5, 20.3), put(0, 0, 20.3)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[2].ambient_I = 5;

		for(int i = 0; i < 4; i++)
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