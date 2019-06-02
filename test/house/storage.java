
public class storage extends solidObject{
	
	public vector start;
	public vector iDirection, jDirection, kDirection;

	
	public storage(double x, double y, double z){
		start = new vector(x,y,z);

		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1,0);
		kDirection = new vector(0,0,1);
		
		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
	}
	
	public void makeBoundary(){
		double x = 5; double y = 6; double  z = 20;
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
		polygons = new polygon3D[22];
		vector[] t;
	
		t = new vector[]{put(0.5, 1, 19.7), put(0.5, 1, 0.8), put(0.5, 0, 0.8), put(0.5, 0, 19.7)};
		polygons[0] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		polygons[0].scaleY = 2;
		polygons[0].scaleX = 0.1;
		
		t = new vector[]{put(0.5, 1, 20), put(0.5, 1, 19.7), put(0.5, 0.5, 19.7), put(0.5, 0.5, 20)};
		polygons[1] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		polygons[1].scaleY = 0.1;
		polygons[1].scaleX = 0.1;
		
		t = new vector[]{put(0.5, 1, 0.8), put(0.5, 1, 0.5), put(0.5, 0.5, 0.5), put(0.5, 0.5, 0.8)};
		polygons[2] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		polygons[2].scaleY = 0.1;
		polygons[2].scaleX = 0.1;
		
		t = new vector[]{put(-0.01, 1, 20), put(-0.01, 1, 0.5), put(0.51, 1, 0.5), put(0.51, 1, 20)};
		polygons[3] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		
		t = new vector[]{put(0, 6.01, 20), put(0, 6.01, 0.5), put(0, 1, 0.5), put(0, 1, 20)};
		polygons[4] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		polygons[4].scaleY = 2.5;
		
		iDirection = new vector(1.1,0,0);
		t = new vector[]{put(-0.02, 6, 15.03), put(-0.02, 6, 14.97), put(-0.02, 1, 14.97), put(-0.02, 1, 15.03)};
		polygons[5] = new polygon3D(t, t[0], t[3], t[1], house.textures[44]);
		
		t = new vector[]{put(-0.02, 6, 10.03), put(-0.02, 6, 9.97), put(-0.02, 1, 9.97), put(-0.02, 1, 10.03)};
		polygons[6] = new polygon3D(t, t[0], t[3], t[1], house.textures[44]);
		
		t = new vector[]{put(-0.02, 6, 5.03), put(-0.02, 6, 4.97), put(-0.02, 1, 4.97), put(-0.02, 1, 5.03)};
		polygons[7] = new polygon3D(t, t[0], t[3], t[1], house.textures[44]);
		
		t = new vector[]{put(-0.02, 6, 2.62), put(-0.02, 6, 2.58), put(-0.02, 1, 2.58), put(-0.02, 1, 2.62)};
		polygons[8] = new polygon3D(t, t[0], t[3], t[1], house.textures[44]);
		
		t = new vector[]{put(-0.02, 6, 7.52), put(-0.02, 6, 7.48), put(-0.02, 1, 7.48), put(-0.02, 1, 7.52)};
		polygons[9] = new polygon3D(t, t[0], t[3], t[1], house.textures[44]);
		
		t = new vector[]{put(-0.02, 6, 12.52), put(-0.02, 6, 12.48), put(-0.02, 1, 12.48), put(-0.02, 1, 12.52)};
		polygons[10] = new polygon3D(t, t[0], t[3], t[1], house.textures[44]);
		
		iDirection = new vector(1,0,0);
		jDirection = new vector(0,1.05,0);
		
		t = new vector[]{put(-0.02, 2.63, 20), put(-0.02, 2.63, 15), put(-0.02, 2.57, 15), put(-0.02, 2.57, 20)};
		polygons[11] = new polygon3D(t, t[0], t[3], t[1], house.textures[44]);
		
		t = new vector[]{put(-0.02, 4.33, 20), put(-0.02, 4.33, 15), put(-0.02, 4.27, 15), put(-0.02, 4.27, 20)};
		polygons[12] = new polygon3D(t, t[0], t[3], t[1], house.textures[44]);
		
		jDirection = new vector(0,1,0);
		
		t = new vector[]{put(5, 6, 20), put(5, 6, 12.5), put(-0.01, 6, 12.5), put(-0.01, 6, 20)};
		polygons[13] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		
		t = new vector[]{put(5, 6, 7.5), put(5, 6, 0.5), put(-0.02, 6, 0.5), put(-0.01, 6, 7.5)};
		polygons[14] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		
		t = new vector[]{put(5, 6, 12.51), put(5, 6, 7.49), put(4, 6, 7.49), put(4, 6, 12.51)};
		polygons[15] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		polygons[15].scaleY = 0.75;
		polygons[15].scaleX = 0.25;
		
		t = new vector[]{put(0.5, 6, 12.51), put(0.5, 6, 7.49), put(0, 6, 7.49), put(0, 6, 12.51)};
		polygons[16] = new polygon3D(t, t[0], t[3], t[1], house.textures[43]);
		polygons[16].scaleY = 0.75;
		polygons[16].scaleX = 0.15;
		
		t = new vector[]{put(4, 6, 12.5), put(4, 6, 7.5), put(3.65, 4.3, 7.85), put(3.65, 4.3, 12.15)};
		polygons[17] = new polygon3D(t, t[0], t[3], t[1], house.textures[45]);
		polygons[17].ambient_I = -2;
		polygons[17].setLightSource( LightSource.s10);
		
		t = new vector[]{put(3.65, 4.3, 7.85), put(4, 6, 7.5), put(0.5, 6, 7.5), put(0.85, 4.3, 7.85)};
		polygons[18] = new polygon3D(t, t[1], t[0], t[2], house.textures[45]);
		polygons[18].ambient_I = -2;
		polygons[18].setLightSource( LightSource.s10);
		
		t = new vector[]{put(0.85, 4.3, 7.85), put(0.5, 6, 7.5), put(0.5, 6, 12.5), put(0.85, 4.3, 12.15)};
		polygons[19] = new polygon3D(t, t[1], t[0], t[2], house.textures[45]);
		polygons[19].ambient_I = 6;
		polygons[19].setLightSource( LightSource.s10);
		
		t = new vector[]{put(0.85, 4.3, 12.15), put(0.5, 6, 12.5), put(4, 6, 12.5), put(3.65, 4.3, 12.15)};
		polygons[20] = new polygon3D(t, t[1], t[0], t[2], house.textures[45]);
		polygons[20].ambient_I = 4;
		polygons[20].setLightSource( LightSource.s10);
		
		
		t = new vector[]{put(0.85, 4.3, 12.15), put(3.65, 4.3, 12.15), put(3.65, 4.3, 7.85), put(0.85, 4.3, 7.85)};
		polygons[21] = new polygon3D(t, t[1], t[0], t[2], house.textures[45]);
		polygons[21].ambient_I = 3;
		polygons[21].setLightSource( LightSource.s10);
		
		for(int i = 0; i < 17; i++){
			polygons[i].ambient_I = 1;
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
