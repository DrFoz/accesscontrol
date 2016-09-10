package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 * 1=space, 2=ground, 3=wall, 4=special, 5=spawn point, 6=objective
 */
public class tiles {
	private int type;
	private boolean isAccessible;
	private boolean isOccupied;
		
	public tiles(){
		this.type=1;
		this.isAccessible=false;
		this.isOccupied=false;
	}
	
	public tiles(int typeToSet){
		this.type=typeToSet;
		this.isOccupied=false;
		
		switch (typeToSet){
			default:
				this.type=1; //space
				this.isAccessible=false;
				this.isOccupied=false;
				break;
			case 1:
				this.type=1; //space
				this.isAccessible=false;
				break;
			case 2:
				this.type=2; //ground
				this.isAccessible=true;
				break;
			case 3:
				this.type=3; //wall
				this.isAccessible=false;
				break;
			case 4:
				this.type=4; //crate
				this.isAccessible=false;
				break;
			case 5:
				this.type=5; //spawn point
				this.isAccessible=true;
				this.isOccupied=false;
				break;
			case 6:
				this.type=6; //objective
				this.isAccessible=true;
				this.isOccupied=false;
		}	
	}
	public int tileType(){
		return this.type;
	}
	public boolean isAccessible(){
		return this.isAccessible;
	}
	public boolean isOccupied(){
		return this.isOccupied;
	}
	public boolean occupy(){
		if (this.isOccupied || this.isAccessible==false){
			return false;
		}
		else{
			this.isOccupied=true;
			return true;
		}
	}
}
