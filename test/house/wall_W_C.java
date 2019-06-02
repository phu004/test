public class wall_W_C extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public wall_W_C(double x, double y, double z){
		start = new vector(x,y,z);
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		iDirection.rotate_XZ(Math.PI);
		jDirection.rotate_XZ(Math.PI);
		kDirection.rotate_XZ(Math.PI);

		this.start = start;
		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
		
		code = "B";
	}

	public void makeBoundary(){
		double x = 7; double y = 15; double  z = 10;
		boundary = new polygon3D[6];
		vector[] a = new vector[]{ put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[3];
		vector[] t;

		t = new vector[]{put(-0.5, 15, 10), put(-0.5, 15, 0), put(-0.5, 0, 0), put(-0.5, 0, 10)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[2]);
		polygons[2].scaleX = 1;
		polygons[2].scaleY = 2;
		polygons[2].ambient_I = -3;

		t = new vector[]{put(-0.5, 0.5, 10), put(-0.5, 0.5,0), put(-0.8, 0.5, 0), put(-0.8, 0.5, 10)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[1].scaleX = 3;
		polygons[1].ambient_I = 1;

		t = new vector[]{put(-0.8, 0.5, 10), put(-0.8, 0.5, 0), put(-0.8, 0, 0), put(-0.8, 0, 10)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[0].scaleX = 3;
		polygons[0].ambient_I = -3;

		for(int i = 0; i < 3; i++)
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