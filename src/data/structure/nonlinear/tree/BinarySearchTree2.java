package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTree2 {

	//Array X :
	static ArrayList<Integer> xList = new ArrayList(Arrays.asList(-1, 2, 3, 4, 5, 6));
	//index   :
	static ArrayList<Integer> indexList = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5));

	public static void main(String[] args) {
		int start = 0;
		int end = xList.size();
		int result = find(start, end);
		if(result > -1){
			System.out.println("Answer is " + result + "as X[" + result + "] = " + result +".");
		} else {
			System.out.println("No exist!");
		}
	}
	static Integer find(int start, int end){
		int result = -1;
		do{
			if (start == end){
				result = xList.get(end);
			} else {
				int middle=xList.get((start+end)/2);
				int index =xList.indexOf(middle);

				if(middle < index){
					start = index+1;    //right
				} else if(middle > index){
					end = index-1;      //left
				} else {
					result = middle;
				}
			}
		}while(result<0 && !(start<1 && end<1));

		return result;

	}
}
