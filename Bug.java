package coding.tree;

import java.util.ArrayList;
import java.util.List;

public class Bug {

	List<Node> node;
	String name;
	
	Bug(){}
	
	Bug(String name){
		this.name = name; 
		this.node = new ArrayList<>(); 
	}
	void addNode(Node node){
		this.node.add(node);
	}
	
	public List<Node> getNode() {
		return node;
	}
	public void setNode(List<Node> node) {
		this.node = node;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
