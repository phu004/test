
public class LightSource{
	public static vector s1_ = new vector(0,10,-5);
	public static vector s1 = new vector(0, 10,-5);

	public static vector s2_ = new vector(0,0,0);
	public static vector s2 = new vector(0,0,0);

	public static vector s3_ = new vector(-20,4,-25);
	public static vector s3 = new vector(-20,4,-25);

	public static vector s4_ = new vector(-20,20.5,-25);
	public static vector s4 = new vector(-20,20.5,-25);

	public static vector s5_ = new vector(0,26.5,-5);
	public static vector s5 = new vector(0, 26.5,-5);

	public static vector s6_ = new vector(-23,4,45);
	public static vector s6 = new vector(-23,4,45);

	public static vector s7_ = new vector(-23,20.5,45);
	public static vector s7 = new vector(-23,20.5,45);

	public static vector s8_ = new vector(5,5,35);
	public static vector s8 = new vector(5,5,35);
	
	public static vector s9_ = new vector(-2,5,35);
	public static vector s9 = new vector(-2,5,35);
	
	public static vector s10_ = new vector(20,5,35);
	public static vector s10 = new vector(20,5,35);
	
	public static vector s11_ = new vector(25,4,-15);
	public static vector s11 = new vector(25,4,-15);


	//global  ambient
	public static int ambient = 25;

	public static void init(){
	s1_ .set(0,10,-5);
	s1.set(0, 10,-5);

	s2_.set(0,0,0);
	s2.set(0,0,0);

	s3_.set(-20,4,-25);
	s3.set(-20,4,-25);

	s4_ .set(-20,20.5,-25);
	s4 .set(-20,20.5,-25);

	s5_.set(0,26.5,-5);
	s5.set(0, 26.5,-5);

	s6_.set(-23,4,45);
	s6.set(-23,4,45);

	s7_.set(-23,20.5,45);
	s7.set(-23,20.5,45);

	s8_.set(5,5,35);
	s8.set(5,5,35);
	
	s9_.set(-2,5,35);
	s9.set(-2,5,35);

	s10_.set(20,5,35);
	s10.set(20,5,35);
	
	s11_.set(25,4,-15);
	s11.set(25,4,-15);


	}

	public static void update(){
		s1.set(s1_);
		s1.subtract(camera.position);
		s1.rotate_XZ();
		s1.rotate_YZ();

		s2.set(s2_);
		s2.subtract(camera.position);
		s2.rotate_XZ();
		s2.rotate_YZ();

		s3.set(s3_);
		s3.subtract(camera.position);
		s3.rotate_XZ();
		s3.rotate_YZ();

		s4.set(s4_);
		s4.subtract(camera.position);
		s4.rotate_XZ();
		s4.rotate_YZ();

		s5.set(s5_);
		s5.subtract(camera.position);
		s5.rotate_XZ();
		s5.rotate_YZ();

		s6.set(s6_);
		s6.subtract(camera.position);
		s6.rotate_XZ();
		s6.rotate_YZ();

		s7.set(s7_);
		s7.subtract(camera.position);
		s7.rotate_XZ();
		s7.rotate_YZ();

		s8.set(s8_);
		s8.subtract(camera.position);
		s8.rotate_XZ();
		s8.rotate_YZ();
		
		s9.set(s9_);
		s9.subtract(camera.position);
		s9.rotate_XZ();
		s9.rotate_YZ();
		
		s10.set(s10_);
		s10.subtract(camera.position);
		s10.rotate_XZ();
		s10.rotate_YZ();
		
		s11.set(s11_);
		s11.subtract(camera.position);
		s11.rotate_XZ();
		s11.rotate_YZ();
	}

}