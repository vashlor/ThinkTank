package thinktank.simulator.controllers;

import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;

import gameAssets.Cichlid;
import thinktank.simulator.actions.MoveForward;
import thinktank.simulator.entity.Fish;

public class CichlidController implements AnalogListener, ActionListener{
	private Cichlid player;
	private static MoveForward moveForward;
	
	public CichlidController(Cichlid player){
		this.player = player;
		moveForward = new MoveForward(player);
	}

	@Override
	public void onAction(String name, boolean keyPressed, float tpf) {
		if(keyPressed){
			
		}
	}

	@Override
	public void onAnalog(String name, float keyPressed, float tpf) {
		if (keyPressed > 0){
			switch(name){
			case MoveForward.NAME:
				moveForward.actionPerformed(null);
			}
		}
	}
	
	
	
}
