public class  stairLower_A  extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public stairLower_A(double x, double y, double z){
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
		vector temp = start.myClone();
		start.add(-4, 0,0);
		double x = 4.49; double y = 30; double  z = 20;
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
		start = temp;
	}

	public void makePolygons(){
		polygons = new polygon3D[49];
		vector[] t;

		t = new vector[]{put(0, 0, 20), put(0, 1, 20), put(0, 9.5, 5), put(0,0,5)};
		polygons[0] = new polygon3D(t, t[3],  t[0], t[2], house.textures[25]);
		polygons[0].scaleX = 2;
		polygons[0].scaleY = 2;
		polygons[0].ambient_I = 2;

		t = new vector[]{put(0,0.5,5.01), put(0, 9.5, 5.01), put(0, 9.5, 0),  put(0, 0.5, 0)};
		polygons[1] = new polygon3D(t, t[0],  t[3], t[1], house.textures[25]);
		polygons[1].scaleY = 2;
		polygons[1].ambient_I = 2;

		t = new vector[]{put(0,0, 5.01), put(0, 0.51, 5.01), put(0, 0.51, 0.3),  put(0, 0, 0.3)};
		polygons[2] = new polygon3D(t, t[3],  t[0], t[2], house.textures[25]);
		polygons[2].scaleY = 0.1;
		polygons[2].ambient_I = 2;

		t = new vector[]{put(0.5,0,5), put(0.5, 9.5, 5), put(0.5, 1, 20), put(0.5, 0, 20)};
		polygons[3] = new polygon3D(t, t[3],  t[0], t[2], house.textures[25]);
		polygons[3].scaleX = 2;
		polygons[3].scaleY = 2;
		polygons[3].ambient_I = 2;

		t  = new vector[]{put(0, 9.5, 5), put(0, 1, 20), put(0.5, 1, 20), put(0.5, 9.5, 5)};
		polygons[4] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[4].scaleX = 12;
		polygons[4].scaleY = 0.3;
		polygons[4].ambient_I = 2;

		t = new vector[]{put(0, 1, 20), put(0, 0, 20), put(0.5, 0, 20), put(0.5, 1, 20) };
		polygons[5] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[5].scaleX = 12;
		polygons[5].scaleY = 0.3;
		polygons[5].ambient_I = 2;


		t = new vector[]{put(0.5, 9.5,  0), put(0.5, 9.5, 5), put(0.5, 8.5, 5), put(0.5, 8.5, 0)};
		polygons[7] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[7].scaleX = 1;
		polygons[7].scaleY = 2;
		polygons[7].ambient_I = 2;

		t = new vector[]{put(0.5, 9.5, 0),  put(0, 9.5, 0), put(0, 9.5, 5), put(0.5, 9.5, 5)};
		polygons[32] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[32].scaleX = 1;
		polygons[32].scaleY = 2;
		polygons[32].ambient_I = 2;


		vector temp = start.myClone();
		for(int i = 0; i < 6; i ++){
			t = new vector[]{put(0.4,  6, 19), put(0.1, 6, 19), put(0.1, 1.56, 19), put(0.4, 1.56, 19)};
			polygons[8 + i*4] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
			polygons[8 + i*4].scaleY = 2;
			polygons[8 + i*4].ambient_I = 2;

			t = new vector[]{put(0.1, 1.55, 19), put(0.1, 6, 19), put(0.1, 6.15, 18.7), put(0.1, 1.75, 18.7)};
			polygons[9 + i*4] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
			polygons[9 + i*4].scaleY = 0.2;
			polygons[9 + i*4].ambient_I = 2;

			t = new vector[]{put(0.4, 1.75, 18.7), put(0.4, 6.15, 18.7), put(0.4, 6, 19) ,put(0.4, 1.55, 19)};
			polygons[10 + i*4] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
			polygons[10 + i*4].scaleY = 0.2;
			polygons[10 + i*4].ambient_I = 2;

			t = new vector[]{put(0.1, 1.75, 18.7), put(0.1, 6.15, 18.7), put(0.4, 6.15, 18.7), put(0.4, 1.75, 18.7)};
			polygons[11 + i*4] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
			polygons[11 + i*4].scaleY = 0.2;
			polygons[11 + i*4].ambient_I = 2;

			start.add(0, 1.36,- 2.4);
		}

		start = temp;

		temp = start.myClone();

	 	start.add(0,0,-14.5);

		t = new vector[]{put(0.4,  14.25, 19), put(0.1, 14.25, 19), put(0.1, 9.5, 19), put(0.4, 9.5, 19)};
		polygons[33] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[33].scaleY = 2;
		polygons[33].ambient_I = 2;

		t = new vector[]{put(0.1, 9.5, 19), put(0.1, 14.25, 19), put(0.1, 14.25, 18.7), put(0.1, 9.5, 18.7)};
		polygons[34] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[34].scaleY = 0.2;
		polygons[34].ambient_I = 2;

		t = new vector[]{put(0.4, 9.5, 18.7), put(0.4, 14.25, 18.7), put(0.4, 14.25, 19) ,put(0.4, 9.5, 19)};
		polygons[35] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[35].scaleY = 0.2;
		polygons[35].ambient_I = 2;

		t = new vector[]{put(0.1, 9.5, 18.7), put(0.1, 14.25, 18.7), put(0.4, 14.25, 18.7), put(0.4, 9.5, 18.7)};
		polygons[36] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[36].scaleY = 0.2;
		polygons[36].ambient_I = 2;

		start.add(0,0, -2.5);

		t = new vector[]{put(0.4,  14.25, 19), put(0.1, 14.25, 19), put(0.1, 9.5, 19), put(0.4, 9.5, 19)};
		polygons[37] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[37].scaleY = 2;
		polygons[37].ambient_I = 2;

		t = new vector[]{put(0.1, 9.5, 19), put(0.1, 14.25, 19), put(0.1, 14.25, 18.7), put(0.1, 9.5, 18.7)};
		polygons[38] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[38].scaleY = 0.2;
		polygons[38].ambient_I = 2;

		t = new vector[]{put(0.4, 9.5, 18.7), put(0.4, 14.25, 18.7), put(0.4, 14.25, 19) ,put(0.4, 9.5, 19)};
		polygons[39] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[39].scaleY = 0.2;
		polygons[39].ambient_I = 2;

		t = new vector[]{put(0.1, 9.5, 18.7), put(0.1, 14.25, 18.7), put(0.4, 14.25, 18.7), put(0.4, 9.5, 18.7)};
		polygons[6] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[6].scaleY = 0.2;
		polygons[6].ambient_I = 2;

		start = temp;


		t = new vector[]{put(0, 14.25, 4.5), put(0,14.6, 4.5), put(0, 14.6, 0), put(0, 14.25, 0)};
		polygons[40] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[40].scaleY = 0.2;
		polygons[40].ambient_I = 2;

		t = new vector[]{put(0.5, 14.25, 0), put(0.5, 14.6, 0), put(0.5,14.6, 4.5), put(0.5, 14.25, 4.5)};
		polygons[41] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[41].scaleY = 0.2;
		polygons[41].ambient_I = 2;

		t = new vector[]{put(0, 14.6, 0), put(0,14.6, 4.5), put(0.5,14.6, 4.5), put(0.5, 14.6, 0)};
		polygons[42] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[42].scaleY = 0.2;
		polygons[42].ambient_I = 2;

		t = new vector[]{put(0.5, 14.25, 0), put(0.5,14.25, 4.5), put(0,14.25, 4.5), put(0, 14.25, 0)};
		polygons[43] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[43].scaleY = 0.2;
		polygons[43].ambient_I = 2;

		t = new vector[]{put(0, 14.6, 4.5), put(0, 14.25, 4.5), put(0, 5.45, 20), put(0, 5.8, 20)};
		polygons[44] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[44].scaleY = 0.2;
		polygons[44].ambient_I = 2;

		t = new vector[]{put(0, 5.45, 20), put(0, 14.25, 4.5), put(0.5, 14.25, 4.5), put(0.5, 5.45, 20)};
		polygons[45] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[45].scaleY = 0.2;
		polygons[45].ambient_I = 2;

		t = new vector[]{put(0.5, 5.8, 20), put(0.5, 5.45, 20), put(0.5, 14.25, 4.5), put(0.5, 14.6, 4.5)};
		polygons[46] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[46].scaleY = 0.2;
		polygons[46].ambient_I = 2;

		t = new vector[]{put(0, 14.6, 4.5), put(0, 5.8, 20), put(0.5, 5.8, 20), put(0.5, 14.6, 4.5)};
		polygons[47] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[47].scaleY = 0.2;
		polygons[47].ambient_I = 2;

		t = new vector[]{put(0, 5.8, 20), put(0, 5.45, 20), put(0.5, 5.45, 20), put(0.5, 5.8, 20)};
		polygons[48] = new polygon3D(t, t[3],  t[2], t[0], house.textures[25]);
		polygons[48].scaleY = 0.2;
		polygons[48].ambient_I = 2;

		for(int i = 0; i < 49; i++)
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