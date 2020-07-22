package kakao;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//		int [] a  = solution.solution(gems);
//		System.out.println(Arrays.toString(a));
	}

//	public int[] solution(String[] gems) {
//		int[] answer = new int[2];
//
//		HashSet<String> h = new HashSet<>();
//		for (int i = 0; i < gems.length; i++) {
//			h.add(gems[i]);
//		}
//		int N = gems.length;
//		answer[1] = N;
//		int num = h.size();
//		int start = 0;
//		int end = 0;
//		while (start < N && end < N) {
//
//			if (check(gems, start, end) == num) {
//
//				if (answer[1] - answer[0] > end - start) {
//					answer[0] = start + 1;
//					answer[1] = end + 1;
//				}
//
//				start++;
//				end = start;
//
//			} else {
//				end++;
//			}
//
//		}
//
//		return answer;
//	}
//
//	public static int check(String[] gems, int start, int end) {
//		HashSet<String> ch = new HashSet<>();
//		for (int i = start; i <= end; i++) {
//			ch.add(gems[i]);
//		}
//
//		return ch.size();
//	}
}