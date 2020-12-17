package com.kishorekumarkorada.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class PlayGround {

	public static void main(String[] args) {
		//swapCharacters();
		Stack<Character> stack = new Stack<Character>();
		String string = "{([])}";
		char[] charArray = string.toCharArray();
		for(char ch : charArray) {
			stack.push(ch);
		}
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}
	
	static boolean isBalencedString(String characterString) {
		Map<Character, Character> braces = new HashMap<Character, Character>();
		braces.put('{', '}');
		braces.put('(', ')');
		braces.put('[', ']');
		Stack<Character> stack = new Stack<Character>();
		if(characterString.length() % 2 != 0) {
			return false;
		}
		for(char ch : characterString.toCharArray()) {
			
		}
		return false;
	}
	
	boolean charExistCheck(String[] str, char c) {
		int count = 0;
		for (String s : str) {
			char[] charArray = s.toCharArray();
			for (char ch : charArray) {
				if (ch == c) {
					count++;
				}
			}
			if (count == 6) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkIfACharacterExists6times(String[] s, char c) {
		boolean isRepeated6Times = false;
		for(int i = 0; i < s.length; i++) {
			int count = 0;			 
			for (int j = 0; i < s[i].length(); j++) {
			    if (s[i].charAt(j) == c) {
			        count++;
			    }
			}
			if(count == 6) {
				isRepeated6Times = true;
			}
		}
		
		return isRepeated6Times;
	}
	
	public static double prodValue(double[] values) {
		int result = 0;
		for(int i = 0; i < values.length; i++) {
			//result = result * ar[i]; 
		}
		
		return 0;
	}
	
    
	
	public static void swapCharacters() {
		String someString = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(someString.substring(2,someString.length()-1));
		System.out.println(someString.charAt(someString.length()-1));
	}
	
	public void countCharacters() {
		String strng = "appppppPle";
		char[] charArray = strng.toCharArray();
		Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
		Set<Character> hashSet = new HashSet<Character>();
		for(int i = 0; i < charArray.length; i++) {
			char ch = Character.toLowerCase((char) charArray[i]);
			if(!hashSet.add(ch)) {
				int count = (int)charCounts.get(ch);
				charCounts.put(ch, ++count);
			} else {
				charCounts.put(ch, 1);
			}
		}
		System.out.println(charCounts);
	}
	
	static Double prodValue(Double[] dArray) {
		Double product = 0.0;
		if (dArray.length >= 2) {
			double secondElement = dArray[1];
			for (int i = 0; i < dArray.length; i++) {
				Double result = dArray[i] % secondElement;
				if (result.compareTo(0.0) == 0.0) {
					product = product + dArray[i];
				}
			}
		}
		return product;
	}
	
}
