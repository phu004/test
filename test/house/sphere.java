public class sphere  extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;
	public double theta_, angle;
	public double height;
	vector[][] vertixs;

	public sphere(double x, double y, double z){
		start = new vector(x,y,z);

		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		vertixs = new vector[21][20];

		this.start = start;
		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
		code = "sphere";
		theta_ = Math.PI/45;
		sortedPolygons = true;
	}

	public void makeBoundary(){
		boundary = new polygon3D[6];
		vector[] a = new vector[]{put(-1.5, -1.5, -1.5), put(-1.5, 1.5, -1.5), put(1.5, 1.5, -1.5), put(1.5, -1.5, -1.5)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(1.5, 1.5, -1.5), put(1.5, 1.5, 1.5), put(1.5, -1.5, 1.5), put(1.5, -1.5, -1.5)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(1.5, 1.5, 1.5), put(-1.5, 1.5, 1.5), put(-1.5, -1.5, 1.5), put(1.5, -1.5, 1.5)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(-1.5, 1.5, 1.5), put(-1.5, 1.5, -1.5), put(-1.5, -1.5, -1.5), put(-1.5, -1.5, 1.5)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(-1.5, 1.5, -1.5), put(-1.5, 1.5, 1.5), put(1.5, 1.5, 1.5), put(1.5, 1.5, -1.5)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(1.5, -1.5, -1.5), put(1.5, -1.5, 1.5),put(-1.5, -1.5, 1.5), put(-1.5, -1.5, -1.5)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}

	public void makePolygons(){
		specularCentre = new vector[]{put(0, 0, 0)};

		double R = 1.3;

		double[] h = new double[21];
		double[] r = new double[21];

		double angle = 0;
		for(int i = 0; i < 21; i ++){
			angle = Math.PI/20*i;
			h[i] = R*Math.cos(angle);
			r[i] = R*Math.sin(angle)+0.001;
		}

		for(int i = 0; i < 21; i++){
			angle=0;
			for(int j = 0; j < 20; j++){
				vertixs[i][j] = put(0, h[i], 0);
				vertixs[i][j].add(Math.sin(angle)*r[i], 0, -Math.cos(angle)*r[i]);
				angle+=(Math.PI/10);
			}
		}

		polygons = new polygon3D[400];
		vector[] t;

		for(int i = 0; i < 20; i ++){
			for(int j = 0; j < 20; j++){
				t = new vector[]{vertixs[i][j], vertixs[i][(j+21)%20],  vertixs[i+1][(j+21)%20], vertixs[i+1][j]};
				polygons[i*20 + j] = polygon3D.createPolygon(t, t[0].myClone(), t[1].myClone(), t[3].myClone(), house.textures[15], j, i, (double)1/20, (double)1/20);
				polygons[i*20 + j].gouraudShading = true;
				polygons[i*20 + j].roughness = 1;
				polygons[i*20 + j].vertixNormals = new vector[]{makeNormal(t[0],0), makeNormal(t[1], 0), makeNormal(t[2], 0), makeNormal(t[3], 0)};
			}
		}

	}

	public void move(){
		angle+=(theta_*2);
		vector.sinXZ = Math.sin(theta_);
		vector.cosXZ = Math.cos(theta_);
		height = 0.05* Math.sin(angle);

		for(int i = 0; i < 400; i ++){
			polygons[i].realNormal.rotateXZ();


			polygons[i].realCentre.subtract(start);
			polygons[i].realCentre.rotateXZ();
			polygons[i].realCentre.add(start);
			polygons[i].realCentre.y+=height;

			polygons[i].origin.subtract(start);
			polygons[i].origin.rotateXZ();
			polygons[i].origin.add(start);
			polygons[i].origin.y+=height;

			polygons[i].rightEnd.subtract(start);
			polygons[i].rightEnd.rotateXZ();
			polygons[i].rightEnd.add(start);
			polygons[i].rightEnd.y+=height;

			polygons[i].bottomEnd.subtract(start);
			polygons[i].bottomEnd.rotateXZ();
			polygons[i].bottomEnd.add(start);
			polygons[i].bottomEnd.y+=height;

			polygons[i].findDiffuse();

			for(int j = 0; j< 4; j++)
				polygons[i].vertixNormals[j].rotateXZ();
		}

		for(int i = 0; i < 21; i++){
			for(int j = 0; j < 20; j++){
				vertixs[i][j].subtract(start);
				vertixs[i][j].rotateXZ();
				vertixs[i][j].add(start);
				vertixs[i][j].y+=height;
			}
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
		temp.add(iDirection, i);
		temp.add(jDirection, j);
		temp.add(kDirection, k);
		return temp;
	}



}