
public class bathRoom_lower extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	
	public bathRoom_lower(double x, double y, double z){
		start = new vector(x,y,z);
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
		double x = 11; double y = 0.8; double  z = 7;
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
		polygons = new polygon3D[5];
		vector[] t;
		
		t = new vector[]{put(0, 0.8, 7), put(10.5, 0.8, 7), put(10.5, 0.8, 0), put(0, 0.8, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		
		t = new vector[]{put(10.5, 0.8, 0), put(10.5, 0.8, 0.3), put(10.5, 0.5, 0.3), put(10.5, 0.5, 0)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		
		t = new vector[]{put(10.5, 0.8, 0.3), put(10.5, 0.8, 7), put(10.5, 0, 7), put(10.5, 0, 0.3)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		
		t = new vector[]{put(10.5, 0.8, 7), put(0.3, 0.8, 7), put(0.3, 0, 7), put(10.5, 0, 7)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		
		t = new vector[]{put(0.3, 0.8, 7), put(0.0, 0.8, 7), put(0.0, 0.5, 7), put(0.3, 0.5, 7)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		
		for(int i = 0; i < 5; i++)
			polygons[i].setLightSource( LightSource.s11);
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
