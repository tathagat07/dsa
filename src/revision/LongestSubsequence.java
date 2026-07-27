package revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubsequence {
    public static int lengthOfLongestSubsequence(String str){
        Set<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for(int right = 0 ; right < str.length(); right ++){

            while (set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));

            max = Math.max(max, right - left +1);

        }
        return max;
    }

    // using HashSet
    public static int lengthOfLongestSubsequenceRevision(String str){
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;

        for(int right = 0 ; right < str.length(); right ++){

            while(set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));

            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // using HashMap
    public static int lengthOfLongestSubsequenceHashMap(String str){
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for(int right = 0 ; right < str.length(); right ++){
            char ch = str.charAt(right);

            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, 1);

            max = Math.max(max, right - left + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        String str = "AABBAAABAB";
        System.out.println(lengthOfLongestSubsequence(str));
    }
}
