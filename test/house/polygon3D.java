import java.awt.*;

public final class polygon3D{
	public vector[] tempVertix;
	public vector[] vertix2D;
	public vector[] vertix3D;
	public int[] vertixSpecular;
	public vector[] vertixNormals;
	public vector[] temp_vertixNormals;
	public static vector[] tempVectors;
	public vector normal, realNormal;
	public vector centre, realCentre;
	public static int[] xLow, xHigh, s_left, s_right, xChange_left, xChange_right;
	public int[] xLow_transprent, xHigh_transprent;
	public int height;
	public int topIndex;
	public boolean visible;
	public Rectangle bound;
	public double zMax, zMin;
	public texture myTexture;
	public double textureScaleX, textureScaleY;
	public vector W, O, V, U, A, B, C;
	public double aDotW, bDotW, cDotW;
	public double scaleX = 1, scaleY = 1;
	public int textureWidth, textureHeight, heightMask, widthMask, widthBits, heightBits;
	public int X, Y, X1, Y1, dx, dy, textureIndex;
	public int visibleCount;
	public vector origin, rightEnd, bottomEnd;
	public int L;
	public vector view = new vector(0,0,1);
	public int end = 0;
	public int start = 479;
	public boolean isLightMap;
	public short[] Texture_;
	public int Z_length;
	public double A_offset, B_offset, C_offset;
	public boolean faceVerticalPolygon;
	public int BigX, BigY, BigDx, BigDy;
	public boolean gouraudShading;
	public int diffuse_I;
	public int ambient_I;
	public int roughness;
	public int bigHeight;
	public boolean calculateScale;
	public boolean withinViewScreen;
	public boolean darkFace;
	public static boolean emptyPixel;
	public vector lightSource;
	public int type;  //0 = normal polygon, 1 = skybox polygon,  2 = glass1,  3 = glass2, 4 =glass3
	public static int[] tempBuffer;
	public int xMax, yMax, xMin, yMin;


	public polygon3D(vector[] vertix3D, vector origin,  vector  rightEnd, vector bottomEnd,  texture myTexture){
		L = vertix3D.length;
		Z_length = vector.Z_length;
		tempVectors = new vector[4];
		for(int i = 0; i < tempVectors.length; i++)
			if(tempVectors[i] == null)
				tempVectors[i] = new vector();

		this.vertix3D = vertix3D;

		tempVertix = new vector[L];

		for(int i = 0; i < L; i++){
			tempVertix[i] = new vector();
			tempVertix[i].set(vertix3D[i]);
		}

		centre =  new vector(0,0,0);
		bound = new Rectangle(0,0,0,0);

		tempVectors[0].set(tempVertix[1]);
		tempVectors[0].subtract(tempVertix[0]);
		tempVectors[1].set(tempVertix[2]);
		tempVectors[1].subtract(tempVertix[1]);
		normal = tempVectors[0].cross(tempVectors[1]);
		normal.unit();
		findCentre();

		if(Math.abs(normal.y) > 0.99)
			faceVerticalPolygon = true;
		else
			faceVerticalPolygon = false;

		realNormal = new vector(0,0,0);
		realNormal.set(normal);

		realCentre = new vector(0,0,0);
		realCentre.set(centre);


		this.myTexture = myTexture;

		if(myTexture == null)
			return;

		lightSource = new vector(0,0,0);

		Texture_ = myTexture.Texture;

		this.origin = origin;
		this.rightEnd = rightEnd;
		this.bottomEnd = bottomEnd;

		textureWidth = myTexture.width;
		textureHeight = myTexture.height;
		heightMask = myTexture.heightMask;
		widthMask = myTexture.widthMask;
		widthBits = myTexture.widthBits;
		heightBits = myTexture.heightBits;
		bigHeight = textureHeight << 21;

		findTextureScale();

		W = new vector(); O = new vector(); V = new vector(); U = new vector(); A = new vector(); B = new vector(); C = new vector();

		vertix2D = new vector[L+1];
		for(int i = 0; i < vertix2D.length; i++)
			vertix2D[i] = new vector(0,0,0);

		vertixSpecular = new int[L+1];

		temp_vertixNormals = new vector[L+1];
		for(int i = 0; i < L+1; i++)
			temp_vertixNormals[i] = new vector(0,0,0);

		vertixNormals = new vector[L];
		for(int i = 0; i < L; i++)
			vertixNormals[i] = new vector(0,0,0);

		if(xLow == null){
			xLow = new int[480];
			xHigh = new int[480];
			s_left= new int[480];
			s_right = new int[480];
			xChange_left = new int[480];
			xChange_right = new int[480];
		}
	}


