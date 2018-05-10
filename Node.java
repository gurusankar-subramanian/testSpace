package coding.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

	Integer level;
	String name;
	List<Node> children;
	
	
	public Node(){}
	
	public Node(String name){
		this.name = name;
		this.children = new ArrayList<>();
	}
	
	public Node(Integer level, String name){
		this.level = level;
		this.name = name;
		this.children = new ArrayList<>();
	}
	

	public void addChild(Node node){
		this.children.add(node);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
}
