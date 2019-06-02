
public class woodChairLower extends solidObject{
	public vector start;
	public vector iDirection, jDirection, kDirection;
	public vector  tempi, tempj, tempk;
	public double  angle;
	
	public woodChairLower(double x, double y, double z, double angle){
		start = new vector(x,y,z);
		tempi = new vector(0,0,0);
		tempj = new vector(0,0,0);
		tempk = new vector(0,0,0);
		this.angle = angle;

		
		iDirection = new vector(0.9,0,0);
		jDirection = new vector(0,0.85,0);
		kDirection = new vector(0,0,0.9);

		makeBoundary();
		super.visible = super.testVisibility();
		super.tempCentre = new vector(0,0,0);
		super.findCentre();
		makePolygons();
	}
	
	public void makeBoundary(){
		double x = 3; double y = 3.2; double  z = 3;
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
		polygons = new polygon3D[50];
		vector[] t;
		
		t = new vector[]{put(0, 3.25, 3), put(3, 3.25, 3), put(2.75, 3.25, 0), put(0.25, 3.25, 0)};
		polygons[0] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.25, 3.25, 0), put(2.75, 3.25, 0), put(2.75, 3.1, 0), put(0.25, 3.1, 0)};
		polygons[1] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		polygons[1].scaleY = 0.1;		
		
		t = new vector[]{put(2.75, 3.1, 0), put(2.75, 3.25, 0), put(3, 3.25, 3), put(3, 3.1, 3)};
		polygons[2] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		polygons[2].scaleX = 0.1;	
		
		t = new vector[]{put(0, 3.1, 3), put(0, 3.25, 3), put(0.25, 3.25, 0), put(0.25, 3.1, 0)};
		polygons[3] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		polygons[3].scaleX = 0.1;	
		
		t = new vector[]{put(3, 3.25, 3), put(0, 3.25, 3), put(0, 3.1, 3), put(3, 3.1, 3)};
		polygons[4] = new polygon3D(t, t[0], t[1], t[3], house.textures[42]);
		polygons[4].scaleY = 0.1;	
		
		t = new vector[]{put(0.25, 3.1, 0), put(2.75, 3.1, 0), put(3, 3.1, 3), put(0, 3.1, 3)};
		polygons[5] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		
		t = new vector[]{put(0.3, 3.099, 0.05), put(0.55, 3.099, 0.05), put(0.55, 0, 0.05), put(0.3, 0, 0.05)};
		polygons[6] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.55, 0, 0.05), put(0.55, 3.099, 0.05), put(0.55, 3.099, 0.3), put(0.55, 0, 0.3)};
		polygons[7] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.3, 3.099, 0.3), put(0.3, 3.099, 0.05), put(0.3, 0, 0.05)};
		polygons[8] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.55, 0, 0.3), put(0.55, 3.099, 0.3), put(0.3, 3.099, 0.3)};
		polygons[9] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		vector temp = new vector(0,0,0);
		temp = start.myClone();
		
		start = put(1.94/0.9,0,0);
		
		
		t = new vector[]{put(0.3, 3.099, 0.05), put(0.55, 3.099, 0.05), put(0.55, 0, 0.05), put(0.3, 0, 0.05)};
		polygons[10] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.55, 0, 0.05), put(0.55, 3.099, 0.05), put(0.55, 3.099, 0.3), put(0.55, 0, 0.3)};
		polygons[11] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.3, 3.099, 0.3), put(0.3, 3.099, 0.05), put(0.3, 0, 0.05)};
		polygons[12] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.55, 0, 0.3), put(0.55, 3.099, 0.3), put(0.3, 3.099, 0.3)};
		polygons[13] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);	
		
		start = put(0.2/0.9,0, 2.3/0.9);
		
		t = new vector[]{put(0.3, 3.099, 0.05), put(0.55, 3.099, 0.05), put(0.55, 0, 0.05), put(0.3, 0, 0.05)};
		polygons[14] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.55, 0, 0.05), put(0.55, 3.099, 0.05), put(0.55, 3.099, 0.3), put(0.55, 0, 0.3)};
		polygons[15] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.3, 3.099, 0.3), put(0.3, 3.099, 0.05), put(0.3, 0, 0.05)};
		polygons[16] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.55, 0, 0.3), put(0.55, 3.099, 0.3), put(0.3, 3.099, 0.3)};
		polygons[17] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);	
		
		start = put(-2.35/0.9,0, 0);

		
		t = new vector[]{put(0.3, 3.099, 0.05), put(0.55, 3.099, 0.05), put(0.55, 0, 0.05), put(0.3, 0, 0.05)};
		polygons[18] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.55, 0, 0.05), put(0.55, 3.099, 0.05), put(0.55, 3.099, 0.3), put(0.55, 0, 0.3)};
		polygons[19] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.3, 3.099, 0.3), put(0.3, 3.099, 0.05), put(0.3, 0, 0.05)};
		polygons[20] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.3, 0, 0.3), put(0.55, 0, 0.3), put(0.55, 3.099, 0.3), put(0.3, 3.099, 0.3)};
		polygons[21] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);	
		
		start.set(temp);
		
		t = new vector[]{put(0.55, 3.099, 0.1), put(2.455, 3.099, 0.1), put(2.455, 2.6, 0.1), put(0.55, 2.6, 0.1)};
		polygons[22] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		polygons[22].scaleY = 0.3;	
		
		t = new vector[]{put(0.55, 2.6, 0.25), put(2.455, 2.6, 0.25), put(2.455, 3.099, 0.25), put(0.55, 3.099, 0.25)};
		polygons[23] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		polygons[23].scaleX = 0.3;	
		
		t = new vector[]{put(0.55, 2.6, 0.1), put(2.455, 2.6, 0.1), put(2.455, 2.6, 0.25), put(0.55, 2.6, 0.25)};
		polygons[24] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.55, 1.25, 0.1), put(2.455, 1.25, 0.1), put(2.455, 1, 0.1), put(0.55, 1, 0.1)};
		polygons[25] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		polygons[25].scaleY = 0.3;	
		
		t = new vector[]{put(0.55, 1, 0.25), put(2.455, 1, 0.25), put(2.455, 1.25, 0.25), put(0.55, 1.25, 0.25)};
		polygons[26] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		polygons[26].scaleX = 0.3;	
		
		t = new vector[]{put(0.55, 1, 0.1), put(2.455, 1, 0.1), put(2.455, 1, 0.25), put(0.55, 1, 0.25)};
		polygons[27] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.55, 1.25, 0.25), put(2.455, 1.25, 0.25), put(2.455, 1.25, 0.1), put(0.55, 1.25, 0.1)};
		polygons[28] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		temp = start.myClone();
		start = put(0,0,2.3/0.9);
	
		
		t = new vector[]{put(0.32, 3.099, 0.1), put(2.67, 3.099, 0.1), put(2.67, 2.6, 0.1), put(0.32, 2.6, 0.1)};
		polygons[29] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		polygons[29].scaleY = 0.3;	
		
		t = new vector[]{put(0.32, 2.6, 0.25), put(2.67, 2.6, 0.25), put(2.67, 3.099, 0.25), put(0.32, 3.099, 0.25)};
		polygons[30] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		polygons[30].scaleX = 0.3;	
		
		t = new vector[]{put(0.32, 2.6, 0.1), put(2.67, 2.6, 0.1), put(2.67, 2.6, 0.25), put(0.32, 2.6, 0.25)};
		polygons[31] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.32, 1.25, 0.1), put(2.67, 1.25, 0.1), put(2.67, 1, 0.1), put(0.32, 1, 0.1)};
		polygons[32] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		polygons[32].scaleY = 0.3;	
		
		t = new vector[]{put(0.32, 1, 0.25), put(2.67, 1, 0.25), put(2.67, 1.25, 0.25), put(0.32, 1.25, 0.25)};
		polygons[33] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		polygons[33].scaleX = 0.3;	
		
		t = new vector[]{put(0.32, 1, 0.1), put(2.67, 1, 0.1), put(2.67, 1, 0.25), put(0.32, 1, 0.25)};
		polygons[34] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(0.32, 1.25, 0.25), put(2.67, 1.25, 0.25), put(2.67, 1.25, 0.1), put(0.32, 1.25, 0.1)};
		polygons[35] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		start.set(temp);
		t = new vector[]{put(2.66, 3.099, 0.313), put(2.87, 3.099, 2.587), put(2.87, 2.6, 2.587), put(2.66, 2.6, 0.313)};
		polygons[36] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.51, 2.6, 0.314), put(2.72, 2.6, 2.587), put(2.72, 3.099, 2.587), put(2.51, 3.099, 0.314)};
		polygons[37] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.66, 2.6, 0.313), put(2.87, 2.6, 2.587), put(2.72, 2.6, 2.587), put(2.51, 2.6, 0.313)};
		polygons[38] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.66, 1.25, 0.313), put(2.87, 1.25, 2.587), put(2.87, 1, 2.587), put(2.66, 1, 0.313)};
		polygons[39] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.51, 1, 0.314), put(2.72, 1, 2.587), put(2.72, 1.25, 2.587), put(2.51, 1.25, 0.314)};
		polygons[40] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.66, 1, 0.313), put(2.87, 1, 2.587), put(2.72, 1, 2.587), put(2.51, 1, 0.313)};
		polygons[41] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.51, 1.25, 0.313), put(2.72, 1.25, 2.587), put(2.87, 1.25, 2.587), put(2.66, 1.25, 0.313)};
		polygons[42] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		iDirection = new vector(-0.9,0,0);
		
		start = put(2.7/-0.9,0,0);
	
		
		t = new vector[]{put(2.66, 2.6, 0.313), put(2.87, 2.6, 2.587), put(2.87, 3.099, 2.587), put(2.66, 3.099, 0.313)};
		polygons[43] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.51, 3.099, 0.314), put(2.72, 3.099, 2.587), put(2.72, 2.6, 2.587), put(2.51, 2.6, 0.314)};
		polygons[44] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.51, 2.6, 0.313), put(2.72, 2.6, 2.587), put(2.87, 2.6, 2.587),put(2.66, 2.6, 0.313) };
		polygons[45] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.66, 1, 0.313), put(2.87, 1, 2.587), put(2.87, 1.25, 2.587),put(2.66, 1.25, 0.313) };
		polygons[46] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.51, 1.25, 0.314), put(2.72, 1.25, 2.587), put(2.72, 1, 2.587) ,put(2.51, 1, 0.314)};
		polygons[47] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.51, 1, 0.313), put(2.72, 1, 2.587), put(2.87, 1, 2.587),put(2.66, 1, 0.313) };
		polygons[48] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		t = new vector[]{put(2.66, 1.25, 0.313), put(2.87, 1.25, 2.587), put(2.72, 1.25, 2.587), put(2.51, 1.25, 0.313)};
		polygons[49] = new polygon3D(t, t[0], t[3], t[1], house.textures[42]);
		
		start.set(temp);
		
		for(int i = 0; i < 50; i++){
			//polygons[i].ambient_I = 2;
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

