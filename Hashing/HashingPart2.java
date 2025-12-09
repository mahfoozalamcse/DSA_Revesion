package Hashing;

import java.util.HashSet;

public class HashingPart2 {
    // Count distinct elements in an array
    public static int countDistinctElements(int[] arr) {
        // Your code here
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set.size();
        
    }

    
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        int distinctCount = countDistinctElements(arr);
        System.out.println("Number of distinct elements: " + distinctCount);
    }
}
