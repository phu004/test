public class geometry{

	public final static boolean compareModels(model a, model b){
		polygon3D[] aPolygons = a.getBoundary();
		polygon3D[] bPolygons = b.getBoundary();

		boolean insideA = true;
		boolean insideB = true;

		vector origin = new vector(0,0,0);
		for(int i = 0; i < 6; i++){
			origin.reset();
			origin.subtract(aPolygons[i].centre);
			if(origin.dot(aPolygons[i].normal) > 0)
				insideA = false;
		}

		for(int i = 0; i < 6; i++){
			origin.reset();
			origin.subtract(bPolygons[i].centre);
			if(origin.dot(bPolygons[i].normal) > 0)
				insideB = false;
		}

		if(insideA)
			return true;

		if(insideB)
			return false;

		boolean aboveAll = true;
		/*for(int i = 0; i < 6; i++){
			aboveAll = true;
			for(int j = 0; j< 6; j++){
				if(comparePolygons(bPolygons[j], aPolygons[i])){
					aboveAll = false;
					break;
				}
			}
		}

		if(aboveAll)
			return true;*/

		for(int i = 0; i < 6; i++){
			aboveAll = true;
			for(int j = 0; j< 6; j++){
				if(comparePolygons(aPolygons[i], bPolygons[j])){
					aboveAll = false;
					break;
				}
			}
		}

		if(aboveAll)
			return false;

		if(a.getType() != 0 && a.getType() == b.getType()){
			//System.out.println(a.getCentre());
			if(a.getCentre().getLength() < b.getCentre().getLength())
				return true;
			else
				return false;
		}


		vector difference = new vector(0,0,0);
		difference.set(a.getCentre());
		difference.subtract(b.getCentre());

		polygon3D comparebleA =  aPolygons[0];
		for(int i = 0; i < 6; i++){
			if(aPolygons[i].visible){
				comparebleA = aPolygons[i];
				break;
			}
		}

		for(int i = 0; i < 6; i++){
			if(aPolygons[i].visible){
				if(Math.abs(comparebleA.normal.dot(difference)) < Math.abs(aPolygons[i].normal.dot(difference)))
					comparebleA = aPolygons[i];
			}
		}

		polygon3D comparebleB =  bPolygons[0];
		for(int i = 0; i < 6; i++){
			if(bPolygons[i].visible){
				comparebleB = bPolygons[i];
				break;
			}
		}

		for(int i = 0; i < 6; i++){
			if(bPolygons[i].visible){
				if(Math.abs(comparebleB.normal.dot(difference)) < Math.abs(bPolygons[i].normal.dot(difference)))
					comparebleB = bPolygons[i];
			}
		}

		if(comparePolygons(comparebleA, comparebleB))
			return true;

		return false;
	}

	public final static boolean comparePolygons(polygon3D a, polygon3D b){
		if(!a.visible)
			return true;
		if(!b.visible)
			return false;

		if(a.zMax < b.zMin)
			return true;
		if(a.zMin > b.zMax)
			return false;
		if(a.tempVertix[0].z < b.tempVertix[0].z && a.tempVertix[1].z < b.tempVertix[1].z && a.tempVertix[2].z < b.tempVertix[2].z && a.tempVertix[3].z < b.tempVertix[3].z)
			return true;

		vector tempVector = new vector(0,0,0);

		boolean inside = true;
		for(int i = 0; i < b.tempVertix.length; i++){
			tempVector.set(b.tempVertix[i]);
			tempVector.subtract(a.centre);
			tempVector.unit();

			if(tempVector.dot(a.normal) > 0.0001 ){
				inside = false;
				break;
			}

		}
		if(inside)
			return true;


		inside = true;
		for(int i = 0; i <a.tempVertix.length; i++){
			tempVector.set(a.tempVertix[i]);
			tempVector.subtract(b.centre);
			tempVector.unit();

			if(tempVector.dot(b.normal) < -0.0001 ){
				inside = false;
				break;
			}
		}

		if(inside)
			return true;

		return false;
	}

	public static boolean isLinePolygonIntersect(polygon3D poly, vector p0, vector c){
		//find intersection point with polygon plane
		vector n = poly.normal;
		double d = n.dot(poly.vertix3D[0]);
		double t = (d - n.dot(p0))/(n.dot(c));
		if(t < 0)
			return false;

		vector P = p0.myClone();
		c.scale(t);
		P.add(c);


		//test if the intersection points lies inside the polygon
		//test whether the sum of the angles formed by the intersection point and each edge of the polygon is equal to 360 degree
		double angle = 0;
		int length = poly.vertix3D.length;
		for(int i = 0; i < length; i++){
			vector a = poly.vertix3D[i].myClone();
			a.subtract(P);
			vector b = poly.vertix3D[(i+1+length)%length].myClone();
			b.subtract(P);
			double dot = a.dot(b);
			dot = dot/(a.getLength())/(b.getLength());
			angle+=Math.acos(dot);

		}

		if(Math.PI*2 - angle < 0.005)
			return true;

		return false;
	}
}