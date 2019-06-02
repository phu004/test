public class  stairUpper_B  extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public stairUpper_B(double x, double y, double z){
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
		double x = 4.5; double y = 30; double  z = 20;
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

		t = new vector[]{put(0, 9, 5.72), put(4.5, 9, 5.72), put(4.5, 9, 0), put(-0, 9, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[0].scaleY = 2;
		polygons[0].ambient_I = 3;

		double w = (20 - 5.69)/8;
		double h = (double)7.5/7;

		for(int i = 0; i < 7; i ++){
			if(i == 0)
				t = new vector[]{put(0, 9 + i*h, 5.7+i*w), put(0, 9 + i*h, 5.7+i*w + w*2), put(4.5, 9 + i*h, 5.7+i*w + w*2), put(4.5, 9 + i*h, 5.7+i*w)};
			else
				t = new vector[]{put(0, 9 + i*h, 5.7+i*w + w), put(0, 9 + i*h, 5.7+i*w + w*2), put(4.5, 9 + i*h, 5.7+i*w + w*2), put(4.5, 9 + i*h, 5.7+i*w + w)};
			polygons[1 + i] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
			polygons[1+ i].scaleY = 2;
			polygons[1 + i].ambient_I = 2;
		}

		for(int i = 0; i < 7; i ++){
			t = new vector[]{put(0, 9 + i*h, 5.7 + 2*w + i*w), put(0, 9 + i*h + h, 5.7 + 2*w + i*w), put(4.5, 9 + i*h + h, 5.7 + 2*w + i*w), put(4.5, 9 + i*h, 5.7 + 2*w + i*w)};
			polygons[8 + i] = new polygon3D(t, t[0],  t[1], t[3], house.textures[25]);
			polygons[8+ i].scaleY = 2;
			polygons[8 + i].ambient_I = 2;
		}

		t = new vector[]{put(4.5, 15, 20), put(0, 15, 20), put(0, 0, 20), put(4.5, 0, 20)};
		polygons[15] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[15].scaleY = 2;
		polygons[15].ambient_I = 3;

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