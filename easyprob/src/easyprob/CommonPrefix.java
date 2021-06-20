package easyprob;

public class CommonPrefix {

	public static void main(String[] args) {
		CommonPrefix prefix = new CommonPrefix();
		String[] input = {"flower","flow","flight"};
		System.out.println(prefix.longestCommonPrefix(input));
		System.out.println(prefix.longestCommonPrefix(new String[] {"dog","dacecar","dar"}));
	}
	
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		if (strs.length > 200) return "ARRAY OVERFLOW";

		String prefix = (strs[0] == null)? "" : strs[0];
		for(int i = 1; i < strs.length; i++) {
			while(strs[i] != null && !strs[i].startsWith(prefix)) {
				prefix = prefix.substring(0, prefix.length() -1);
			}
		}
		return prefix;
    }
	
	public String longestCommonPrefix1(String[] strs) {
        
		String res = "";
		
		if(strs.length == 0)
		{
			return res;
		}
		
		res = strs[0];
		for(int i = 1 ; i < strs.length ; i++)
		{
			res = commonPrefix(strs[i], res);
			if(res.length() == 0)
			{
				break;
			}
		}
		return res;
    }
	
	public String commonPrefix(String str, String prefix)
	{
		int len = str.length() > prefix.length() ? prefix.length() : str.length();
		String resPrefix = "";
		for(int i = 0 ; i < len ; i++)
		{
			if(str.charAt(i) != prefix.charAt(i))
			{
				return resPrefix;
			}
			resPrefix = resPrefix + str.charAt(i);
		}
		
		return resPrefix;
	}
}
