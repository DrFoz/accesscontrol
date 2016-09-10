package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 *
 */
public class hpBar {
	private int healthMax;
	private int healthCurrent;
	private int halfWay;
	private boolean halfDead=false;
	private boolean alive=true;
	
	public hpBar(){
		this.healthMax=this.healthCurrent=1;
		this.halfWay=0;
	}
	public hpBar(int health){
		this.healthMax=this.healthCurrent=health;
		this.halfWay=this.healthMax/2;
	}
	public hpBar(int healthMax, int currentHealth){
		this.healthMax=healthMax;
		this.healthCurrent=currentHealth;
		this.halfWay=this.healthMax/2;		
	}
	public int effectHealth(int change){
		healthCurrent+=change;
		if (healthCurrent>healthMax){
			healthCurrent=healthMax;
		}
			checkStatus();
			return healthCurrent;
		}
	public boolean checkStatus(){
		//check for half way
		if (healthCurrent<=halfWay){
			this.halfDead=true;
		}
		else
			this.halfDead=false;
		//check for death
		if (healthCurrent<=0){
			alive=false;
		}else
			alive=true;
			return alive;
	}
	public int currentHP(){
		return this.healthCurrent;
	}
	public boolean isHalfDead(){
		return halfDead;
	}
	public boolean isAlive(){
		return this.alive;
	}	
}
