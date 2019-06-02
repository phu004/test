public class skyBox extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;

	public skyBox(double x, double y, double z){
		start = new vector(x,y,z);
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		this.start = start;
		makePolygons();
		code = "skyBox";
	}

	public void makePolygons(){
		polygons = new polygon3D[6];
		vector[] t;

		t = new vector[]{put(-10, 10, 10), put(10,10, 10), put(10,-10, 10), put(-10, -10, 10)};
		polygons[0] = new polygon3D(t, put(-10.1, 10.1, 10), put(10,10.1, 10), put(-10.1, -10.1, 10), house.textures[16]);

		t = new vector[]{put(10, 10, 10), put(10,10, -10), put(10,-10, -10), put(10, -10, 10)};
		polygons[1] = new polygon3D(t, put(10, 10.1, 10.1),  put(10,10.1, -10), put(10, -10.1, 10.1), house.textures[17]);

		t = new vector[]{put(10, 10, -10), put(-10,10, -10), put(-10, -10, -10), put(10, -10, -10)};
		polygons[2] = new polygon3D(t,put(10.1, 10.1, -10), put(-10,10.1, -10), put(10.1, -10.1, -10), house.textures[18]);

		t = new vector[]{put(-10, 10, -10), put(-10,10, 10), put(-10, -10, 10), put(-10, -10, -10)};
		polygons[3] = new polygon3D(t, put(-10, 10.1, -10.1),  put(-10,10.1, 10), put(-10, -10.1, -10.1), house.textures[19]);

		t = new vector[]{put(-10, 10, -10), put(10,10, -10), put(10, 10, 10), put(-10, 10, 10)};
		polygons[4] = new polygon3D(t, put(-10.1, 9.9, -10.1),  put(10.1,9.9, -10.1), put(-10.1, 9.9, 10.1), house.textures[20]);

		t = new vector[]{put(-10, -10, 10), put(10,-10, 10), put(10, -10, -10), put(-10, -10, -10)};
		polygons[5] = new polygon3D(t, put(-10.1, -9.9, 10.1),  put(10.1,-9.9, 10.1), put(-10.1, -9.9, -10.1), house.textures[21]);

		for(int i = 0; i <polygons.length; i++ ){
			polygons[i].setLightSource( LightSource.s2);
			polygons[i].type = 1;
		}

		boundary = polygons;
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