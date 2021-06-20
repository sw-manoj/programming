package easyprob;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {

	static Map<Integer,String> charDict = new HashMap<>();
	
	static void populateDict() {
		for (int i = 1; i < 27; i++)
		{
			charDict.put(i, Character.toString((char)(i + 64)));
		}
	}
	public static void main(String[] args) {
		populateDict();
		System.out.println(charDict);
		ExcelColumnNumber colNum = new ExcelColumnNumber();
//		System.out.println(colNum.convertToTitle(2147483647));
		System.out.println(colNum.convertToTitle(26));

	}
	 public String convertToTitle(int columnNumber) {
		 String res= "";
		 int num = columnNumber;
		 
		 while(num > 27)
		 {
			 int div = num/27;
			 int index = num - (div * 27);
			 System.out.println(index);
			 index = index == 0 ? 2 : index;
			 res = charDict.get(index) + res;
			 num = num/26;
		 }
		 return charDict.get(num-1) + res;
	   }
}
