public class tableLamp extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;
	public double angle;
	public double height;
	public vector  tempi, tempj, tempk;

	public tableLamp(double x, double y, double z, double angle){
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
		vector[] a = new vector[]{put(-2, 0.1, -2), put(-2, 4, -2), put(2, 4, -2), put(2, 0.1, -2)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(2, 4, -2), put(2, 4, 2), put(2, 0.1, 2), put(2, 0.1, -2)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(2, 4, 2), put(-2, 4, 2), put(-2, 0.1, 2), put(2, 0.1, 2)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(-2, 4, 2), put(-2, 4, -2), put(-2, 0.1, -2), put(-2, 0.1, 2)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(-2, 4, -2), put(-2, 4, 2), put(2, 4, 2), put(2, 4, -2)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(2, 0.1, -2), put(2, 0.1, 2),put(-2, 0.1, 2), put(-2, 0.1, -2)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[99];
		vector[] t;

		double r1 = 0.8;
		double theta = Math.PI/16;

		specularCentre = new vector[]{put(0,-100,0)};
		t = new vector[32];
		for(int i = 1; i < 33; i++)
			t[32-i] = put(r1*Math.cos(i*theta), 0.19, r1*Math.sin(i*theta));
		polygons[0] = new polygon3D(t, t[1],  t[0], t[2], house.textures[11] );
		polygons[0].scaleX = 5;
		polygons[0].scaleY = 5;
		polygons[0].gouraudShading = true;
		polygons[0].roughness = 4;
		for(int i = 0; i < 32; i++)
			polygons[0].vertixNormals[i] = makeNormal(t[i], 0);

		double r2 = 0.85;

		t = new vector[32];
		for(int i = 1; i < 33; i++)
			t[32-i] = put(r2*Math.cos(-i*theta), 0, r2*Math.sin(-i*theta));
		polygons[98] = new polygon3D(t, put(2.5, 0, -2.5),  put(-2.5, 0, -2.5), put(2.5, 0, 2.5), house.textures[11] );
		polygons[98].scaleX = 5;
		polygons[98].scaleY = 5;



		specularCentre = new vector[]{put(0,0.2,0), put(0,0,0)};
		for(int i = 0; i < 32; i++){
			t = new vector[]{put(r1*Math.cos(i*theta), 0.2, r1*Math.sin(i*theta)),
							 put(r1*Math.cos((i+1)*theta), 0.2, r1*Math.sin((i+1)*theta)),
							 put(r2*Math.cos((i+1)*theta), 0, r2*Math.sin((i+1)*theta)),
							 put(r2*Math.cos(i*theta), 0, r2*Math.sin(i*theta)),
							};
			polygons[1+i] = new polygon3D(t, t[0], t[1], t[3], house.textures[11]);
			polygons[1+i].gouraudShading = true;
			polygons[1+i].roughness = 3;
			polygons[1+i].vertixNormals = new vector[]{makeNormal(t[0], 0), makeNormal(t[1], 0), makeNormal(t[2], 1), makeNormal(t[3], 1)};
		}

		vector tempI = iDirection.myClone();
		vector tempJ = jDirection.myClone();
		vector tempK = kDirection.myClone();

		iDirection.rotate_XZ(Math.PI/6);
		kDirection.rotate_XZ(Math.PI/6);

		theta = Math.PI/4;
		double r3 = 0.05;

		specularCentre = new vector[]{put(1.3,1.8,0), put(0,0.21,0)};
		for(int i = 0; i < 8; i++){
			t = new vector[]{put(r3*Math.cos(i*theta)+1.3, 1.8, r3*Math.sin(i*theta)),
							 put(r3*Math.cos((i+1)*theta)+1.3, 1.8, r3*Math.sin((i+1)*theta)),
							 put(r3*Math.cos((i+1)*theta), 0.21, r3*Math.sin((i+1)*theta)),
							 put(r3*Math.cos(i*theta), 0.21, r3*Math.sin(i*theta)),
							};
			polygons[33+i] = new polygon3D(t, t[0], t[1], t[3], house.textures[11]);
			polygons[33+i].gouraudShading = true;
			polygons[33+i].roughness = 3;
			polygons[33+i].vertixNormals = new vector[]{makeNormal(t[0], 0), makeNormal(t[1], 0), makeNormal(t[2], 1), makeNormal(t[3], 1)};

		}

		for(int i = 0; i < 8; i++){
			specularCentre = new vector[]{put(-0.95,3+r3*Math.cos(i*theta),0), put(1.3,1.79,0)};
			t = new vector[]{put(r3*Math.cos(i*theta)*0.3-0.95, 3+r3*Math.cos(i*theta), r3*Math.sin(i*theta)),
							 put(r3*Math.cos((i+1)*theta)*0.3-0.95, 3+r3*Math.cos((i+1)*theta), r3*Math.sin((i+1)*theta)),
							 put(r3*Math.cos((i+1)*theta)+1.3, 1.79, r3*Math.sin((i+1)*theta)),
							 put(r3*Math.cos(i*theta)+1.3, 1.79, r3*Math.sin(i*theta)),
							};
			polygons[41+i] = new polygon3D(t, t[0], t[1], t[3], house.textures[11]);
			polygons[41+i].gouraudShading = true;
			polygons[41+i].roughness = 3;
			polygons[41+i].vertixNormals = new vector[]{makeNormal(t[0], 0), makeNormal(t[1], 0), makeNormal(t[2], 1), makeNormal(t[3], 1)};

		}

		iDirection.set(tempI);
		jDirection.set(tempJ);
		kDirection.set(tempK);

		start = put(-0.8,3.4,-0.45);

		jDirection.rotate_YZ((Math.PI/6) * 4.9);
		kDirection.rotate_YZ((Math.PI/6) * 4.9);


		jDirection.rotate_XZ((Math.PI/6) * 4);
		kDirection.rotate_XZ((Math.PI/6) * 4);

		iDirection = jDirection.cross(kDirection);


		theta = Math.PI/8;
		double r4 = 0.2;

		specularCentre = new vector[]{put(0,0.7,0), put(0,0,0)};
		for(int i = 0; i < 16; i++){
			t = new vector[]{ put(r4*Math.cos(i*theta), 0.7, r4*Math.sin(i*theta)),
							  put(r4*Math.cos((i+1)*theta), 0.7, r4*Math.sin((i+1)*theta)),
							  put(r4*Math.cos((i+1)*theta), 0, r4*Math.sin((i+1)*theta)),
							  put(r4*Math.cos(i*theta), 0, r4*Math.sin(i*theta))
							};
			polygons[49+i] = new polygon3D(t, t[0], t[1], t[3], house.textures[12]);
			polygons[49+i].scaleX = 1;
			polygons[49+i].scaleY = 2;
			polygons[49+i].gouraudShading = true;
			polygons[49+i].roughness = 3;
			polygons[49+i].vertixNormals = new vector[]{makeNormal(t[0], 0), makeNormal(t[1], 0), makeNormal(t[2], 1), makeNormal(t[3], 1)};

		}

		specularCentre = new vector[]{put(0,-100,0)};
		t = new vector[16];
		for(int i = 1; i < 17; i++){
			t[i-1] = put(r4*Math.cos(i*theta), 0, r4*Math.sin(i*theta));
		}
		polygons[65] = new polygon3D(t, t[1], t[0], t[2], house.textures[12]);
		polygons[65].gouraudShading = true;
		polygons[65].roughness = 3;
		for(int i = 0; i < 16; i++)
			polygons[65].vertixNormals[i] = makeNormal(t[i], 0);



		double r5 = 0.6;

		specularCentre = new vector[]{put(0,1.4,0), put(0,0.7,0)};
		for(int i = 0; i < 16; i++){
			t = new vector[]{ put(r5*Math.cos(i*theta), 1.4, r5*Math.sin(i*theta)),
							  put(r5*Math.cos((i+1)*theta), 1.4, r5*Math.sin((i+1)*theta)),
							  put(r4*Math.cos((i+1)*theta), 0.7, r4*Math.sin((i+1)*theta)),
							  put(r4*Math.cos(i*theta), 0.7, r4*Math.sin(i*theta))
							};
			polygons[66+i] = new polygon3D(t, t[0], t[1], t[3], house.textures[12]);
			polygons[66+i].scaleX = 1;
			polygons[66+i].scaleY = 2;
			polygons[66+i].gouraudShading = true;
			polygons[66+i].roughness = 3;
			polygons[66+i].vertixNormals = new vector[]{makeNormal(t[0], 0), makeNormal(t[1], 0), makeNormal(t[2], 1), makeNormal(t[3], 1)};
		}

		r4 = 0.15;
		r5 = 0.599;
		for(int i = 0; i < 16; i++){
			t = new vector[]{  put(r4*Math.cos(i*theta), 0.8, r4*Math.sin(i*theta)),
							  put(r4*Math.cos((i+1)*theta), 0.8, r4*Math.sin((i+1)*theta)),
							  put(r5*Math.cos((i+1)*theta), 1.4, r5*Math.sin((i+1)*theta)),
							  put(r5*Math.cos(i*theta), 1.4, r5*Math.sin(i*theta))

							};
			polygons[82+i] = new polygon3D(t, t[0], t[1], t[3], house.textures[13]);
			polygons[82+i].scaleX = 1;
			polygons[82+i].scaleY = 2;
		}

		for(int i = 0; i < 99; i++){
			polygons[i].ambient_I = 4;
			polygons[i].setLightSource( LightSource.s3);
		}

	}

	public vector makeNormal(vector vertix, int i){
		vector temp = vertix.myClone();
		temp.subtract(specularCentre[i]);
		temp.unit();
		return temp;
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