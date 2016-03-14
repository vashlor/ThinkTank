package thinktank.simulator.entity;

import com.jme3.asset.AssetManager;

/*****************************************************************************************
 * Class: Plant
 * Purpose: creates plant objects
 * Author: Think Tank
 * Revisions:
 * 3/11/16 - JC - Added Class Header
 * 
 * 
 * 
 * 
 * 
 ****************************************************************************************/
/**
 * 
 * @author Bob Thompson
 * @version %I%, %G%
 *
 */
public class Plant extends EnvironmentObject{
	//---------------------static constants----------------------------
	private static final long serialVersionUID = 8500489926122948173L;
	
	//---------------------static variables----------------------------
	//---------------------instance constants--------------------------
	//---------------------instance variables--------------------------
	//---------------------constructors--------------------------------
	public Plant(AssetManager am){
		setObj(am.loadModel("AmazonSword.obj"));
		getObj().rotate(0, -1f, 0);
	}
	
	//---------------------instance methods----------------------------
	//---------------------static main---------------------------------
	//---------------------static methods------------------------------
}//end of Plant class