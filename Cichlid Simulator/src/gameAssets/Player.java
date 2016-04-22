package gameAssets;
/*****************************************************************************************
 * Class: Player
 * Purpose: Create a player instance of a Cichlid
 * Author: Think Tank
 * Revisions:
 * 3/11/16 - JC - Added Class Header
 * 
 * 
 * 
 * 
 * 
 ****************************************************************************************/
import com.jme3.asset.AssetManager;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Node;
import com.jme3.scene.control.CameraControl.ControlDirection;

import Game.Main;

public class Player extends Cichlid
{
	private static final long serialVersionUID = 4038460719382327559L;
	static private Player player;  //singleton
	private static Node node = null;
	private CameraNode cam;
	private BetterCharacterControl cc;
	
	private Player(float size, float speed, String sex)
	{
		super(size, speed, sex);
		cc = new BetterCharacterControl(1,1,1);
		//node.addControl(cc);
		node.attachChild(getObj());
		getObj().rotate(0, (float) (3.14/2), 0);
	}
	
	static public Player getPlayer()
	{
		if(player == null){
			node = new Node();
			player = new Player(1, 1, "male");
		}
			
		return player;
	}
	
	public void attachCam(CameraNode camera){
		this.cam = camera;
		cam.setControlDir(ControlDirection.SpatialToCamera);
		getObj().setLocalTranslation(0, 0, .15f);
		cam.lookAt(player.getObj().getWorldTranslation(), new Vector3f(0,1,0));
		cam.attachChild(node);
		cam.setLocalTranslation(.1f, .1f, 0);
	}
	public Node getNode(){
		if (node == null){
			System.out.println("There is no player fish");
			return null;
		}
		else return node;
	}
	public void update(){
		//cam.lookAt(player.getObj().getWorldTranslation(), new Vector3f(0,1,0));
		//getObj().lookAt(Main.camera.getDirection(), Vector3f.UNIT_Y);
	}
	public CameraNode getCam(){
		return cam;
	}
}