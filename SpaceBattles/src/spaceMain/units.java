package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 *
 */
public class units {
	private String name;
	private int health;
	private int defense;
	private int speed;
	private weapons armorment;
	
	public units(){
		this.name="Small Defense Bot";
		this.health=5;
		this.defense=1;
		this.speed=3;
		armorment=new weapons();
	}
	public units(String name){
		this.name=name;
		this.health=5;
		this.defense=1;
		this.speed=3;
		armorment=new weapons();
	}
	public units(String name, int hp, int df, int spd, weapons toArm){
		this.name=name;
		this.health=hp;
		this.defense=df;
		this.speed=spd;
		this.armorment=toArm;
	}
	public String getName(){
		return this.name;
	}
	public boolean setName(String name){
		if(name==null)
			return false;
		this.name=name;
		return true;
	}
	public int getHp(){
		return this.health;
	}
	public int editHp(int hp){
		if (hp <0){
			return -1;
		}
		return this.health=hp;
	}
	public int getDef(){
		return this.defense;
	}
	public int editDef(int def){
		return this.defense=def;
	}
	public int getSpd(){
		return this.speed;
	}
	public int editSpd(int spd){
		if (spd<0)
			return 0;
		return this.speed=spd;
	}
	public weapons getArm(){
		return this.armorment;
	}
	public boolean editArm(weapons newArm){
		if (newArm==null)
			return false;
		else
			this.armorment=newArm;
		return true;
	}
	public boolean editUnit(units toCopy){
		this.name=toCopy.getName();
		this.armorment=toCopy.getArm();
		this.defense=toCopy.getDef();
		this.speed=toCopy.getSpd();
		this.health=toCopy.getHp();
		return true;
	}
	public boolean contains(String toCheck){
		if (toCheck.equalsIgnoreCase(this.name)){
			return true;
		}else
			return false;
	}
}
