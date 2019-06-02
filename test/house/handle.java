
public class handle extends solidObject{

	public vector start;
	public vector iDirection, jDirection, kDirection;
	
	public handle(double x, double y, double z, int orientation){
		start = new vector(x,y,z);
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);
		
		if(orientation ==1){
			iDirection.rotate_YZ(Math.PI/2);
			jDirection.rotate_YZ(Math.PI/2);
			kDirection.rotate_YZ(Math.PI/2);
		}
		
		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
	}
	
	public void makeBoundary(){
		double x = 0.25; double y = 0.8; double  z = 0.2;
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
		polygons = new polygon3D[20];
		vector[] t;
		
		t = new vector[]{put(0, 0.7, 0.16), put(0, 0.7, 0), put(0, 0.1, 0), put(0, 0.1, 0.16)};
		polygons[0] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0, 0.1, 0), put(0, 0.7, 0), put(0.1, 0.7, 0), put(0.1, 0.1, 0)};
		polygons[1] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.1, 0.1, 0.16), put(0.1, 0.7, 0.16), put(0, 0.7, 0.16), put(0, 0.1, 0.16)};
		polygons[2] = new polygon3D(t, t[0],  t[3], t[1], house.textures[46]);
		
		t = new vector[]{put(0.1, 0.1, 0.16), put(0.1, 0.1, 0), put(0.1, 0.7, 0), put(0.1, 0.7, 0.16)};
		polygons[3] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0, 0.7, 0), put(0, 0.7, 0.16), put(0.15, 0.85, 0.16), put(0.15, 0.85, 0)};
		polygons[4] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0, 0.7, 0), put(0.15, 0.85, 0), put(0.15, 0.75, 0), put(0.1, 0.7, 0)};
		polygons[5] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.1, 0.7, 0.16), put(0.15, 0.75, 0.16), put(0.15, 0.85, 0.16), put(0, 0.7, 0.16)};
		polygons[6] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.1, 0.7, 0), put(0.15, 0.75, 0), put(0.15, 0.75, 0.16), put(0.1, 0.7, 0.16)};
		polygons[7] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.15, 0.75, 0), put(0.15, 0.85, 0), put(0.25, 0.85, 0), put(0.25, 0.75, 0)};
		polygons[8] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.25, 0.75, 0.16), put(0.25, 0.85, 0.16), put(0.15, 0.85, 0.16), put(0.15, 0.75, 0.16)};
		polygons[9] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.25, 0.85, 0), put(0.15, 0.85, 0), put(0.15, 0.85, 0.16), put(0.25, 0.85, 0.16)};
		polygons[10] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.25, 0.75, 0.16), put(0.15, 0.75, 0.16), put(0.15, 0.75, 0), put(0.25, 0.75, 0)};
		polygons[11] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0, 0.1, 0), put(0.1, 0.1, 0), put(0.15, 0.05, 0), put(0.15, -0.05, 0)};
		polygons[12] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.15, -0.05, 0.16), put(0.15, 0.05, 0.16), put(0.1, 0.1, 0.16), put(0, 0.1, 0.16)};
		polygons[13] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0, 0.1, 0), put(0.15, -0.05, 0), put(0.15, -0.05, 0.16), put(0, 0.1, 0.16)};
		polygons[14] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.15, 0.05, 0.16), put(0.15, 0.05, 0), put(0.1, 0.1, 0), put(0.1, 0.1, 0.16)};
		polygons[15] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.15, 0.05, 0), put(0.15, 0.05, 0.16), put(0.25, 0.05, 0.16), put(0.25, 0.05, 0)};
		polygons[16] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.25, -0.05, 0), put(0.25, -0.05, 0.16), put(0.15, -0.05, 0.16), put(0.15, -0.05, 0)};
		polygons[17] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.15, 0.05, 0), put(0.25, 0.05, 0), put(0.25, -0.05, 0), put(0.15, -0.05, 0)};
		polygons[18] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		t = new vector[]{put(0.15, -0.05, 0.16), put(0.25, -0.05, 0.16), put(0.25, 0.05, 0.16), put(0.15, 0.05, 0.16)};
		polygons[19] = new polygon3D(t, t[0],  t[1], t[3], house.textures[46]);
		
		for(int i = 0; i < 20; i++){
			polygons[i].ambient_I = 3;
			polygons[i].setLightSource( LightSource.s10);
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
