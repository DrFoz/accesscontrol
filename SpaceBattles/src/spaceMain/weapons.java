package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 *
 */
public class weapons {
	private String name;
	private int range;
	private int damage;
	
	public weapons(){
		name="Robo punch";
		this.range=1;
		this.damage=1;
	}
	public weapons(String name, int range, int damage){
		this.name=name;
		this.range=range;
		this.damage=damage;
	}
	
	public weapons(int index){
		switch (index){
		case 1:
			this.name="Metalic Claws";
			this.range=1;
			this.damage=6;
			break;
		case 2:
			this.name="Laser Rifle";
			this.range=24;
			this.damage=5;
			break;
		case 3:
			this.name="Sword staff";
			this.range=2;
			this.damage=4;
			break;
		case 4:
			this.name="Magnetic Rail Pistol";
			this.range=36;
			this.damage=2;
			break;
		case 5:
			this.name="Magnetic Rail Rifle";
			this.range=72;
			this.damage=2;
			break;
		case 6:
			this.name="Energy Blasting Palm Cannons";
			this.range=5;
			this.damage=3;
			break;
		default:
			this.name="Laser Pistol";
			this.damage=1;
			this.range=12;
			break;
		}
	}
	
	public int checkRange(){
		return this.range;
	}
	public int checkDamage(){
		return this.damage;
	}
	public boolean changeDamage(int new_damage){
		this.damage=new_damage;
		if (this.damage>0){
			return true;
		}else
			return false;
	}
	public boolean changeRange(int new_range){
		this.range=new_range;
		if (this.range>0){
			return true;
		}else
			return false;
	}
	public String changeName(String new_name){
		this.name=new_name;
		return this.name;
	}
	public String nameIs(){
		return this.name;
	}
}
