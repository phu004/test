public class magicCube extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;

	public magicCube(double x, double y, double z){
		start = new vector(x,y,z);

		iDirection = new vector(0.75,0,0);
		jDirection = new vector(0,0.75,0);
		kDirection = new vector(0,0,0.75);

		iDirection.rotate_XZ(Math.PI/4);
		kDirection.rotate_XZ(Math.PI/4);

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
		vector[] a = new vector[]{put(0,0,0), put(0, 0.5, 0), put(0.5, 0.5, 0), put(0.5, 0, 0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(0.5, 0, 0), put(0.5, 0.5, 0), put(0.5, 0.5, 0.5), put(0.5, 0, 0.5)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(0.5, 0, 0.5), put(0.5, 0.5, 0.5), put(0, 0.5, 0.5), put(0, 0, 0.5)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(0, 0, 0.5), put(0, 0.5, 0.5), put(0, 0.5, 0), put(0,0,0)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(0,0.5, 0), put(0, 0.5, 0.5), put(0.5, 0.5, 0.5), put(0.5, 0.5, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(0.5, 0, 0), put(0.5, 0, 0.5), put(0, 0, 0.5), put(0,0.5, 0)};
		boundary[5] = new polygon3D(f, null, null, null, null);

		vector p0 =put(0.25,3, 0.25);
		vector direction = new vector(2,-1,0);
		direction.unit();
		geometry.isLinePolygonIntersect(boundary[4], p0, direction);
	}

	public void makePolygons(){
		polygons = new polygon3D[5];
		vector[] t;
		t = new vector[]{put(-0.001,0,0), put(-0.01, 0.501, 0), put(0.501, 0.51, 0), put(0.501, 0, 0)};
		polygons[0] = new polygon3D(t, t[1], t[2], t[0], house.textures[36]);
		t = new vector[]{put(0.5, 0, 0), put(0.5, 0.501, 0), put(0.5, 0.501, 0.5), put(0.5, 0, 0.5)};
		polygons[1] = new polygon3D(t, t[1], t[2], t[0], house.textures[37]);
		t = new vector[]{put(0.501, 0, 0.5), put(0.501, 0.51, 0.5), put(-0.001, 0.51, 0.5), put(-0.001, 0, 0.5)};
		polygons[2] = new polygon3D(t, t[1], t[2], t[0], house.textures[38]);
		t = new vector[]{put(0, 0, 0.5), put(0, 0.501, 0.5), put(0, 0.501, 0), put(0,0,0)};
		polygons[3] = new polygon3D(t, t[1], t[2], t[0], house.textures[39]);
		t = new vector[]{put(0,0.5, 0), put(0, 0.5, 0.5), put(0.5, 0.5, 0.5), put(0.5, 0.5, 0)};
		polygons[4] = new polygon3D(t, t[1], t[2], t[0], house.textures[40]);

		for(int i = 0; i < 5; i++){
			polygons[i].ambient_I = 2;
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