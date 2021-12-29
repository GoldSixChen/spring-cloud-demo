package com.example.interviewTest;

public class AgTestClass {
	public static void main(String[] args) {
		String s="abaxdcverfsasspeoxssas";
		System.out.println(getMaxStr(s));
	}

	public static int getMaxStr(String s) {

		char[] str = s.toCharArray();
		int length = s.length();
		int max = 0;

		for (int i = 0; i < length; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean[] set = new boolean[26];
			
			for (int j = i; j < length; j++) {
				System.out.println(str[j] + "" +set[str[j]-'a']);
				if (set[str[j] - 'a']) {
					
					break;
				}
				
				set[str[j] - 'a'] = true;
				
				max = Math.max(max, j - i + 1);
			}
		}

		return max;
	}
}
