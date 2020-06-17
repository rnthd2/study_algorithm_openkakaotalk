package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.List;

public class DefaultTree2 {
	static List<Node> tree = new ArrayList<>();

	public static void main(String[] args) {
		String str = "-1 0 0 1 1";
		String[] list = str.split(" ");

		//make tree
		for (int i = 0; i < list.length; i++) {
			int x = Integer.valueOf(list[i]);

			//root node
			if (x < 0){
				tree.add(new Node(null, 0));
			} else {
				for (Node node : tree) {
					if((int)node.getElement() == x){
						Node child = new Node(node, i);
						node.getChildren().add(child);
						tree.add(child);
						break;
					}
				}
			}
		}

		int remove_num = 2;

		//remove node at tree
		tree.removeIf(node -> (int) node.getElement() == remove_num
				|| node.getParent()!= null && (int)node.getParent().getElement() == remove_num);

		//find leaf node at tree
		System.out.println(tree.stream().filter(node -> node.getChildren().size() < 1).count());
	}
}
