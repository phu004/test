public final class vector{
	//x, y, z component of the vector
	public double x, y, z;

	//2d coordinate on screen
	public int screenX, screenY;

	public static int Z_length = 500;

	public static double cosXZ, cosYZ, sinXZ, sinYZ, old_X, old_Y, old_Z, zInverse, lengthInverse;

	public vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;

		updateLocation();
	}

	public vector(){
	}

	public final void add(vector v){
		x+=v.x;
		y+=v.y;
		z+=v.z;
	}

	public final void add(double a, double b, double c){
		x+=a;
		y+=b;
		z+=c;
	}

	public final void add(vector v, double scaler){
		x+=v.x*scaler;
		y+=v.y*scaler;
		z+=v.z*scaler;
	}

	public final void subtract(vector v, double scaler){
		x-=v.x*scaler;
		y-=v.y*scaler;
		z-=v.z*scaler;
	}

	public final void subtract(vector v){
		x-=v.x;
		y-=v.y;
		z-=v.z;
	}

	//amplify each component of the vector by a number
	public final void scale(double a){
		x*=a;
		y*=a;
		z*=a;
	}

	//make the length of this vector equal to one
	public final void unit(){
		lengthInverse = 1/getLength();
		x = x*lengthInverse;
		y = y*lengthInverse;
		z = z*lengthInverse;
	}

	public final double getLength(){
		return Math.sqrt(x*x + y*y + z*z);
	}

	//retrun the dot product of this vector with another vector
	public final double dot(vector v){
		return x*v.x + y*v.y + z*v.z;
	}

	public final double dot(double a, double b, double c){
		return x*a + y*b + z*c;
	}

	//return the cross product of this vector with another vector
	public final vector cross(vector v){
		return new vector(y*v.z - z*v.y, z*v.x - x*v.z, x*v.y - y*v.x);
	}

	//rotate the vector along Y axis
	public final void  rotate_XZ(double angle){
		double sin = Math.sin(angle);
		double cos = Math.cos(angle);
		double old_X = x;
		double old_Z = z;
		x = cos*old_X - sin*old_Z;
		z = sin*old_X + cos*old_Z;
	}

	//rotate the vector along X axis
	public final void rotate_YZ(double angle){
		double sin = Math.sin(angle);
		double cos = Math.cos(angle);
		old_Y = y;
		old_Z = z;
		y = cos*old_Y - sin*old_Z;
		z = sin*old_Y + cos*old_Z;
	}

	//rotate the vector vertically, return the new rotated vector
	public final void rotate_vertical(double angle){
		y = (Math.sqrt(x*x + z*z)*Math.tan(angle));
	}

	//use precalculated (from camera) sin and cos values to rotate the vector along Y axis
	public final void  rotate_XZ(){
		old_X = x;
		old_Z = z;
		x = camera.cosXZ*old_X - camera.sinXZ*old_Z;
		z = camera.sinXZ*old_X + camera.cosXZ*old_Z;
	}

	//use precalculated (from camera) sin and cos values to rotate the vector along X axis
	public final void rotate_YZ(){
		old_Y = y;
		old_Z = z;
		y = camera.cosYZ*old_Y - camera.sinYZ*old_Z;
		z = camera.sinYZ*old_Y + camera.cosYZ*old_Z;
	}

	//use precalculated (from default) sin and cos values to rotate the vector along X axis
	public final void  rotateXZ(){
		old_X = x;
		old_Z = z;
		x = cosXZ*old_X - sinXZ*old_Z;
		z = sinXZ*old_X + cosXZ*old_Z;
	}

	//use precalculated (from default) sin and cos values to rotate the vector along X axis
	public final void rotateYZ(){
		old_Y = y;
		old_Z = z;
		y = cosYZ*old_Y - sinYZ*old_Z;
		z = sinYZ*old_Y + cosYZ*old_Z;
	}


	//set all the component equal to the corresponding component of a given vector
	public final void set(vector v){
		x = v.x;
		y = v.y;
		z = v.z;
	}

	public final void set(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	//set all the component to 0
	public final void reset(){
		x = 0;
		y = 0;
		z = 0;
	}

	public final void updateLocation(){
		if(z <= 0.01){
			screenX = (int)(x*Z_length*100) + 320; screenY = (int)(-y*Z_length*100) + 240;
		}else{
			zInverse = Z_length/z;
			screenX = (int)(x*zInverse) + 320; screenY = (int)(-y*zInverse) + 240;
		}
	}

	public final vector myClone(){
		return new vector(x,y,z);
	}

	public String toString(){
		return "(" + x + ", " + y + ", " + z + ")";
	}

	public final void update(vector vertix){
		old_X = vertix.x - camera.position.x;
	 	old_Y = vertix.y - camera.position.y;
		old_Z = vertix.z - camera.position.z;

		x = camera.cosXZ*old_X - camera.sinXZ*old_Z;
		z = camera.sinXZ*old_X + camera.cosXZ*old_Z;

		old_Z = z;
		y = camera.cosYZ*old_Y - camera.sinYZ*old_Z;
		z = camera.sinYZ*old_Y + camera.cosYZ*old_Z;

		if(z <= 0.01){
			screenX = (int)(x*Z_length*100) + 320; screenY = (int)(-y*Z_length*100) + 240;
		}else{
			zInverse = Z_length/z;
			screenX = (int)(x*zInverse) + 320; screenY = (int)(-y*zInverse) + 240;
		}
	}

	public void setScreenLocation(vector v){
		screenX = v.screenX;
		screenY = v.screenY;
	}

}