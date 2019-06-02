

public class storage_ extends solidObject{
	
	public vector start;
	public vector iDirection, jDirection, kDirection;
	
	public storage_(double x, double y, double z){
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
		double x = 5; double y = 6; double  z = 20;
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
		polygons = new polygon3D[2];
		vector[] t;
		
		start = put(3, 0,0);
		
		t = new vector[]{put(-20, 0, 0), put(-20, 0, 0.5), put(-20, 12, 0.5), put(-20, 12, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[41]);
		polygons[0].scaleY = 3;
		polygons[0].scaleX = 0.3;
		polygons[0].setLightSource( LightSource.s8);
		
		t = new vector[]{put(-20, 0, 0.5), put(-20, 0, 0.8), put(-20, 12, 0.8), put(-20, 12, 0.5)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[3]);
		polygons[1].scaleY = 3;
		polygons[1].scaleX = 0.3;
		polygons[1].setLightSource( LightSource.s8);
		
	
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
