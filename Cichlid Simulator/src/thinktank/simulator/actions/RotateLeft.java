package thinktank.simulator.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import gameAssets.Player;
import thinktank.simulator.entity.Fish;

/**
 * 
 * @author Vasher Lor
 * @version %I%, %G%
 */
public class RotateLeft extends AbstractAction{
	//---------------------static constants----------------------------
	private static final long serialVersionUID = 9077272919747923379L;
	public static final String NAME = "rotate-left";

	//---------------------static variables----------------------------
	/**
	 * Singleton instance for the action.
	 */
	private static RotateLeft instance = null;

	//---------------------instance constants--------------------------
	//---------------------instance variables--------------------------
	private Player fish;
	private Node obj;

	//---------------------constructors--------------------------------
	/**
	 * Constructs a basic, default <code>RotateLeft</code> action 
	 * with the specified <code>Player</code>.
	 */
	private RotateLeft(Player fish){
		this.fish = fish;
		this.obj = fish.getNode();
	}//end of (Player) constructor

	//---------------------instance methods----------------------------
	//OPERATIONS
	@Override
	public void actionPerformed(ActionEvent evt){
		Vector3f up = new Vector3f(0,1,0);
		Quaternion q = new Quaternion();
		q.fromAngleNormalAxis(.1f, up);
		obj.rotate(q);
	}//end of actionPerformed method

	//---------------------static main---------------------------------
	//---------------------static methods------------------------------
	public static RotateLeft getInstance(Player fish){
		if (instance != null){
			return instance;
		}
		else {
			instance = new RotateLeft(fish);
			return instance;
		}
	}//end of getInstance(Player) method
	
	public static RotateLeft getInstance(){
		if (instance == null){
			System.out.println("Pass in a fish!");
			return null;
		}
		else return instance;
	}//end of getInstance method
	
}//end of RotateLeft class