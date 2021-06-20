package com.samples.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        String finalStr = "";
        List<String> listStrs = new ArrayList<String>();
        for(String s : words)
        {
//        	String samp = finalStr  + " " + s;
        	//-1 of length is to  te space at beginning.
        	if((finalStr.length() + s.length() ) <= maxWidth)
        	{
        		listStrs.add(s); 
        		finalStr = finalStr  + " " + s;
        	}
        	else
        	{
        		if(!listStrs.isEmpty())
        		{
        		String spacedStr = formSpacedString(listStrs, finalStr, maxWidth);
        		res.add(spacedStr);
        		}
        		listStrs.clear();
        		finalStr = " " + s;
        		listStrs.add(s);
        		
        	}
        }
        if(!listStrs.isEmpty())
        {
        	finalStr = finalStr.substring(1);
    		res.add(finalStr + genrateEmptyStr(maxWidth - finalStr.length()));
        }
        
        return res;
    }
	
	private String formSpacedString(List<String> strs, String samp, int maxWidth)
	{
		if(strs.size() == 1)
{
	return strs.get(0) + genrateEmptyStr(maxWidth - strs.get(0).length());
}
		// no need -1 to samp.length as size of list also eliminate the extra sapce at beginning
		int totalSpace = maxWidth - (samp.length() - strs.size());
		int quotient = totalSpace/(strs.size()-1);
		int modulo = totalSpace%(strs.size() -1);
		String finalStr = "";
		System.out.println(quotient + "==" + modulo + "===" + samp.length() + "==" + strs + "===" + totalSpace);
		for(int i = 0 ; i < strs.size() -1 ; i++) 
		{
			finalStr = finalStr + strs.get(i)  + genrateEmptyStr(quotient + (modulo > 0 ? (1) : 0));
			
			if(modulo > 0 )
			{
				modulo--;
			}
		}
		finalStr = finalStr + strs.get(strs.size()-1);
		return finalStr;
	}
	
	private String genrateEmptyStr(int size)
	{
		char[] repeat = new char[size];
		  Arrays.fill(repeat, ' ');
		  return new String(repeat);
	}
	public static void main(String[] args) {
	
		
		TextJustification text = new TextJustification();
//		List<String>  res = text.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16);
		List<String>  res = text.fullJustifySol(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
		
		System.out.println(res);
	}
	
	public List<String> fullJustifySol(String[] words, int maxWidth) {
        List<String> ans = new ArrayList();
        if (words.length == 0 || maxWidth == 0) {
            ans.add("");
            return ans;
        }
        
        for (int i = 0, w = i; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {
                len += words[w].length() + 1;
            }
            
            int evenSlot = 1;
            int extraSlot = 0;
            int gap = w-i-1;
            
            //1st condn, finds if only one word fits the the maxWidth 2nd condn finds if words encountered for cuurent line is last,
//            for one word or last line, its enough to fill extra spaces at the end hence no need to find the extra lot
            if (w != i+1 && w != words.length) {
                evenSlot = (maxWidth - len) / gap + 1;
                extraSlot = (maxWidth - len) % gap;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            
            for (int j = i+1; j < w; ++j) {
                for (int k = 0; k < evenSlot; ++k) {
                    sb.append(" ");
                }
                
                if (extraSlot > 0) {
                    sb.append(" ");
                    extraSlot--;
                }
                sb.append(words[j]);
            }
            
            int remain = maxWidth - sb.length();
            while (remain > 0) {
                sb.append(" ");
                remain--;
            }
            
            ans.add(sb.toString());
        }
        return ans;
    }
}
