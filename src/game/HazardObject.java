package game;

import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;

public class HazardObject extends InGameObject{

	public HazardObject(GameWorld gameworld, float x, float y, float vx, float vy) {
                super(gameworld, x, y, vx, vy);		
		setDamage(10);
		
	}

	
