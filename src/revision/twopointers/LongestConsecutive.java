package revision.twopointers;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();

        // Step 1: Put all numbers into a HashSet
        for (int num : nums){
            set.add(num);
        }

        int longest = 0 ;
        // Step 2: Only start from the beginning of a sequence
        for (int num : set){
            // FIX: Check if (num - 1) is NOT in the set.
            // If (num - 1) exists, 'num' is not the start of a sequence.
            if (!set.contains(num-1)){
                int current = num;
                int length = 1;

                while (set.contains(current + 1)){
                    current++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }

        return longest;
    }
}
