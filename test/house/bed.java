public class bed extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;

	public bed(double x, double y, double z){
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
		vector[] a = new vector[]{put(0,0,0), put(0,8, 0), put(-17, 8, 0), put(-17,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(-17,0,0), put(-17, 8, 0), put(-17, 8, -8), put(-17, 0, -8)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(-17, 0, -8), put(-17, 8, -8), put(0, 8, -8), put(0, 0, -8)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(0, 0, -8), put(0, 8, -8), put(0, 8, 0), put(0, 0, 0)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(0,0,0), put(-17,0,0), put(-17,0,-8), put(0,0,-8)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(0,8,-8), put(-17,8,-8), put(-17,8,0), put(0,8,0)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[18];
		vector[] t;

		t = new vector[]{put(0,1,-8), put(-17,1,-8), put(-17,1,0), put(0,1,0)};
		polygons[0] = new polygon3D(t, t[0], t[1], t[3], house.textures[34]);
		polygons[0].scaleX = 6;


		t = new vector[]{put(0,1.01,0), put(-17,1.01,0), put(-17,0,0), put(0,0,0)};
		polygons[1] = new polygon3D(t, t[1], t[0], t[2], house.textures[34]);
		polygons[1].scaleX = 6;

		t = new vector[]{put(0,0,-8), put(-17,0,-8), put(-17,1,-8), put(0,1,-8)};
		polygons[2] = new polygon3D(t, t[1], t[0], t[2], house.textures[34]);
		polygons[2].scaleX = 6;

		t = new vector[]{put(0,1.01,-8), put(0,1.01,0.01), put(0,0,0.01),put(0,0,-8)};
		polygons[3] = new polygon3D(t, t[1], t[0], t[2], house.textures[34]);
		polygons[3].scaleX = 2;

		t = new vector[]{put(-17,0,-8), put(-17,0,0.01), put(-17,1.01,0.01),put(-17,1.01,-8)};
		polygons[4] = new polygon3D(t, t[1], t[0], t[2], house.textures[34]);
		polygons[4].scaleX = 2;

		t = new vector[]{put(-0.2, 2.5, -1), put(-0.2, 2.5, -7), put(-0.5, 2.5, -7.5), put(-1, 2.5, -7.8), put(-16, 2.5, -7.8), put(-16.5, 2.5, -7.5), put(-16.8, 2.5, -7), put(-16.8, 2.5, -1), put(-16.5, 2.5, -0.5), put(-16, 2.5, -0.2), put(-1, 2.5, -0.2), put(-0.5, 2.5, -0.5)};
		polygons[5] = new polygon3D(t, put(0,2.5,0), put(-17,2.5,0), put(0, 2.7, -8), house.textures[33]);
		polygons[5].scaleX = 6;
		polygons[5].scaleY = 3;

		t = new vector[]{put(-0.2, 1.01, -1), put(-0.2, 1.01, -7), put(-0.2, 2.51, -7), put(-0.2, 2.51, -1)};
		polygons[6] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[6].scaleX = 2;

		t = new vector[]{put(-0.2, 1.01, -7), put(-0.5, 1.01, -7.5), put(-0.5, 2.51, -7.5),put(-0.2, 2.51, -7)};
		polygons[7] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[7].scaleX = 0.2;

		t = new vector[]{put(-0.5, 1.01, -7.5), put(-1, 1.01, -7.8), put(-1, 2.51, -7.8), put(-0.5, 2.51, -7.5)};
		polygons[8] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[8].scaleX = 0.2;

		t = new vector[]{put(-1, 1.01, -7.8), put(-16, 1.01, -7.8),put(-16, 2.51, -7.8), put(-1, 2.51, -7.8)};
		polygons[9] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[9].scaleX = 6;


		t = new vector[]{put(-16, 1.01, -7.8), put(-16.5, 1.01, -7.5), put(-16.5, 2.51, -7.5),put(-16, 2.51, -7.8)};
		polygons[10] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[10].scaleX = 0.2;

		t = new vector[]{put(-16.5, 1.01, -7.5), put(-16.8, 1.01, -7), put(-16.8, 2.51, -7), put(-16.5, 2.51, -7.5)};
		polygons[11] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[11].scaleX = 0.2;

		t = new vector[]{put(-16.8, 1.01, -7), put(-16.8, 1.01, -1), put(-16.8, 2.51, -1), put(-16.8, 2.51, -7)};
		polygons[12] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[12].scaleX = 2;

		t = new vector[]{put(-16.8, 1.01, -1), put(-16.5, 1.01, -0.5), put(-16.5, 2.51, -0.5), put(-16.8, 2.51, -1)};
		polygons[13] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[13].scaleX = 0.2;

		t = new vector[]{put(-16.5, 1.01, -0.5), put(-16, 1.01, -0.2), put(-16, 2.51, -0.2), put(-16.5, 2.51, -0.5)};
		polygons[14] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[14].scaleX = 0.2;

		t = new vector[]{put(-16, 1.01, -0.2), put(-1, 1.01, -0.2), put(-1, 2.51, -0.2), put(-16, 2.51, -0.2)};
		polygons[15] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[15].scaleX = 6;

		t = new vector[]{put(-1, 1.01, -0.2), put(-0.5, 1.01, -0.5), put(-0.5, 2.51, -0.5), put(-1, 2.51, -0.2)};
		polygons[16] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[16].scaleX = 0.2;

		t = new vector[]{put(-0.5, 1.01, -0.5), put(-0.2, 1.01, -1), put(-0.2, 2.51, -1), put(-0.5, 2.51, -0.5)};
		polygons[17] = new polygon3D(t, t[1], t[0], t[2], house.textures[33]);
		polygons[17].scaleX = 0.2;

		for(int i = 0; i < 18; i++){
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