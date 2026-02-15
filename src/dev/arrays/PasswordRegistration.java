package dev.arrays;

import java.util.*;

import static dev.arrays.PasswordRegistration.ArrayChallenge.arrayChallenge;

public class PasswordRegistration {
    /**
     * Determines whether each password should be accepted or rejected.
     * A password is rejected if it has already been used by k users.
     *
     * @param passwords An array of strings representing passwords
     * @param k         The maximum number of users who can have the same password
     * @return An array of strings ("ACCEPT" or "REJECT") for each password
     */

    // Edge case check
    public class ArrayChallenge {
        /**
         * Final optimized solution with O(n log n) time complexity
         */
        public static List<Long> arrayChallenge(List<Long> arr) {
            if (arr == null || arr.isEmpty()) {
                return new ArrayList<>();
            }

            int n = arr.size();
            List<Long> result = new ArrayList<>(n);

            // For the first element, counter is always 0
            result.add(0L);

            if (n == 1) {
                return result;
            }

            // Keep track of elements to the left
            long leftSum = arr.get(0);
            int leftCount = 1;

            // Use a TreeMap to efficiently find elements smaller/greater than current
            TreeMap<Long, Integer> leftElements = new TreeMap<>();
            leftElements.put(arr.get(0), 1);

            for (int i = 1; i < n; i++) {
                long current = arr.get(i);

                // Find sum of elements smaller than current
                long smallerSum = 0;
                int smallerCount = 0;

                for (Map.Entry<Long, Integer> entry : leftElements.headMap(current, false).entrySet()) {
                    smallerSum += entry.getKey() * entry.getValue();
                    smallerCount += entry.getValue();
                }

                // Find sum of elements greater than current
                long greaterSum = leftSum - smallerSum;
                int greaterCount = leftCount - smallerCount;

                // If current value already exists in leftElements, adjust greaterSum and greaterCount
                if (leftElements.containsKey(current)) {
                    int equalCount = leftElements.get(current);
                    greaterSum -= current * equalCount;
                    greaterCount -= equalCount;
                }

                // Calculate counter
                long smallerContribution = current * smallerCount - smallerSum;
                long greaterContribution = greaterSum - current * greaterCount;
                long counter = smallerContribution - greaterContribution;

                result.add(counter);

                // Update for next iteration
                leftSum += current;
                leftCount++;
                leftElements.put(current, leftElements.getOrDefault(current, 0) + 1);
            }

            return result;
        }

        // Example usage

    }

    public static void main(String[] args) {
        List<Long> arr = Arrays.asList(2L, 4L, 3L);
        List<Long> result = arrayChallenge(arr);
        System.out.println(result);
        // Expected output: [0, 2, 0]
    }
}
