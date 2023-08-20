package com.samples.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

class ListNode {
	int val;
	ListNode next;
	ListNode() {
	}
	ListNode(int x) {
		val = x;
	}
}

// Definition for a Node.
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;
	public Node random;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}

	@Override
	public String toString() {
		return val + "==" +next + "->" + left + "->" + right;
	}
};

public class RandomProgram {

	public static void main(String[] args) {
		RandomProgram obj = new RandomProgram();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(7);

		System.out.println(obj.connect(root));

//		System.out.println(obj.longestPalindrome("babad"));
//		System.out.println(obj.longestPalindrome("cbbd"));
//		System.out.println(obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
//		System.out.println(obj.letterCombinations("23"));
//		System.out.println(obj.letterCombinations(""));
//		System.out.println(obj.letterCombinations("2"));
//		System.out.println(obj.generateParenthesis(3));
//		System.out.println(obj.generateParenthesis(1));
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
//
//		ListNode res = obj.swapPairs(head);
//
//		System.out.println();
//		while(res != null)
//		{
//			System.out.print(res.val + " ");
//			res = res.next;
//		}


//		System.out.println(obj.permute(new int[] {1,2,3}));
//
//		int[] nums = new int[] {2,1,0};
//		obj.sortColors(nums);
//		System.out.println(Arrays.toString(nums));

//		System.out.println((obj.buildTree(new int[]{9,3,15,20,7}, new int[] {9,15,7,20,3})));

//		System.out.println(obj.canFinish(2, new int[][]{{1,0}, {0,1}}));
//		System.out.println(obj.canFinish(2, new int[][]{{1,0}}));
//		System.out.println(obj.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
//		System.out.println(obj.lengthOfLIS(new int[] {0,1,0,3,2,3}));
//		System.out.println(obj.lengthOfLIS(new int[] {11,12,13,14,15,6,7,8,101,18}));
//		System.out.println(obj.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
//		System.out.println(obj.characterReplacement("ABAB", 2));
//		System.out.println(obj.characterReplacement("AABABBA", 1));
//		System.out.println(obj.characterReplacement("BAAA", 0));

//		int[] nums = {1,2,3};
//		System.out.println(obj.sequenceReconstruction(nums, Arrays.asList(Arrays.asList(1,2), Arrays.asList(1,3),Arrays.asList(2, 3))));
//
//		System.out.println(obj.sequenceReconstruction(nums, Arrays.asList(Arrays.asList(1,2), Arrays.asList(1,3))));
//		System.out.println(obj.findMaxLength(new int[] {0,1,0,0,1}));
//		System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(obj.minWindow("bba", "ab"));
	}

