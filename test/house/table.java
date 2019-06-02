public class table extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;


	public table(double x, double y, double z){
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
		double x = 12; double y = 6; double  z = 5;
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
		polygons = new polygon3D[22];
		vector[] t;

		t = new vector[]{put(0, 4.55, 5.5), put(12, 4.55, 5.5), put(12, 4.55, 0), put(0,4.55, 0)};
		polygons[0] = new polygon3D(t, put(-0.03, 4.5, 5.5),  t[1], put(-0.03,4.5, 0), house.textures[14]);
		polygons[0].ambient_I = 5;
		polygons[0].scaleX = 0.99;


		t = new vector[]{put(0,4.25, 0), put(12, 4.25, 0), put(12, 4.25, 5.5), put(0, 4.25, 5.5)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[1].ambient_I = 7;
		

		t = new vector[]{put(0,4.55, 0), put(12,4.55, 0), put(12,4.25, 0), put(0,4.25, 0)};
		polygons[2] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[2].ambient_I = 11;
		polygons[2].scaleY = 0.1;

		t = new vector[]{put(0,4.25, 5.5), put(12,4.25, 5.5), put(12,4.55, 5.5), put(0,4.55, 5.5)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[3].ambient_I = 2;
		polygons[3].scaleY = 0.1;
		
		t = new vector[]{put(0, 4.55, 5.5), put(0, 4.55, 0), put(0, 4.25, 0), put(0, 4.25, 5.5)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[4].ambient_I = 14;
		polygons[4].scaleY = 0.1;
		
		t = new vector[]{put(12, 4.25, 5.5), put(12, 4.25, 0), put(12, 4.55, 0), put(12, 4.55, 5.5)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[5].ambient_I = 11;
		polygons[5].scaleY = 0.1;
		
		t = new vector[]{put(0.3, 4.249, 0.3), put(1, 4.249, 0.3), put(0.9, 0, 0.4), put(0.4, 0, 0.4)};
		polygons[6] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[6].ambient_I = 11;
		
		t = new vector[]{put(0.4, 0, 5.1), put(0.9, 0, 5.1), put(1, 4.249, 5.2), put(0.3, 4.249, 5.2)};
		polygons[7] = new polygon3D(t, t[2],  t[3], t[1], house.textures[14]);
		polygons[7].ambient_I = 11;
		
		t = new vector[]{put(11, 4.249, 0.3), put(11.7, 4.249, 0.3), put(11.6, 0, 0.4), put(11.1, 0, 0.4)};
		polygons[8] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[8].ambient_I = 11;
		
		t = new vector[]{put(11.1, 0, 5.1), put(11.6, 0, 5.1), put(11.7, 4.249, 5.2) ,put(11, 4.249, 5.2)};
		polygons[9] = new polygon3D(t, t[3],  t[2], t[0], house.textures[14]);
		polygons[9].ambient_I = 11;
		
		t = new vector[]{put(0.3, 4.249, 1), put(0.3, 4.249, 0.3), put(0.4, 0, 0.4), put(0.4, 0, 0.9)};
		polygons[10] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[10].ambient_I = 15;
		
		t = new vector[]{put(0.3, 4.249, 5.2), put(0.3, 4.249, 4.5), put(0.4, 0, 4.6), put(0.4, 0, 5.1)};
		polygons[11] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[11].ambient_I = 15;
		
		t = new vector[]{put(11.6, 0, 0.9), put(11.6, 0, 0.4), put(11.7, 4.249, 0.3) ,put(11.7, 4.249, 1)};
		polygons[12] = new polygon3D(t, t[2],  t[3], t[1], house.textures[14]);
		polygons[12].ambient_I = 15;
		
		t = new vector[]{put(11.6, 0, 5.1), put(11.6, 0, 4.6), put(11.7, 4.249, 4.5) ,put(11.7, 4.249, 5.2)};
		polygons[13] = new polygon3D(t, t[2],  t[3], t[1], house.textures[14]);
		polygons[13].ambient_I = 13;
		
		t = new vector[]{put(1, 4.249, 0.3), put(1, 4.249, 1), put(0.9, 0, 0.9), put(0.9, 0, 0.4)};
		polygons[14] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[14].ambient_I = 13;
		
		t = new vector[]{put(0.9, 0, 0.9), put(1, 4.249, 1), put(0.3, 4.249, 1), put(0.4, 0, 0.9)};
		polygons[15] = new polygon3D(t, t[1],  t[2], t[0], house.textures[14]);
		polygons[15].ambient_I = 13;
		
		t = new vector[]{put(1, 4.249, 4.5), put(1, 4.249, 5.2), put(0.9, 0, 5.1), put(0.9, 0, 4.6)};
		polygons[16] = new polygon3D(t, t[0],  t[1], t[3], house.textures[14]);
		polygons[16].ambient_I = 13;
		
		t = new vector[]{put(11.6, 0, 0.9), put(11.7, 4.249, 1), put(11, 4.249, 1), put(11.1, 0, 0.9)};
		polygons[17] = new polygon3D(t, t[1],  t[2], t[0], house.textures[14]);
		polygons[17].ambient_I = 13;
		
		t = new vector[]{put(0.3, 4.249, 4.5), put(1, 4.249, 4.5), put(0.9,0 , 4.6), put(0.4, 0 , 4.6)};
		polygons[18] = new polygon3D(t, t[1],  t[0], t[2], house.textures[14]);
		polygons[18].ambient_I = 13;
		
		t = new vector[]{put(11, 4.249, 4.5), put(11.7, 4.249, 4.5), put(11.6,0 , 4.6), put(11.1, 0 , 4.6)};
		polygons[19] = new polygon3D(t, t[1],  t[0], t[2], house.textures[14]);
		polygons[19].ambient_I = 11;
		
		t = new vector[]{put(11, 4.249, 5.2), put(11, 4.249, 4.5), put(11.1, 0, 4.6), put(11.1, 0, 5.1)};
		polygons[20] = new polygon3D(t, t[1],  t[0], t[2], house.textures[14]);
		polygons[20].ambient_I = 11;
		
		t = new vector[]{put(11, 4.249, 1), put(11, 4.249, 0.3), put(11.1, 0, 0.4), put(11.1, 0, 0.9)};
		polygons[21] = new polygon3D(t, t[1],  t[0], t[2], house.textures[14]);
		polygons[21].ambient_I = 11;
		
		for(int i = 0; i < 22; i++)
			polygons[i].setLightSource( LightSource.s8);
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