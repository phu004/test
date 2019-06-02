public class shelf_lower extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;
	public double angle;
	public vector tempi, tempj, tempk;

	public shelf_lower(double x, double y, double z, double angle){
		start = new vector(x,y,z);
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		tempi = new vector(0,0,0);
		tempj = new vector(0,0,0);
		tempk = new vector(0,0,0);
		this.angle = angle;

		this.start = start;
		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
	}


	public void makeBoundary(){
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(0.2, 1, 0.2), put(0.2, 1.5, 0.2), put(0.2, 1.5, 7.8), put(0.2, 1, 7.8)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(0.2, 1, 7.8), put(0.2, 1.5, 7.8), put(-2, 1.5, 7.8), put(-2, 1, 7.8)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(-2, 1, 7.8), put(-2, 1.5, 7.8), put(-2, 1.5, 0.2), put(-2, 1, 0.2)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(-2, 1, 0.2), put(-2, 1.5, 0.2), put(0.2, 1.5, 0.2), put(0.2, 1, 0.2)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(0.2,1,0.2), put(0.2,1,7.8), put(-2, 1, 7.8), put(-2, 1, 0.2)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(-2, 1.5, 0.2), put(-2, 1.5, 7.8), put(0.2,1.5,7.8), put(0.2,1.5,0.2)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[10];
		vector[] t;


		t = new vector[]{put(-2, 1.86, 0.3), put(-0.2, 1.86, 0.3), put(-0.2, 1.64, 0.3), put(-1.8, 1, 0.3), put(-2, 1, 0.3)};
		polygons[0] = new polygon3D(t, t[0], t[1], t[4], house.textures[35]);

		t = new vector[]{put(-2, 1.86, 7.55), put(-0.2, 1.86, 7.55), put(-0.2, 1.64, 7.55), put(-1.8, 1, 7.55), put(-2, 1, 7.55)};
		polygons[1] = new polygon3D(t, t[0], t[1], t[4], house.textures[35]);

		t = new vector[]{put(-2, 1, 0.45), put(-1.8, 1, 0.45), put(-0.2, 1.64, 0.45), put(-0.2, 1.86, 0.45), put(-2, 1.86, 0.45)};
		polygons[2] = new polygon3D(t, t[4], t[0], t[3], house.textures[35]);

		t = new vector[]{put(-2, 1, 7.7), put(-1.8, 1, 7.7), put(-0.2, 1.64, 7.7), put(-0.2, 1.86, 7.7), put(-2, 1.86, 7.7)};
		polygons[3] = new polygon3D(t, t[4], t[0], t[3], house.textures[35]);

		t = new vector[]{put(-0.2, 1.86, 0.45), put(-0.2, 1.64, 0.45), put(-0.2, 1.64, 0.29), put(-0.2, 1.86, 0.29)};
		polygons[4] = new polygon3D(t, t[0], t[1], t[3], house.textures[35]);

		t = new vector[]{put(-0.2, 1.86, 7.71), put(-0.2, 1.64, 7.71), put(-0.2, 1.64, 7.54), put(-0.2, 1.86, 7.54)};
		polygons[5] = new polygon3D(t, t[0], t[1], t[3], house.textures[35]);

		t = new vector[]{put(-0.2, 1.64, 0.46), put(-1.8, 1, 0.46), put(-1.8, 1, 0.29), put(-0.2, 1.64, 0.29)};
		polygons[6] = new polygon3D(t, t[0], t[1], t[3], house.textures[35]);

		t = new vector[]{put(-0.2, 1.64, 7.71), put(-1.8, 1, 7.71), put(-1.8, 1, 7.54), put(-0.2, 1.64, 7.54)};
		polygons[7] = new polygon3D(t, t[0], t[1], t[3], house.textures[35]);

		t = new vector[]{put(-1.79, 1, 0.29), put(-1.79, 1, 0.46), put(-2, 1, 0.46), put(-2, 1, 0.29)};
		polygons[8] = new polygon3D(t, t[0], t[1], t[3], house.textures[35]);

		t = new vector[]{put(-1.79, 1, 7.54), put(-1.79, 1, 7.71), put(-2, 1, 7.71), put(-2, 1, 7.54)};
		polygons[9] = new polygon3D(t, t[0], t[1], t[3], house.textures[35]);

		for(int i = 0; i < 10; i++){
			polygons[i].ambient_I = 1;
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
		temp.add(tempk, k);
		return temp;
	}
}