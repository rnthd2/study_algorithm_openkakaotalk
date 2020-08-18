package leetcode;

public class StringToInteger {
	public static void main(String[] args) {
		StringToInteger stringToInteger = new StringToInteger();
//		System.out.println(stringToInteger.myAtoi("4193 with words"));
//		System.out.println(stringToInteger.myAtoi("words and 987"));
//		System.out.println(stringToInteger.myAtoi("-91283472332"));
//		System.out.println(stringToInteger.myAtoi("   -42"));
//		System.out.println(stringToInteger.myAtoi("3.123"));
//		System.out.println(stringToInteger.myAtoi(""));
//		System.out.println(stringToInteger.myAtoi("-"));
//		System.out.println(stringToInteger.myAtoi("+-1"));
		System.out.println(stringToInteger.myAtoi("  -0012a42"));
	}


	public int myAtoi(String str) {
		int result = 0;
		char[] list = new char[str.length()];
		boolean negative = false;
		for (char c : str.toCharArray()) {
			switch (c){
				//공백 제거
				case ' ' : break;
				//양수, 음수 기호 확인
				case '-' : negative = true;
				//숫자인지 확인
				case  :
			}
		}
	}
	public int test(String str) {

		//공백 제거
		str = str.trim().replace(" ", "");

		if(str.length() < 1) return 0;

		//char 숫자인지 확인
		if(str.length()>1 && !Character.isDigit(str.charAt(1)) && str.charAt(1) != '.') return 0;

		int result;
		try{
			//정규식, 문자열에서 숫자만 추출, 음수 소수점 허용
			// ^ 은 정규표현식을 제외한
			// -? 에서 ?은 허용에 표시
			// 0-9는 숫자
			// .* 에서 *는 뭐든 허용
			str = str.replaceAll("[^-?0-9.0-9]","");

			//소수점 살려 int 로 변환해야 소수점을 숫자로 인식하고 exception을 발생하지 않는다
			result =(int) Double.parseDouble(str);
		} catch (NumberFormatException ne) {
			return 0;
		}
		return result;
	}
}
