public class wall_S_J extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public wall_S_J(double x, double y, double z){
		start = new vector(x,y,z);
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
		sortedPolygons = true;
	
	}

	public void makeBoundary(){
		double x = 20; double y = 15; double  z = 0.3;
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

		t = new vector[]{put(20.1, 6, 0), put(0, 6, 0), put(0, 0.5, 0), put(20.1, 0.5, 0)};
		polygons[2] = new polygon3D(t, put(20, 5.57, 0),  put(0, 5.57, 0),  put(20, 0.07, 0), house.textures[48]);
		polygons[2].scaleX = 5;
		polygons[2].scaleY = 1.9;
		polygons[2].ambient_I = 10;
		
		t = new vector[]{put(20.1, 12, 0), put(18, 12, 0), put(18, 5.99, 0), put(20.1, 5.99, 0)};
		polygons[3] = new polygon3D(t, put(20, 12.9, 0),  put(17.9, 12.9, 0),  put(20, 6.19, 0), house.textures[48]);
		polygons[3].scaleX = 0.53;
		polygons[3].scaleY = 2.27;
		polygons[3].ambient_I = 10;
		
		t = new vector[]{put(13, 12, 0), put(0, 12, 0), put(0, 5.97, 0), put(13, 5.97, 0)};
		polygons[4] = new polygon3D(t, put(13, 12.83, 0),  put(0, 12.83, 0),  put(13, 6.8, 0), house.textures[48]);
		polygons[4].scaleX = 3.25;
		polygons[4].scaleY = 2.1;
		polygons[4].ambient_I = 10;
		
		t = new vector[]{put(20.1, 15, 0), put(0, 15, 0), put(0, 11.97, 0), put(20.1, 11.97, 0)};
		polygons[5] = new polygon3D(t, t[0],  t[1],  t[3], house.textures[48]);
		polygons[5].scaleX = 5;
		polygons[5].scaleY = 1.04;
		polygons[5].ambient_I = 10;
		
		

		t = new vector[]{put(11, 0.5, 0.3), put(11, 0, 0.3), put(19.7, 0, 0.3), put(19.7, 0.5, 0.3)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[47]);
		polygons[1].scaleX = 8;
		polygons[1].ambient_I = 5;

		t = new vector[]{put(11, 0.5, 0.3), put(20, 0.5, 0.3), put(20, 0.5, 0), put(11, 0.5, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[47]);
		polygons[0].scaleX = 8;
		polygons[0].ambient_I = 1;

		for(int i = 0; i < 6; i++)
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