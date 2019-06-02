public class solidObject implements model{
	public polygon3D[] boundary;
	public polygon3D[] polygons;
	public boolean visible;
	public vector centre;
	public vector tempCentre;
	public boolean sortedPolygons;
	public String code = "";
	public int modelType;
	public int backGroundModelCount;
	public boolean inside;
	public vector  s;

	/*public solidObject(polygon3D[] boundary){
		this.boundary = boundary;
		visible = testVisibility();
		findCentre();
	}*/

	public void findCentre(){
		centre = new vector(0,0,0);
		for(int i = 0; i < 6; i++)
			centre.add(boundary[i].centre);
		centre.scale(1.0/6);

	}

	public polygon3D[] getPolygon(){
		return polygons;
	}

	public final void update(){
		if(!code.equals("")){
			if(code.equals("skyBox")){
				visible = true;

				polygon3D[] p = polygons;
				for(int i = 0; i < p.length; i++){
						for(int j = 0; j < p[i].vertix3D.length; j++)
							p[i].vertix3D[j].add(camera.displacement);
						p[i].origin.add(camera.displacement);
						p[i].rightEnd.add(camera.displacement);
						p[i].bottomEnd.add(camera.displacement);
						p[i].update();
				}
				return;
			}
		}

		for(int i = 0; i < boundary.length; i++){
			boundary[i].update_();
		}

		visible = testVisibility();


		if(!visible)
			return;

		tempCentre.set(centre);
		tempCentre.subtract(camera.position);
		tempCentre.rotate_XZ();
		tempCentre.rotate_YZ();
	}

	public final polygon3D[] getBoundary(){
		return boundary;
	}

	public vector getCentre(){
		return tempCentre;
	}

	public int getType(){
		return modelType;
	}

	public final void  draw(){
		if(!visible)
			return;

		int xMax = 0;
		int yMax = 0;
		int xMin = 639;
		int yMin = 479;


		if(!code.equals("skyBox") && !code.equals("B") && !inside){
			for(int i = 0; i < 6; i++){
				if(boundary[i].visible){
					xMax = Math.max(xMax, boundary[i].xMax);
					xMin = Math.min(xMin, boundary[i].xMin);
					yMax = Math.max(yMax, boundary[i].yMax);
					yMin = Math.min(yMin, boundary[i].yMin);
				}
			}

			if(xMax - xMin <= 0 || yMax - yMin <= 0)
				return;

			if(xMax > 639)
				xMax = 639;
			if(xMin < 0)
				xMin = 0;
			if(yMax > 479)
				yMax = 479;
			if(yMin < 0)
				yMin = 0;

			double dx = ((double)(xMax - xMin))/(yMax - yMin);

			boolean withinView = false;
			boolean emptyPixel = polygon3D.emptyPixel;
			boolean[] screenBuffer = house.screenBuffer;
			double i;
			double k;
			int j;
			int middleLine =( yMax -(yMax - yMin)/2)*640;
			int oneQuarter = ( yMax -(yMax - yMin)/4)*640;
			int threeQuarter = ( yMin +(yMax - yMin)/4)*640;

			for(i = xMin, k = xMax, j = yMin; j <= 480 && i <= xMax; i+=dx, k-=dx, j++){
				if(j > 478)
					break;

				if(screenBuffer[oneQuarter + (int)i] == emptyPixel){
					withinView = true;
					break;
				}

				if(screenBuffer[middleLine + (int)i] == emptyPixel){
						withinView = true;
						break;
				}

				if(screenBuffer[threeQuarter + (int)i] == emptyPixel){
					withinView = true;
					break;
				}

				if(screenBuffer[j*640 + (int)i] == emptyPixel){
					withinView = true;
					break;
				}
				if(screenBuffer[j*640 + (int)k] == emptyPixel){
					withinView = true;
					break;
				}
			}

			if(!withinView)
				return;
		}

		polygon3D[] p = polygons;
		for(int i = 0; i < p.length; i++)
			p[i].update();

		if(!sortedPolygons && camera.cameraMoved){
			int length = polygons.length - backGroundModelCount;
			for(int i = 1; i < length; i++){
				for(int j = 0; j <length - i; j++){
					if(geometry.comparePolygons(polygons[j+1],polygons[j])){
						polygon3D temp = polygons[j+1];
						polygons[j+1] = polygons[j];
						polygons[j] = temp;
					}
				}
			}
		}

		for(int i = 0; i < p.length; i++){
			if(p[i].visible){
				house.visiblePolygon++;
				p[i].draw();
			}
		}
	}

	public final void sort(){

	}

	public final void setLightSource(vector  s){
		for(int i = 0; i < polygons.length; i++){
			polygons[i].setLightSource(s);
		}
	}

	public final boolean testVisibility(){
		if(code.equals("C"))
			return boundary[0].visible;
		boolean inside_ = true;
		inside = false;
		vector origin = new vector(0,0,0);

		for(int i = 0; i < 6; i++){
			if(boundary[i].visible)
				return true;
			origin.reset();
			origin.subtract(boundary[i].centre);
			if(origin.dot(boundary[i].normal) > 0)
				inside_ = false;
		}
		inside = inside_;
		return inside_;
	}

}