	public final void findTextureScale(){
		tempVectors[0].set(origin);
		tempVectors[0].subtract(rightEnd);
		double l = tempVectors[0].getLength();
		textureScaleX = l/myTexture.width;

		tempVectors[0].set(origin);
		tempVectors[0].subtract(bottomEnd);
		l = tempVectors[0].getLength();
		textureScaleY = l/myTexture.height;
	}

	public static polygon3D createPolygon(vector[] vertix3D, vector origin,  vector  rightEnd, vector bottomEnd,  texture myTexture, double textureX, double textureY, double scaleX, double scaleY){
		vector x = origin.myClone();
		x.subtract(rightEnd);
		x.scale(textureX);
		vector y = origin.myClone();
		y.subtract(bottomEnd);
		y.scale(textureY);

		origin.add(x);
		bottomEnd.add(x);
		rightEnd.add(x);
		origin.add(y);
		bottomEnd.add(y);
		rightEnd.add(y);

		polygon3D p = new polygon3D(vertix3D,  origin, rightEnd, bottomEnd, myTexture);
		p.scaleX = scaleX;
		p.scaleY = scaleY;
		return p;
	}



	public final void update_(){
		for(int i = 0; i < L; i++)
			tempVertix[i].update(vertix3D[i]);

		visible = false;

		//find normal vector
		tempVectors[0].set(tempVertix[1]);
		tempVectors[0].subtract(tempVertix[0]);
		tempVectors[1].set(tempVertix[2]);
		tempVectors[1].subtract(tempVertix[1]);
		normal = tempVectors[0].cross(tempVectors[1]);

		//find centre
		centre.reset();
		for(int i = 0; i < tempVertix.length; i++)
			centre.add(tempVertix[i]);
		centre.scale(1.0/tempVertix.length);

		//test whether all vertix is in front of viwer's plane
		for(int i = 0; i < tempVertix.length; i++){
			if(tempVertix[i].z > 0){
				visible = true;
				break;
			}
		}

		//test whether this polygon is facing toward viewer
		if(visible){
			if(tempVertix[0].dot(normal) >= 0)
				visible = false;
		}

		//test whether this polygon is inside the screen
		if(visible){
			xMax = tempVertix[0].screenX;
			xMin = xMax;
			yMax = tempVertix[0].screenY;
			yMin = yMax;
			for(int i = 1; i < tempVertix.length; i++){
				xMax = Math.max(xMax, tempVertix[i].screenX);
				xMin = Math.min(xMin, tempVertix[i].screenX);
				yMax = Math.max(yMax, tempVertix[i].screenY);
				yMin = Math.min(yMin, tempVertix[i].screenY);
			}
			bound.setLocation(xMin,yMin);
			bound.setSize( xMax-xMin, yMax-yMin);
			visible = camera.screen.intersects(bound);
			if(visible){
				withinViewScreen = camera.screen.inside(xMin, yMin) && camera.screen.inside(xMax, yMax);
			}
		}
	}

	public final void update(){
		tempVectors[0].set(camera.position);
			tempVectors[0].subtract(vertix3D[0]);
			if(tempVectors[0].dot(realNormal) <= 0){
				visible = false;
				return;
		}

		for(int i = 0; i < L; i++)
			tempVertix[i].update(vertix3D[i]);

		//visible = true;

		//find normal vector
		tempVectors[0].set(tempVertix[1]);
		tempVectors[0].subtract(tempVertix[0]);
		tempVectors[1].set(tempVertix[2]);
		tempVectors[1].subtract(tempVertix[1]);
		normal = tempVectors[0].cross(tempVectors[1]);
		//normal.unit();

		//find centre
		centre.reset();
		for(int i = 0; i < tempVertix.length; i++)
			centre.add(tempVertix[i]);
		centre.scale(1.0/tempVertix.length);

		//test whether this polygon is inside the screen
		//if(visible){
			int xMax = tempVertix[0].screenX;
			int xMin = xMax;
			int yMax = tempVertix[0].screenY;
			int yMin = yMax;
			for(int i = 1; i < tempVertix.length; i++){
				xMax = Math.max(xMax, tempVertix[i].screenX);
				xMin = Math.min(xMin, tempVertix[i].screenX);
				yMax = Math.max(yMax, tempVertix[i].screenY);
				yMin = Math.min(yMin, tempVertix[i].screenY);
			}
			bound.setLocation(xMin,yMin);
			bound.setSize( xMax-xMin, yMax-yMin);
			visible = camera.screen.intersects(bound);
			if(visible){
				withinViewScreen = camera.screen.inside(xMin, yMin) && camera.screen.inside(xMax, yMax);
			}
		//}
	}

