public class container implements model{
	public model[] models;
	public polygon3D[] boundary;
	public vector centre;
	public vector tempCentre;
	public boolean visible;
	public polygon3D[] transparentPolygons;
	public int backGroundModelCount;
	public int modelType;


	public container(polygon3D[] boundary, int modelCount){
		this.boundary = boundary;
		visible = testVisibility();
		transparentPolygons = new polygon3D[100];

		findCentre();


		tempCentre = new vector(0,0,0);
		tempCentre.set(centre);
		models = new model[modelCount];
	}

	public void findCentre(){
		centre = new vector(0,0,0);
		for(int i = 0; i < 6; i++)
			centre.add(boundary[i].centre);
		centre.scale(1.0/6);

	}

	public polygon3D[] getPolygon(){
		return null;
	}


	public void update(){
		//update centre
		tempCentre.set(centre);
		tempCentre.subtract(camera.position);
		tempCentre.rotate_XZ();
		tempCentre.rotate_YZ();

		//update boundary
		for(int i = 0; i < boundary.length; i++){
			boundary[i].update_();
		}

		visible = testVisibility();

		if(!visible)
			return;

		//update inclosed models
		for(int i = 0; i < models.length; i++)
			models[i].update();
	}


	public polygon3D[] getBoundary(){
		return boundary;
	}


	public vector getCentre(){
		return tempCentre;
	}

	public int getType(){
		return modelType;
	}

	public void draw(){
		if(!visible)
			return;
		for(int i = 0; i < models.length; i++)
			models[i].draw();

		for(int i = 0; i < transparentPolygons.length; i++){
			if(transparentPolygons[i] == null)
				return;

			if(transparentPolygons[i].visible){
				transparentPolygons[i].update();
				transparentPolygons[i].drawTransparent();
			}
		}
	}

	public void addTransparentPolygon(polygon3D p){
		for(int i = 0; i < transparentPolygons.length; i++){
			if(transparentPolygons[i] == null){
				transparentPolygons[i] = p;
				return;
			}
		}
	}

	public void sort(){
		if(!visible)
			return;

		int length = models.length - backGroundModelCount;


		//sort models according to their postion to the view point
		for(int i = 1; i < length; i++){
			for(int j = 0; j <length - i; j++){
				if(geometry.compareModels(models[j+1],models[j])){
					model temp = models[j+1];
					models[j+1] = models[j];
					models[j] = temp;
				}
			}
		}

		for(int i = 0; i < models.length; i++)
			models[i].sort();
	}

	public void addModel(model m){
		for(int i = 0; i < models.length; i ++){
			if(models[i] == null){
				models[i] = m;
				return;
			}
		}
	}

	public boolean testVisibility(){
		boolean inside = true;
		vector origin = new vector(0,0,0);

		for(int i = 0; i < 6; i++){
			if(boundary[i].visible)
				return true;
			origin.reset();
			origin.subtract(boundary[i].centre);
			if(origin.dot(boundary[i].normal) > 0)
				inside = false;
		}

		return inside;
	}
}