package game;

//NOTE for controlling, use player object's set_vx(...) and set_vy(...) methods, corresponding to some condition like mouse changing position in window

public class PlayerChar extends InGameObject {

	// variables (in addition to inherited ones):
	
	// game mechanics variables
	private int health = 100;
	private boolean isInvincible = false;
	
	// physics variables
	float dampingParameter = 0; // player object should stop immediately once control stops moving it
	// TODO any other special variables? change any of the inherited variables?
	
	
	// methods (in addition to inherited ones):
	
	public PlayerChar(GameWorld gameworld, float x, float y, float vx, float vy) {
		super(gameworld, x, y, vx, vy);
		// TODO Auto-generated constructor stub, NEED ANY FIX?
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health=health;
		//TODO maybe put health checker here? if it throws an exception for game over?
	}
	
	public boolean getInvincibility() {
		return isInvincible;
	}
	
	public void setInvincibility(boolean isInvincible) {
		this.isInvincible=isInvincible;
	}
	
	//TODO override collisionDetect() to add health-detracting then death-checking functionality
	@Override
	public boolean collisionDetect() {
		boolean didCollide = false;
		
		// first check if the player collides with the walls, and fix their position accordingly
		if ((get_x()+getCollisionRadius()) > gameworld.get_xmax()) { // right boundary
			set_x(gameworld.get_xmax()-getCollisionRadius());
		}
		else if ((get_x()-getCollisionRadius()) < gameworld.get_xmin()) { // left boundary
			set_x(gameworld.get_xmin()+getCollisionRadius());
		}
		if ((get_y()+getCollisionRadius()) > gameworld.get_ymax()) { // bottom boundary
			set_y(gameworld.get_ymax()-getCollisionRadius());
		}
		else if ((get_y()-getCollisionRadius()) < gameworld.get_ymin()) { // top boundary
			set_y(gameworld.get_ymin()+getCollisionRadius());
		}
		// note that this does not return true if the player collides only with boundaries
		
		// then check if player collided with any other in-game objects
		// note how it does not change player object's position or velocity in any way
		for (InGameObject other : gameworld.listOfLiveObjects) {
			if (this.isCollidingWith(other)) {
				subtractHealth(other.getDamage());
				didCollide = true;
				// note that this function should not return immediately after one collision detection,
				// ...because player might be colliding with more than one object!
				
				// and if the object was damaging, allow temporary invincibility
				//TODO how to make a method for this with some sorta time counter??? for alpha it dont exist though
			}
		}
		// if no object-player collision was detected, this will be false
		return didCollide;
	}
	
	// health-subtracting function, for collisions with hazardous objects
	// note that harmless objects have damage=0 so it doesnt change anything
	public void subtractHealth(int damage) {
		if (getInvincibility()==false) {
			setHealth(getHealth()-damage);			
		}
	}
	
	// health-checking function that activates after each collision (any other times?)
	// ...and kills player and somehow ends game (throws exception e.g. GameOverException?) when health<=0
	public boolean isPlayerStillAlive() {
		if (getHealth() <= 0) {
			return false;
			//TODO maybe throw a new exception like "GameOverException" for reliable control flow stuff?
		}
		return true;
	}
	
}
