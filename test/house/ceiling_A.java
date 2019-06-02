public class ceiling_A extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public ceiling_A(double x, double y, double z){
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
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(25, 0, -0.2),  put(25, 0, 30), put(-0.2, 0, 30), put(-0.2, 0, -0.2)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(25, 0, -0.2),  put(25, 0, 30), put(-0.2, 0, 30), put(-0.2, 0, -0.2)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(25, 0, -0.2),  put(25, 0, 30), put(-0.2, 0, 30), put(-0.2, 0, -0.2)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(25, 0, -0.2),  put(25, 0, 30), put(-0.2, 0, 30), put(-0.2, 0, -0.2)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(25, 0, -0.2),  put(25, 0, 30), put(-0.2, 0, 30), put(-0.2, 0, -0.2)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(25, 0, -0.2),  put(25, 0, 30), put(-0.2, 0, 30), put(-0.2, 0, -0.2)};
		boundary[5] = new polygon3D(f, null, null, null, null);

	}

	public void makePolygons(){
		polygons = new polygon3D[1];
		vector[] t;

		t = new vector[]{put(25.1, 0, 0), put(25.1, 0, 30), put(-0.1, 0, 30), put(-0.1, 0, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[4]);
		polygons[0].scaleX = 4;
		polygons[0].scaleY = 3;
		polygons[0].ambient_I = -4;


		for(int i = 0; i < 1; i++)
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