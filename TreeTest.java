package coding.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class TreeTest {

	List<Bug> bugs = new ArrayList<>();
	
	
	public static void main(String[] args) {
		TreeTest treeTest = new TreeTest();
		Node root = createNode(treeTest);
		
		String find = "six";
//		findParent(root, find);
		
//		findParent(root);
		traverseBugs(treeTest, find);
	}
	
	static Node createNode(TreeTest treeTest ){
		Node root = new Node("one");
		Node two = new Node("two"); 
		Node three = new Node("three"); 
		Node four = new Node("four"); 
		Node five = new Node("five"); 
		Node six = new Node("six");
		
		root.addChild(two);
		two.addChild(three);
		two.addChild(four);
		three.addChild(five);
		four.addChild(six);
		
		Bug bug1 = new Bug("bug1");
		bug1.addNode(three);
		Bug bug2 = new Bug("bug2");
		bug2.addNode(root);
		Bug bug3 = new Bug("bug3");
		bug3.addNode(five);
		Bug bug4 = new Bug("bug4");
		bug4.addNode(three);bug4.addNode(six);
		
		treeTest.bugs.add(bug1);
		treeTest.bugs.add(bug2);
		treeTest.bugs.add(bug3);
		treeTest.bugs.add(bug4);
		
		return root;
	}
	
	static void traverseBugs(TreeTest treeTest, String name){
		Map<String, List<Node>> test = new HashMap<>();
		treeTest.bugs.stream().forEach(x->{
//			System.out.println("Bug name :" + x.getName());
			x.getNode().forEach(y->{
				List<Node> nodes = new ArrayList<>();
				nodes = findParent(nodes, y, name);
				if(nodes != null && !nodes.isEmpty())
					test.put(x.getName(), nodes);
			});
		});
		System.out.println(new Gson().toJson(test));
		
	}
	
	static void printChildren(List<Node> children){
		if(children != null && !children.isEmpty()){
			children.stream().forEach(x->{
				System.out.println("children : " + x.getName());
				printChildren(x.getChildren());
			});
		}
	}
	
	static List<Node> findParent(List<Node> nodes, Node node, String name){
		if(name.equals(node.getName())){
			nodes.add(node);
//			System.out.println("Parent : " + node.getName());
//			printChildren(node.getChildren());
		}else{
			if(node.getChildren() != null && !node.getChildren().isEmpty()){
				node.getChildren().stream().forEach(x-> findParent(nodes, x, name));
			} 
		}
		return nodes;
	}
 
	static List<Node> findParent(List<Node> nodes, Node node){
		System.out.println("nodes affected " + node.getName());
		nodes.add(node);
		node.getChildren().stream().forEach(x-> findParent(nodes, x));
		return nodes;
	}
	
}
