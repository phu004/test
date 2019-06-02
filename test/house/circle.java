public class circle  extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector[] specularCentre;
	public double theta_, angle;
	public double height;
	vector[][] vertixs;

	public circle(double x, double y, double z){
		start = new vector(x,y,z);

		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);

		vertixs = new vector[20][16];

		this.start = start;
		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
		code = "circle";
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

		double r = 0.5;
		double R = 1.25;

		double a1 = Math.PI/10;
		double a2 = Math.PI/8;

		specularCentre = new vector[20];
		for(int i = 0; i < 20; i ++){
			specularCentre[i] = put(0, R, 0);
			jDirection.rotate_YZ(a1);
			kDirection.rotate_YZ(a1);
		}


		vector temp = start.myClone();
		start.set(0,0,0);
		for(int i = 0; i < 20; i++){
			double t = 0;
			for(int j = 0; j < 16; j++){
				vector C = specularCentre[i].myClone();
				C.add(put(Math.sin(t)*r, Math.cos(t)*r, 0));
				vertixs[i][j] = C;
				t+=a2;
			}
			jDirection.rotate_YZ(a1);
			kDirection.rotate_YZ(a1);
		}
		start.set(temp);

		polygons = new polygon3D[320];
		vector[] t;

		for(int i = 0; i < 20; i ++){
			for(int j = 0; j < 16; j++){
				t = new vector[]{vertixs[i][j], vertixs[(i+21)%20][j], vertixs[(i+21)%20][(j+17)%16], vertixs[i][(j+17)%16]};

				polygons[i*16 + j] = polygon3D.createPolygon(t, t[0].myClone(), t[1].myClone(), t[3].myClone(), house.textures[14], i, j, (double)1/8, (double)1/8);

				polygons[i*16 + j].gouraudShading = true;
				polygons[i*16 + j].roughness = 2;
				polygons[i*16 + j].vertixNormals = new vector[]{makeNormal(t[0],i), makeNormal(t[1], (i+21)%20), makeNormal(t[2], (i+21)%20), makeNormal(t[3], i)};
			}
		}

		sort_();
	}

	public void sort_(){
		for(int i = 1; i < polygons.length; i++){
			for(int j = 0; j <polygons.length - i; j++){
				vector temp1 = polygons[j+1].centre.myClone();
				temp1.subtract(start);
				vector temp2 = polygons[j].centre.myClone();
				temp2.subtract(start);

				if(temp1.getLength() > temp2.getLength()){
					polygon3D temp = polygons[j+1];
					polygons[j+1] = polygons[j];
					polygons[j] = temp;
				}
			}
		}

	}

	public void move(){
		angle+=(theta_*2);
		vector.sinXZ = Math.sin(theta_);
		vector.cosXZ = Math.cos(theta_);
		height = 0.05* Math.sin(angle);

		for(int i = 0; i < 320; i ++){
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

		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 16; j++){
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