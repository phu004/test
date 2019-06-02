import java.awt.*;

public interface model{
	public polygon3D[] getPolygon();
	public void update();
	public polygon3D[] getBoundary();
	public vector getCentre();
	public void draw();
	public void sort();
	public int getType();
}