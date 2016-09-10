package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 * Purpose of this class is to take and add two ships together from blue prints passed in. The ships are then attached 
 * by the ship with the highest speed with the attachment type it possesses. Then the spawn points are made. Then the map
 * is populated by crates randomly to add some scenery.
 */

public class spaceMap {
	private int XVAL=128;
	private int YVAL=64; 
	private int spawnSize=10;
	private tiles[][] map=new tiles[XVAL][YVAL];

	int crates=50;
	public spaceMap(shipLayout Player1,shipLayout Player2){
		int P2x;
		//adds the two ship layouts to the play mat
		for(int y=0;y<YVAL;++y){
			for (int x=0;x<XVAL;++x){
				if (x<XVAL/2){
					map[x][y]=Player1.getTile(x, y);
				//end if
				}else{
					P2x=x%(XVAL/2);
					map[x][y]=Player2.getTile(P2x, y);
				}
			}//end for
		}//end for
		if (Player1.getSpeed()>Player2.getSpeed()){
			//use the ship 1 connector.
			//get the type add connector by type
			buildConnections(Player1.getConnectionType());
		}else{
			buildConnections(2);
			//use the ship 2 connector.
		}
		crates=(int)(Math.random()*340);
		if (addSpawnpoints()==false){
			System.out.println("Error adding spawns");
		}
		addRandomCrates(crates);
		
	}//end spaceMap
	
	private boolean addSpawnpoints(){
		//creates spawn points based on splitting the play mat into 8ths for the xval and in half for the y
		
		
		int []p1=new int[2];
		p1[0]=this.XVAL/8;
		p1[1]=this.YVAL/2;
		int []p2=new int[2];
		p2[0]=this.XVAL-p1[0];
		p2[1]=p1[1];
		int length=this.spawnSize;
		int width=3;
		
		for (int y=p1[1]-length;y<p1[1]+length;++y){
			for (int x=p1[0]-width;x<p1[0]+width;++x){
				this.map[x][y]=new tiles(5); //spawn point
			}
		}
		for (int y=p2[1]-length;y<p2[1]+length;++y){
			for (int x=p2[0]-width;x<p2[0]+width;++x){
				this.map[x][y]=new tiles(5); //spawn point
			}
		}
		return true;
	}
	
	public void showMap(){
		char display;
		for (int y=0;y<this.YVAL;++y){
			for (int x=0;x<this.XVAL;++x){
				if (this.map[x][y]!=null){
					if(this.map[x][y].isOccupied()){
						display='O';
					}else{	
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
							case 4:
								display='C';
								break;
							case 5:
								display='s';
								break;
							case 6:
								display='X';
								break;
							default:
								display='?';
								break;	
						}
					}
					System.out.print(display);
				}
			}System.out.println();
		}
	}


	public void buildConnections(int type){
		switch(type){
			case 1:
				for(int x=XVAL/2-3;x<XVAL/2+3;++x){
					for (int y=(YVAL/2-8); y<(YVAL/2+9);++y){
						if (y==YVAL/2-8 || y==YVAL/2+8){
							map[x][y]=new tiles(3);//wall
						}else{
							map[x][y]=new tiles(2);//floor
						}
					}
				}
				break;
			case 2:
			default:
				for(int y=12;y<25;++y){
					if (y==12 || y==24){
						for (int x=XVAL/2-3; x<XVAL/2+3; ++x){
							map[x][y]=new tiles(3); //walls
						}//end for
					}else if (y>12 && y<24){
						for (int x=XVAL/2-3;x<XVAL/2+3;++x){
							map[x][y]=new tiles(2); //floor
						}//end for
					}//end if
				}//end for
				for(int y=YVAL-23;y<YVAL-11;++y){
					if (y==YVAL-23 || y==YVAL-12){
						for (int x=XVAL/2-3; x<XVAL/2+3;++x){
							map[x][y]=new tiles(3); //walls
						}//end for
					}else if (y>YVAL-23 && y<YVAL-12){
						for (int x=XVAL/2-3; x<XVAL/2+3;++x){
							map[x][y]=new tiles(2); //floor
						}//end for
					}//end if
				}//end for
				break;
				//end default
		}//end switch
	}//end build Connections
	
	public void addRandomCrates(int number){
		boolean crated=false;
		int randomX;
		int randomY;
		if (number<1)
			return;
		for (int x=number; x>0;--x){
			do {
				randomX=(int) (Math.random()*XVAL);
				randomY=(int) (Math.random()*YVAL);
				if (map[randomX][randomY].tileType()==2 || map[randomX][randomY].tileType()==5){
					map[randomX][randomY]=new tiles(4);
					crated=true;
				}else{
					crated=false;
				}
			}while(!crated);
		}
	
	}
	public boolean displayP1SpawnPoints(){
		int count=0;
		for (int y=0;y<this.YVAL;++y){
			for (int x=0; x<this.XVAL/2;++x){
				if (map[x][y].tileType()==5){
					++count;
					System.out.print(count + ". |"+ x + "," + y +"| ");
					if (count % 10==0){
						System.out.println();
					}
				}
			}
		}
		if (count==0){
			return false;
		}else{
			System.out.println();
			return true;
		}
	}
	public boolean displayP2SpawnPoints(){
		int count=0;
		for (int y=0;y<this.YVAL;++y){
			for (int x=XVAL/2; x<this.XVAL;++x){
				if (map[x][y].tileType()==5){
					++count;
					System.out.print(count + ". |"+ x + "," + y +"| ");
					if (count % 10==0){
						System.out.println();
					}
				}
			}
		}
		if (count==0){
			return false;
		}else{
			System.out.println();
			return true;
		}
	}
}