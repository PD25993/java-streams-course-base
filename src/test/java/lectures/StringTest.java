package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class StringTest {
	@Test
	public void findSecondLastWordFromSentence() {
		String InputFromUser = "Hi Good Morning To All People";
		int lengthOfInput = InputFromUser.length();
		char[] inpurStringAsArray = InputFromUser.toCharArray();
		int counter = 1;
		StringBuilder finalWord = new StringBuilder();
		for (int index = lengthOfInput - 1; index >= 0; index--) {

			if ((inpurStringAsArray[index] == ' ') && (counter == 1)) {
				finalWord.append(inpurStringAsArray[index]);
				counter--;
			} else if ((inpurStringAsArray[index] == ' ') && (counter != 1)) {
				finalWord.reverse();
				break;
			} else if (counter != 1) {
				finalWord.append(inpurStringAsArray[index]);
			}
		}
		System.out.println("Final Result : " + finalWord);
		// assertThat(finalWord).contains("All");
	}

	@Test
	public void anagramOfaString() {
		String input1FromUser = "LISTEN";
		String input2FromUser = "SILENT";
		if (input1FromUser.length() != input2FromUser.length()) {
			System.out.println("Invalid Data");
		} else {
			Map<Character, Integer> mapForInput1FromUser = new HashMap<>();
			Map<Character, Integer> mapForInput2FromUser = new HashMap<>();

			for (int i = 0; i < input1FromUser.length(); i++) {

				Integer occuranceForString1 = mapForInput1FromUser.get(input1FromUser.charAt(i));
				if (null == occuranceForString1) {
					mapForInput1FromUser.put(input1FromUser.charAt(i), 1);
				} else {
					mapForInput1FromUser.put(input1FromUser.charAt(i), occuranceForString1 + 1);
				}

				Integer occuranceForString2 = mapForInput2FromUser.get(input2FromUser.charAt(i));
				if (null == occuranceForString2) {
					mapForInput2FromUser.put(input2FromUser.charAt(i), 1);
				} else {
					mapForInput2FromUser.put(input2FromUser.charAt(i), occuranceForString2 + 1);
				}
			}
			if (mapForInput1FromUser.equals(mapForInput2FromUser))
				System.out.println(input1FromUser + " and " + input2FromUser + " - Two Strings are anagram");
			else
				System.out.println(input1FromUser + " and " + input2FromUser + " - Two Strings are not anagram");

		}
	}
	
	@Test
	public void addReverseAndCheckPalindrom() {
		
		Integer userInputNumber=7325;

			while(!checkForPalidrom(userInputNumber)) {
				Integer reverOfInputNumber = reverseofNum(userInputNumber);
				Integer sum = userInputNumber+reverOfInputNumber;
				System.out.println("Number "+userInputNumber+" and reverse "+reverOfInputNumber+" : sum "+sum);
				userInputNumber=sum;
			}

	}
	
	private static Boolean checkForPalidrom(int num) {

		Integer reverseToCheckPalindrom = reverseofNum(num);
		if(num == reverseToCheckPalindrom)
			return true;
		else
			return false;
	}

	private static Integer reverseofNum(Integer number) {
		Integer reverse = 0;
		while (number != 0) {
			reverse = (reverse*10)+(number%10);
			number = number/10;
		}
		return reverse;		
	}
	
	@Test
	public void assignCoupons() {
		String arrayOfCustomerName[] = new String[] {"Mohit","Poulami","Partha","Anirban","Chandrika"};
		String arrayOfCoupons[] = new String[] {"SS10","SS20","SS30"};
		int lengthOfArray;
		
		for (int i = 0 ; i < arrayOfCustomerName.length ; i++) {
			lengthOfArray = arrayOfCustomerName.length;		
			if(i != 0) {
				lengthOfArray = lengthOfArray - i;
			}
			int randomIndex = new Random().nextInt(lengthOfArray);
			//System.out.println("Old Array : "+ Arrays.toString(arrayOfCustomerName));
			System.out.println("Random Customer : "+ arrayOfCustomerName[randomIndex]);
			//arrayOfCustomerName = swapData(arrayOfCustomerName, randomIndex);
			if(lengthOfArray != randomIndex) {
				String val = arrayOfCustomerName[randomIndex];
				arrayOfCustomerName[lengthOfArray-1] = val;
				
			}
			System.out.println("New Array : "+Arrays.toString(arrayOfCustomerName));
		}
		
	}
	
	public static String[] swapData(String arrayOfCustomerName[],int randomIndex) {
		
		int lengthOfArray = arrayOfCustomerName.length;
		if(lengthOfArray != randomIndex) {
			String val = arrayOfCustomerName[randomIndex];
			//arrayOfCustomerName[randomIndex] = arrayOfCustomerName[lengthOfArray-1];
			arrayOfCustomerName[lengthOfArray-1] = val;
		}
		return arrayOfCustomerName;
		
	}
}
