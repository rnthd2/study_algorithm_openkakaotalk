package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
	public static void main(String[] args) {
		CamelcaseMatching camelcaseMatching = new CamelcaseMatching();
		System.out.println(camelcaseMatching.camelMatch(new String[] { "ControlPanel" }, "CooP"));
		System.out.println(camelcaseMatching.camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, "FoBa"));
		System.out.println(camelcaseMatching.camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, "FB"));
	}

	public List<Boolean> camelMatch(String[] queries, String pattern) {
		ArrayList list = new ArrayList();
		for (String query : queries) {
			char[] p = pattern.toCharArray();
//			char[] s = query.toCharArray();
//			List<Character> patterns = new ArrayList(Arrays.asList(pattern.toCharArray()));
//			List<Character> chars = new ArrayList(Arrays.asList(s.toCharArray()));

//			pattern.split(Character.isUpperCase())
//			if(query.startsWith(pattern)



		}
/*

		String new_pattern = pattern.substring(0, 1);

		for (int i = 1; i < pattern.length(); i++) {
			if (Character.isUpperCase(pattern.charAt(i))) {
				new_pattern += "[a-z]*";
			}
			new_pattern += pattern.charAt(i);
		}

		new_pattern += "[a-z]*";

		for (String s : queries) {
			list.add(s.matches(new_pattern));
		}
*/

		return list;
	}


}
