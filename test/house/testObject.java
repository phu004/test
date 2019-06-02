public class testObject extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;
	public double x, y, z;

	public testObject(double x,  double y, double z, double w, double h, double l){
		start = new vector(x,y,z);
		this.x = w;
		this.y = h;
		this.z = l;
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
	}

	public void makeBoundary(){
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

		t = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		t = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		t = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		t = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		t = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		t = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
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