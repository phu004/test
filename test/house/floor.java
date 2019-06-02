public class floor extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public floor(double x, double y, double z){
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
		code = "B";
	}

	public void makeBoundary(){
		double x = 70; double y = 1.99; double  z = 70;
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
		polygons = new polygon3D[7];
		vector[] t;

		t = new vector[]{put(25, 2,  40), put(50, 2, 40), put(50, 2, 10), put(25, 2, 10)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[1]);
		polygons[1].scaleX = 2.5;
		polygons[1].scaleY = 3;
		polygons[1].ambient_I = -2;

		t = new vector[]{put(0, 2,  40), put(25, 2, 40), put(25, 2, 30), put(0, 2, 30)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[1]);
		polygons[0].scaleX = 2.5;
		polygons[0].scaleY = 1;
		polygons[0].ambient_I = 2;

		t = new vector[]{put(50, 2,  40), put(70, 2, 40), put(70, 2, 30), put(50, 2, 30)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[1]);
		polygons[2].scaleX = 2.5;
		polygons[2].scaleY = 1;
		polygons[2].ambient_I = 2;

		t = new vector[]{put(0, 2, 30), put(25, 2, 30), put(25, 2, 10), put(0, 2, 10)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[22]);
		polygons[3].scaleX = 6;
		polygons[3].scaleY = 8;
		polygons[3].ambient_I = -2;

		t = new vector[]{put(0, 2, 60), put(20, 2, 60), put(20, 2, 40), put(0, 2, 40)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[22]);
		polygons[4].scaleX = 6;
		polygons[4].scaleY = 8;
		polygons[4].ambient_I = 2;

		t = new vector[]{put(20,  2, 60), put(70, 2, 60), put(70, 2, 40), put(20, 2, 40)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[23]);
		polygons[5].scaleX = 20;
		polygons[5].scaleY = 8;
		polygons[5].ambient_I = 4;

		t = new vector[]{put(50, 2, 30), put(70, 2, 30), put(70, 2, 10), put(50, 2, 10)};
		polygons[6] = new polygon3D(t, t[0],  t[1], t[3], house.textures[24]);
		polygons[6].scaleX = 3;
		polygons[6].scaleY = 4;
		polygons[6].ambient_I = 1;

		for(int i = 0; i < 7; i++)
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