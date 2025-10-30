package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class intro1 {
    public static int searchArray(int arr[], int key){

        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    // 2. insert element at specific position
    public static void insertElement(int arr[], int pos, int element){

        // shifting elements to the right
        for(int i=arr.length-1; i>pos; i--){
            arr[i] = arr[i-1];
        }
        // inserting element at specified position
        arr[pos] = element;
    }

    // Delete element at specific position
    public static void deleteElement(int arr[], int pos){

        // shifting elements to the left
        for(int i=pos; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        // optional: set last element as 0
        arr[arr.length-1] = 0;
    }
    // 3. Rotate array by k times
    public static void rotateArray(int arr[], int k){
        int n = arr.length;
        k = k % n; // in case k is greater than n

        // reverse first n-k elements
        reverse(arr, 0, n-k-1);
        // reverse last k elements
        reverse(arr, n-k, n-1);
        // reverse the whole array
        reverse(arr, 0, n-1);
    }

    public static void reverse(int arr[], int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 4. Find maximum and minimum element in array

    public static int[] findMaxMin(int arr[]){
        int max = arr[0];
        int min = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return new int[]{max, min};
    }

    // 5. Calculate the sum of all elements in the array
    public static int sumOfArray(int arr[]){
      int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }


    // 6. Merge two sorted arrays
    public static int[] mergeSortedArrays(int arr1[], int arr2[]){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int mergedArr[] = new int[n1 + n2];

        int i=0, j=0, k=0;
        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }
        while(i < n1){
            mergedArr[k++] = arr1[i++];
        }
        while(j < n2){
            mergedArr[k++] = arr2[j++];
        }
        return mergedArr;
    }

    // 7. Find the second largest element in the array

    public static int findSecondLargest(int arr[]){
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > firstLargest){
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if(arr[i] > secondLargest && arr[i] != firstLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    // 8. Check if the array is sorted in ascending order
    public static boolean isSorted(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    // 9. Remove duplicates from a sorted array
    public static int removeDuplicates(int arr[]){
        if(arr.length == 0) return 0;

        int j = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1; // new length of array
    }

    // 10 . Find the frequency of each element in the array
    public static void findFrequency(int arr[]){
        int n = arr.length;
        boolean visited[] = new boolean[n];

        for(int i=0; i<n; i++){

            if(visited[i]) continue;

            int count = 1;
            for(int j=i+1; j<n; j++){
                if(arr[i] == arr[j]){
                    count++;
                    visited[j] = true;
                }
            }
            System.out.println(arr[i] + " occurs " + count + " times");
        }
    }
    // 12. reverse the array
    public static void reverseArray(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 13. Find the intersection of two arrays
    public static void intersectionOfArrays(int arr1[], int arr2[]){
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
    }

    // Optamized intersection of two sorted arrays
    public static void optimizedIntersection(int arr1[], int arr2[]){
        int i=0, j=0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            } else if(arr1[i] < arr2[j]){
                i++;
            } else {
                j++;
            }
        }
    }

    // 14 . Move all zeros to the end of the array
    public static void moveZerosToEnd(int arr[]){
        int count = 0; // count of non-zero elements

        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                arr[count++] = arr[i];
            }
        }
        // Fill remaining positions with zeros
        while(count < arr.length){
            arr[count++] = 0;
        }
    }


    // 15. Find the majority element in the array
    // expalination: The majority element is the element that appears more than n/2 times in the array.

    public static int findMajorityElement(int arr[]){
        int count = 0;
        int candidate = -1;

        // Finding a candidate for majority element
        for(int i=0; i<arr.length; i++){
            if(count == 0){
                candidate = arr[i];
            }
            if(arr[i] == candidate){
                count++;
            } else {
                count--;
            }
        }

        // Verifying the candidate
        count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == candidate){
                count++;
            }
        }

        if(count > arr.length / 2){
            return candidate;
        } else {
            return -1; // No majority element
        }
    }


    // 16 . sliding window maximum
    // explanation: Given an array and a number k, find the maximum element in every contiguous subarray of size k.
    /*
      Example:
        
      Array: [1, 3, 5, 2, 8, 9]
       Window Size: 3

         [1, 3, 5] → sum = 9
         [3, 5, 2] → sum = 10
         [5, 2, 8] → sum = 15
        [2, 8, 9] → sum = 19
    

     */

     public static void maxSizeK(int arr[], int k){
        int n = arr.length;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Calculate sum of first window
        for(int i=0; i<k; i++){
            windowSum += arr[i];
        }

        maxSum = windowSum;

        for(int i=k; i<n; i++){
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println("Maximum sum of size " + k + " is: " + maxSum);
     }



    // type of Sliding window 
    // 1. fixed size window
    // 2. variable size window

    // fixe size window
    // example: find maximum sum of k consecutive elements in an array

    // explain find maximum sum of k consecutive elements in an array
    // example: [1, 3, 5, 2, 8, 9], k=3
    // output: 19 (8+9+2)

    public static void fixedSizeWindow(int arr[], int k){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<=n-k; i++){
            int windowSum = 0;
            for(int j=0; j<k; j++){
                windowSum += arr[i+j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println("Maximum sum of " + k + " consecutive elements is: " + maxSum);
    }
     

    // variable size example: find the smallest subarray with sum greater than a given value
    // example: [2, 3, 1, 2, 4, 3], sum=7
    // output: 2 (subarray [4,3])

    public static void variableSizeWindow(int arr[], int sum){
        int n = arr.length;
        int minLength = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int currentSum = 0;
            for(int j=i; j<n; j++){
                currentSum += arr[j];
                if(currentSum > sum){
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }

        if(minLength == Integer.MAX_VALUE){
            System.out.println("No subarray found");
        } else {
            System.out.println("Smallest subarray length is: " + minLength);
        }
    }


     /*
      Find the length of the longest substring without repeating characters.
      Input: s = "abcabcbb"
      Output: 3 (substring: "abc")
      */

    public static int lengthofLongestSubstring(String s){
        int n = s.length();
        int maxLength = 0;

        for(int i=0; i<n; i++){
            boolean[] vis = new boolean[26];
            for(int j=i; j<n; j++){
                char ch  = s.charAt(j);
                if (vis[ch - 'a']) {
                    break;
                }else{
                    vis[ch - 'a'] = true;
                    maxLength = Math.max(maxLength, j-i+1);
                 }
            }
        }

        return maxLength;
    }

    // opytimized approach using sliding window
    public static int lengthOfLongestSubstringOptimized(String s) {

        int n = s.length();
        int maxLength = 0;
        int left = 0;
        boolean[] vis = new boolean[256]; // assuming ASCII characters

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            while (vis[ch]) {
                vis[s.charAt(left)] = false;
                left++;
            }
            vis[ch] = true;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // using hashmap
    public static int lengthOfLongestSubstringHashMap(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        int left = 0;

        for (int right = 0; right < n; right++) {
           
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }

    // prefix sum array
    // explanation: A prefix sum array is an array that contains the cumulative sum of elements from the original array up to each index.
    // example: original array: [1, 2, 3, 4]
    // prefix sum array: [1, 3, 6, 10]
    public static int[] prefixSumArray(int arr[]){

        int n = arr.length;
        int prefixSum[] = new int[n];
        prefixSum[0] = arr[0];

        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        return prefixSum;
    }

    // usage of prefix sum array to find sum of elements in a given range
    public static int rangeSum(int prefixSum[], int left, int right){

        if(left == 0){
            return prefixSum[right];
        } else {
            return prefixSum[right] - prefixSum[left-1];
        }
    }

    // formula : Sum(L,R)=prefix[R]−prefix[L−1];
    // if L=0 then Sum(0,R)=prefix[R];
    // else Sum(L,R)=prefix[R]−prefix[L−1];

    // Google Interview Question
    // Question: Given an array of integers, find two numbers such that they add up to a specific target number.
    public static int[] twoSum(int arr[], int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1}; // no solution found
    }

    // Implementation of Kadane's Algorithm to find the maximum subarray sum
    public static int kadaneAlgorithm(int arr[]){
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for(int i=1; i<arr.length; i++){
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }


    //  Equilibrium index of an array
    public static int equilibriumIndex(int arr[]){
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }

        int leftSum = 0;
        for(int i=0; i<arr.length; i++){
            totalSum -= arr[i]; // now totalSum is right sum for index i

            if(leftSum == totalSum){
                return i;
            }

            leftSum += arr[i];
        }

        return -1; // no equilibrium index found
    }


    // Largest Sum Subarray
    public static int largestSumSubarray(int arr[]){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for(int i=0; i<arr.length; i++){
            maxEndingHere += arr[i];

            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }

            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    //  Merge two sorted Arrays
    public static int[] mergeTwoSortedArrays(int arr1[], int arr2[]){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int mergedArr[] = new int[n1 + n2];

        int i=0, j=0, k=0;
        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }
        while(i < n1){
            mergedArr[k++] = arr1[i++];
        }
        while(j < n2){
            mergedArr[k++] = arr2[j++];
        }
        return mergedArr;
    }

    // Largest Element in an Array
    public static int largestElement(int arr[]){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }


    // Smallest Element in an Array
    public static int smallestElement(int arr[]){
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    // Check if an Array is Sorted
    public static boolean checkSorted(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    // Second Largest Element in Array
    public static int secondLargestElement(int arr[]){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > first){
                second = first;
                first = arr[i];
            } else if(arr[i] > second && arr[i] != first){
                second = arr[i];
            }
        }
        return second;
    }

    // Remove duplicates from a sorted array
    public static int removeDuplicatesSortedArray(int arr[]){
        if(arr.length == 0) return 0;

        int j = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1; // new length of array
    }


    public static void main(String[] args) {
    //    int arr[] = {23, 45, 12, 67, 34, 89};
    //    int key = 34;

    //    System.out.println(searchArray(arr, key));

    String s = "abcabcbb";
    System.out.println(lengthofLongestSubstring(s));
    System.out.println(lengthOfLongestSubstringOptimized(s));
    System.out.println(lengthOfLongestSubstringHashMap(s));

    // implementation of array in java
    int arr[] = new int[5]; // declaration and instantiation
    arr[0] = 10; // initialization
    System.out.println(arr[0]); // accessing elements

    // array literal
    int arr2[] = {1, 2, 3, 4, 5};
    System.out.println(arr2[2]);

    // length of array
    System.out.println("Length of arr2: " + arr2.length);

    // traversing array
    for(int i=0; i<arr2.length; i++){
        System.out.print(arr2[i] + " ");
    }

    // Array list in java
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=1; i<=5; i++){
        list.add(i * 10); // adding elements
    }
    System.out.println(" ArrayList: " + list);

    // operations on array list
    list.remove(2); // remove element at index 2
    System.out.println("After removing index 2: " + list);
    list.set(1, 50); // set element at index 1 to 50
    System.out.println("After setting index 1 to 50: " + list);


    // Range Sum Queries using Prefix Sum
    int arr3[] = {1, 2, 3, 4, 5};
    int prefixSum[] = prefixSumArray(arr3);
    int left = 1;
    int right = 3;
    System.out.println("Sum of elements from index " + left + " to " + right + " is: " + rangeSum(prefixSum, left, right));




   }
}
