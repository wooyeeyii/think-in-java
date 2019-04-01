package com.chapter18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args) {
		String regex = "A[a-z]c";
		String regex1 = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}";
		String regex2 = "(\\(\\d{3}\\)|\\d{3})\\s?\\d{3}(-|)?\\d{4}";
		/*Pattern pattern = Pattern.compile(regex2);
		Pattern pattern1 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);  //对大小写不敏感

		String[] checkStr = {"abc", "(555) 5555555", "(123)456-7890"};
		for(int i=0; i<checkStr.length; i++) {
			Matcher m = pattern.matcher(checkStr[i]);
			if( m.matches()) {
				System.out.println(checkStr[i]);
			}
		}*/
		String aaa = "(.*/)*6727(/.*)*";
//		String aaa = "^ALL$";
//		String aaa = "^ALL EXCEPT (.*/)*(?!6727)(/.*)*";
		Pattern pattern = Pattern.compile(aaa);
		String[] checkStr = {"ALL EXCEPT 672799/123", "ALL EXCEPT 6727/6455", "ALL EXCEPT 67", "ALL", "6727", "672789"};
		for(int i=0; i<checkStr.length; i++) {
			Matcher m = pattern.matcher(checkStr[i]);
			if( m.matches()) {
				System.out.println(checkStr[i]);
			}
		}
	}
}
