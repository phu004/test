
public class woodChairUpper extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector  tempi, tempj, tempk;
	public double  angle;
	
	public woodChairUpper(double x, double y, double z, double angle){
		start = new vector(x,y,z);
		tempi = new vector(0,0,0);
		tempj = new vector(0,0,0);
		tempk = new vector(0,0,0);
		this.angle = angle;

		
		iDirection = new vector(0.9,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,0.9);

		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
	}
	
	public void makeBoundary(){
		double x = 3; double y = 3.5; double  z = 3.3;
		boundary = new polygon3D[6];
		vector[] a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
	}
	
	public void makePolygons(){
		polygons = new polygon3D[34];
		vector[] t;
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.3, 1, 0.3), put(0.3, 1, 0.05), put(0.3, 0, 0.05)};
		polygons[0] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.3, 1, 0.3), put(0.3, 3.5, -0.1), put(0.3, 3.5, -0.35), put(0.3, 1, 0.05)};
		polygons[1] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 0, 0.05), put(0.55, 1, 0.05), put(0.55, 1, 0.3), put(0.55, 0, 0.3)};
		polygons[2] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 1, 0.05), put(0.55, 3.5, -0.35), put(0.55, 3.5, -0.1), put(0.55, 1, 0.3)};
		polygons[3] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.3, 1, 0.3), put(0.3, 0, 0.3), put(0.55, 0, 0.3), put(0.55, 1, 0.3)};
		polygons[4] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.3, 3.5, -0.1), put(0.3, 1, 0.3), put(0.55, 1, 0.3), put(0.55, 3.5, -0.1)};
		polygons[5] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 1, 0.05), put(0.55, 0, 0.05), put(0.3, 0, 0.05),put(0.3,1, 0.05)};
		polygons[6] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 1, 0.05), put(0.3,1, 0.05), put(0.3,3.5, -0.35), put(0.55,3.5, -0.35)};
		polygons[7] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55,3.5, -0.35), put(0.3,3.5, -0.35), put(0.3,3.5, -0.1), put(0.55,3.5, -0.1)};
		polygons[8] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		vector temp = new vector(0,0,0);
			
		temp.set(start);
		start= put(1.94/0.9,0,0);
		
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.3, 1, 0.3), put(0.3, 1, 0.05), put(0.3, 0, 0.05)};
		polygons[9] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.3, 1, 0.3), put(0.3, 3.5, -0.1), put(0.3, 3.5, -0.35), put(0.3, 1, 0.05)};
		polygons[10] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 0, 0.05), put(0.55, 1, 0.05), put(0.55, 1, 0.3), put(0.55, 0, 0.3)};
		polygons[11] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 1, 0.05), put(0.55, 3.5, -0.35), put(0.55, 3.5, -0.1), put(0.55, 1, 0.3)};
		polygons[12] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.3, 1, 0.3), put(0.3, 0, 0.3), put(0.55, 0, 0.3), put(0.55, 1, 0.3)};
		polygons[13] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.3, 3.5, -0.1), put(0.3, 1, 0.3), put(0.55, 1, 0.3), put(0.55, 3.5, -0.1)};
		polygons[14] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 1, 0.05), put(0.55, 0, 0.05), put(0.3, 0, 0.05),put(0.3,1, 0.05)};
		polygons[15] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 1, 0.05), put(0.3,1, 0.05), put(0.3,3.5, -0.35), put(0.55,3.5, -0.35)};
		polygons[16] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55,3.5, -0.35), put(0.3,3.5, -0.35), put(0.3,3.5, -0.1), put(0.55,3.5, -0.1)};
		polygons[17] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		start.set(temp);
		start = put(0,-0.7,- 0.13);
		
		
		jDirection = new vector(0,1.2,0);
		
		t = new vector[]{put(0.55, 3.2, 0.06), put(1.5, 3.2, -0.11), put(1.5, 3.2, -0.27), put(0.55, 3.2, -0.1)};
		polygons[18] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(1.5, 3.2, -0.27), put(1.5, 3.2, -0.11), put(2.45, 3.2, 0.06), put(2.45, 3.2, -0.1)};
		polygons[19] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 2.9, -0.09), put(1.5, 2.9, -0.26),put(1.5, 2.9, -0.10), put(0.55, 2.9, 0.07)};
		polygons[20] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(2.45, 2.9, -0.09), put(2.45, 2.9, 0.07), put(1.5, 2.9, -0.10), put(1.5,2.9, -0.26)};
		polygons[21] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 3.2, -0.1), put(1.5, 3.2, -0.27), put(1.5, 2.9, -0.26), put(0.55, 2.9, -0.09)};
		polygons[22] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 2.9, 0.07), put(1.5, 2.9, -0.1), put(1.5, 3.2, -0.11), put(0.55, 3.2, 0.06)};
		polygons[23] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(1.5, 3.2, -0.11), put(1.5, 2.9, -0.1), put(2.45, 2.9, 0.07), put(2.45, 3.2, 0.06)};
		polygons[24] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(2.45, 3.2, -0.1), put(2.45, 2.9, -0.09), put(1.5, 2.9, -0.26), put(1.5, 3.2, -0.27)};
		polygons[25] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		start = put(0, -1, 0.18);
		
		
		t = new vector[]{put(0.55, 3.2, 0.06), put(1.5, 3.2, -0.11), put(1.5, 3.2, -0.27), put(0.55, 3.2, -0.1)};
		polygons[26] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(1.5, 3.2, -0.27), put(1.5, 3.2, -0.11), put(2.45, 3.2, 0.06), put(2.45, 3.2, -0.1)};
		polygons[27] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 2.9, -0.09), put(1.5, 2.9, -0.26),put(1.5, 2.9, -0.10), put(0.55, 2.9, 0.07)};
		polygons[28] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(2.45, 2.9, -0.09), put(2.45, 2.9, 0.07), put(1.5, 2.9, -0.10), put(1.5,2.9, -0.26)};
		polygons[29] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 3.2, -0.1), put(1.5, 3.2, -0.27), put(1.5, 2.9, -0.26), put(0.55, 2.9, -0.09)};
		polygons[30] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(0.55, 2.9, 0.07), put(1.5, 2.9, -0.1), put(1.5, 3.2, -0.11), put(0.55, 3.2, 0.06)};
		polygons[31] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(1.5, 3.2, -0.11), put(1.5, 2.9, -0.1), put(2.45, 2.9, 0.07), put(2.45, 3.2, 0.06)};
		polygons[32] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		t = new vector[]{put(2.45, 3.2, -0.1), put(2.45, 2.9, -0.09), put(1.5, 2.9, -0.26), put(1.5, 3.2, -0.27)};
		polygons[33] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		
		start.set(temp);
		
		for(int i = 0; i < 34; i++){
			polygons[i].setLightSource( LightSource.s9);
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

		temp.add(tempi, i);
		temp.add(tempj, j);
		temp.add(tempk, k);
		return temp;
	}
}

