package thinktank.simulator.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.jme3.math.Vector3f;

import thinktank.simulator.Starter;
import thinktank.simulator.entity.Entity;
import thinktank.simulator.entity.Fish;
import thinktank.simulator.main.Main;
import thinktank.simulator.scenario.Scenario;
import thinktank.simulator.ui.ScenarioBuilderScreenController;

/**
 * Moves the currently selected entity down, relative to the camera perspective.
 * 
 * @author Bob Thompson
 * @version %I%, %G%
 */
public class MoveEntityDownAction extends AbstractAction{
	//---------------------static constants----------------------------
	private static final long serialVersionUID = 201389170013758967L;
	/**
	 * Constant String identifying this action.
	 */
	public static final String NAME = "move-entity-down";
	
	//---------------------static variables----------------------------
	/**
	 * Singleton instance for the action.
	 */
	private static MoveEntityDownAction instance = null;
	
	//---------------------instance constants--------------------------
	/**
	 * <code>Vector3f</code> representation of the direction in the game 
	 * world in which the entity will be moved upon invocation.
	 */
	private final Vector3f translateVector;
	
	//---------------------instance variables--------------------------
	//---------------------constructors--------------------------------
	/**
	 * Constructs a basic, default <code>MoveEntityDownAction</code>.
	 */
	private MoveEntityDownAction(){
		translateVector = new Vector3f(0f, -0.01f, 0f);
	}//end of constructor
	
	//---------------------instance methods----------------------------
	//OPERATIONS
	/**
	 * Method invoked when the associated action occurs. 
	 * 
	 * @param evt the object for the triggering event.
	 */
	@Override
	public void actionPerformed(ActionEvent evt){
		Main client = Starter.getClient();
		Scenario scenario = client.getWorkingScenario();
		if(!client.isInMenus() && scenario != null && scenario.isEditingMode() && !client.isMouselookActive() && scenario.isMovingMode()){
			Entity entity = scenario.getSelectedEntity();
			if(entity != null && entity instanceof Fish){
				entity.translate(translateVector);
				ScenarioBuilderScreenController.unsaved_changes = true;
			}
		}
	}//end of actionPerformed method
	
	//---------------------static main---------------------------------
	//---------------------static methods------------------------------
	/**
	 * Returns a reference to the singleton instance of the action.
	 * 
	 * @return the action object
	 */
	public static MoveEntityDownAction getInstance(){
		if(instance == null){
			instance = new MoveEntityDownAction();
		}
		return instance;
	}//end of getInstance method
	
}//end of MoveEntityDownAction class