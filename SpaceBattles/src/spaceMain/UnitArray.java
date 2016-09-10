package spaceMain;

/**
 * @author Lee Strenge
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class UnitArray {
	private ArrayList <units> team;
	
	UnitArray(){
		team=new ArrayList<units>();
	}
	
	public units getUnit(String toFind){
		for (int x=0;x<team.size();++x){
			units toCheck;
			toCheck=team.get(x);
			if (toCheck.contains(toFind)){
				return toCheck;
			}
		}
		return null;
	}
	public boolean add(units toAdd){
		return team.add(toAdd);
	}
	public boolean remove(units toRemove){
		return team.remove(toRemove);
	}
	public boolean addAll(ArrayList <units> toAdd){
		return team.addAll(toAdd);
	}
	public void clear(){
		team.clear();
	}
	public int size(){
		return team.size();
	}
	public boolean updateUnit(units toUpdate){
		return false;
	}
}
