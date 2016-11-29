package thinktank.simulator.entity;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;

import com.jme3.scene.Geometry;
import com.jme3.scene.Node;

/**
 * Concrete type of <code>Entity</code> meant to serve as a base for 
 * any more specific type of fish.
 * 
 * @author Bob Thompson
 * @version %I%, %G%
 *
 */
public class Fish extends Entity{
	/**
	 *
	 */
	public enum BEHAVIOR{
		ATTACK("Attack"),
		HIDE("Hide"),
		DART("Dart"),
		LOITER("Loiter"),
		RUN("Run");
		
		/**
		 * 
		 */
		public final String NAME;

		private BEHAVIOR(String name){
			this.NAME = name;
		}//end of enum constructor
	}//end of BEHAVIOR enum
	
	//---------------------static constants----------------------------
	private static final long serialVersionUID = 8860191503415305251L;
	
	//---------------------static variables----------------------------
	//---------------------instance constants--------------------------
	//---------------------instance variables--------------------------
	/**
	 * Value representing the gender of this fish.
	 */
	private String sex;
	/**
	 * The name for this fish.
	 */
	private String name;
	/**
	 * Values for the general size and speed of this fish.
	 */
	private float size;
	/**
	 * 
	 */
	private float baseSpeed;
	/**
	 * 
	 */
	private float speed;
	/**
	 * Value for the general color of this fish.
	 */
	private Color color;
	/**
	 * 
	 */
	private BEHAVIOR behavior;
	/**
	 * 
	 */
	private double targetAggression;
	/**
	 * 
	 */
	private Fish targetFish;
	/**
	 * 
	 */
	private int randomTimeControl;
	
	//---------------------constructors--------------------------------
	/**
	 * Constructs a basic, default fish.
	 */
	public Fish(){
		this.sex = "male";
		this.name = "unnamed";
		this.size = 1.0f;
		this.baseSpeed = -1;
		this.speed = -1;
		this.color = Color.BLACK;
		this.behavior = BEHAVIOR.LOITER;
		this.targetAggression = 0;
		this.targetFish = null;
		this.randomTimeControl = 0;
	}//end of default constructor
	
	//---------------------instance methods----------------------------
	//GETTERS
	/**
	 * Gets the value for the size of this fish.
	 * 
	 * @return the value for the size of this fish.
	 */
	public float getSize(){
		return this.size;
	}//end of getSize method

	/**
	 * Gets the value for the color of this fish.
	 * 
	 * @return the value for the color of this fish.
	 */
	public Color getColor(){
		return this.color;
	}//end of getColor method

	/**
	 * Gets the value for the speed of this fish.
	 * 
	 * @return the value for the speed of this fish.
	 */
	public float getSpeed(){
		return this.speed;
	}//end of getSpeed method
	
	/**
	 * Returns the sex of this fish.
	 * 
	 * @return the sex of this fish.
	 */
	public String getSex(){
		return sex;
	}//end of getSex method
	
	/**
	 * Gets the name of this fish.
	 * 
	 * @return the name of this fish.
	 */
	public String getName(){
		return name;
	}//end of getName method
	
	/**
	 * 
	 * @return
	 */
	public int getTimeControl(){
		return randomTimeControl;
	}//end of getTimeControl method
	
	/**
	 * Gets the Target Fish
	 * @return the targeted Fish object
	 */
	public Fish getTargetFish(){
		return targetFish;
	}//end of getTargetFish method

	/**
	 * Gets the Aggression towards the target fish
	 * @return the Aggression level towards the targeted fish
	 */
	public double getTargetAggression(){
		return targetAggression;
	}//end of getTargetAgression method
	
	/**
	 * 
	 * @return
	 */
	public float getBaseSpeed(){
		return baseSpeed;
	}//end of getBaseSpeed method
	
