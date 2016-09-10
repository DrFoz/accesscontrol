package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 *
 */
public class crew {
	String teamName;
	units crewMember;
	boolean isDead;
	int currentHp;
	int location[]=new int[2]; //0=x 1=y
	
	public crew(){
		this.teamName="Default";
		this.crewMember=new units();
		this.isDead=false;
	}
	
	public crew(String teamName, units toAdd){
		this.teamName=teamName;
		this.crewMember=toAdd;
		this.isDead=false;
		this.currentHp=crewMember.getHp();
	}
	
	public boolean damageCrew(int damage){
		this.currentHp-=damage;
		if (currentHp<1)
			this.isDead=true;
		return this.isDead;
	}
	public boolean isItDead(){
		return !this.isDead;
	}
	public weapons getArm(){
		return crewMember.getArm();
	}
	public void setLocation(int x, int y){
		this.location[0]=x;
		this.location[1]=y;
	}
	public int[] getLocation(){
		int []copy=this.location;
		return copy;
	}
}
