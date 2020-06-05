import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

//문자열을 입력받고, 그 다음 문자 하나를 입력받아 문자열 값 안에 입력문자가 몇 개 존재하는지 그 개수를 출력함
//단, 영문자만 입력받도록함.
public class FindCharTotalNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String question = null;
		String input = null;
		do {
			String str = null;
			if (question == null) {
				System.out.print("문자열 입력 : ");
				str = sc.next();
				if(!Pattern.matches("^[a-z]*$", str)) {
					System.out.println("영문자가 아닙니다.");
					break;
				}
				question = str;
			}
			if (input == null) {
				System.out.print("문자 입력 : ");
				str = sc.next();
				if(!Pattern.matches("^[a-z]*$", str)) {
					System.out.println("영문자가 아닙니다.");
					break;
				}
				input = str;
			}
			Map<String, Integer> map = new HashMap<>();
			for (String a : question.split("")) {
				map.put(a, map.getOrDefault(input, 0) + 1);
			}
			System.out.println("포함된 개수 : " + map.get(input));
			System.out.println("==============");
			question = null;
			input = null;
		} while(sc.hasNextLine());

	}

}
