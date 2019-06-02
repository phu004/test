
public class door_F extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;

	public door_F(double x, double y, double z){
		start = new vector(x,y,z);

		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);
		
		iDirection.rotate_XZ(Math.PI/2);
		jDirection.rotate_XZ(Math.PI/2);
		kDirection.rotate_XZ(Math.PI/2);

		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
	}
	
	public void makeBoundary(){
		double x = 5; double y = 12; double  z = 2;
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
		polygons = new polygon3D[21];
		vector[] t;
		
		t = new vector[]{put(0, 7, 1.6), put(5, 7, 1.6), put(5, 0, 1.6), put(0, 0, 1.6)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[0].ambient_I = 13;

		t = new vector[]{put(0, 0, 2), put(5, 0, 2), put(5, 7, 2), put(0, 7, 2)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[1].ambient_I = 4;

		t = new vector[]{put(0, 11, 1.6), put(1, 11, 1.6), put(1, 6.98, 1.6), put(0, 6.98, 1.6)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		polygons[2].scaleX = 0.2;
		//polygons[2].ambient_I = 14;

		t = new vector[]{put(4, 11, 1.6), put(5, 11, 1.6), put(5, 6.98, 1.6), put(4, 6.98, 1.6)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		polygons[3].scaleX = 0.2;
		//polygons[3].ambient_I = 14;

		t = new vector[]{put(0, 6.98, 2), put(1, 6.98, 2), put(1, 11, 2), put(0, 11, 2)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		polygons[4].scaleX = 0.2;
		//polygons[4].ambient_I = 2;

		t = new vector[]{put(4, 6.98, 2), put(5, 6.98, 2), put(5, 11, 2), put(4, 11, 2)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		polygons[5].scaleX = 0.2;
		//polygons[5].ambient_I = 1;

		t = new vector[]{put(0, 12, 1.6), put(5, 12, 1.6), put(5, 10.99, 1.6), put(0, 10.99, 1.6)};
		polygons[6] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		polygons[6].scaleY = 0.1;
		//polygons[6].ambient_I = 14;

		t = new vector[]{put(0, 10.99, 2), put(5, 10.99, 2), put(5, 12, 2) ,put(0, 12, 2)};
		polygons[7] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		polygons[7].scaleY = 0.1;
		//polygons[7].ambient_I = -1;

		t = new vector[]{put(1.3, 7.3, 1.75), put(3.7, 7.3, 1.75), put(4, 6.99, 1.6), put(1, 6.99, 1.6)};
		polygons[8] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[8].ambient_I = 13;

		t = new vector[]{put(1.3, 7.3, 1.75), put(1, 6.99, 1.6), put(1, 11, 1.6), put(1.3, 10.7, 1.75)};
		polygons[9] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[9].ambient_I = 10;

		t = new vector[]{put(1.3, 10.7, 1.75), put(1, 11, 1.6), put(4, 11, 1.6), put(3.7, 10.7, 1.75)};
		polygons[10] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[10].ambient_I = 8;

		t = new vector[]{put(3.7, 10.7, 1.75), put(4, 11, 1.6), put(4, 6.99, 1.6), put(3.7, 7.3, 1.75)};
		polygons[11] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[11].ambient_I = 10;


		t = new vector[]{put(1, 6.99, 2), put(4, 6.99, 2), put(3.7, 7.3, 1.85), put(1.3, 7.3, 1.85)};
		polygons[12] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[12].ambient_I = 5;

		t = new vector[]{put(1.3, 10.7, 1.85), put(1, 11, 2), put(1, 6.99, 2), put(1.3, 7.3, 1.85)};
		polygons[13] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[13].ambient_I = 3;

		t = new vector[]{put(3.7, 10.7, 1.85), put(4, 11, 2), put(1, 11, 2), put(1.3, 10.7, 1.85)};
		polygons[14] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[14].ambient_I = -2;

		t = new vector[]{put(3.7, 7.3, 1.85), put(4, 6.99, 2), put(4, 11, 2), put(3.7, 10.7, 1.85)};
		polygons[15] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		//polygons[15].ambient_I = 3;

		t = new vector[]{put(1.3, 10.7, 1.75), put(3.7, 10.7, 1.75), put(3.7, 7.3, 1.75), put(1.3, 7.3, 1.75)};
		polygons[16] = new polygon3D(t, t[0], t[3], t[1], gameData.glass1);
		polygons[16].type = 2;
		polygons[16].scaleY = 1;
		polygons[16].scaleX = 20;
		modelBuilder.world.addTransparentPolygon(polygons[16]);

		t = new vector[]{put(1.3, 7.3, 1.85), put(3.7, 7.3, 1.85), put(3.7, 10.7, 1.85), put(1.3, 10.7, 1.85)};
		polygons[17] = new polygon3D(t, t[0], t[3], t[1], gameData.glass1);
		polygons[17].type = 2;
		polygons[17].scaleY = 1;
		polygons[17].scaleX = 20;
		modelBuilder.world.addTransparentPolygon(polygons[17]);

		t = new vector[]{put(0, 12, 2), put(5, 12, 2), put(5, 12, 1.6), put(0, 12, 1.6)};
		polygons[18] = new polygon3D(t, t[0],  t[1], t[3], house.textures[26]);
		
		t = new vector[]{put(5, 12, 1.6), put(5, 12, 2), put(5, 0, 2), put(5, 0, 1.6)};
		polygons[19] = new polygon3D(t, t[0],  t[3], t[1], house.textures[26]);
		
		t = new vector[]{put(0, 0, 1.59), put(0, 0, 2), put(0, 12, 2), put(0, 12, 1.59)};
		polygons[20] = new polygon3D(t, t[0],  t[3], t[1], house.textures[26]);
		
		for(int i = 0; i < 21; i++){
			polygons[i].ambient_I = 4;
			polygons[i].setLightSource( LightSource.s6);
		}
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
