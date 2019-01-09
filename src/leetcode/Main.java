package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(reverseString("123 456"));
		int[] aa = { 4, 2, 0, 5, 3, 0, 1, 2, 4, 1 };
		// System.out.println(singleNumber(aa));
		// moveZeroes(aa);
		int a = 2;
		System.out.print(titleToNumber("BD"));
	}

	private static String reverseString(String s) {
		StringBuffer buffer = new StringBuffer();

		for (int i = s.length() - 1; i >= 0; i--) {
			buffer.append(s.charAt(i));
		}

		return buffer.toString();
	}

	public List<String> fizzBuzz(int n) {
		List<String> strList = new ArrayList<String>(n);

		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				strList.add("FizzBuzz");
			else if (i % 3 == 0)
				strList.add("Fizz");
			else if (i % 5 == 0)
				strList.add("Buzz");
			else
				strList.add(Integer.toString(i));
		}

		return strList;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = 1 + maxDepth(root.left);
		int right = 1 + maxDepth(root.right);

		return Math.max(left, right);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int singleNumber(int[] nums) {
		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}

		return result;
	}

	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int index = 0;
		for (int num : nums) {
			if (num != 0)
				nums[index++] = num;
		}

		while (index < nums.length) {
			nums[index++] = 0;
		}

	}

	/*
	 * public int getSum(int a, int b) {
	 * 
	 * }
	 */

	public ListNode reverseList(ListNode head) {
		return reverseList(head, null);
	}

	public ListNode reverseList(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;

		ListNode next = head.next;
		head.next = newHead;
		newHead = head;

		return reverseList(next, newHead);
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;

	}

	public int romanToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'M':
				result += 1000;
				break;
			case 'D':
				result += 500;
				break;
			case 'C':
				result += 100;
				break;
			case 'L':
				result += 50;
				break;
			case 'X':
				result += 10;
				break;
			case 'V':
				result += 5;
				break;
			default:
				result += 1;
				break;
			}
		}

		if (s.indexOf("IV") > 0)
			result -= 2;
		if (s.indexOf("IX") > 0)
			result -= 2;
		if (s.indexOf("XL") > 0)
			result -= 20;
		if (s.indexOf("XC") > 0)
			result -= 20;
		if (s.indexOf("CD") > 0)
			result -= 200;
		if (s.indexOf("CM") > 0)
			result -= 200;

		return result;
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);
		}

		Map.Entry<Integer, Integer> majorMap = null;
		;
		for (Map.Entry<Integer, Integer> major : map.entrySet()) {
			if (majorMap == null || major.getValue() > majorMap.getValue())
				majorMap = major;

		}

		return majorMap.getKey();
	}

	public static int titleToNumber(String s) {
		int result = 0;

		for (int i = 0; i < s.length(); i++)
			result = result * 26 + (s.charAt(i) - 'A' + 1);

		return result;
	}

}
