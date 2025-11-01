package Hashing;

import java.util.HashSet;

public class Hashing1 {
    // Subarray with zero sum
    public static boolean subarrayWithZeroSum(int[] arr) {
        // Your code here
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (set.contains(prefixSum) || prefixSum == 0) {
                return true;
            }
            set.add(prefixSum);
        }

        return false;
    }









    public static void main(String[] args) {
        
    }
}
