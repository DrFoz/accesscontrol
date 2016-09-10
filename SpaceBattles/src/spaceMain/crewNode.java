package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 *
 */
public class crewNode {
	private crew crewMember;
	private crewNode next;
	
	crewNode(crew toAdd){
		this.crewMember=toAdd;
	}
	public crew getCrew(){
		return this.crewMember;
	}
	public crewNode isNext(){
		return this.next;
	}
	crewNode(crewNode toAdd){
		this.crewMember=toAdd.getCrew();
		this.next=toAdd.isNext();
	}
}
