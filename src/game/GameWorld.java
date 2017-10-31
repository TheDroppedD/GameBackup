package game;

import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;

public class GameWorld {

	// variables:
	
	// game world physical boundaries of where objects are allowed to move
	private float xmin; // left boundary
	private float xmax; // right boundary
	private float ymin; // top boundary
	private float ymax; // bottom boundary
	
	// collection of all live physical in-game objects
	Collection<InGameObject> listOfLiveObjects = new ArrayList<InGameObject>(10);
	
	
	// methods:
	
	// constructor that requires boundaries to be specified
	public GameWorld(float xmin, float xmax, float ymin, float ymax) {
		this.xmin=xmin;
		this.xmax=xmax;
		this.ymin=ymin;
		this.ymax=ymax;
		// TODO anything else needed?
	}
	
	// getters
	float get_xmin() {
		return xmin;
	}
	float get_xmax() {
		return xmax;
	}
	float get_ymin() {
		return ymin;
	}
	float get_ymax() {
		return ymax;
	}
	
	// I don't think this should have any setters??? the game world is supposed
	// ...to be fairly constant once initialized and instantiated
	
}
