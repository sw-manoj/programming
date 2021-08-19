package com.samples.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GrpAnagram {

	// two methods avaiable
	public static void main(String[] args) {
		String str = "eat";
		System.out.println(str.hashCode());
		System.out.println("tea".hashCode());
		GrpAnagram grpAna = new GrpAnagram();
		String[] strs = {"cab","tin","sjn","duh","may","ill","buy","bac","max","doc"};
		grpAna.groupAnagrams(strs);
		grpAna.groupAnagramsAnother(strs);
	}
public List<List<String>> groupAnagrams(String[] strs) 
{
        Map<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	for(String s : strs)
	{
		char[] charArr = s.toCharArray();
		Arrays.sort(charArr);
		int asciiChar = 0;
		for(int i = 0 ; i < s.length() ; i++)
		{
			asciiChar += s.charAt(i);
		}
		System.out.println(String.copyValueOf(charArr) + "==="+asciiChar);

		addToMap(map, String.copyValueOf(charArr), s);
	}
	
//	List<List<String>> res = new ArrayList<List<String>>();
//	for(Entry<Integer, List<String>> entry : map.vaentrySet())
//	{
//		res.add(entry.getValue());
//	}
	System.out.println(map.values());
	return new ArrayList<List<String>>(map.values());
}

private void addToMap(Map<String, ArrayList<String>> map, String asciiChar, String str)
{
	ArrayList<String> strList = map.get(asciiChar);
	if(strList == null)
	{
		strList = new ArrayList<String>();
		map.put(asciiChar, strList);
	}
	strList.add(str);
	
}


public List<List<String>> groupAnagramsAnother(String[] strs) {
    HashMap<Long, List<String>> map = new HashMap<Long, List<String>>();
    for (int i = 0; i < strs.length; i++) {
        long h = hash(strs[i]);
        List<String> list = map.get(h);
        if (list == null) {
            list = new ArrayList();
            map.put(h, list);
        }
        list.add(strs[i]);
    }
    return new ArrayList(map.values());
}

static int[] prime = new int[]{2,
3,
5,
7,
11,
13,
17,
19,
23,
29,
31,
37,
41,
43,
47,
53,
59,
61,
67,
71,
73,
79,
83,
89,
97,
101};

long hash(String s) {
    long result = 7;
    for (int i = 0; i < s.length(); i++) {
        result *= prime[s.charAt(i) - 'a'];
    }
    return result;
}


public List<List<String>> groupAnagrams1(String[] strs) {
    if (strs.length == 0) return new ArrayList();
    Map<String, List> ans = new HashMap<String, List>();
    int[] count = new int[26];
    for (String s : strs) {
        Arrays.fill(count, 0);
        for (char c : s.toCharArray()) count[c - 'a']++;

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            sb.append('#');
            sb.append(count[i]);
        }
        String key = sb.toString();
        if (!ans.containsKey(key)) ans.put(key, new ArrayList());
        ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
}

}
