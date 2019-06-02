public class modelBuilder{

	public static container world;
	public static vector start = new vector(0,0,0);
	public static vector iDirection = new vector(1,0,0);
	public static vector jDirection = new vector(0,1,0);
	public static vector kDirection = new vector(0,0,1);

	public static void build(){
		//container world
		polygon3D[] boundary = new polygon3D[6];
		vector[] a = new vector[]{new vector(-200, 200, 200), new vector(200, 200, 200), new vector(200, -200, 200), new vector(-200, -200, 200)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		vector[] b = new vector[]{new vector(200, 200, 200), new vector(200, 200, -200), new vector(200, -200, -200), new vector(200, -200, 200)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		vector[] c = new vector[]{new vector(200, 200, -200), new vector(-200, 200, -200), new vector(-200, -200, -200), new vector(200, -200, -200)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		vector[] d = new vector[]{new vector(-200, 200, -200), new vector(-200, 200, 200), new vector(-200, -200, 200), new vector(-200, -200, -200)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		vector[] e = new vector[]{new vector(200, 200, 200), new vector(-200, 200, 200), new vector(-200, 200, -200), new vector(200, 200, -200)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		vector[] f = new vector[]{new vector(200, -200, 200), new vector(200, -200, -200), new vector(-200, -200, -200), new vector(-200, -200, 200)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		world = new container(boundary, 13);
		world.backGroundModelCount = 2;

		//testObject tbA = new testObject(-10, -8, -15,  25, 34, 30);
		//world.addModel(tbA);

		//testObject tbB = new testObject(-35, -8, -15,  24.9, 17, 20);
		//world.addModel(tbB);

		//testObject tbC = new testObject(-35, -8, 5.1,  24.9, 17, 9.8);
		//world.addModel(tbC);

		//container A
		start = new vector(-10, -8, -15);
		double x = 24.9; double y = 34; double  z = 29.9;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerA = new container(boundary, 10);
		world.addModel(containerA);
		containerA.backGroundModelCount = 4;

		stairLower_B  stairL_B= new stairLower_B(5, -8, -15);
		containerA.addModel(stairL_B);
		stairL_B.modelType = 1;

		stairLower_A  stairL_A= new stairLower_A(5, -8, -15);
		containerA.addModel(stairL_A);
		stairL_A.modelType = 1;

		stairUpper_A stairU_A = new stairUpper_A(10, -8, -15);
		containerA.addModel(stairU_A);
		stairU_A.modelType = 1;

		stairUpper_B stairU_B = new stairUpper_B(10.5, -8, -15);
		containerA.addModel(stairU_B);
		stairU_B.modelType = 1;

		stairUpper_C stairU_C = new stairUpper_C(-10, -8,5 );
		containerA.addModel(stairU_C);

		wall_N_A wallNA = new  wall_N_A(-10, -8, 14.7);
		containerA.addModel(wallNA);

		wall_S_A wallSA = new wall_S_A(-10,-8, -15);
		containerA.addModel(wallSA);

		wall_E_A wallEA = new wall_E_A(15,-8, -15);
		containerA.addModel(wallEA);

		wall_W_A wallWA = new wall_W_A(-10,-8, -15);
		containerA.addModel(wallWA);

		ceiling_A ceilingA = new ceiling_A(-10,23.5, -15);
		containerA.addModel(ceilingA);


		//container B
		start = new vector(-35, -8, -15);
		 x = 24; y = 15; z = 19.5;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerB = new container(boundary, 14);
		world.addModel(containerB);
		containerB.backGroundModelCount = 5;

		desk deskB = new desk(-27, -8, -14);
		containerB.addModel(deskB);

		tableLamp TLB = new tableLamp(-21, -3.49, -13, (Math.PI/6) *-14);
		containerB.addModel(TLB);

		chair_upper ChairUB = new chair_upper(-24, -5.75, -7.5, Math.PI);
		containerB.addModel(ChairUB);

		chair_lower  ChairLB = new chair_lower(-24, -8, -7.5, Math.PI);
		containerB.addModel(ChairLB);

		bed bedB = new bed(-21.5, -8, 3.5);
		containerB.addModel(bedB);

		shelf_upper shelfUB1 = new shelf_upper(-12, 1, -2, Math.PI);
		containerB.addModel(shelfUB1);

		shelf_lower shelfLB1 = new shelf_lower(-12, 0.99, -2, Math.PI);
		containerB.addModel(shelfLB1);

		shelf_upper shelfUB2 = new shelf_upper(-12, -1, -2, Math.PI);
		containerB.addModel(shelfUB2);

		shelf_lower shelfLB2 = new shelf_lower(-12, -1.01, -2, Math.PI);
		containerB.addModel(shelfLB2);

		wall_S_B wallS_B = new wall_S_B(-35, -8, -15);
		containerB.addModel(wallS_B);

		wall_N_B wallN_B = new wall_N_B(-35, -8, 4.2);
		containerB.addModel(wallN_B);

		wall_E_B wallE_B = new wall_E_B(-10.5, -8, -15);
		containerB.addModel(wallE_B);

		wall_W_B wallW_B = new wall_W_B(-35, -8, 4.5);
		containerB.addModel(wallW_B);

		ceiling_B ceilingB = new ceiling_B(-35, 7, -15);
		containerB.addModel(ceilingB);

		//container C
		start = new vector(-56, -49, 5);
		 x = 46; y = 57; z = 9.8;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerC = new container(boundary, 5);
		world.addModel(containerC);
		containerC.backGroundModelCount = 0;

		door_C doorC = new door_C(-17.5, -8, 2.6);
		containerC.addModel(doorC);

		wall_S_C wallS_C = new wall_S_C(-35, -8, 5);
		containerC.addModel(wallS_C);

		ceiling_C ceilingC = new ceiling_C(-35, 7, 5);
		containerC.addModel(ceilingC);

		wall_W_C wallW_C = new wall_W_C(-35.5, -8, 15);
		containerC.addModel(wallW_C);

		wall_N_C wallN_C = new wall_N_C(-10, -8, 15);
		containerC.addModel(wallN_C);

		//container D
		start = new vector(-35, 8.5, -15);
		 x = 24.9; y = 16; z = 20;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerD = new container(boundary, 15);
		world.addModel(containerD);
		containerD.backGroundModelCount = 6;

		desk deskD = new desk(-27, 8.5, -14);
		containerD.addModel(deskD);
		deskD.setLightSource(LightSource.s4);

		tableLamp TLD = new tableLamp(-21, 13.01, -13, (Math.PI/6) *-14);
		containerD.addModel(TLD);
		TLD.setLightSource(LightSource.s4);

		chair_upper ChairUD = new chair_upper(-24, 10.75, -7.5, -Math.PI/4*3);
		containerD.addModel(ChairUD);
		ChairUD.setLightSource(LightSource.s4);

		chair_lower  ChairLD = new chair_lower(-24, 8.5, -7.5, -Math.PI/4*3);
		containerD.addModel(ChairLD);
		ChairLD.setLightSource(LightSource.s4);

		bed bedD = new bed(-21.5, 8.5, 3.5);
		containerD.addModel(bedD);
		bedD.setLightSource(LightSource.s4);

		shelf_upper shelfUD1 = new shelf_upper(-12, 17.5, -2, Math.PI);
		containerD.addModel(shelfUD1);
		shelfUD1.setLightSource(LightSource.s4);

		shelf_lower shelfLD1 = new shelf_lower(-12, 17.49, -2, Math.PI);
		containerD.addModel(shelfLD1);
		shelfLD1.setLightSource(LightSource.s4);

		shelf_upper shelfUD2 = new shelf_upper(-12, 15.5, -2, Math.PI);
		containerD.addModel(shelfUD2);
		shelfUD2.setLightSource(LightSource.s4);

		shelf_lower shelfLD2 = new shelf_lower(-12, 15.49, -2, Math.PI);
		containerD.addModel(shelfLD2);
		shelfLD2.setLightSource(LightSource.s4);

		wall_S_D wallS_D = new wall_S_D(-35, 8.5, -15);
		containerD.addModel(wallS_D);

		wall_N_D wallN_D = new wall_N_D(-35, 8.5, 4.2);
		containerD.addModel(wallN_D);

		wall_E_D wallE_D = new wall_E_D(-10.5, 8.5, -15);
		containerD.addModel(wallE_D);

		wall_W_D wallW_D = new wall_W_D(-35, 8.5, 4.5);
		containerD.addModel(wallW_D);

		ceiling_D ceilingD = new ceiling_D(-35, 23.5, -15);
		containerD.addModel(ceilingD);

		floorD floor_D = new floorD(-35, 8.5, -15);
		containerD.addModel(floor_D);

		//container E
		start = new vector(-35, 8.6,  5.1);
		 x = 25; y = 15; z = 9.8;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerE = new container(boundary, 6);
		world.addModel(containerE);
		containerE.backGroundModelCount = 2;

		wall_S_E wallS_E= new wall_S_E(-35, 8.5, 5);
		containerE.addModel(wallS_E);

		door_E doorE = new door_E(-17.5, 8.5, 2.6);
		containerE.addModel(doorE);

		wall_W_C wallW_E = new wall_W_C(-35.5, 8.5, 15);
		containerE.addModel(wallW_E);
		wallW_E.setLightSource(LightSource.s5);

		wall_N_C wallN_E = new wall_N_C(-10, 8.5, 15);
		containerE.addModel(wallN_E);
		wallN_E.setLightSource(LightSource.s5);

		ceiling_E ceilingE = new ceiling_E(-35, 23.5, 5);
		containerE.addModel(ceilingE);

		floor_E floorE = new floor_E(-35, 8.5, 5);
		containerE.addModel(floorE);

		//container F
		start = new vector(-35, -8, 15.1);
		x = 20; y = 15; z = 19.9;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerF = new container(boundary, 12);
		world.addModel(containerF);
		containerF.backGroundModelCount = 4;

		desk deskF = new desk(-28, -8, 30);
		containerF.addModel(deskF);
		deskF.setLightSource(LightSource.s6);

		wall_S_F wallS_F = new wall_S_F(-35, -8, 15);
		containerF.addModel(wallS_F);

		tableLamp TLF = new tableLamp(-22, -3.5, 32.5, (Math.PI/6) *12);
		containerF.addModel(TLF);
		TLF.setLightSource(LightSource.s6);

		chair_upper ChairUF = new chair_upper(-24, -5.75, 25, -Math.PI/4*3);
		containerF.addModel(ChairUF);
		ChairUF.setLightSource(LightSource.s6);

		chair_lower  ChairLF = new chair_lower(-24, -8, 25, -Math.PI/4*3);
		containerF.addModel(ChairLF);
		ChairLF.setLightSource(LightSource.s6);

		magicCube magicCubeF = new magicCube(-26, -3.5, 31);
		containerF.addModel(magicCubeF);

		door_F doorF = new door_F(-30.5, -8, 15.8);
		containerF.addModel(doorF);

		wall_W_H wallWH = new wall_W_H(-15, -8, 35);
		containerF.addModel(wallWH);

		wall_W_F wallW_F = new wall_W_F(-35, -8, 35);
		containerF.addModel(wallW_F);

		wall_E_F wallE_F = new wall_E_F(-15.5, -8, 15.5);
		containerF.addModel(wallE_F);

		wall_N_F wallN_F = new wall_N_F(-35, -8, 34.5);
		containerF.addModel(wallN_F);

		ceiling_F ceilingF = new ceiling_F(-35, 7, 15);
		containerF.addModel(ceilingF);

		//container G
		start = new vector(-35, 8.5, 15.1);
		x = 20; y = 16; z = 19.9;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerG = new container(boundary, 12);
		world.addModel(containerG);
		containerG.backGroundModelCount = 5;

		desk deskG = new desk(-28, 8.5, 30);
		containerG.addModel(deskG);
		deskG.setLightSource(LightSource.s7);

		wall_S_F wallS_G = new wall_S_F(-35, 8.5, 15);
		containerG.addModel(wallS_G);
		wallS_G.setLightSource(LightSource.s7);

		tableLamp TLG = new tableLamp(-22, 13, 32.5, (Math.PI/6) *12);
		containerG.addModel(TLG);
		TLG.setLightSource(LightSource.s7);

		chair_upper ChairUG = new chair_upper(-24, 10.75, 25, 0);
		containerG.addModel(ChairUG);
		ChairUG.setLightSource(LightSource.s7);

		chair_lower  ChairLG = new chair_lower(-24, 8.5, 25, 0);
		containerG.addModel(ChairLG);
		ChairLG.setLightSource(LightSource.s7);

		magicCube magicCubeG = new magicCube(-26, 13, 31);
		containerG.addModel(magicCubeG);
		magicCubeG.setLightSource(LightSource.s7);

		door_F doorG = new door_F(-30.5, 8.5, 15.8);
		containerG.addModel(doorG);
		doorG.setLightSource(LightSource.s7);

		wall_W_F wallW_G = new wall_W_F(-35, 8.5, 35);
		containerG.addModel(wallW_G);
		wallW_G.setLightSource(LightSource.s7);


		wall_E_F wallE_G = new wall_E_F(-15.5, 8.5, 15.5);
		containerG.addModel(wallE_G);
		wallE_G.setLightSource(LightSource.s7);


		wall_N_F wallN_G = new wall_N_F(-35, 8.5, 34.5);
		containerG.addModel(wallN_G);
		wallN_G.setLightSource(LightSource.s7);

		ceiling_F ceilingG = new ceiling_F(-35, 23.5, 15);
		containerG.addModel(ceilingG);
		ceilingG.setLightSource(LightSource.s7);

		floorG floor_G = new floorG(-35, 8.5, 15);
		containerG.addModel(floor_G);


		//container H
		start = new vector(-14.9, -109, 15.1);
		x = 50; y = 116; z = 19.9;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerH = new container(boundary, 26);
		world.addModel(containerH);
		containerH.backGroundModelCount = 4;

		table TableH = new table(-2, -8, 23);
		containerH.addModel(TableH);

		woodChairLower WChairLower1 = new woodChairLower(0, -8, 20, 0);
		containerH.addModel(WChairLower1);
		
		woodChairUpper WChairUpper1 = new woodChairUpper(0, -5.25, 20, 0);
		containerH.addModel(WChairUpper1);
		
		woodChairLower WChairLower2 = new woodChairLower(5, -8, 20, 0);
		containerH.addModel(WChairLower2);
		
		woodChairUpper WChairUpper2 = new woodChairUpper(5, -5.25, 20, 0);
		containerH.addModel(WChairUpper2);
		
		woodChairLower WChairLower3 = new woodChairLower(-5, -8, 27, -Math.PI/2);
		containerH.addModel(WChairLower3);
		
		woodChairUpper WChairUpper3 = new woodChairUpper(-5, -5.25, 27, -Math.PI/2);
		containerH.addModel(WChairUpper3);
		
		woodChairLower WChairLower4 = new woodChairLower(9, -8, 31.5, Math.PI/4*3);
		containerH.addModel(WChairLower4);
		
		woodChairUpper WChairUpper4 = new woodChairUpper(9, -5.25, 31.5, Math.PI/4*3);
		containerH.addModel(WChairUpper4);
		
		woodChairLower WChairLower5 = new woodChairLower(0, -8, 32, -Math.PI/2);
		containerH.addModel(WChairLower5);
		
		woodChairUpper WChairUpper5 = new woodChairUpper(0, -5.25, 32, -Math.PI/2);
		containerH.addModel(WChairUpper5);
		
		storage Storage = new storage(30, -8, 15);
		containerH.addModel(Storage);
		
		storage_ Storage_ = new storage_(27, -8, 15);
		containerH.addModel(Storage_);
		
		handle handle_1 = new handle(29.75, -4.5, 27.8, 0);
		containerH.addModel(handle_1);
		
		handle handle_2 = new handle(29.75, -4.5, 27, 0);
		containerH.addModel(handle_2);
		
		handle handle_3 = new handle(29.75, -4.5, 22.85, 0);
		containerH.addModel(handle_3);
		
		handle handle_4 = new handle(29.75, -4.5, 22.05, 0);
		containerH.addModel(handle_4);
		
		handle handle_5 = new handle(29.75, -4.5, 17.95, 0);
		containerH.addModel(handle_5);
		
		handle handle_6 = new handle(29.75, -4.5, 17.15, 0);
		containerH.addModel(handle_6);
		
		handle handle_7 = new handle(29.75, -2.5, 32.1, 1);
		containerH.addModel(handle_7);
		
		handle handle_8 = new handle(29.75, -4.2, 32.1, 1);
		containerH.addModel(handle_8);
		
		handle handle_9 = new handle(29.75, -5.9, 32.1, 1);
		containerH.addModel(handle_9);
		
		wall_S_H wallSH = new wall_S_H(-15, -8, 15);
		containerH.addModel(wallSH);

		wall_N_H wallNH = new wall_N_H(-15, -8, 34.5);
		containerH.addModel(wallNH);

		wall_E_H wallEH = new wall_E_H(35, -8, 15.5);
		containerH.addModel(wallEH);

		ceiling_H ceilingH = new ceiling_H(-15, 7, 15);
		containerH.addModel(ceilingH);

		//container I	
		start = new vector(15, -8, 5.1);
		x = 20; y = 15; z = 9.5;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerI = new container(boundary, 4);
		world.addModel(containerI);
		containerI.backGroundModelCount = 0;
		
		wall_S_I wallSI = new wall_S_I(15, -8, 5);
		containerI.addModel(wallSI);
		
		wall_E_I wallEI = new wall_E_I(34.7, -8, 5); 
		containerI.addModel(wallEI);
		
		wall_N_I wallNI = new wall_N_I(15, -8, 14.7);
		containerI.addModel(wallNI);
		
		ceiling_I ceilingI = new ceiling_I(15, 7, 5);
		containerI.addModel(ceilingI);
		
		
		
		//container J
		start = new vector(15.5, -8, -15);
		x = 19.5; y = 14.8; z = 19.5;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container containerJ = new container(boundary, 8);
		world.addModel(containerJ);
		containerJ.backGroundModelCount = 4;
		
		bathRoom_lower BathRoomL = new bathRoom_lower(15.5, -8, -15);
		containerJ.addModel(BathRoomL); 
		
		bathRoom_Upper BathRoomU = new bathRoom_Upper(15.5, -7.2, -15);
		containerJ.addModel(BathRoomU); 
		
		wall_N_J wallNJ = new wall_N_J(10, -8, 4.2);
		containerJ.addModel(wallNJ); 
		
		door_I doorI = new door_I(27.5, -8, 2.6);
		containerJ.addModel(doorI);
		
		wall_S_J wallSJ = new wall_S_J(15, -8, -15);
		containerJ.addModel(wallSJ); 
		
		wall_W_J wallWJ = new wall_W_J(15.5, -8, 4.5);
		containerJ.addModel(wallWJ); 
		
		wall_E_J wallEJ = new wall_E_J(35, -8, -15);
		containerJ.addModel(wallEJ); 
		
		ceiling_F ceilingJ = new ceiling_F(15, 7, -15);
		ceilingJ.setLightSource(LightSource.s11);
		containerJ.addModel(ceilingJ); 

		//south house wall
		start = new vector(-35, -8, -35);
		x = 70; y = 32; z = 20;
		boundary = new polygon3D[6];
		a = new vector[]{ put(0, y, 0), put(x, y, 0), put(x, 0, 0), put(0,0,0)};
		boundary[0] = new polygon3D(a, null, null, null, null);
		b = new vector[]{put(x, y, 0), put(x, y, z), put(x, 0, z), put(x, 0, 0)};
		boundary[1] = new polygon3D(b, null, null, null, null);
		c = new vector[]{put(x, y, z), put(0, y, z), put(0, 0, z), put(x, 0, z)};
		boundary[2] = new polygon3D(c, null, null, null, null);
		d = new vector[]{put(0, y, z), put(0, y, 0), put(0, 0, 0), put(0, 0, z)};
		boundary[3] = new polygon3D(d, null, null, null, null);
		e = new vector[]{put(0,y,z), put(x, y, z), put(x, y, 0), put(0, y, 0)};
		boundary[4] = new polygon3D(e, null, null, null, null);
		f = new vector[]{put(0, 0, 0), put(x, 0, 0), put(x, 0, z), put(0, 0, z)};
		boundary[5] = new polygon3D(f, null, null, null, null);
		container south_house_wall = new container(boundary, 1);
		world.addModel(south_house_wall);

		mainDoor md = new mainDoor(-5, -8, -17);
		south_house_wall.addModel(md);

		floor floor1 = new floor(-35,-10,-25);
		world.addModel(floor1);

		//background of world
		skyBox sb = new skyBox(camera.position.x,camera.position.y,camera.position.z);
		world.addModel(sb);

	}

	public static vector put(double i, double j, double k){
		vector temp = new vector(0,0,0);
		temp.set(start);
		temp.add(iDirection, i);
		temp.add(jDirection, j);
		temp.add(kDirection, k);
		return temp;
	}

}