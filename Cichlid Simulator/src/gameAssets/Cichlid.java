package gameAssets;
import java.awt.Color;

public class Cichlid extends item
{
	private float speed;
	private String sex;
	//have to determine which we want to be our own types or existing
	//another useless comment
	public Cichlid()
	{
		
	}
	
	public Cichlid(float size, float speed, String sex){
		super.setSize(size);
		this.speed = speed;
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}
	public float getSpeed(){
		return this.speed;
	}
	public void setSpeed(float speed){
		this.speed = speed;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
}