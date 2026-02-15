package dev.string;

import java.util.*;

public class Palindrome {

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;

            }
            map.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());

    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;

        for (int i = 0; i < n; ) {
            char ch = chars[i];
            int count = 0;

            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            if (count == 1) {
                chars[idx++] = ch;
            } else {
                chars[idx++] = ch;
                String str = String.valueOf(count);
                for (int j = 0; j < str.length(); j++) {
                    char digit = str.charAt(j);
                    chars[idx++] = digit;
                }
            }

        }
        return idx;
    }

    public boolean isFreqSame(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;

    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int windowSize = s1.length();

        for (int i = 0; i < s2.length(); i++) {

            int[] windowFreq = new int[26];
            int windowIndex = 0;
            int index = i;

            while (windowIndex < windowSize && index < s2.length()) {
                windowFreq[s2.charAt(i) - 'a']++;
                index++;
                windowIndex++;
            }

            if (isFreqSame(freq, windowFreq)) {
                return true;
            }
        }

        return false;

    }

    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;
    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();

        String[] sArray = s.trim().split("\\s+");
        for (String word : sArray) {
            stack.push(word);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (stack.size() >= 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void printDuplicates(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }


        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print("['" + entry.getKey() + "', " + entry.getValue() + "], ");
            }
        }
    }

    public static String removeConsecutiveCharacter(String s) {
        // code here

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ((stack.isEmpty() == false && stack.peek() != s.charAt(i)) || stack.isEmpty() == true) {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() - 1);

            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')
                ) {
                    return false;
                }
                stack.pop();
            }


        }
        return stack.isEmpty();

    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[256]; // For all ASCII characters
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(String s) {

        int st = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (st < end) {
            if (!isAlphanumeric(s.charAt(st))) {
                st++;
                continue;
            }
            if (!isAlphanumeric(s.charAt(end))) {
                end--;
                continue;
            }
            if (s.charAt(st) != s.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String input = "aabaa";
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //  System.out.println(compress(chars));
//      System.out.println(isPalindrome(str));
//        System.out.println(removeConsecutiveCharacter(input));

        // String s = "geeksforgeeks";
   //     String s = "axxxxyyyyb"; // dab
        String part = "xy";
        String input1 = "abcabcbb";
        String s ="AABABBA";
      //  System.out.println(lengthOfLongestSubstring(input1));
        System.out.println(characterReplacement(s,1));
        //     System.out.println(removeOccurrences(s,part));
        //  printDuplicates(s);
    }
}
