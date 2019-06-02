public class shelf_upper extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;
	public double angle;
	public vector tempi, tempj, tempk;

	public shelf_upper(double x, double y, double z, double angle){
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
		sortedPolygons = true;
	}


	public void makeBoundary(){
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(0, 1.85, 0), put(0, 2, 0), put(0, 2, 8), put(0, 1.85, 8)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(0, 1.85, 8), put(0, 2, 8), put(-2, 2, 8), put(-2, 1.85, 8)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(-2, 1.85, 8), put(-2, 2, 8), put(-2, 2, 0), put(-2, 1.85, 0)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(-2, 1.85, 0), put(-2, 2, 0), put(0, 2, 0), put(0, 1.85, 0)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(0,1.85,0), put(0,1.85,8), put(-2, 1.85, 8), put(-2, 1.85, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(-2, 2, 0), put(-2, 2, 8), put(0,2,8), put(0,2,0)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[7];
		vector[] t;

		t = new vector[]{put(-2, 2, 0), put(-2, 2, 8), put(-0.2, 2, 8), put(0, 2, 7.8), put(0,2,0.2), put(-0.2,2,0)};
		polygons[0] = new polygon3D(t, put(-2, 2, 8), put(0,2,8), put(-2, 2, 0), house.textures[35]);
		polygons[0].scaleX = 1.5;
		polygons[0].scaleY = 3;

		t = new vector[]{put(-0.2,1.85,0), put(0,1.85,0.2), put(0, 1.85, 7.8), put(-0.2, 1.85, 8), put(-2, 1.85, 8), put(-2, 1.85, 0)};
		polygons[1] = new polygon3D(t, put(-2, 1.85, 8), put(0,1.85,8), put(-2, 1.85, 0), house.textures[35]);
		polygons[1].scaleX = 1.5;
		polygons[1].scaleY = 3;

		t = new vector[]{put(-2, 1.84, 8), put(-0.2, 1.84, 8), put(-0.2, 2.01, 8), put(-2, 2.01, 8)};
		polygons[2] = new polygon3D(t, t[1], t[0], t[2], house.textures[35]);
		polygons[2].scaleY = 0.4;

		t = new vector[]{put(-2, 2.01, 0), put(-0.2, 2.01, 0), put(-0.2, 1.84, 0), put(-2, 1.84, 0)};
		polygons[3] = new polygon3D(t, t[1], t[0], t[2], house.textures[35]);
		polygons[3].scaleY = 0.4;


		t = new vector[]{put(0, 1.84, 7.8), put(0,1.84,0.2), put(0,2.01,0.2), put(0, 2.01, 7.8)};
		polygons[4] = new polygon3D(t, t[1], t[2], t[0], house.textures[35]);
		polygons[4].scaleY = 3;
		polygons[4].scaleX = 0.4;

		t = new vector[]{put(-0.2, 1.84, 8), put(0, 1.84, 7.8), put(0, 2.01, 7.8), put(-0.2, 2.01, 8)};
		polygons[5] = new polygon3D(t, t[1], t[0], t[2], house.textures[35]);
		polygons[5].scaleY = 0.4;
		polygons[5].scaleX = 0.4;

		t = new vector[]{ put(-0.2, 2.01, 0), put(0, 2.01, 0.2), put(0, 1.84, 0.2),put(-0.2, 1.84, 0)};
		polygons[6] = new polygon3D(t, t[1], t[0], t[2], house.textures[35]);
		polygons[6].scaleY = 0.4;
		polygons[6].scaleX = 0.4;

	for(int i = 0; i < 7; i++){
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