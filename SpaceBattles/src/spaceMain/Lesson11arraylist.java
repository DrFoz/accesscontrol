package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class Lesson11arraylist {
	public void testArraty(){
		ArrayList <String> names =new ArrayList<String>();
		names.add("Jim");
		names.add("Ted");
		names.add(1, "Kai");
	
		for (int i =0; i< names.size();++i){
			System.out.println(names.get(i));
		}
	}
}
