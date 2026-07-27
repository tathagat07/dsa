package patternbased.SlidingWindow;

import java.util.*;

public class SlidingWindow {

    public int lengthOfLongestSubstring(String s){
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0 ; right < s.length() ; right++){
           char ch = s.charAt(right);

           while (window.contains(ch)){
               window.remove(s.charAt(left));
               left++;
           }

           window.add(s.charAt(right));
           maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

  /*  You may replace at most k characters.
    Find the longest substring consisting of the same character.*/

    public int characterReplacement(String s, int k){
      int[] freq = new int[26];

      int left = 0;
      int maxFreq = 0;
      int maxLength = 0;

      for(int right = 0; right < s.length() ; right++){
         char ch = s.charAt(right);
         freq[ch - 'A']++;

         maxFreq = Math.max(maxFreq,freq[ch - 'A']);
       // window - maxFreq > k (we can't go beyond k)
          // Window Size - Maximum Frequency <= k
         while((right - left + 1 ) - maxFreq > k){
             freq[s.charAt(left) - 'A']--;
             left++;
         }

         maxLength = Math.max(maxLength, right - left + 1);
      }
      return maxLength;
    }

    public String minWindow(String s, String t){
         if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();

        for(char ch : t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }

        Map<Character,Integer> window = new HashMap<>();
        int required = need.size();
        int formed = 0;

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);

            window.put(ch,window.getOrDefault(ch,0)+1);

            if(need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()){
                formed++;
            }

            while (formed == required){
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;

                    startIndex = left;
                }
             char leftChar = s.charAt(left);

                window.put(leftChar,window.get(leftChar) -1);

                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){

                    formed --;
                }
                left ++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex,startIndex + minLength);
    }

    // 1) Maximum Sum Subarray of Size K
    public static int maxSumSubarrayOfSizeK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) return -1;

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];
            // Remove left element
            // No need for left pointer!
            //Because fixed size window.
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[right - k + 1];
            }
        }
        return maxSum;
    }

    // 2) Permutation in String
    // Returns true if s2 contains any permutation of s1
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0, count = s1.length();

        while (right < s2.length()) {
            char r = s2.charAt(right);
            if (freq[r - 'a'] > 0) {
                count--;
            }
            freq[r - 'a']--;
            right++;

            if (count == 0) return true;

            if (right - left == s1.length()) {
                char l = s2.charAt(left);
                if (freq[l - 'a'] >= 0) {
                    count++;
                }
                freq[l - 'a']++;
                left++;
            }
        }

        return false;
    }

    // 3) Find All Anagrams in a String
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        int[] freq = new int[26];
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            char r = s.charAt(right);
            if (freq[r - 'a'] > 0) {
                count--;
            }
            freq[r - 'a']--;
            right++;

            if (count == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                char l = s.charAt(left);
                if (freq[l - 'a'] >= 0) {
                    count++;
                }
                freq[l - 'a']++;
                left++;
            }
        }

        return result;
    }

    // 4) Fruits Into Baskets
    // Longest subarray with at most 2 distinct numbers
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
           // too many distinct shrink
            while (map.size() > 2) {
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // 5) Minimum Size Subarray Sum
    // Smallest window
    //whose sum >= target
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        // 1) Maximum Sum Subarray of Size K
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum Sum Subarray of Size K: " + maxSumSubarrayOfSizeK(arr1, k)); // 9

        // 2) Permutation in String
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("Permutation in String: " + checkInclusion(s1, s2)); // true

        // 3) Find All Anagrams
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println("Find All Anagrams: " + findAnagrams(s, p)); // [0, 6]

        // 4) Fruits Into Baskets
        int[] fruits = {1, 2, 1, 2, 3, 2, 2};
        System.out.println("Fruits Into Baskets: " + totalFruit(fruits)); // 4

        // 5) Minimum Size Subarray Sum
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println("Minimum Size Subarray Sum: " + minSubArrayLen(target, nums)); // 2
    }
}
