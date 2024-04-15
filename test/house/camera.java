import java.awt.*;

public class camera{
	public static vector position, displacement;

	public static vector view_Direction;

	public static boolean MOVE_FORWARD, MOVE_BACKWARD, SLIDE_LEFT, SLIDE_RIGHT, UP_TYPED, DOWN_TYPED, RIGHT_TYPED, LEFT_TYPED;

	public static double look_up, look_down, look_right, look_left;

	public static final vector viewDirection = new vector(0, 0, 1);

	public static final Rectangle screen = new Rectangle(0,0,house.screen_w, house.screen_h);

	public static double sinXZ, cosXZ, sinYZ, cosYZ;

	public camera(vector position){
		this.position = position;
		displacement = new vector(0,0,0);
		view_Direction = new vector(0, 0, 1);
		look_up = 0;
		look_down = 0;
		look_right =0;
		look_left = 0;
	}

	public static final void update(){
		vector oldPosition = position.myClone();

		if(UP_TYPED){
			look_up+=0.05;
			if(look_up > 1.570796326)
				look_up = 1.570796326;
		}

		if(DOWN_TYPED){
			look_up-=0.05;
			if(look_up < -1.570796326)
				look_up = -1.570796326;
		}

		if(RIGHT_TYPED){
			look_right-=0.05;
		}

		if(LEFT_TYPED){
			look_right+=0.05;
		}

		if(MOVE_FORWARD){
			position.subtract(view_Direction, -0.2);
		}

		if(MOVE_BACKWARD){
			position.subtract(view_Direction, 0.2);
		}

		if(SLIDE_LEFT){
			vector left = view_Direction.cross(new vector(-view_Direction.x, -1000000, -view_Direction.z));
			left.unit();
			position.subtract(left, 0.2);
		}

		if(SLIDE_RIGHT){
			vector right = view_Direction.cross(new vector(view_Direction.x, 10000000, view_Direction.z));
			right.unit();
			position.subtract(right, 0.2);
		}

		oldPosition.subtract(position);
		oldPosition.scale(-1);
		displacement.set(oldPosition);


		view_Direction.set(viewDirection);
		view_Direction.rotate_XZ(look_right);
		view_Direction.rotate_vertical(look_up);
		view_Direction.unit();

		sinXZ = Math.sin(-look_right);
		cosXZ = Math.cos(-look_right);
		sinYZ = Math.sin(look_up);
		cosYZ = Math.cos(look_up);
	}

}