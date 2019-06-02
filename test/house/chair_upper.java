public class chair_upper extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector tempi, tempj, tempk;
	public double angle;

	public chair_upper(double x, double y, double z, double angle){
		start = new vector(x,y,z);
		tempi = new vector(0,0,0);
		tempj = new vector(0,0,0);
		tempk = new vector(0,0,0);
		this.angle = angle;

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
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(-2.5, 0.1, -2.5), put(-2.5, 5, -2.5), put(2.5, 3, -2.5), put(2.5, 0.1, -2.5)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(2.5, 3, -2.5), put(2.5, 3, 2.5), put(2.5, 0.1, 2.5), put(2.5, 0.1, -2.5)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(2.5, 3, 2.5), put(-2.5, 3, 2.5), put(-2.5, 0.1, 2.5), put(2.5, 0.1, 2.5)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(-2.5, 3, 2.5), put(-2.5, 3, -2.5), put(-2.5, 0.1, -2.5), put(-2.5, 0.1, 2.5)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(-2.5, 3, -2.5), put(-2.5, 3, 2.5), put(2.5, 3, 2.5), put(2.5, 3, -2.5)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(2.5, 0.1, -2.5), put(2.5, 0.1, 2.5),put(-2.5, 0.1, 2.5), put(-2.5, 0.1, -2.5)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		start.y -=0.2;

		iDirection.rotate_XZ(Math.PI);
		kDirection.rotate_XZ(Math.PI);

		polygons = new polygon3D[29];
		vector[] t;

		t = new vector[]{put(-1.8, 0.01, -1.8), put(-1.6, 0.01, -2),  put(1.6, 0.01, -2), put(1.8, 0.01, -1.8),  put(1.5, 0.01, 1.8), put(1.3, 0.01, 2), put(-1.3, 0.01, 2), put(-1.5, 0.01, 1.8)};
		polygons[0] = new polygon3D(t, put(1.5, 0.01, 2), put(1.8, 0.01, -2), put(-1.5, 0.01, 2), house.textures[30]);
		polygons[0].scaleX = 4;
		polygons[0].scaleY = 4;


		t = new vector[]{put(-1.5, 0.25, 1.8), put(-1.3, 0.25, 2), put(1.3, 0.25, 2), put(1.5, 0.25, 1.8), put(1.8, 0.25, -1.8), put(1.6, 0.25, -2), put(-1.6, 0.25, -2), put(-1.8, 0.25, -1.8)};
		polygons[1] = new polygon3D(t, put(1.8, 0.21, 2), put(1.8, 0.21, -2), put(-1.8, 0.21, 2), house.textures[32]);
		polygons[1].scaleX = 5;
		polygons[1].scaleY = 5;


		t = new vector[]{put(-1.5, 0., 1.8), put(-1.3, 0, 2), put(-1.3, 0.26, 2), put(-1.5, 0.26, 1.8)};
		polygons[2] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[2].scaleX = 0.5;

		t = new vector[]{put(1.3, 0.26, 2), put(-1.3, 0.26, 2), put(-1.3, 0, 2), put(1.3, 0, 2)};
		polygons[3] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[3].scaleY = 5;
		polygons[3].scaleX = 0.5;

		t = new vector[]{put(1.5, 0.26, 1.8), put(1.3, 0.26, 2), put(1.3, 0, 2), put(1.5, 0, 1.8)};
		polygons[4] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[4].scaleX = 0.5;

		t = new vector[]{put(1.8, 0.26, -1.8), put(1.5, 0.26, 1.8), put(1.5, 0, 1.8), put(1.8, 0, -1.8)};
		polygons[5] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[5].scaleY = 5;
		polygons[5].scaleX = 0.5;

		t = new vector[]{put(1.6, 0.26, -2), put(1.8, 0.26, -1.8), put(1.8, 0, -1.8), put(1.6, 0, -2)};
		polygons[6] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[6].scaleX = 0.5;

		t = new vector[]{put(-1.6, 0.26, -2), put(1.6, 0.26, -2), put(1.6, 0, -2), put(-1.6, 0, -2) };
		polygons[7] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[7].scaleY = 5;
		polygons[7].scaleX = 0.5;

		t = new vector[]{put(-1.8, 0.26, -1.8), put(-1.6, 0.26, -2), put(-1.6, 0, -2), put(-1.8, 0, -1.8)};
		polygons[8] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[8].scaleX = 0.5;

		t = new vector[]{put(-1.5, 0.26, 1.8), put(-1.8, 0.26, -1.8), put(-1.8, 0, -1.8), put(-1.5, 0, 1.8)};
		polygons[9] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[9].scaleY = 5;
		polygons[9].scaleX = 0.5;

		iDirection.rotate_XZ(Math.PI);
		kDirection.rotate_XZ(Math.PI);

		t = new vector[]{put(-0.2, 0, -2), put(-0.2, 0.7, -2.5), put(0.2, 0.7, -2.5), put(0.2, 0, -2)};
		polygons[10] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);

		t = new vector[]{put(-0.21, 0.249, -2), put(0.21, 0.249, -2), put(0.21, 0.7, -2.3), put(-0.21, 0.7, -2.3)};
		polygons[11] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);

		t = new vector[]{put(-0.18, 0.26, -2.01),put(-0.18, 0.7, -2.3), put(-0.18, 0.7, -2.5), put(-0.18, 0, -2.01)};
		polygons[12] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);


		t = new vector[]{put(0.18, 0, -2.01), put(0.18, 0.7, -2.5),put(0.18, 0.7, -2.3), put(0.18, 0.26, -2.01)};
		polygons[13] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);

		t = new vector[]{put(-0.2, 2, -2.5), put(0.2, 2, -2.5), put(0.2, 0.7, -2.5), put(-0.2, 0.7, -2.5)};
		polygons[14] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);

		t = new vector[]{put(0.18, 0.7, -2.5), put(0.18, 2, -2.5), put(0.18, 2, -2.3), put(0.18, 0.7, -2.3)};
		polygons[15] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);

		t = new vector[]{put(-0.18, 0.7, -2.3), put(-0.18, 2, -2.3), put(-0.18, 2, -2.5), put(-0.18, 0.7, -2.5)};
		polygons[16] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);

		t = new vector[]{put(-0.2, 0.69, -2.3), put(0.2, 0.67, -2.3), put(0.2, 1.3, -2.3), put(-0.2, 1.3, -2.3)};
		polygons[17] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);

		t = new vector[]{put(0.2, 2, -2.31), put(0.2, 2, -2.5), put(-0.2, 2, -2.5), put(-0.2, 2, -2.31)};
		polygons[18] = new polygon3D(t,t[0], t[1], t[3], house.textures[30]);


		t = new vector[]{put(-1.6, 3.2, -2.28),  put(-1.4, 3.4, -2.28),  put(1.4, 3.4, -2.28), put(1.6, 3.2, -2.28), put(1.6, 1.5, -2.28), put(1.4, 1.3, -2.28), put(-1.4, 1.3, -2.28), put(-1.6, 1.5, -2.28)};
		polygons[19] = new polygon3D(t, put(-2, 3.4, -2.3), put(-2, 1, -2.3), put(2, 3.4, -2.3), house.textures[32]);
		polygons[19].scaleX = 5;
		polygons[19].scaleY = 5;

		t = new vector[]{put(-1.6, 1.5, -2.09), put(-1.4, 1.3, -2.09), put(1.4, 1.3, -2.08), put(1.6, 1.5, -2.09), put(1.6, 3.2, -2.09),  put(1.4, 3.4, -2.09),  put(-1.4, 3.4, -2.09), put(-1.6, 3.2, -2.09)};
		polygons[20] = new polygon3D(t, put(2, 3.4, -2.08), put(-2, 3.4, -2.08), put(2, 1, -2.08), house.textures[32]);
		polygons[20].scaleX = 5;
		polygons[20].scaleY = 5;

		t = new vector[]{put(-1.6, 1.5, -2.28), put(-1.4, 1.3, -2.28), put(-1.4, 1.3, -2.08), put(-1.6, 1.5, -2.08)};
		polygons[21] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[21].scaleX = 0.5;

		t = new vector[]{put(-1.4, 1.3, -2.28), put(1.4, 1.3, -2.28), put(1.4, 1.3, -2.08), put(-1.4, 1.3, -2.08)};
		polygons[22] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[22].scaleY = 5;
		polygons[22].scaleX = 0.5;

		t = new vector[]{put(1.4, 1.3, -2.28), put(1.6, 1.5, -2.28), put(1.6, 1.5, -2.08), put(1.4, 1.3, -2.08)};
		polygons[23] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[23].scaleX = 0.5;

		t = new vector[]{put(1.6, 1.5, -2.28),  put(1.6, 3.2, -2.28), put(1.6, 3.2, -2.08), put(1.6, 1.5, -2.08)};
		polygons[24] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[24].scaleY = 5;
		polygons[24].scaleX = 0.5;

		t = new vector[]{put(1.6, 3.2, -2.28), put(1.4, 3.4, -2.28),  put(1.4, 3.4, -2.08), put(1.6, 3.2, -2.08)};
		polygons[25] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[25].scaleX = 0.5;

		t = new vector[]{put(1.41, 3.4, -2.28), put(-1.41, 3.4, -2.28),  put(-1.41, 3.4, -2.08), put(1.41, 3.4, -2.08)};
		polygons[26] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[26].scaleY = 5;
		polygons[26].scaleX = 0.5;

		t = new vector[]{put(-1.4, 3.4, -2.28), put(-1.6, 3.2, -2.28), put(-1.6, 3.2, -2.08), put(-1.4, 3.4, -2.08)};
		polygons[27] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[27].scaleX = 0.5;

		t = new vector[]{put(-1.6, 3.2, -2.28), put(-1.6, 1.5, -2.28), put(-1.6, 1.5, -2.08), put(-1.6, 3.2, -2.08)};
		polygons[28] = new polygon3D(t, t[2], t[1], t[3], house.textures[32]);
		polygons[28].scaleY = 5;
		polygons[28].scaleX = 0.5;

		for(int i = 0; i < 29; i++){
			polygons[i].ambient_I = 4;
			polygons[i].setLightSource( LightSource.s3);
		}
	}


	public vector put(double i, double j, double k){
		vector temp = new vector(0,0,0);
		temp.set(start);
		tempi.set(iDirection);
		tempj.set(jDirection);
		tempk.set(kDirection);

		tempi.rotate_XZ(angle);
		tempj.rotate_XZ(angle);
		tempk.rotate_XZ(angle);

		temp.add(tempi, i*0.75);
		temp.add(tempj, j*0.75);
		temp.add(tempk, k*0.75);
		return temp;
	}

}