	/**
	 * this returns the behavior value
	 * @return
	 */
	public BEHAVIOR getBehavior(){
		return behavior;
	}//end of getBehavior method
	
	//SETTERS
	/**
	 * Sets the value for the speed of this fish to the specified value.
	 * 
	 * @param speed the value to which this fish's speed is to be set.
	 */
	public void setSpeed(float speed){
		if(speed == -1){
			setBaseSpeed(speed);
		}
		this.speed = speed;
	}//end of setSpeed method

	/**
	 * Sets the time control variable
	 * @param time
	 */
	public void setTimeControl(int time) {
		this.randomTimeControl = time;
	}//end of setTimeControl method

	/**
	 * 
	 * @param base
	 */
	private void setBaseSpeed(float base){
		baseSpeed = base;
	}//end of setBaseSpeed method
	
	/**
	 * Sets the value for the size of this fish to the specified value.
	 * 
	 * @param size the value to which this fish's size is to be set.
	 */
	public void setSize(float size){
		this.size = size;
	}//end of setSize method
	
	/**
	 * Sets the target ish
	 * @param Fish nextFish 
	 */
	public void setTargetFish(Fish nextFish){
		this.targetFish = nextFish;
	}//end of setTargetFish method
	
	/**
	 * Sets the Aggression level towards the target fish
	 * @param double targetAggression
	 */
	public void setTargetAggression(double targetAggression){
		this.targetAggression = targetAggression;
	}//end of setTargetAggression method
	
	/**
	 * Sets the value for the color of this fish to the specified value.
	 * 
	 * @param color the value to which this fish's color is to be set.
	 */
	public void setColor(Color color){
		this.color = color;
	}//end of setColor method
	
	/**
	 * Sets the sex of this fish to the specified value.
	 * 
	 * @param sex the value to which the sex is to be set.
	 */
	public void setSex(String sex){
		this.sex = sex;
	}//end of setSex method
	
	/**
	 * Sets the name of this fish to the specified value.
	 * 
	 * @param name the value to which the name is to be set.
	 */
	public void setName(String name){
		this.name = name;
		if(getObj() instanceof Geometry){
			Geometry geom = (Geometry)getObj();
			geom.setName(name);
		}
		if(getObj() instanceof Node){						// sets the name of the geometry
			Node oN = (Node)getObj();						// which is returned by the ray collision
			for(int i=0; i<oN.getChildren().size(); i++){	// when selecting with mouse clicks
				oN.getChild(i).setName(name+"-"+i);	
			}
		}
	}//end of setName method

	/**
	 * This sets the behavior value based on the passed enum
	 * @param behave
	 */
	public void setBehavior(BEHAVIOR behave){
		behavior = behave;
	}//end of setBehavior method
	
	@Override
	public void setGlow(boolean glow){
		//not implemented in this class
	}//end of setGlow method
	
	//OPERATIONS
	/**
	 * Method called in the update loop to move the fish based on the 
	 * specified elapsed time since the last update.
	 * 
	 * @param tpf the elapsed time since the last update.
	 */
	public void move(float tpf){
		//TODO implement or remove
	}//end of move method
	
	/**
	 * The readObject method is responsible for reading from the stream and restoring 
	 * the fields of the class.
	 * 
	 * @param stream the input stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
		size = stream.readFloat();
		speed = stream.readFloat();
		String name = (String)(stream.readObject());
		this.setName(name);
	}//end of readObject method

	/**
	 * The writeObject method is responsible for writing the state of the object 
	 * so that the corresponding readObject method can restore it.
	 * 
	 * @param stream the output stream.
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException{
		stream.writeFloat(size);
		stream.writeFloat(speed);
		stream.writeObject(name);
	}//end of writeObject method
	
	@SuppressWarnings("unused")
	private void readObjectNoData() throws ObjectStreamException{}//end of readObjectNoData method

	//---------------------static main---------------------------------
	//---------------------static methods------------------------------
}//end of Fish class