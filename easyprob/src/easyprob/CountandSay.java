package easyprob;

public class CountandSay {

	public static void main(String[] args) {
		CountandSay cs = new CountandSay();
		System.out.println(cs.countAndSay(4));
		System.out.println(cs.countAndSay(5));
		System.out.println(cs.countAndSay(8));

		System.out.println(cs.countAndSay(10));//13211311123113112211
	}
	public String countAndSay1(int n) {
        if(n == 1)
        {
        	return "1";
        }
        String strRes = countAndSay(n - 1);
        char lastChar =  strRes.charAt(0);
        int num = 1;
        String res = "";
        boolean first = true; 
        for(char c : strRes.toCharArray())
        {
        	if(first)
        	{
        		first = false;
        		continue;
        	}
        	if(lastChar != c)
        	{
        		
        		res = res + num + "" + Character.getNumericValue(lastChar);
        		num = 1;
        		lastChar = c;
        	}
        	else
        	{
        		num++;
        	}
        }
        
        return res + "" + num + "" + Character.getNumericValue(lastChar);
    }
	
	public String countAndSay(int n) {
        String out = "1" ;
       if(n == 1)
          return out;
      else{
       for(int k = 2;k <= n;k++){
           out = say(out);
       }
          return out ;
      }
   }
   public String say(String s){
       StringBuilder sb = new StringBuilder();
       int count = 1 ;
       for(int i = 0; i < s.length()-1;i++){
           if(s.charAt(i) == s.charAt(i+1))
               count++ ;
           else {
               sb.append(count);
           sb.append(s.charAt(i));
               count = 1;
           }
       }
       sb.append(count);
           sb.append(s.charAt(s.length()-1));
       return sb.toString();
   }
}
