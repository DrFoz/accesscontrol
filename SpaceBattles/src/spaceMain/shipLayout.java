package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 *
 */

public class shipLayout {
	private String name;
	private int type;
	private tiles [][]map;
	private int connectionType;
	private int speed;
	private int []cords=new int[2];
	
	public shipLayout(int type){
		this.type=type;
		switch (type){
			case 1:
				this.name="A ship";
				this.type=type;
				this.cords[0]=this.cords[1]=64;
				this.map=new tiles[this.cords[0]][this.cords[1]];
				this.connectionType=1;
				this.speed=100;
				break;
			case 2:
				this.name="A ship";
				this.type=type;
				this.cords[0]=this.cords[1]=64;
				this.map=new tiles[this.cords[0]][this.cords[1]];
				this.connectionType=1;
				this.speed=120;
				break;
			default:
				break;
		}

		constructShip(type);
	}
	
	public shipLayout(String name, int type, int xSize, int ySize, int connectionType,int speed){
		this.name=name;
		this.type=type;
		cords[0]=xSize; cords[1]=ySize;
		this.map=new tiles[xSize][ySize];
		//construct it here with type input
		this.connectionType=connectionType;
		this.speed=speed;
	}
	
	public void constructShip(int type){
		if (type<0 || type>3)
			return;
		switch (type){
			default:
				//all of row 1,2 is space
				//this will create a square ship with 2 spaces of space around it.
				for (int y=0;y<2;++y){
					for (int x=0;x<this.cords[0];++x){
						this.map[x][y]=new tiles(1);					}
				}
			
				for (int y=2;y<this.cords[1];++y){
					if (y==2){
						//outer wall
						for(int x=0;x<this.cords[0];++x){
							if (x<2|| x>this.cords[0]-3){
								this.map[x][2]=new tiles(1); //space
							}else
								this.map[x][2]=new tiles(3); //wall
						}
					}else if(y>2 && y <this.cords[0]-3){
						//inner area
						for (int x=0;x<this.cords[0];++x){
							if (x<2 || x>this.cords[0]-3){
								this.map[x][y]=new tiles(1); //space
							}else if (x==2 || x==this.cords[0]-3){
								this.map[x][y]=new tiles(3); //wall
							}else
								this.map[x][y]=new tiles(2); //ground
						}
					}else{
						for (int x=0;x<this.cords[0];++x){
							this.map[x][y]=new tiles(1); //space
						}
					}
				}
				for (int y=this.cords[1]-2;y<this.cords[1];++y){
					for (int x=0;x<this.cords[0];++x){
						this.map[x][y]=new tiles(1);					}
				}
				//last wall
				for (int x=0;x<this.cords[0];++x){
					if (x<2 || x>this.cords[0]-3){
						this.map[x][(this.cords[1]-4)]=new tiles(1);
					}else
						this.map[x][(this.cords[1]-4)]=new tiles(3);
				}
				
				//outer space wall last two rows
				for (int y=this.cords[1]-3;y<this.cords[1];++y){
					for (int x=0;x<this.cords[0];++x){
						this.map[x][y]=new tiles(1);					}
				}
		}
		
		return;
	}
	
	public void showShip(){
		char display;
		for (int y=0;y<this.cords[1]-1;++y){
			for (int x=0;x<this.cords[0];++x){
				if (this.map[x][y]!=null){
					switch(this.map[x][y].tileType()){
						case 1:
							display='*';
							break;
						case 2:
							display='-';
							break;
						case 3:
							display='W';
							break;
						default:
							display='C';
							break;	
						}
					System.out.print(display);
				}
			}System.out.println();
		}
	}
	
	public tiles getTile (int x,int y){
		tiles tilesToReturn=this.map[x][y];
		if (tilesToReturn==null){//prevents passing a null instead it passes a space tile
			tilesToReturn=new tiles(1);//space
		}// end if
		return tilesToReturn;
	}//end getTile
	
	public int getSpeed(){
		return this.speed;
	}
	public int getConnectionType(){
		return this.connectionType;
	}
	
}