	public final void findCentre(){
		centre.reset();
		for(int i = 0; i < tempVertix.length; i++)
			centre.add(tempVertix[i]);
		centre.scale(1.0/tempVertix.length);

	}

	public final void setLightSource(vector l){
		lightSource = l;
		findDiffuse();
	}

	public final void findDiffuse(){
		tempVectors[0].set(lightSource);
		tempVectors[0].subtract(realCentre);
		tempVectors[0].unit();
		double temp = (tempVectors[0].dot(realNormal) +0.5)/1.5;

		if(temp < 0)
			temp = 0;

		diffuse_I = (int)(temp*16) + ambient_I;

		if(diffuse_I < 0)
			diffuse_I = 0;
		if(diffuse_I > 16)
			diffuse_I = 16;
	}

	public final void findSpecular(){
		for(int i = 0; i < visibleCount; i++){
			tempVectors[2].set(temp_vertixNormals[i]);
			tempVectors[2].rotate_XZ();
			tempVectors[2].rotate_YZ();

			tempVectors[0].set(lightSource);
			tempVectors[0].subtract(vertix2D[i]);
			tempVectors[0].unit();
			tempVectors[1].set(tempVectors[2]);
			tempVectors[1].scale(2*tempVectors[0].dot(tempVectors[1]));
			tempVectors[0].subtract(tempVectors[1]);
			tempVectors[0].scale(-1);

			tempVectors[1].set(0,0,0);
			tempVectors[1].subtract(vertix2D[i]);
			tempVectors[1].unit();

			double temp = tempVectors[1].dot(tempVectors[0]);


			if(temp < 0){
				temp = 0;
			}else{
				for(int j = 0; j < roughness; j++)
					temp*=temp;
			}
			int specular = (int)(temp * 16 + diffuse_I);
			if(specular > 31)
				vertixSpecular[i] = (31-diffuse_I) << 16;
			else
				vertixSpecular[i] = (specular - diffuse_I) << 16;

		}
	}

	public final void findVectorOUV(){
		O.set(origin);
		O.subtract(camera.position);
		O.rotate_XZ();
		O.rotate_YZ();

		U.set(rightEnd);
		U.subtract(camera.position);
		U.rotate_XZ();
		U.rotate_YZ();

		V.set(bottomEnd);
		V.subtract(camera.position);
		V.rotate_XZ();
		V.rotate_YZ();

		if(!calculateScale){
			textureScaleX = textureScaleX/scaleX;
			textureScaleY = textureScaleY/scaleY;
			calculateScale = true;
		}

		U.subtract(O);
		U.unit();
		U.scale(textureScaleX);

		V.subtract(O);
		V.unit();
		V.scale(textureScaleY);

		A = V.cross(O);
		B = O.cross(U);
		C = U.cross(V);
	}

	public final void findClipping(){
		visibleCount = 0;
		for(int i = 0; i < L; i++){
			if(tempVertix[i].z >= 0.01){
				vertix2D[visibleCount].set(tempVertix[i]);
				vertix2D[visibleCount].setScreenLocation(tempVertix[i]);
				temp_vertixNormals[visibleCount].set(vertixNormals[i]);
				visibleCount++;
			} else{
				int index = (i+L - 1)%L;
				if(tempVertix[index].z >= 0.01){
					approximatePoint(visibleCount, tempVertix[i], tempVertix[index]);
					temp_vertixNormals[visibleCount].set(vertixNormals[index]);
					visibleCount++;
				}
				index = (i+1)%L;
				if(tempVertix[index].z >= 0.01){
					approximatePoint(visibleCount, tempVertix[i], tempVertix[index]);
					temp_vertixNormals[visibleCount].set(vertixNormals[index]);
					visibleCount++;
				}
			}
		}
	}


