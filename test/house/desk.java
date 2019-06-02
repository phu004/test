public class desk extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;


	public desk(double x, double y, double z){
		start = new vector(x,y,z);

		iDirection = new vector(0.75,0,0);
		jDirection = new vector(0,0.75,0);
		kDirection = new vector(0,0,0.75);

		this.start = start;
		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();

	}

	public void makeBoundary(){
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(0,0,0), put(0, 0, 5), put(0,6, 5), put(0, 6,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(0,0,0), put(0, 6, 0), put(10,6, 0), put(10, 0,0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(10,6,0), put(10, 6, 5), put(10,0, 5), put(10, 0,0)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(10,6,5), put(0, 6, 5), put(0,0, 5), put(10, 0,5)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(10,6,5), put(10, 6, 0), put(0,6, 0), put(0, 6,5)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(0,0,0), put(10, 0, 0), put(10,0, 5), put(0, 0,5)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[22];
		vector[] t;

		//desktop
		t = new vector[]{put(0,6,0), put(0, 6, 5), put(10,6, 5), put(10, 6,0)};
		polygons[0] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);
		polygons[0].scaleY= 2;

		t = new vector[]{put(0,6,0.03), put(10, 6,0.03), put(10.25, 5.8, -0.25), put(-0.25, 5.8, -0.25)};
		polygons[1] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);

		t = new vector[]{put(0.03, 6, 5), put(0.03,6,0), put(-0.25, 5.8, -0.25), put(-0.25, 5.8, 5.25)};
		polygons[2] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);

		t = new vector[]{put(10.25, 5.8, 5.25), put(10.25, 5.8, -0.25), put(9.97,6,0), put(9.97, 6, 5)};
		polygons[3] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);

		t = new vector[]{put(-0.25, 5.8, 5.25), put(10.25, 5.8, 5.25), put(10, 6,4.97), put(0,6,4.97)};
		polygons[4] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);

		t = new vector[]{put(-0.25, 5.8, -0.25), put(10.25, 5.8, -0.25), put(10.25, 5.8, 5.25), put(-0.25, 5.8, 5.25)};
		polygons[5] = new polygon3D(t, t[1], t[2], t[0], house.textures[28]);
		polygons[5].scaleY = 2;


		//leg 1
		t = new vector[]{put(0,0,5), put(0, 5.8, 5), put(0, 5.8, 0), put(0, 0, 0)};
		polygons[6] = new polygon3D(t, t[1], t[2], t[0], house.textures[28]);

		t = new vector[]{put(0.25, 0, 0), put(0.25, 5.8, 0), put(0.25, 5.8, 5), put(0.25,0,5)};
		polygons[7] = new polygon3D(t, t[1], t[2], t[0], house.textures[28]);

		t = new vector[]{put(0, 5.8, 0), put(0.25, 5.8, 0), put(0.25, 0, 0), put(0,0,0)};
		polygons[8] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);
		polygons[8].scaleX = 0.1;

		t = new vector[]{put(0,0,5), put(0.25, 0, 5), put(0.25, 5.8, 5),  put(0, 5.8, 5)};
		polygons[9] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);
		polygons[9].scaleX = 0.1;

		//leg 2
		t = new vector[]{put(9.75,0,5), put(9.75, 5.8, 5), put(9.75, 5.8, 0), put(9.75, 0, 0)};
		polygons[10] = new polygon3D(t, t[1], t[2], t[0], house.textures[28]);

		t = new vector[]{put(10, 0, 0), put(10, 5.8, 0), put(10, 5.8, 5), put(10,0,5)};
		polygons[11] = new polygon3D(t, t[1], t[2], t[0], house.textures[28]);

		t = new vector[]{put(9.75, 5.8, 0), put(10, 5.8, 0), put(10, 0, 0), put(9.75,0,0)};
		polygons[12] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);
		polygons[12].scaleX = 0.1;

		t = new vector[]{put(9.75,0,5), put(10, 0, 5), put(10, 5.8, 5),  put(9.75, 5.8, 5)};
		polygons[13] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);
		polygons[13].scaleX = 0.1;

		//leg 3
		t = new vector[]{put(7,0,5), put(7, 5.8, 5), put(7, 5.8, 0), put(7, 0, 0)};
		polygons[14] = new polygon3D(t, t[1], t[2], t[0], house.textures[28]);

		t = new vector[]{put(7.25, 0, 0), put(7.25, 5.8, 0), put(7.25, 5.8, 5), put(7.25,0,5)};
		polygons[15] = new polygon3D(t, t[1], t[2], t[0], house.textures[28]);

		t = new vector[]{put(7, 5.8, 0), put(7.25, 5.8, 0), put(7.25, 0, 0), put(7,0,0)};
		polygons[16] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);
		polygons[16].scaleX = 0.1;

		t = new vector[]{put(7,0,5), put(7.25, 0, 5), put(7.25, 5.8, 5),  put(7, 5.8, 5)};
		polygons[17] = new polygon3D(t, t[0], t[1], t[3], house.textures[28]);
		polygons[17].scaleX = 0.1;

		//leg 4
		t = new vector[]{put(7.26, 1.5, 0), put(7.26, 1.5, 5), put(9.74, 1.5, 5), put(9.74, 1.5, 0)};
		polygons[18] = new polygon3D(t, t[1], t[0], t[2], house.textures[28]);

		t = new vector[]{put(9.74, 1.3, 0), put(9.74, 1.3, 5), put(7.26, 1.3, 5), put(7.26, 1.3, 0)};
		polygons[19] = new polygon3D(t, t[1], t[0], t[2], house.textures[28]);

		t = new vector[]{put(7.26, 1.52, 0), put(9.74, 1.52, 0), put(9.74, 1.3, 0), put(7.26, 1.3, 0)};
		polygons[20] = new polygon3D(t, t[1], t[0], t[2], house.textures[28]);
		polygons[20].scaleY = 0.1;

		t = new vector[]{put(7.26, 1.3, 5), put(9.74, 1.3, 5), put(9.74, 1.52, 5), put(7.26, 1.52, 5)};
		polygons[21] = new polygon3D(t, t[1], t[0], t[2], house.textures[28]);
		polygons[21].scaleY = 0.1;

		for(int i = 0; i < 22; i++){
			polygons[i].ambient_I = 4;
			polygons[i].setLightSource( LightSource.s3);
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