public class cylinder extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;

	public cylinder(double x, double y, double z){
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
		sortedPolygons = true;
		code = "cylinder";
	}

	public void makeBoundary(){
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(0, 0, 0), put(0, 6, 0), put(4, 6, 0), put(4, 0, 0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(4, 0, 0), put(4, 6, 0), put(4, 6, 4), put(4, 0, 4) };
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(4, 0, 4), put(4, 6, 4), put(0, 6, 4), put(0, 0, 4)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(0, 0, 4), put(0, 6, 4), put(0, 6, 0), put(0, 0, 0)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(0,6,0), put(0,6,4), put(4,6,4), put(4, 6, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(0,0,0), put(4,0,0), put(4,0,4), put(0, 0, 4)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		polygons = new polygon3D[33];
		vector[] t;

		specularCentre = new vector[]{put(2, 6, 2),put(2, 0, 2)};

		double r = 2;
		double theta = Math.PI/16;

		for(int i =0; i < 32; i++){
			t = new vector[]{put(r*Math.cos(i*theta) + r, 6, r*Math.sin(i*theta)+ r),
							 put(r*Math.cos((i+1)*theta) + r, 6, r*Math.sin((i+1)*theta) + r),
							 put(r*Math.cos((i+1)*theta) + r, 0, r*Math.sin((i+1)*theta) + r),
							 put(r*Math.cos(i*theta) + r, 0, r*Math.sin(i*theta) + r),
							};
			polygons[i] = polygon3D.createPolygon(t, t[0].myClone(), t[1].myClone(), t[3].myClone(), house.textures[0], i, 0, (double)1/32, 1);
			polygons[i].gouraudShading = true;
			polygons[i].roughness = 4;
			polygons[i].vertixNormals = new vector[]{makeNormal(t[0],0), makeNormal(t[1], 0), makeNormal(t[2], 1), makeNormal(t[3], 1)};
		}

		specularCentre = new vector[]{put(2, -100, 2),put(2, -100, 2)};
		t = new vector[32];
		for(int i = 1; i < 33; i++)
			t[32-i] = put(r*Math.cos(i*theta) + r, 6, r*Math.sin(i*theta) + r);
		polygons[32] = new polygon3D(t, put(0, 6, 0),  put(0, 6, 4), put(4, 6, 0), house.textures[0]);
		polygons[32].gouraudShading = true;
		polygons[32].roughness = 4;
		for(int i = 0; i < 32; i++)
			polygons[32].vertixNormals[i] = makeNormal(t[i], 0);
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
		temp.add(iDirection, i);
		temp.add(jDirection, j);
		temp.add(kDirection, k);
		return temp;
	}


}