	public final void approximatePoint(int index, vector behindPoint, vector frontPoint){
		tempVectors[0].set(frontPoint.x - behindPoint.x, frontPoint.y - behindPoint.y, frontPoint.z - behindPoint.z);
		tempVectors[0].scale(frontPoint.z/tempVectors[0].z);
		vertix2D[index].set(frontPoint.x, frontPoint.y, frontPoint.z);
		vertix2D[index].subtract(tempVectors[0]);
		vertix2D[index].add(0,0,0.01);
		vertix2D[index].updateLocation();
	}

	public final void scanPolygon(){
		int minX = 0;
		int maxX = 639;
		int minY = 0;
		int maxY = 479;
		start = 479;
		end = 0;
		int temp_ = 0;
		int g = 0;

		for(int i = 0; i < visibleCount; i++){
			vector v1 = vertix2D[i];
			int s1 = vertixSpecular[i];
			vector v2;
			int s2;
			if(i == visibleCount -1 ){
				v2 = vertix2D[0];
				s2 = vertixSpecular[0];
			}else{
				v2 = vertix2D[i+1];
				s2 = vertixSpecular[i+1];
			}

			boolean downwards = false;


			//ensure v1.y < v2.y;
			if (v1.screenY> v2.screenY) {
				downwards = true;
				vector temp = v1;
				int temp1 = s1;
				v1 = v2;
				s1 = s2;
				v2 = temp;
				s2 = temp1;
			}
			int dy = v2.screenY - v1.screenY;

			// ignore horizontal lines
			if (dy == 0) {
				continue;
			}

			int ds = (s2 - s1)/dy;

			if(withinViewScreen){
				int startY = Math.max(v1.screenY, minY);
				int endY = Math.min(v2.screenY, maxY);
				if(startY < start )
					start = startY;
				if(endY > end)
					end = endY;
				int startS =s1;
				double dx = v2.screenX - v1.screenX;
				g = (int)(dx / dy *0xff);
				temp_ = v1.screenX<<8;

				if(gouraudShading)
					for (int y=startY, s=startS; y<=endY; y++, s+=ds) {
						if(downwards){
							xLow[y] = temp_ >> 8;
							s_left[y] = s;
						}else{
							xHigh[y] = temp_ >> 8;
							s_right[y] = s;
						}
						temp_+=g;
					}
				else{
					for (int y=startY; y<=endY; y++) {
						if(downwards)
							xLow[y] = temp_ >> 8;
						else
							xHigh[y] = (temp_ >> 8) + 1;
						temp_+=g;
					}
				}
				continue;
			}


			int startY = Math.max(v1.screenY, minY);
			int endY = Math.min(v2.screenY, maxY);

			int startS = s1 + (startY - v1.screenY) * ds;

			if(startY < start )
				start = startY;

			if(endY > end)
				end = endY;

			double dx = v2.screenX - v1.screenX;
			double gradient = dx / dy;

			int temp_x, x;
			temp_ = (int)(v1.screenX + (startY - v1.screenY) * gradient) <<8;
			// scan-convert this edge (line equation)
			g = (int)(gradient*0xff);

			if(gouraudShading){
				for (int y=startY, s=startS; y<=endY; y++, s+=ds) {
					temp_x = temp_ >> 8;
					temp_+=g;
					// ensure x within view bounds
					x = Math.min(maxX+1, Math.max(temp_x, minX));
					if(downwards){
						xLow[y] = x;
						s_left[y] = s;
						xChange_left[y] =  x - temp_x;
					}else{
						xHigh[y] = x;
						s_right[y] = s;
						xChange_right[y] = x - temp_x;
					}
				}
			}else{

				if(type != 1){
					for (int y=startY; y<=endY; y++) {
						temp_x = temp_>>8;
						temp_+=g;
						// ensure x within view bounds
						x = Math.min(maxX+1, Math.max(temp_x, minX));
						if(downwards){
							xLow[y] = x;
						}else{
							if(x < 639)
								x++;
							xHigh[y] = x ;
						}
					}
				}
				else{
					for (int y=startY; y<=endY; y++) {
						temp_x = temp_>>8;
						temp_+=g;
						// ensure x within view bounds
						x = Math.min(maxX+1, Math.max(temp_x, minX));
						if(downwards){
							xLow[y] = x;
						}else{
							xHigh[y] = x ;
						}
					}
				}
			}
		}
		if(!gouraudShading || withinViewScreen)
			return;

		int ds, l;
		for(int i = start; i <= end; i++){
			l = (xHigh[i] - xChange_right[i]) - (xLow[i] - xChange_left[i]);
			if(l == 0)
				continue;
			ds = (s_right[i] - s_left[i])/l;
			s_left[i] = s_left[i] + xChange_left[i]*ds;
			s_right[i] = s_right[i] + xChange_right[i]*ds;
		}
	}