	public String minWindow(String s, String t) {

		if(t.length() > s.length()) return  "";
		Map<Character, Integer> tMap = new HashMap<>();
		for(char c : t.toCharArray()) {
			int count = tMap.getOrDefault(c, 0);
			tMap.put(c, count+1);
		}

		int minStartIndex = -1;
		int minEndIndex = 0;
		int minWindowLen = Integer.MAX_VALUE;
		int currentWindowLen = 0;
		Map<Character, Integer> windowMap = new HashMap<>();
		int tLen = t.length();
		int start = 0;
		int end = 0;
		int matchingCharLen = 0;

		while(end < s.length() ) {

			char currChar = s.charAt(end);
			int charFreq = windowMap.getOrDefault(currChar, 0);
			windowMap.put(currChar, charFreq+1);
			currentWindowLen++;
			if(tMap.containsKey(currChar) && tMap.get(currChar) > 0 && windowMap.get(currChar) <= tMap.get(currChar)) {
				matchingCharLen++;
			}

			while(matchingCharLen == tLen) {
				if(end-start+1 < minWindowLen) {
					minWindowLen = end-start+1;
					minStartIndex = start;
					minEndIndex = end;
				}
				char startChar = s.charAt(start);

				if(tMap.containsKey(startChar) && tMap.get(startChar) > 0 && windowMap.get(startChar) <= tMap.get(startChar)) {
					matchingCharLen--;
				}
				int count = windowMap.get(startChar);
				windowMap.put(startChar, count-1);
				start++;
			}
			end++;
		}
		if(minStartIndex == -1) {
			return "";
		}

		return s.substring(minStartIndex, minEndIndex + 1);
	}

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		long totalArea = 0;
		for(int i = 0 ; i <= heights.length;i++) {

			while(!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])){
				int mid = stack.pop();
				int prevLargestIndex = -1;
				if(!stack.isEmpty()) {
					prevLargestIndex = stack.peek();
				}

				int area = i - prevLargestIndex - 1;
				totalArea = Math.max(totalArea, area * heights[mid]);
			}
			stack.push(i);
		}
		return (int)totalArea;
	}

	public int sumSubarrayMins(int[] arr) {

		int[] dp = new int[arr.length];

		Stack<Integer> stack = new Stack();
		int totalSum = 0;
		for(int i = 0 ; i <= arr.length ;i++) {

			while(!stack.isEmpty() && (i == arr.length || stack.peek() >= arr[i])) {
				int mid = stack.pop();
				int prevSmallestIndex = -1;
				if(!stack.isEmpty()) {
					prevSmallestIndex = stack.peek();

				}
				int sumContribution = (mid-prevSmallestIndex) * (i - mid) * arr[mid];
				totalSum += sumContribution;
			}
			stack.push(i);
		}
		return totalSum;
	}

	public int sumSubarrayMinsDp(int[] arr) {
//		3,4,5,2
		int[] dp = new int[arr.length];

		Stack<Integer> stack = new Stack();
		int totalSum = 0;
		for(int i = 0 ; i < arr.length ;i++) {

			while (!stack.isEmpty() && (arr[stack.peek()] >= arr[i])) {
				stack.pop();
			}
			int prevSmallestElementSum = 0;
			int prevSmallestIndex = -1;
			if (!stack.isEmpty()) {
				prevSmallestElementSum = dp[stack.peek()];
				prevSmallestIndex = stack.peek();
			}
			int sumContribution = prevSmallestElementSum + ((i - prevSmallestIndex) * arr[i]) ;
			dp[i] = sumContribution;
			stack.push(i);
		}
		for(int count : dp){
			totalSum +=count;
		}
		return totalSum;
	}

	public int minOperations(int[] nums, int x) {

		return minOperationsHelper(0 , nums.length-1, nums, x);
	}

	public int minOperationsHelper(int start, int end, int[] nums, int x) {
		if(start > end) {
			return 1000;
		}
		if(x < 0) {
			System.out.println(start + "--===--" + end);

			return 1000;
		}
		if(x == 0) {
			System.out.println(start + "===" + end);
			return 1;
		}
		int startIndex = 1 + minOperationsHelper(start+1, end, nums, x-nums[start]);
		int endIndex = 1 + minOperationsHelper(start, end-1, nums, x-nums[end]);
//		System.out.println(start + "===" + startIndex);
//		System.out.println(end + "===" + endIndex);
		return Math.min(endIndex, startIndex) ;
	}
	public List<Integer> partitionLabels(String s) {
		int[] chararr = new int[256];
		for(int i = 0 ; i <  s.toCharArray().length; i++) {
			chararr[s.charAt(i)] = i;
		}

		List<Integer> result = new ArrayList<>();
		int maxLastIndex = 0;
		int startIndex = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			int charIndex = chararr[c];

			maxLastIndex = Math.max(maxLastIndex, charIndex);

			if(maxLastIndex <= i) {
				result.add(i -startIndex +1);
				startIndex = i+1;
				maxLastIndex = 0;
			}
		}
		return result;
	}

	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0, -1);
		int maxLen = 0;
		int count = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			count += nums[i] == 0 ? -1 : 1;
			if(cache.containsKey(count)) {
				maxLen = Math.max(maxLen, i - cache.get(count));
			}
			else {
				cache.put(count, i);
			}
		}
