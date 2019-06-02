public class chair_lower extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector  tempi, tempj, tempk;
	public double  angle;


	public chair_lower(double x, double y, double z, double angle){
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
		vector[] a = new vector[]{put(-2.5, 0.1, -2.5), put(-2.5, 2.5, -2.5), put(2.5, 2.5, -2.5), put(2.5, 0.1, -2.5)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(2.5, 2.5, -2.5), put(2.5, 2.5, 2.5), put(2.5, 0.1, 2.5), put(2.5, 0.1, -2.5)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(2.5, 2.5, 2.5), put(-2.5, 2.5, 2.5), put(-2.5, 0.1, 2.5), put(2.5, 0.1, 2.5)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(-2.5, 2.5, 2.5), put(-2.5, 2.5, -2.5), put(-2.5, 0.1, -2.5), put(-2.5, 0.1, 2.5)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(-2.5, 2.5, -2.5), put(-2.5, 2.5, 2.5), put(2.5, 2.5, 2.5), put(2.5, 2.5, -2.5)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(2.5, 0.1, -2.5), put(2.5, 0.1, 2.5),put(-2.5, 0.1, 2.5), put(-2.5, 0.1, -2.5)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[44];
		vector[] t;

		start.y -=0.2;
		vector tempI = iDirection;
		vector tempK = kDirection;

		t = new vector[]{put(-0.16, 1, -0.15), put(-0.16, 3, -0.15), put(0.16, 3, -0.15), put(0.16, 1, -0.15)};
		polygons[0] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(0.15, 1, -0.16), put(0.15, 3, -0.16), put(0.15, 3, 0.16), put(0.15, 1, 0.16)};
		polygons[1] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(0.16, 1, 0.15), put(0.152, 3, 0.15), put(-0.16, 3, 0.15), put(-0.16, 1, 0.15)};
		polygons[2] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.15, 1, 0.16), put(-0.15, 3, 0.16), put(-0.15, 3, -0.16), put(-0.15, 1, -0.16)};
		polygons[3] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);

		t = new vector[]{put(-0.15, 1, -0.15), put(0.15, 1, -0.15),put(0.10, 0.7, -2.65), put(-0.10, 0.7, -2.65)};
		polygons[4] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.14, 1.01, -0.15), put(-0.10, 0.72, -2.65),put(-0.10, 0.6, -2.65), put(-0.15, 0.71, -0.15)};
		polygons[5] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(0.15, 0.71, -0.15),put(0.10, 0.6, -2.65), put(0.10, 0.71, -2.65), put(0.15, 1, -0.15)};
		polygons[6] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.10, 0.71, -2.65), put(0.10, 0.71, -2.65), put(0.10, 0.6, -2.65), put(-0.10, 0.6, -2.65)};
		polygons[7] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.08,0.6, -2.65), put(-0.08,0.4, -2.75), put(-0.08,0.2, -2.65),  put(-0.08,0.2, -2.45), put(-0.08,0.4, -2.35), put(-0.08,0.6, -2.45)};
		polygons[8] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{ put(0.08,0.6, -2.45), put(0.08,0.4, -2.35),  put(0.08,0.2, -2.45), put(0.08,0.2, -2.65), put(0.08,0.4, -2.75),put(0.08,0.6, -2.65)};
		polygons[9] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.4, -2.75), put(-0.08,0.6, -2.65), put(0.08,0.6, -2.65), put(0.08,0.4, -2.75)};
		polygons[10] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.4, -2.75), put(0.08,0.4, -2.75), put(0.08, 0.2, -2.65), put(-0.08, 0.2, -2.65)};
		polygons[11] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.6, -2.45), put(-0.08,0.4, -2.35), put(0.08,0.4, -2.35), put(0.08,0.6, -2.45)};
		polygons[12] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(0.08,0.4, -2.35), put(-0.08,0.4, -2.35), put(-0.08,0.2, -2.45), put(0.08,0.2, -2.45)};
		polygons[13] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);


		iDirection.rotate_XZ(Math.PI/2);
		kDirection.rotate_XZ(Math.PI/2);

		t = new vector[]{put(-0.15, 1, -0.15), put(0.15, 1, -0.15),put(0.10, 0.7, -2.65), put(-0.10, 0.7, -2.65)};
		polygons[14] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.14, 1.01, -0.15), put(-0.10, 0.72, -2.65),put(-0.10, 0.6, -2.65), put(-0.15, 0.71, -0.15)};
		polygons[15] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(0.15, 0.71, -0.15),put(0.10, 0.6, -2.65), put(0.10, 0.71, -2.65), put(0.15, 1, -0.15)};
		polygons[16] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.10, 0.71, -2.65), put(0.10, 0.71, -2.65), put(0.10, 0.6, -2.65), put(-0.10, 0.6, -2.65)};
		polygons[17] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.08,0.6, -2.65), put(-0.08,0.4, -2.75), put(-0.08,0.2, -2.65),  put(-0.08,0.2, -2.45), put(-0.08,0.4, -2.35), put(-0.08,0.6, -2.45)};
		polygons[18] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{ put(0.08,0.6, -2.45), put(0.08,0.4, -2.35),  put(0.08,0.2, -2.45), put(0.08,0.2, -2.65), put(0.08,0.4, -2.75),put(0.08,0.6, -2.65)};
		polygons[19] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.4, -2.75), put(-0.08,0.6, -2.65), put(0.08,0.6, -2.65), put(0.08,0.4, -2.75)};
		polygons[20] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.4, -2.75), put(0.08,0.4, -2.75), put(0.08, 0.2, -2.65), put(-0.08, 0.2, -2.65)};
		polygons[21] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.6, -2.45), put(-0.08,0.4, -2.35), put(0.08,0.4, -2.35), put(0.08,0.6, -2.45)};
		polygons[22] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(0.08,0.4, -2.35), put(-0.08,0.4, -2.35), put(-0.08,0.2, -2.45), put(0.08,0.2, -2.45)};
		polygons[23] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);


		iDirection.rotate_XZ(Math.PI/2);
		kDirection.rotate_XZ(Math.PI/2);

		t = new vector[]{put(-0.15, 1, -0.15), put(0.15, 1, -0.15),put(0.10, 0.7, -2.65), put(-0.10, 0.7, -2.65)};
		polygons[24] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.14, 1.01, -0.15), put(-0.10, 0.72, -2.65),put(-0.10, 0.6, -2.65), put(-0.15, 0.71, -0.15)};
		polygons[25] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(0.15, 0.71, -0.15),put(0.10, 0.6, -2.65), put(0.10, 0.71, -2.65), put(0.15, 1, -0.15)};
		polygons[26] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.10, 0.71, -2.65), put(0.10, 0.71, -2.65), put(0.10, 0.6, -2.65), put(-0.10, 0.6, -2.65)};
		polygons[27] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.08,0.6, -2.65), put(-0.08,0.4, -2.75), put(-0.08,0.2, -2.65),  put(-0.08,0.2, -2.45), put(-0.08,0.4, -2.35), put(-0.08,0.6, -2.45)};
		polygons[28] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{ put(0.08,0.6, -2.45), put(0.08,0.4, -2.35),  put(0.08,0.2, -2.45), put(0.08,0.2, -2.65), put(0.08,0.4, -2.75),put(0.08,0.6, -2.65)};
		polygons[29] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.4, -2.75), put(-0.08,0.6, -2.65), put(0.08,0.6, -2.65), put(0.08,0.4, -2.75)};
		polygons[30] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.4, -2.75), put(0.08,0.4, -2.75), put(0.08, 0.2, -2.65), put(-0.08, 0.2, -2.65)};
		polygons[31] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.6, -2.45), put(-0.08,0.4, -2.35), put(0.08,0.4, -2.35), put(0.08,0.6, -2.45)};
		polygons[32] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(0.08,0.4, -2.35), put(-0.08,0.4, -2.35), put(-0.08,0.2, -2.45), put(0.08,0.2, -2.45)};
		polygons[33] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);


		iDirection.rotate_XZ(Math.PI/2);
		kDirection.rotate_XZ(Math.PI/2);

		t = new vector[]{put(-0.15, 1, -0.15), put(0.15, 1, -0.15),put(0.10, 0.7, -2.65), put(-0.10, 0.7, -2.65)};
		polygons[34] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.14, 1.01, -0.15), put(-0.10, 0.72, -2.65),put(-0.10, 0.6, -2.65), put(-0.15, 0.71, -0.15)};
		polygons[35] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(0.15, 0.71, -0.15),put(0.10, 0.6, -2.65), put(0.10, 0.71, -2.65), put(0.15, 1, -0.15)};
		polygons[36] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.10, 0.71, -2.65), put(0.10, 0.71, -2.65), put(0.10, 0.6, -2.65), put(-0.10, 0.6, -2.65)};
		polygons[37] = new polygon3D(t, t[0], t[1], t[3], house.textures[30]);
		t = new vector[]{put(-0.08,0.6, -2.65), put(-0.08,0.4, -2.75), put(-0.08,0.2, -2.65),  put(-0.08,0.2, -2.45), put(-0.08,0.4, -2.35), put(-0.08,0.6, -2.45)};
		polygons[38] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{ put(0.08,0.6, -2.45), put(0.08,0.4, -2.35),  put(0.08,0.2, -2.45), put(0.08,0.2, -2.65), put(0.08,0.4, -2.75),put(0.08,0.6, -2.65)};
		polygons[39] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.4, -2.75), put(-0.08,0.6, -2.65), put(0.08,0.6, -2.65), put(0.08,0.4, -2.75)};
		polygons[40] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.4, -2.75), put(0.08,0.4, -2.75), put(0.08, 0.2, -2.65), put(-0.08, 0.2, -2.65)};
		polygons[41] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(-0.08,0.6, -2.45), put(-0.08,0.4, -2.35), put(0.08,0.4, -2.35), put(0.08,0.6, -2.45)};
		polygons[42] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);
		t = new vector[]{put(0.08,0.4, -2.35), put(-0.08,0.4, -2.35), put(-0.08,0.2, -2.45), put(0.08,0.2, -2.45)};
		polygons[43] = new polygon3D(t, t[2], t[1], t[3], house.textures[31]);

			for(int i = 0; i < 44; i++){
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