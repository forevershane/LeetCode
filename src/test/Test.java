package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);

		String result = findNumber(arr, 5);
		// System.out.print(result);

		String[] words = { "a",
				"zxb",
				"ba",
				"bca",
				"bda",
				"bdca",
				"zxbe",
				"azxbe",
				"azxpbe"};

		// System.out.println("Longest Chain Length : " + longest_chain(words));

		String aa = "abc";

//		System.out.println(removeCharAt("abc", 2));
		System.out.println(longestChain(words));

	}

	static String findNumber(List<Integer> arr, int k) {
		String result = "NO";
		if (arr.contains(k))
			result = "YES";

		return result;

	}

	static List<Integer> oddNumbers(int l, int r) {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = l; i <= r; i++) {
			if (i % 2 == 1)
				result.add(i);
		}

		return result;
	}
	

	public static int longestChain(List<String> words) {
		int max = 0;
		String[] wordArray = (String[]) words.toArray();

		Set<String> wordSet = new HashSet<>(words);

		for(String word: wordArray) {
			if(word.length() < max)
				continue;
			
			int depth = getDepth(word, wordSet);
			max = Math.max(max, depth);
		}

		return max;
	}

	private static int getDepth(String word, Set<String> wordSet) {
		int max = 0;
		int length = word.length();

		if (!wordSet.contains(word))
			return 0;

		for (int i = 0; i < length; i++) {
			StringBuffer buffer = new StringBuffer(word);
			buffer.delete(i, i + 1);
			String newWord = buffer.toString();

			int submax = 1 + getDepth(newWord, wordSet);

			max = Math.max(max, submax);
		}
		return max;
	}

	static int longest_chain(String[] w) {
		if (null == w || w.length < 1) {
			return 0;
		}

		int maxChainLen = 0;

		HashSet<String> words = new HashSet<>(Arrays.asList(w));
		HashMap<String, Integer> wordToLongestChain = new HashMap<>();

		for (String word : w) {
			if (maxChainLen > word.length()) {
				continue;
			}
			int curChainLen = find_chain_len(word, words, wordToLongestChain) + 1;
			wordToLongestChain.put(word, curChainLen);
			maxChainLen = Math.max(maxChainLen, curChainLen);
		}
		return maxChainLen;
	}

	static int find_chain_len(String word, HashSet<String> words, HashMap<String, Integer> wordToLongestChain) {
		int curChainLen = 0;

		for (int i = 0; i < word.length(); i++) {
			String nextWord = word.substring(0, i) + word.substring(i + 1);
			System.out.println("QQ1" + i);
			System.out.println("QQ1" + word);
			System.out.println("QQ2" + word.substring(0, i));
			System.out.println("QQ3" + word.substring(i + 1));
			System.out.println("QQ4" + nextWord);

			if (words.contains(nextWord)) {
				if (wordToLongestChain.containsKey(nextWord)) {
					curChainLen = Math.max(curChainLen, wordToLongestChain.get(nextWord));
				} else {
					int nextWordChainLen = find_chain_len(nextWord, words, wordToLongestChain);
					curChainLen = Math.max(curChainLen, nextWordChainLen + 1);
				}
			}
		}

		return curChainLen;
	}

	static int longestChain(String[] words) {

		// create something with O(1) searching of words.
		final Set<String> wordMap = new HashSet<>();
		for (String e : words)
			wordMap.add(e);

		int max = -1;
		for (String target : words) {
			int k = depthFirstCount(target, wordMap);
			if (k > max)
				max = k;
		}

		return max;
	}

	private static int depthFirstCount(String target, Set<String> wordMap) {
		int n = target.length();
		int max = 0;

		if (!wordMap.contains(target))
			return 0;

		for (int i = 0; i < n; i++) {
			String current = removeCharAt(target, i);
			// increase our depth by 1;
			int local = 1 + depthFirstCount(current, wordMap);
			// find the max depth recursively.
			if (local > max)
				max = local;
		}
		return max;
	}

	static String removeCharAt(String s, int i) {
		StringBuilder buf = new StringBuilder(s);
		buf.delete(i, i + 1);
		return buf.toString();
	}
	

	
}


class Person {
	int time;
	int direction;
	boolean isAct;
}