	public final void drawTransparent(){
		if(!visible)
			return;

		int texel = 0;
		int r = 0;
		int g = 0;
		int b = 0;
		int temp = 0;
		int temp_ = 0;
		int theIndex = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		int d_x = 0;
		int d_y = 0;
		boolean needToRecaluclate = true;
		double Aoffset, Boffset, Coffset;
		double cDotWInverse;

		short[] Texture = Texture_;
		int[] screen = house.screen;
		boolean[] screenBuffer = house.screenBuffer;
		boolean[] transparentBuffer = house.transparentBuffer;

		if(tempBuffer == null)
			tempBuffer = new int[640*480];

		if(type == 2){
			for(i = start; i < end; i++){
				needToRecaluclate = true;
				W.set(xLow_transprent[i]-320, -i + 240, Z_length);
				aDotW = A.dot(W);
				bDotW = B.dot(W);
				cDotW = C.dot(W);

				temp = gameData.screenTable[i];
				int index;
				for(j = xLow_transprent[i]; j < xHigh_transprent[i]; j+=16){
					index = j + temp;
					if(xHigh_transprent[i] - j < 16){
						if(xHigh_transprent[i] - j>0){
							int offset = xHigh[i] - j;
							Aoffset = A.x*offset;
							Boffset = B.x*offset;
							Coffset = C.x*offset;

							cDotWInverse = 1/cDotW;
							X = (int)(aDotW*cDotWInverse);
							Y = (int)(bDotW*cDotWInverse);
							aDotW+=Aoffset;
							bDotW+=Boffset;
							cDotW+=Coffset;
							cDotWInverse = 1/cDotW;
							X1 = (int)(aDotW*cDotWInverse);
							Y1 = (int)(bDotW*cDotWInverse);
							dx = X1 - X;
							dy = Y1 - Y;


							for(k = offset, d_x = 0, d_y = 0; k >0; k--, d_x+=dx, d_y+=dy, index++){
								if(transparentBuffer[index]){
									textureIndex = (((d_x/offset) + X)&widthMask) + ((((d_y/offset) + Y)&heightMask)<<widthBits);
									temp_ = Texture[textureIndex];
									theIndex = index + temp_*640;
									if(theIndex< 0 || theIndex >= 307200)
										theIndex = index;
									tempBuffer[index] = screen[theIndex];
								}
							}
						}
						break;
					}

					if(needToRecaluclate){
						cDotWInverse = 1/cDotW;
						X = (int)(aDotW*cDotWInverse);
						Y = (int)(bDotW*cDotWInverse);
						needToRecaluclate = false;
					}else{
						X = X1; Y =Y1;
					}
					aDotW+=A_offset;
					bDotW+=B_offset;
					cDotW+=C_offset;
					cDotWInverse = 1/cDotW;
					X1 = (int)(aDotW*cDotWInverse);
					Y1 = (int)(bDotW*cDotWInverse);
					dx = X1 - X;
					dy = Y1 - Y;


					for(k = 16, d_x = 0, d_y = 0; k >0; k--, d_x+=dx, d_y+=dy, index++){
						if(transparentBuffer[index]){
							textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
							temp_ = Texture[textureIndex];
							theIndex = index + temp_*640;
							if(theIndex< 0 || theIndex >= 307200)
								theIndex = index;
							tempBuffer[index] = screen[theIndex];
						}
					}
				}
			}
		}else if(type == 3){
			textureIndex = 0;
			for(i = start; i < end; i++){
				temp = gameData.screenTable[i];
				int index;
				for(j = xLow_transprent[i]; j < xHigh_transprent[i]; j++, textureIndex++){
					index = j+ temp;
					temp_ = Texture[textureIndex%4096];
					theIndex = index + ((temp_>>3)-3)*640 + (temp_&7)-3;
					if(theIndex< 0 || theIndex >= 307200)
						theIndex = index;
					tempBuffer[index] = screen[theIndex];
				}
			}
		}else if(type == 4){
			textureIndex = 0;
			for(i = start; i < end; i++){
				temp = gameData.screenTable[i];
				int index;
				for(j = xLow_transprent[i]; j < xHigh_transprent[i]; j++, textureIndex++){
					index = j+ temp;
					temp_ = Texture[textureIndex%4096];
					theIndex = index + ((temp_>>3)-3)*640 + (temp_&7)-3;
					if(theIndex< 0 || theIndex >= 307200)
						theIndex = index;
					int color = screen[theIndex];
					r = (color>> 16) & 0xff;
					g = (color>> 8) & 0xff;
					b = (color) & 0xff; 
					r = r*4/5;
					g = g*9/10;
					color = (r<<16) | (g<<8) | b | 0xff000000;
					tempBuffer[index] = color;
				}
			}
		}

		for(i = start; i < end; i++){
			int index = gameData.screenTable[i];
			for(j = xLow_transprent[i]; j < xHigh_transprent[i]; j++){
				if(transparentBuffer[index+j]){
					screen[index+j] = tempBuffer[index+j];
					transparentBuffer[index+j] = false;
				}
			}
		}
	}



