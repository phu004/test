public class floor_E extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public floor_E(double x, double y, double z){
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
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(0, 0, 0),  put(25,0,0), put(25, 0, 10), put(0, 0, 10)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		boundary[1] = new polygon3D(a, null, null, null, null);
		boundary[2] = new polygon3D(a, null, null, null, null);
		boundary[3] = new polygon3D(a, null, null, null, null);
		boundary[4] = new polygon3D(a, null, null, null, null);
		boundary[5] = new polygon3D(a, null, null, null, null);

	}

	public void makePolygons(){
		polygons = new polygon3D[1];
			vector[] t;

			t = new vector[]{put(0, 0, 10),put(25.02, 0, 10),  put(25.02,0,0), put(0, 0, 0) };
			polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[1]);
			polygons[0].scaleX = 3;
			polygons[0].scaleY = 1;
			polygons[0].ambient_I = 1;

			for(int i = 0; i < 1; i++){
				polygons[i].setLightSource( LightSource.s5);
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