//		maxLen = Math.max(maxLen, nums.length - cache.get(-count));

		return maxLen;
	}

	public int longestPalindromeSubseq(String s) {
		return longestPalindromeSubseqHelper(0, s.length()-1, s, new Integer[s.length()][s.length()]);
	}

	private int longestPalindromeSubseqHelper(int start, int end, String s, Integer[][] dpArr) {
		if(start > end) {
			return 0;
		}
		if(start == end) {
			return 1;
		}
		if(dpArr[start][end] != null) return dpArr[start][end];
		int res = 0;
		if(s.charAt(start) == s.charAt(end) ) {
			res += 2 + longestPalindromeSubseqHelper(start+1, end-1, s, dpArr);
		}
		else{
			res += Math.max(longestPalindromeSubseqHelper(start+1, end, s, dpArr), longestPalindromeSubseqHelper(start, end-1, s, dpArr));

		}
		dpArr[start][end] = res;
		return res;
	}
	public int characterReplacement(String s, int k) {
		int maxLen = 0;

		int maxFreq = 0;

		int start = 0;
		int end = 0;
		char[] charFreq = new char[26];
		for( ; end < s.length() ; end++)
		{
			charFreq[s.charAt(end)- 'A']++;
			maxFreq = Math.max(maxFreq, charFreq[s.charAt(end)- 'A']);
			int windowSize = end-start + 1;
			int diffCharCount = windowSize - maxFreq;

			if(diffCharCount > k) // not a valid window with more diff chars than k , so reduce the size of window
			{
				charFreq[s.charAt(start)- 'A']--;
				start++;
			}
			else {
				maxLen = Math.max(maxLen, windowSize);
			}
		}
		return maxLen;
	}

	public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
		Map<Integer, List<Integer>> topoSort = new HashMap<>();
		int[] inDegree = new int[nums.length+1];
		for(int i = 0 ; i < sequences.size() ; i++) {
			List<Integer> subseq = sequences.get(i);

			for(int j = 1; j < subseq.size();j++) {
				List<Integer> value = topoSort.computeIfAbsent(subseq.get(j-1), k -> new ArrayList<>());
				value.add(subseq.get(j));
				inDegree[subseq.get(j)]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <  inDegree.length ; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		int[] res = new int[nums.length];
		int index = 0;
		while(!queue.isEmpty()) {
			if(queue.size() > 1) return false;

			int num = queue.poll();
			res[index] = num;
			if(topoSort.containsKey(num)) {
				for (int child : topoSort.get(num)) {
					inDegree[child]--;
					if (inDegree[child] == 0) {
						queue.add(child);
					}
				}
			}

			index++;
		}

//		if(res.length != nums.length ) {
//			return false;
//		}

		return Arrays.equals(res, nums);

//		return false;
	}

	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

		Map<Integer, Integer> sumCache = new HashMap<>();
		for(int i = 0 ; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				int sum = nums1[i] + nums2[j];
				int value = sumCache.getOrDefault(sum, 0);
				sumCache.put(sum, value + 1);
			}
		}

		return fourSumCountHelper(List.of(nums3, nums4), 0, sumCache, 0);
	}



	private int fourSumCountHelper(List<int[]> numList, int index, Map<Integer, Integer> sumCache, int sum) {

		if(index >= numList.size()) {
			if(sumCache.containsKey(-sum)){
				return sumCache.get(-sum);
			}
			return 0;
		}
		int total = 0;
		int[] curArr = numList.get(index);
		for(int i = 0 ; i < curArr.length ; i++) {
			total += fourSumCountHelper(numList, index+1, sumCache, sum+curArr[i]);
		}
		return total;
	}
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> result = new ArrayList<>();
		Boolean[][] atlantic = new Boolean[heights.length][heights[0].length];
		Boolean[][] pacific = new Boolean[heights.length][heights[0].length];

		for(int i = 0 ; i < heights.length ; i++) {
			helper(i, 0, 0, pacific, heights);
			helper(i, heights[i].length-1, 0, atlantic, heights);
		}

		for(int i = 0 ; i < heights[0].length ; i++) {
			helper(0, i, 0, pacific, heights);
			helper(heights[i].length-1, i, 0, atlantic, heights);
		}
		for(int i = 0 ; i < heights.length ; i++) {
			for (int j = 0; j < heights[0].length; j++) {
				if(pacific[i][j] != null && atlantic[i][j] != null && pacific[i][j] && atlantic[i][j]){
					List<Integer> elements = new ArrayList<>();
					elements.add(i);
					elements.add(j);
					result.add(elements);
				}
			}
		}

		return result;
	}

	public void helper(int r, int c, int value, Boolean[][] ocean, int[][] heights) {
		if( r < 0 || c < 0 || r > heights.length-1 || c > heights[r].length-1 || ocean[r][c] != null) {
			return;
		}
		if(heights[r][c] >= value) {
			ocean[r][c] = true;
		}

		helper(r+1, c, heights[r][c], ocean, heights);
		helper(r-1, c, heights[r][c], ocean, heights);
		helper(r, c+1, heights[r][c], ocean, heights);
		helper(r, c-1, heights[r][c], ocean, heights);
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode dummy = new ListNode(0);

		ListNode evenList = new ListNode(0);
		ListNode evenHead = evenList;

		ListNode oddList = new ListNode(0);
		ListNode oddHead = oddList;

		int index = 1;

		while(head != null) {
			if(index % 2 != 0) {
				oddList.next = head;
				oddList = oddList.next;
			}else{
				evenList.next = head;
				evenList = evenList.next;
			}
			head = head.next;
			index++;
		}
		evenList.next = null;
		oddList.next = evenHead.next;
		dummy.next = oddHead.next;
		return dummy.next;
	}

	public int lengthOfLIS(int[] nums) {
		int maxLen = 0;
		int smallElementIndex = 0;
		int[] lenMemo = new int[nums.length];
		for(int i = 0 ; i < nums.length; i++) {
			if(i == 0) {
				lenMemo[i] = 1;
				smallElementIndex = i;
				maxLen = 1;
				continue;
			}
//			if(nums[i] < nums[smallElementIndex]) {
//				smallElementIndex = i;
//				lenMemo[i] = 1;
//				continue;
//			}
			for(int j = 0; j < i ; j++){
				if(nums[j] >= nums[i]) {
					continue;
				}
				lenMemo[i] = Math.max(lenMemo[i], lenMemo[j] + 1);
			}
			maxLen = Math.max(lenMemo[i], maxLen);
		}
		return maxLen;
	}


	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>>  result = new ArrayList<>();
		helper(k, n, 1, result, new ArrayList<>(), 0);
		return result;
	}

	public void helper(int k, int n, int index, List<List<Integer>>  result , List<Integer>  temp, int sum ) {

		if(temp.size() > k || sum > n) {
			return;
		}
		if(temp.size() == k && sum == n) {
			result.add(new ArrayList(temp));
			return;
		}
		for(int i = index ; i <= 9; i++) {
			if(sum + i > n) {
				return;
			}
			temp.add(i);
			helper(k, n, i+1, result,temp, sum + i);
			temp.remove(temp.size()-1);

		}
	}

	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<>();

		for(int i = 0 ; i< nums.length ;i++){
			queue.add(nums[i]);
			if(queue.size() > k) {
				queue.poll();
			}
		}
		return queue.poll();
	}

	public int rob(int[] nums) {
		return Math.max(0, robHelper(nums, 1, nums.length-1));
	}

	private int robHelper(int[] nums, int start, int end) {
		int max = Integer.MIN_VALUE;
		int prev = 0;
		int prevPlusOne = 0;
		for(int i = start ; i <= end ; i++){
//			nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
			int sum = Math.max(prevPlusOne + nums[i], prev);

			prevPlusOne = prev;
			prev = sum;
			System.out.println(prevPlusOne + "==" + prev);
		}
//		1==6
//		6==101
		return Math.max(prevPlusOne, prev);
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> preRequisitesMap = new HashMap<>();

		for(int[] arr: prerequisites) {
			preRequisitesMap.computeIfAbsent(arr[1], k -> new ArrayList<>()).add(arr[0]);
		}


		Set<Integer> visited = new HashSet<>();
		Set<Integer> cycle = new HashSet<>();
		for(int course : preRequisitesMap.keySet()) {
			if(!visited.contains(course) && canFinishHelper(visited, preRequisitesMap, course, cycle)) {
				return false;
			}
		}

		return true;
	}

	boolean canFinishHelper(Set<Integer> visited, Map<Integer, List<Integer>> preRequisitesMap, int currentCourse, Set<Integer> cycle) {

		if(cycle.contains(currentCourse)) {
			return true;
		}
		if(!preRequisitesMap.containsKey(currentCourse)) {
			return false;
		}
		if(visited.contains(currentCourse)) {
			return false;
		}
//		if(totalCoursesAdded > visited.length) {
//			return true;
//		}
		visited.add(currentCourse);
		cycle.add(currentCourse);
		for(int nextCourses : preRequisitesMap.get(currentCourse)) {
			if(canFinishHelper(visited, preRequisitesMap, nextCourses, cycle)) {
				return true;
			}
		}
		cycle.remove(currentCourse);
		return false;
	}



	public int numIslands(char[][] grid) {

		boolean[][] seen = new boolean[grid.length][grid[0].length];
		int islandCount = 0;
		for(int i = 0 ; i< grid.length ; i++) {
			for(int j = 0; j< grid[i].length; j++) {

				if(!seen[i][j] && grid[i][j] == '1') {
					numIslandsHelper(grid, i , j, seen);
					islandCount++;
				}
			}
		}
		return islandCount;
	}

	private void numIslandsHelper(char[][] grid, int row, int col, boolean[][] seen) {
		if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length -1 || grid[row][col] == '0' || seen[row][col]) {
			return;
		}

		seen[row][col] = true;

		numIslandsHelper(grid, row+1,col, seen);
		numIslandsHelper(grid, row-1,col, seen);
		numIslandsHelper(grid, row,col+1, seen);
		numIslandsHelper(grid, row,col-1, seen);

	}

	public ListNode insertionSortList(ListNode head) {
		if(head == null) return null;

		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;

		while(head != null) {

			while(prev.next != null && prev.next.val < head.val) {
				prev = prev.next;
			}

			ListNode next = head;
			head.next = prev.next;
			prev.next = head;
			head = next;
		}

		return dummy.next;
	}

	public Node copyRandomList1(Node head) {
		Node newList = new Node();
		Node dummy = newList;

		while(head != null) {


		}
		return dummy.next;
	}
	public Node copyRandomList(Node head) {
		Map<Node, Node> nodeMap = new HashMap<>();
		Node newList = new Node();
		Node dummy = newList;
		while(head != null){

			Node newNode = nodeMap.get(head);
			if(newNode == null) {
				newNode = new Node(head.val);
				nodeMap.put(head, newNode);
			}

			if(head.random != null) {
				Node randomNode = nodeMap.get(head.random);
				if(randomNode == null) {

					randomNode = new Node(head.random.val);
					nodeMap.put(head.random, randomNode);
				}
				newNode.random = randomNode;

			}
			newList.next = newNode;
			head = head.next;
			newList = newList.next;
		}

		return dummy.next;
	}

	public ListNode detectCycle(ListNode head) {
		if(head == null) return null;

		ListNode tort = head;
		ListNode hare = head;
		boolean cycleFound = false;
		while(hare.next != null && hare.next.next!= null) {
			hare = hare.next.next;
			tort = tort.next;
			if(tort == hare) {
				cycleFound = true;
				break;
			}
		}
		if(cycleFound ){
			hare = head;
			while(tort != hare){
				tort = tort.next;
				hare = hare.next;
			}
			return tort;
		}


		return null;
	}

	public Node connect(Node root) {
		Node dummy = new Node(0);
		dummy.next = root;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			int size = queue.size();
			Node prev = null;
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				if (i == 0) {
					prev = node;
					continue;
				}
				prev.next = node;
				prev = node;

			}
		}

		return dummy.next;
	}

}
