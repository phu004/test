
public class bathRoom_Upper extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	
	public bathRoom_Upper(double x, double y, double z){
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
		double x = 11; double y = 11; double  z = 7;
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
		polygons = new polygon3D[14];
		vector[] t;
		
		t = new vector[]{put(10.3, 11, 0), put(10.3, 11, 7), put(10.3, 0, 7), put(10.3, 0, 0)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		polygons[0].ambient_I = 6;
		
		t = new vector[]{put(9.8, 0, 0), put(9.8, 0, 7), put(9.8, 11, 7), put(9.8, 11, 0)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		polygons[1].ambient_I = 2;
		
		t = new vector[]{put(10.3, 11, 7), put(9.8, 11, 7), put(9.8, 0, 7), put(10.3, 0, 7)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		polygons[2].ambient_I = 12;
		
		t = new vector[]{put(10.3, 11, 0), put(9.8, 11, 0), put(9.8, 11, 7), put(10.3, 11, 7)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		polygons[3].ambient_I = 12;
		
		t = new vector[]{put(9.8, 11, 6.8), put(0, 11, 6.8), put(0, 10.6, 6.8), put(9.8, 10.6, 6.8)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		polygons[4].ambient_I = 12;
		
		t = new vector[]{put(9.8, 10.6, 6.3), put(0, 10.6, 6.3), put(0, 11, 6.3), put(9.8, 11, 6.3)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		polygons[5].ambient_I = -2;
		
		t = new vector[]{put(9.8,11,6.3), put(0,11,6.3), put(0,11,6.8) ,put(9.8,11,6.8)};
		polygons[6] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		polygons[6].ambient_I = 12;
		
		t = new vector[]{put(9.8,10.6,6.8), put(0,10.6,6.8), put(0,10.6,6.3) ,put(9.8,10.6,6.3)};
		polygons[7] = new polygon3D(t, t[0],  t[1], t[3], house.textures[49]);
		polygons[7].ambient_I = 0;
		
		t = new vector[]{put(4.9, 10.6, 6.5), put(0, 10.6, 6.5), put(0, 0, 6.5), put(4.9, 0, 6.5)};
		polygons[8] = new polygon3D(t, t[0], t[3], t[1], gameData.glass2);
		polygons[8].type = 4;
		modelBuilder.world.addTransparentPolygon(polygons[8]);
		
		t = new vector[]{put(4.9, 0, 6.4), put(0, 0, 6.4), put(0, 10.6, 6.4), put(4.9, 10.6, 6.4)};
		polygons[9] = new polygon3D(t, t[0], t[3], t[1], gameData.glass2);
		polygons[9].type = 4;
		modelBuilder.world.addTransparentPolygon(polygons[9]);
		
		t = new vector[]{put(4.9, 10.6, 6.5), put(4.9, 0, 6.5), put(4.9, 0, 6.4), put(4.9, 10.6, 6.4)};
		polygons[10] = new polygon3D(t, t[0],  t[1], t[3], house.textures[50]);
		polygons[10].ambient_I = 2;
		
		t = new vector[]{put(9.8, 10.6, 6.7), put(4.7, 10.6, 6.7), put(4.7, 0, 6.7), put(9.8, 0, 6.7)};
		polygons[11] = new polygon3D(t, t[0], t[3], t[1], gameData.glass2);
		polygons[11].type = 4;
		modelBuilder.world.addTransparentPolygon(polygons[11]);
		
		t = new vector[]{put(9.8, 0, 6.6), put(4.5, 0, 6.6), put(4.5, 10.6, 6.6), put(9.8, 10.6, 6.6)};
		polygons[12] = new polygon3D(t, t[0], t[3], t[1], gameData.glass2);
		polygons[12].type = 4;
		modelBuilder.world.addTransparentPolygon(polygons[12]);
		
		t = new vector[]{put(4.7, 10.6, 6.7), put(4.7, 10.6, 6.6), put(4.7, 0, 6.6), put(4.7, 0, 6.7)};
		polygons[13] = new polygon3D(t, t[0],  t[1], t[3], house.textures[50]);
		polygons[13].ambient_I = 8;
		
		for(int i = 0; i <14; i++)
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
