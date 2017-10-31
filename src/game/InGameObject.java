package game;

public class InGameObject {

	// variables:
	
	// variables about game mechanics
	private int damage = 0; // change this to nonzero in hazardous object subclasses
	
	// variables about physics
	private float x;
	private float y;
	private float vx;
	private float vy;
	private float mass = 1; // relative to mass of player character
	private float collisionRadius = 1; // same idea as a hitbox, but circular for simplicity
	private float dampingParameter = 1; // this slows down the object's movement by some factor every timestep
	
	// must have an object reference to the GameWorld that it was created in
	GameWorld gameworld;
	
	
	// custom constructor adds this new object to the GameWorld's Collection of other physics objects
	public InGameObject(GameWorld gameworld, float x, float y, float vx, float vy){
		this.gameworld=gameworld;
		this.set_x(x);
		this.set_y(y);
		this.set_vx(vx);
		this.set_vy(vy);
		// add this in-game object to the GameWorld's collection of live physical objects
		gameworld.listOfLiveObjects.add(this);
		// also once this object is created, run collision detection on it,
		// ...and if it returns that it collided with something else, then destroy it again!
		// ...you should not be able to place new objects on top of other existing ones
		if (this.collisionDetect()) {
			// if collision is detected, then delete this newly created object
			// by removing it from the list of live objects
			this.beDestroyed();
		}
	}
	
	// methods: 	

	public void move() {
		// update the object's position and velocity
		x = x + vx;
		y = y + vy;
		vx = dampingParameter*vx;
		vy = dampingParameter*vy;
		// check for collisions with other objects and/or the GameWorld boundaries
		collisionDetect();
	}
	
	public boolean collisionDetect() {
		//TODO FOR ALPHA I WILL ONLY IMPLEMENT WALL BOUNDARY AND PLAYER-OBJECT COLLISIONS, NOT OBJECT-OBJECT COLLISIONS
		//TODO where am I gonna get the GameWorld Colleciton of other bodies? FROM THE OBJECT REFERENCE!
		//TODO how am I gonna get the GameWorld's wall boundary?
		//TODO make sure to only ever move THIS particular object, otherwise any other objects you move would have to run collision detection and it could be a bad chain. but of course any other object that collides with, must change its velocity so that's fine!
		//TODO also the player shouldn't be moved when it collides, so maybe override this in player object subclass?
		//TODO if it collided with GameWorld boundary (possibly in addition to other objects; it should make no difference), just move this object to the inside of the boundary (within its radius) and reverse it's appropriate velocity component
		return false;
	}
	
	public boolean isCollidingWith(InGameObject other) {
		// this checks if this object's hitbox-circle intersects with other object's hitbox-circle
		// it has a lot of delicate math so I wanted to put it in a function of its own lol
		
		// first it checks to make sure the "other" object isn't actually "this" own object,
		// ...by seeing if the two objects' positions are exactly identical
		if ((this.get_x() == other.get_x()) && (this.get_y() == other.get_y())) {
			return false; // object should not be considered to "collide with itself" thats silly
		}
		
		// checks if the distance between the centers of the two objects is less than the sum of
		// ...their collision radii, and if so that means the objects are colliding
		if (Math.sqrt(Math.pow((this.x-other.x),2)+Math.pow((this.y-other.y),2)) < (this.collisionRadius+other.collisionRadius)) {
			return true;
		}
		
		// if no other object-object collision found
		return false;
	}
	
	public void beDestroyed() {
		// TODO how to remove this object from the GameWorld's Collection of physical objects?
	}

	// getter methods below
	public int getDamage() {
		return damage;
	}
	
	public float get_x() {
		return x;
	}

	public float get_y() {
		return y;
	}

	public float get_vx() {
		return vx;
	}

	public float get_vy() {
		return vy;
	}

	public float getMass() {
		return mass;
	}

	public float getCollisionRadius() {
		return collisionRadius;
	}

	public float getDampingParameter() {
		return dampingParameter;
	}

	// setter methods below
	public void setDamage(int damage) {
		this.damage=damage;
	}
	
	public void set_x(float x) {
		this.x=x;
	}

	public void set_y(float y) {
		this.y=y;
	}

	public void set_vx(float vx) {
		this.vx=vx;
	}

	public void set_vy(float vy) {
		this.vy=vy;
	}

	public void setMass(float mass) {
		this.mass=mass;
	}

	public void setCollisionRadius(float collisionRadius) {
		this.collisionRadius=collisionRadius;
	}

	public void setDampingParameter(float dampingParameter) {
		this.dampingParameter=dampingParameter;
	}

}