	public final void draw(){
		findVectorOUV();

		if(withinViewScreen){
			visibleCount = L;
			for(int i =0; i < L; i ++){
				vertix2D[i].set(tempVertix[i]);
				vertix2D[i].setScreenLocation(tempVertix[i]);
				temp_vertixNormals[i].set(vertixNormals[i]);
			}
		}else
			findClipping();

		boolean[] screenBuffer = house.screenBuffer;
		boolean emptyPixel = this.emptyPixel;
		int[] screen = house.screen;
		short[] Texture = Texture_;
		int[][] colorTable = gameData.colorTable;;

		//apply specular highlight only when it is in gouraud shading mode
		if(gouraudShading){

			findSpecular();
		}

		scanPolygon();

		if(type >=2){
			if(xLow_transprent == null){
				xLow_transprent = new int[480];
				xHigh_transprent = new int[480];

			}

			for(int i = 0; i < 480; i++){
				xLow_transprent[i] = xLow[i];
				xHigh_transprent[i] = xHigh[i];
			}

			for(int i = start; i <= end; i++){
				int index = gameData.screenTable[i];
				for(int j = xLow_transprent[i]; j < xHigh_transprent[i]; j++){
					if(screenBuffer[index+j] == emptyPixel)
						house.transparentBuffer[index+j] = true;
					else
						house.transparentBuffer[index+j] = false;;
				}
			}
			return;
		}

		int d_x = 0;
		int d_y = 0;
		int k = 0;
		int specular = 0;

		A_offset = A.x*16;
		B_offset = B.x*16;
		C_offset = C.x*16;

		double Aoffset;
		double Boffset;
		double Coffset;

		double cDotWInverse;
		boolean needToRecaluclate = true;

		if(gouraudShading){
			int diffuse = diffuse_I <<16;
			for(int i = start; i <= end; i++){
				if(s_left[i] < 0 || s_right[i] < 0){
					continue;
				}
				needToRecaluclate = true;
				W.set(xLow[i]-320, -i + 240, Z_length);
				aDotW = A.dot(W);
				bDotW = B.dot(W);
				cDotW = C.dot(W);

				if(faceVerticalPolygon){
					cDotWInverse = 1/cDotW;
					BigX = (int)(aDotW*cDotWInverse*0xffff);
					BigY = (int)(bDotW*cDotWInverse*0xffff);
					aDotW+=A_offset;
					bDotW+=B_offset;
					cDotW+=C_offset;
					cDotWInverse = 1/cDotW;
					X1 = (int)(aDotW*cDotWInverse*0xffff);
					Y1 = (int)(bDotW*cDotWInverse*0xffff);
					BigDx = X1 - BigX;
					BigDy = Y1 - BigY;
					dx = BigDx>>16;
					dy = BigDy>>16;
				}

				int temp = gameData.screenTable[i];
				int index;
				int ds = 0;
				if(xHigh[i] > xLow[i])
					ds = (s_right[i] - s_left[i])/(xHigh[i] - xLow[i]);

				for(int j = xLow[i], s = s_left[i]; j < xHigh[i]; j+=16, s+=(ds*16)){
					index = j + temp;
					if(xHigh[i] - j < 16){
						if(xHigh[i] - j>0){
							int offset = xHigh[i] - j;
							Aoffset = A.x*offset;
							Boffset = B.x*offset;
							Coffset = C.x*offset;
							if(index + 16 < screen.length){
								if(screenBuffer[index] != emptyPixel
									&& screenBuffer[index+2] != emptyPixel
									&& screenBuffer[index+4] != emptyPixel
									&& screenBuffer[index+6] != emptyPixel
									&& screenBuffer[index+8] != emptyPixel
									&& screenBuffer[index+10] != emptyPixel
									&& screenBuffer[index+12] != emptyPixel
									&& screenBuffer[index+14] != emptyPixel
									){
									continue;
								}
							}


							if(faceVerticalPolygon){
								X = BigX >>16;
								Y = BigY >>16;
							}else{
								cDotWInverse = 1/cDotW;
								X = (int)(aDotW*cDotWInverse);
								Y = (int)(bDotW*cDotWInverse);
								aDotW+=Aoffset;
								bDotW+=Boffset;
								cDotW+=Coffset;
								cDotWInverse = 1/cDotW;
								X1 = (int)(aDotW*cDotWInverse);
								Y1 = (int)(bDotW*cDotWInverse);
								dx = X1 - X;
								dy = Y1 - Y;
							}

							Y+=bigHeight;


							for(k = offset, d_x = 0, d_y = 0, specular = s + diffuse; k >0; k--, specular+=ds, d_x+=dx, d_y+=dy, index++){
								if(screenBuffer[index] == emptyPixel){
									textureIndex = (((d_x/offset) + X)&widthMask) + ((((d_y/offset) + Y)&heightMask)<<widthBits);
									screen[index] = colorTable[specular>>16][Texture[textureIndex]];
									screenBuffer[index] = !emptyPixel;
								}
							}
						}
						break;
					}

					if(screenBuffer[index] != emptyPixel
						&& screenBuffer[index+2] != emptyPixel
						&& screenBuffer[index+4] != emptyPixel
						&& screenBuffer[index+6] != emptyPixel
						&& screenBuffer[index+8] != emptyPixel
						&& screenBuffer[index+10] != emptyPixel
						&& screenBuffer[index+12] != emptyPixel
						&& screenBuffer[index+14] != emptyPixel
						&& screenBuffer[index+15] != emptyPixel
						){
						if(faceVerticalPolygon){
							BigX+=BigDx;
							BigY+=BigDy;
						}else{
							aDotW+=A_offset;
							bDotW+=B_offset;
							cDotW+=C_offset;
							needToRecaluclate = true;
						}
						continue;
					}

					if(faceVerticalPolygon){
						X = BigX >>16;
						Y = BigY >>16;
						BigX+=BigDx;
						BigY+=BigDy;
					}else{
						if(needToRecaluclate){
							cDotWInverse = 1/cDotW;
							X = (int)(aDotW*cDotWInverse);
							Y = (int)(bDotW*cDotWInverse);
							needToRecaluclate = false;
						}else{
							X = X1; Y =Y1;
						}
						aDotW+=A_offset;
						bDotW+=B_offset;
						cDotW+=C_offset;
						cDotWInverse = 1/cDotW;
						X1 = (int)(aDotW*cDotWInverse);
						Y1 = (int)(bDotW*cDotWInverse);
						dx = X1 - X;
						dy = Y1 - Y;
					}

					Y+=bigHeight;

					d_x = 0; d_y = 0; specular = s + diffuse;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

					d_x+=dx; d_y+=dy; index++; specular+=ds;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = colorTable[specular>>16][Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

				}

			}
		}else{
			int[] table =  colorTable[diffuse_I];
			for(int i = start; i <= end; i++){
				needToRecaluclate = true;
				W.set(xLow[i]-320, -i + 240, Z_length);
				aDotW = A.dot(W);
				bDotW = B.dot(W);
				cDotW = C.dot(W);

				if(faceVerticalPolygon){
					cDotWInverse = 1/cDotW;
					BigX = (int)(aDotW*cDotWInverse*0xffff);
					BigY = (int)(bDotW*cDotWInverse*0xffff);
					aDotW+=A_offset;
					bDotW+=B_offset;
					cDotW+=C_offset;
					cDotWInverse = 1/cDotW;
					X1 = (int)(aDotW*cDotWInverse*0xffff);
					Y1 = (int)(bDotW*cDotWInverse*0xffff);
					BigDx = X1 - BigX;
					BigDy = Y1 - BigY;
					dx = BigDx>>16;
					dy = BigDy>>16;
				}

				int temp = gameData.screenTable[i];
				int index;
				for(int j = xLow[i]; j < xHigh[i]; j+=16){
					index = j + temp;
					if(xHigh[i] - j < 16){
						if(xHigh[i] - j>0){
							int offset = xHigh[i] - j;
							Aoffset = A.x*offset;
							Boffset = B.x*offset;
							Coffset = C.x*offset;
							if(index + 16 < screen.length){
								if(screenBuffer[index] != emptyPixel
									&& screenBuffer[index+1] != emptyPixel
									&& screenBuffer[index+2] != emptyPixel
									&& screenBuffer[index+4] != emptyPixel
									&& screenBuffer[index+6] != emptyPixel
									&& screenBuffer[index+8] != emptyPixel
									&& screenBuffer[index+10] != emptyPixel
									&& screenBuffer[index+12] != emptyPixel
									&& screenBuffer[index+14] != emptyPixel
									&& screenBuffer[index+15] != emptyPixel
									){
									continue;
								}
							}


							if(faceVerticalPolygon){
								X = BigX >>16;
								Y = BigY >>16;
							}else{
								cDotWInverse = 1/cDotW;
								X = (int)(aDotW*cDotWInverse);
								Y = (int)(bDotW*cDotWInverse);
								aDotW+=Aoffset;
								bDotW+=Boffset;
								cDotW+=Coffset;
								cDotWInverse = 1/cDotW;
								X1 = (int)(aDotW*cDotWInverse);
								Y1 = (int)(bDotW*cDotWInverse);
								dx = X1 - X;
								dy = Y1 - Y;

							}

							Y+=bigHeight;

							for( k = offset, d_x = 0, d_y = 0; k >0; k--, d_x+=dx, d_y+=dy, index++){
								if(screenBuffer[index] == emptyPixel){
									textureIndex = (((d_x/offset) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
									screen[index] = table[Texture[textureIndex]];
									screenBuffer[index] = !emptyPixel;
								}
							}
						}
						break;
					}


					if(screenBuffer[index] != emptyPixel
						&& screenBuffer[index+2] != emptyPixel
						&& screenBuffer[index+4] != emptyPixel
						&& screenBuffer[index+6] != emptyPixel
						&& screenBuffer[index+8] != emptyPixel
						&& screenBuffer[index+10] != emptyPixel
						&& screenBuffer[index+12] != emptyPixel
						&& screenBuffer[index+14] != emptyPixel
						&& screenBuffer[index+15] != emptyPixel
						){
						if(faceVerticalPolygon){
							BigX+=BigDx;
							BigY+=BigDy;
						}else{
							aDotW+=A_offset;
							bDotW+=B_offset;
							cDotW+=C_offset;
							needToRecaluclate = true;
						}
						continue;
					}

					if(faceVerticalPolygon){
						X = BigX >>16;
						Y = BigY >>16;
						BigX+=BigDx;
						BigY+=BigDy;
					}else{
						if(needToRecaluclate){
							cDotWInverse = 1/cDotW;
							X = (int)(aDotW*cDotWInverse);
							Y = (int)(bDotW*cDotWInverse);
							needToRecaluclate = false;
						}else{
							X = X1; Y =Y1;
						}
						aDotW+=A_offset;
						bDotW+=B_offset;
						cDotW+=C_offset;
						cDotWInverse = 1/cDotW;
						X1 = (int)(aDotW*cDotWInverse);
						Y1 = (int)(bDotW*cDotWInverse);
						dx = X1 - X;
						dy = Y1 - Y;
					}

					Y+=bigHeight;

					d_x = 0; d_y = 0;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}
					d_x+=dx; d_y+=dy; index++;
					if(screenBuffer[index] == emptyPixel){
						textureIndex = (((d_x>>4) + X)&widthMask) + ((((d_y>>4) + Y)&heightMask)<<widthBits);
						screen[index] = table[Texture[textureIndex]];
						screenBuffer[index] = !emptyPixel;
					}

				}

			}



		}

	}
}