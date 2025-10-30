package Array;

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
    public static void slidingWindowMaximum(int arr[], int k){
        
    }




    public static void main(String[] args) {
       int arr[] = {23, 45, 12, 67, 34, 89};
       int key = 34;

       System.out.println(searchArray(arr, key));
    
    }
}
