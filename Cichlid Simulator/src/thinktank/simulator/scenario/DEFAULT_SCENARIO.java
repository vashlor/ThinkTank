package thinktank.simulator.scenario;

import thinktank.simulator.environment.TANK_TYPE;

/**
 * Specifies the available default scenarios, as well as their names, 
 * tank temperatures, and tank types.
 * 
 * @author Bob Thompson
 * @version %I%, %G%
 */
public enum DEFAULT_SCENARIO{
	
	EMPTY("Empty Scenario", 23.00f, TANK_TYPE.FIFTEEN_GAL),
	LONE_FISH("Lone Fish", 23.00f, TANK_TYPE.TEN_GAL),
	PAIR_FISH("Pair of Fish", 23.00f, TANK_TYPE.FIFTEEN_GAL),
	MEDIUM_BORDER_PLANTS("Edge Plants", 23.00f, TANK_TYPE.THIRTY_GAL_SHORT),
	MEDIUM_CENTER_PLANTS("Middle Plants", 23.00f, TANK_TYPE.TWENTY_GAL_EXTRA_TALL),
	BIG_AND_BUSY("Big and Busy", 23.00f, TANK_TYPE.FIFTY_GAL);
	
	/**
	 * The name of the default scenario.
	 */
	public final String NAME;
	/**
	 * The value of the tank temperature, in degrees Celcius.
	 */
	public final float TANK_TEMP;
	/**
	 * The tank type for the scenario.
	 */
	public final TANK_TYPE TYPE;
	
	private DEFAULT_SCENARIO(String name, float temp, TANK_TYPE type){
		this.NAME = name;
		this.TANK_TEMP = temp;
		this.TYPE = type;
	}//end of constructor

}//end of DEFAULT_SCENARIO enum