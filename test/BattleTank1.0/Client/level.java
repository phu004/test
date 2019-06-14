import java.awt.*;

//the level class on server side
//since there will only be one level object, so everything in this class is a static variable

public class level{
	public static int winningCount;

	public static void loadLevel(ClientModel gameModel, int levelIndex){
		//clear all the stuff from previous level
		for(int i = 0; i <  400; i ++)
			gameModel.drawingList[i] = null;

		//load base (same every level)
		gameModel.drawingList[0] = new wall(248, 498, 2, gameModel);
		gameModel.drawingList[1] = new wall(273, 498, 3, gameModel);
		gameModel.drawingList[2] = new wall(248, 473, 1, gameModel);
		gameModel.drawingList[3] = new wall(273, 473, 1, gameModel);
		gameModel.drawingList[4] = new normalObject(260, 498,  gameModel, "base", 0);

		//load one level
		if(1+ (levelIndex-1)%8 == 1){
			String[] level = new String[]{
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "ss", "ss", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"s0", "##", "##", "__", "__", "__", "__", "__", "##", "s0", "s0", "##", "__", "__", "__", "__", "__", "##", "##", "s0",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "##", "##", "__", "__", "__", "__", "__", "##", "__", "__", "##", "__", "__", "__", "__", "__", "##", "##", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__"
	       };
	       loadLevel(gameModel, level);
		}

		if(1+ (levelIndex-1)%8 == 2){
			String[] level = new String[]{
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$",
			"$$", "==", "==", "==", "==", "==", "==", "==", "$$", "$$", "==", "==", "==", "==", "==", "==", "==", "==", "==", "$$",
			"$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "ss", "##", "##", "##", "##", "##", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "ss", "##", "##", "##", "__", "__", "ss", "ss", "##", "##", "##", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "##", "__", "__", "__", "__", "__", "__", "##", "__", "__", "__", "__", "__", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "__", "__", "__", "__", "__", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "__", "__", "__", "__", "__", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "##", "##", "##", "##", "##", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "##", "##", "##", "##", "##", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "##", "##", "##", "##", "##", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "##", "##", "##", "##", "##", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "##", "##", "##", "##", "##", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "__", "__", "__", "__", "__", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "__", "__", "__", "__", "__", "##", "==", "==", "==", "==", "==", "__",
			"__", "$$", "$$", "$$", "$$", "$$", "##", "__", "__", "__", "__", "__", "__", "##", "==", "==", "==", "==", "==", "__"
	       };
	       loadLevel(gameModel, level);
		}

		if(1+ (levelIndex-1)%8 == 3){
			String[] level = new String[]{
			"__", "__", "__", "ss", "__", "__", "ss", "__", "__", "__", "__", "__", "__", "__", "__", "__", "s3", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "ss", "##", "##", "##", "__", "##", "##", "##", "##", "__", "s3", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "s3", "__", "__", "__",
			"__", "__", "ss", "ss", "__", "##", "##", "##", "##", "__", "__", "##", "##", "__", "##", "##", "##", "__", "__", "__",
			"__", "__", "__", "ss", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "##", "__", "##", "s1",
			"__", "__", "__", "ss", "__", "##", "__", "ss", "##", "ss", "##", "ss", "##", "##", "##", "##", "##", "__", "__", "##",
			"__", "__", "__", "ss", "__", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "__", "__", "__",
			"__", "__", "__", "ss", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "__", "__", "__",
			"__", "__", "__", "##", "ss", "ss", "ss", "ss", "##", "##", "##", "##", "##", "$$", "$$", "$$", "$$", "##", "##", "##",
			"##", "__", "__", "##", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "__", "__", "__",
			"##", "##", "__", "##", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "__", "__", "__",
			"##", "##", "##", "##", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "##", "##", "##", "##", "##", "__", "__", "__",
			"##", "##", "##", "##", "##", "##", "$$", "##", "$$", "##", "$$", "$$", "$$", "$$", "$$", "##", "__", "__", "__", "__",
			"##", "##", "##", "##", "$$", "$$", "$$", "$$", "$$", "##", "$$", "$$", "$$", "$$", "$$", "##", "__", "__", "__", "__",
			"#0", "s0", "s0", "s0", "$$", "ss", "ss", "ss", "ss", "##", "ss", "ss", "$$", "ss", "ss", "##", "##", "##", "ss", "##",
			"__", "__", "__", "##", "__", "__", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "##",
			"__", "__", "__", "##", "__", "__", "__", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$",
			"__", "__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__"
	       };
	       loadLevel(gameModel, level);
		}

		if(1+ (levelIndex-1)%8 == 4){
			String[] level = new String[]{
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "__", "__", "__", "__", "__",
			"__", "__", "__", "##", "##", "##", "##", "##", "##", "##", "##", "##", "ss", "##", "##", "##", "##", "__", "__", "__",
			"__", "__", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "ss", "ss", "s2", "__", "__",
			"__", "__", "##", "##", "$$", "$$", "$$", "$$", "$$", "$$",  "$$", "$$","$$", "$$", "$$", "$$", "$$", "s2", "__", "__",
			"__", "__", "##", "##", "##", "$$", "$$", "$$", "$$", "$$", "##", "$$", "$$", "$$", "$$", "$$", "$$", "s2", "__", "__",
			"__", "##", "##", "##", "##", "##", "$$", "$$", "$$", "##", "$$", "##", "$$", "$$", "$$", "$$", "$$", "s2", "__", "__",
			"__", "##", "##", "##", "##", "##", "$$", "$$", "##", "$$", "$$", "$$", "##", "$$", "$$", "$$", "$$", "s2", "__", "__",
			"__", "##", "##", "##", "##", "##", "$$", "##", "$$", "$$", "$$", "$$", "$$", "##", "$$", "$$", "$$", "s2", "__", "__",
			"__", "##", "##", "##", "##", "##", "$$", "$$", "##", "$$", "$$", "$$", "##",  "$$", "$$",  "$$", "$$", "s2", "__", "__",
			"__", "##", "##", "##", "##", "$$", "$$", "$$", "$$", "##", "$$", "##",  "$$", "$$", "$$", "$$", "##", "s2", "__", "__",
			"__", "__", "##", "##", "$$", "$$", "$$", "$$", "$$", "$$", "##", "$$", "$$", "$$", "$$", "$$", "##", "##", "__", "__",
			"__", "__", "##", "$$", "$$", "$$", "$$", "$$", "$$", "s3", "s2", "$$", "$$", "$$", "$$", "##", "##", "s0", "s0", "s0",
			"__", "__", "##", "##", "##", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "$$", "##", "##", "__", "__", "__", "__",
			"__", "__", "__", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "##", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__"
	       };
	       loadLevel(gameModel, level);
		}

		if(1+ (levelIndex-1)%8 == 5){
			String[] level = new String[]{
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "==", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "==", "==", "==", "__", "__", "==", "==", "==", "==", "==", "==", "__", "==", "==", "==", "==", "==", "==", "__",
			"__", "==", "ss", "__", "__", "__", "__", "==", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "==", "__",
			"__", "==", "__", "__", "__", "__", "__", "==", "__", "==", "==", "__", "ss", "==", "==", "==", "==", "__", "==", "__",
			"__", "==", "__", "==", "==", "==", "==", "==", "__", "==", "__", "__", "==", "__", "__", "==", "__", "__", "==", "__",
			"__", "==", "__", "==", "__", "__", "__", "__", "__", "==", "__", "__", "==", "__", "__", "==", "__", "__", "==", "__",
			"__", "==", "__", "==", "__", "__", "==", "==", "==", "==", "__", "__", "==", "__", "__", "==", "__", "==", "==", "__",
			"__", "==", "__", "==", "__", "__", "==", "__", "__", "__", "__", "__", "==", "ss", "__", "__", "__", "==", "__", "__",
			"__", "==", "__", "==", "__", "__", "==", "__", "__", "==", "__", "__", "==", "__", "__", "==", "__", "==", "__", "==",
			"__", "==", "__", "==", "__", "__", "==", "__", "__", "==", "__", "__", "==", "__", "__", "==", "__", "==", "__", "__",
			"__", "==", "__", "==", "__", "==", "==", "__", "__", "==", "__", "__", "==", "__", "==", "==", "__", "==", "==", "__",
			"__", "==", "__", "__", "__", "__", "__", "__", "__", "==", "__", "__", "==", "__", "==", "__", "__", "__", "==", "__",
			"__", "==", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "==", "__", "==", "==", "==", "__", "__", "__",
			"__", "==", "==", "==", "__", "==", "==", "==", "__", "ss", "ss", "==", "==", "__", "__", "__", "==", "__", "==", "__",
			"__", "__", "__", "__", "__", "__", "==", "__", "__", "__", "__", "__", "==", "__", "ss", "__", "==", "__", "==", "__",
			"==", "==", "==", "==", "==", "__", "==", "__", "__", "__", "__", "__", "==", "__", "__", "__", "==", "__", "==", "__",
			"__", "__", "__", "__", "__", "__", "==", "__", "__", "__", "__", "__", "==", "==", "==", "__", "==", "==", "==", "__",
			"__", "__", "__", "__", "__", "__", "==", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "==", "__",
			"__", "__", "__", "__", "__", "__", "==", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "==", "__"
	       };
	       loadLevel(gameModel, level);
		}

		if(1+ (levelIndex-1)%8 == 6){
			String[] level = new String[]{
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "$$", "__", "__", "__", "__", "$$", "__", "__", "__", "__", "__", "__", "__", "__", "__", "$$", "__",
			"__", "__", "$$", "ss", "$$", "__", "__", "$$", "ss", "$$", "__", "__", "__", "__", "__", "__", "__", "$$", "ss", "$$",
			"__", "$$", "ss", "ss", "$$", "__", "$$", "ss", "ss", "ss", "$$", "__", "__", "__", "__", "__", "__", "$$", "ss", "$$",
			"__", "$$", "ss", "ss", "ss", "$$", "ss", "ss", "ss", "$$", "$$", "$$", "$$", "__", "__", "__", "$$", "ss", "ss", "$$",
			"__", "$$", "ss", "ss", "ss", "$$", "$$", "ss", "$$", "$$", "ss", "ss", "ss", "$$", "__", "__", "$$", "ss", "ss", "$$",
			"$$", "ss", "ss", "ss", "ss", "$$", "__", "$$", "$$", "$$", "ss", "ss", "ss", "$$", "__", "__", "$$", "ss", "ss", "$$",
			"$$", "ss", "ss", "ss", "ss", "$$", "__", "__", "$$", "$$", "ss", "$$", "$$", "__", "__", "$$", "ss", "ss", "ss", "$$",
			"$$", "ss", "ss", "ss", "ss", "$$", "__", "$$", "ss", "ss", "ss", "$$", "__", "__", "__", "$$", "ss", "ss", "ss", "$$",
			"$$", "ss", "ss", "ss", "ss", "$$", "__", "$$", "ss", "ss", "ss", "$$", "__", "__", "__", "$$", "ss", "ss", "$$", "__",
			"$$", "ss", "ss", "ss", "$$", "__", "__", "ss", "ss", "$$", "$$", "__", "__", "__", "__", "$$", "ss", "ss", "$$", "__",
			"$$", "ss", "ss", "ss", "$$", "__", "$$", "ss", "ss", "$$", "__", "__", "__", "__", "$$", "ss", "ss", "ss", "$$", "__",
			"$$", "ss", "ss", "ss", "$$", "$$", "ss", "ss", "$$", "__", "__", "__", "__", "__", "__", "$$", "$$", "$$", "__", "__",
			"$$", "ss", "ss", "ss", "$$", "$$", "ss", "$$", "__", "__", "$$", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"$$", "ss", "ss", "ss", "$$", "__", "$$", "__", "__", "$$", "ss", "$$", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "$$", "ss", "ss", "$$", "__", "__", "__", "__", "$$", "ss", "ss", "$$", "__", "__", "__", "__", "__", "__", "__",
			"__", "$$", "ss", "ss", "$$", "__", "__", "__", "__", "$$", "ss", "ss", "ss", "$$", "$$", "$$", "$$", "$$", "__", "__",
			"__", "$$", "ss", "ss", "$$", "__", "__", "__", "__", "__", "$$", "ss", "ss", "ss", "ss", "ss", "ss", "ss", "$$", "__",
			"__", "__", "$$", "ss", "$$", "__", "__", "__", "__", "__", "__", "$$", "ss", "ss", "ss", "ss", "$$", "$$", "__", "__",
			"__", "__", "__", "$$", "__", "__", "__", "__", "__", "__", "__", "__", "$$", "$$", "$$", "$$", "__", "__", "__", "__"

	       };
	       loadLevel(gameModel, level);
		}

		if(1+ (levelIndex-1)%8 == 7){
			String[] level = new String[]{
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "__", "__", "$$", "$$", "$$", "__", "__",
			"__", "__", "__", "ss", "ss", "ss", "__", "__", "##", "##", "##", "__", "__", "__", "__", "$$", "$$", "$$", "__", "__",
			"__", "__", "__", "ss", "ss", "ss", "__", "__", "##", "##", "##", "__", "__", "__", "__", "$$", "$$", "$$", "__", "__",
			"__", "__", "__", "ss", "ss", "ss", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "==", "==", "==", "__",
			"$$", "$$", "$$", "__", "__", "__", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "==", "==", "==", "__",
			"$$", "$$", "$$", "__", "__", "__", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "==", "==", "==", "__",
			"$$", "$$", "$$", "__", "__", "__", "ss", "ss", "ss", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "ss", "ss", "ss", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "ss", "ss", "ss", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "ss", "ss", "ss", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "ss", "ss", "ss", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "ss", "ss", "ss", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "##", "##", "##", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "##", "##", "##", "__", "__", "__", "__", "__", "__", "__", "__", "==", "==", "==", "__", "__",
			"__", "__", "__", "__", "##", "##", "##", "__", "__", "__", "__", "__", "__", "__", "__", "==", "==", "==", "__", "__",
			"__", "__", "__", "__", "##", "##", "##", "__", "__", "__", "__", "__", "__", "__", "__", "==", "==", "==", "__", "__"
	       };
	       loadLevel(gameModel, level);
		}

		if(1+ (levelIndex-1)%8 == 8){
			String[] level = new String[]{
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"##", "##", "##", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"##", "##", "##", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "##", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "##", "__", "__", "##", "##", "##", "__", "##", "__", "__", "__", "##", "__", "__", "##", "##", "##", "__",
			"__", "__", "##", "__", "##", "__", "__", "##", "__", "##", "__", "__", "__", "##", "__", "##", "__", "__", "##", "__",
			"__", "__", "##", "__", "##", "__", "__", "##", "__", "__", "##", "__", "##", "__", "__", "##", "__", "__", "##", "__",
			"__", "__", "##", "__", "##", "__", "__", "##", "__", "__", "##", "__", "##", "__", "__", "##", "__", "__", "##", "__",
			"__", "__", "##", "__", "##", "__", "__", "##", "__", "__", "##", "__", "##", "__", "__", "##", "__", "__", "##", "__",
			"##", "__", "##", "__", "##", "__", "__", "##", "__", "__", "__", "##", "__", "__", "__", "##", "__", "__", "##", "__",
			"__", "##", "__", "__", "__", "##", "##", "__", "##", "__", "__", "##", "__", "__", "__", "__", "##", "##", "__", "##",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__",
			"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__"
	       };
	       loadLevel(gameModel, level);
		}
	}
	public static void loadLevel(ClientModel gameModel, String[] level){
		for(int i = 0; i < level.length; i++){
			if(level[i].equals("##"))
				gameModel.addActor(new wall(23 + (i%20)*25,  23 + (i/20)*25,   4,gameModel));
           	if(level[i].equals("#0"))
				gameModel.addActor(new wall(23 + (i%20)*25,  23 + (i/20)*25,  0,  gameModel));
			 if(level[i].equals("#1"))
				gameModel.addActor(new wall(23 + (i%20)*25,  23 + (i/20)*25,  1,  gameModel));
			 if(level[i].equals("#2"))
				gameModel.addActor(new wall(23 + (i%19)*25,  23 + (i/20)*25,  2,  gameModel));
			 if(level[i].equals("#3"))
				gameModel.addActor(new wall(23 + (i%20)*25,  23 + (i/20)*25,  3,  gameModel));
		    if(level[i].equals("ss"))
				gameModel.addActor(new Steelwall(23 + (i%20)*25,  23 + (i/20)*25,  4, gameModel));
			if(level[i].equals("s0"))
				gameModel.addActor(new Steelwall(23 + (i%20)*25,  23 + (i/20)*25,  0,  gameModel));
			if(level[i].equals("s1"))
				gameModel.addActor(new Steelwall(23 + (i%20)*25,  23 + (i/20)*25,  1,  gameModel));
			if(level[i].equals("s2"))
				gameModel.addActor(new Steelwall(23 + (i%20)*25,  23 + (i/20)*25,  2,  gameModel));
			if(level[i].equals("s3"))
				gameModel.addActor(new Steelwall(23 + (i%20)*25,  23 + (i/20)*25,  3,  gameModel));

			if(level[i].equals("$$")){
				for(int j = 399; j >=0; j--){
					if(gameModel.drawingList[j] == null){
						gameModel.drawingList[j] = new normalObject(23 + (i%20)*25,  23 + (i/20)*25, gameModel, "grass",  -1);
						break;
					}
				}
			}
			if(level[i].equals("=="))
				gameModel.addActor(new normalObject(23 + (i%20)*25,  23 + (i/20)*25, gameModel, "river", 71));
		}
	}
}