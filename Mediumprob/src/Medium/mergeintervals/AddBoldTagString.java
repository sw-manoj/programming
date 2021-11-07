package Medium.mergeintervals;


//https://leetcode.com/problems/add-bold-tag-in-string/submissions/
public class AddBoldTagString {
	
	public static void main(String[] args) {
		AddBoldTagString obj = new AddBoldTagString();
		System.out.println(obj.addBoldTag("abcxyz123", new String[] {"abc", "123"}));
		
		System.out.println(obj.addBoldTag("aaabbcc", new String[] {"aaa", "aab", "bc"}));

	}

	public String addBoldTag(String s, String[] words) {
		String res = "";
         
        int[] bold = new int[s.length()];
        
        for(String w : words)
        {
        	int index = s.indexOf(w);
        	
        	while(index != -1)
        	{
        		for(int i = index ; i < index + w.length() ; i++)
        		{
        			bold[i] = 1;
        		}
        		
        		index = s.indexOf(w, index + 1);
        	}
        }
        
        boolean isBold = false;
        
        for(int i = 0 ; i < s.length() ; i++)
        {
        	if(bold[i] == 1)
        	{
        		if(!isBold)
        		{
        			isBold = true;
        			res += "<b>";
        		}
        		
        	}else
        	{
        		if(isBold)
        		{
        			isBold = false;
        			res += "</b>";
        		}
        	}
        	res += s.charAt(i);
        }
        
        
        if(isBold)
        {
        	res += "</b>";
        }
        
        return res.toString();
    }
}
