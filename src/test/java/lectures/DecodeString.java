/*
 * There is another nested pattern k[string k[string]]
There is a closing bracket k[string]
 * */

package lectures;

import java.util.ArrayList;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
	
//		String s = "3[a10[c]]";
//		String result = decodeString(s);
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("Input String : " + s +" Final result : "+result);
		
		prog();
	}
	
	public static void prog() {
		Boolean i = false;
		Boolean j = false;
		if(i = j != i) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	public static String decodeString(String s) {
		Stack<Character> stack = new Stack<Character>(); 
		int length = s.length();
		
		for(int i  = 0 ; i <= length -1 ; i ++){
			char current = s.charAt(i);
			//System.out.println("current "+current);
			if(current == ']') {
				ArrayList<Character> decodedString = new ArrayList<>();
				while (stack.peek() != '[') {
					decodedString.add(stack.pop());

                }
				
				//decodedString.forEach(System.out::println);
				//System.out.println("pop elemnt "+stack.peek());
				if(stack.peek() == '[') {
					stack.pop(); // to remove "["
				}
				
				//K might be 1000
				int base = 1;
                int kNum = 0;
                //System.out.println(" Is digit check "+Character.isDigit(stack.peek())+ " : "+stack.peek());
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                	kNum = kNum + (stack.pop() - '0') * base;
                    base *= 10;
                }
				//System.out.println("kNum : "+kNum);
				while(kNum != 0) {
					for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
					kNum--;
				}
				
			}else {
				stack.push(current);
			}
		}
		char[] arrResultString = new char[stack.size()];
		for(int i = arrResultString.length - 1 ; i >= 0 ; i--) {
			arrResultString[i] = stack.pop();
		}
		return new String(arrResultString);
    }
}
