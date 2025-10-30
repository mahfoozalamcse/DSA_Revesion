package Recursion;

public class Recursion1 {
    // explain recurion -> a function calling itself
    // types of recursion
    // direct and indirect recursion
    // direct recursion -> when a function calls itself directly
    // indirect recursion -> when a function calls another function which in turn calls the first function
    // tail recursion -> when the recursive call is the last statement in the function
    // head recursion -> when the recursive call is the first statement in the function
    

    // Basic Example of Recursion
    static void printNto1(int n) {
        // base case
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNto1(n - 1); // recursive call
    }

    // example of factorial using recursion
    static int factorial(int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1); // recursive call
    }

    // example of fibonacci using recursion
    static int fibonacci(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive call
    }

    // example of sum of n natural numbers using recursion
    static int sumN(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        return n + sumN(n - 1); // recursive call
    }

    // example of power using recursion
    static int power(int x, int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1); // recursive call
    }

    // example of gcd using recursion
    static int gcd(int a, int b) {
        // base case
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b); // recursive call
    }

    // example of lcm using recursion
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /*
     Input :  set = "abc"
     Output : "". "a", "b", "c", "ab", "ac", "bc", "abc"

     Input : set = "abcd"
    Output : "" "a" "ab" "abc" "abcd" "abd" "ac" "acd"
         "ad" "b" "bc" "bcd" "bd" "c" "cd" "d"
     */

     // Subset Generation Problem
    static void generateSubsets(String str, String curr, int index) {
        // base case
        if (index == str.length()) {
            System.out.println(curr);
            return;
        }
        // include the current character
        generateSubsets(str, curr + str.charAt(index), index + 1);
        // exclude the current character
        generateSubsets(str, curr, index + 1);
    }

    // Joesphus Problem
    static int josephus(int n, int k) {
        // base case
        if (n == 1) {
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }

    //  permutations of a string
    /*
     * Input : str = "ABC"
       Output : ABC ACB BAC BCA CAB CBA
     */
    static void permute(String str, String curr) {
        // base case
        if (str.length() == 0) {
            System.out.println(curr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permute(ros, curr + ch);
        }
    }

   // Print 1 to N using Recursion
   public  static void print1toN(int n) {
          // base case
          if (n == 0) {
                return;
          }
          print1toN(n - 1);
          System.out.println(n);
     }

     // Sum of Digits using Recursion
    public static int sumOfDigits(int n) {
            // base case
            if (n == 0) {
                    return 0;
            }
            return n % 10 + sumOfDigits(n / 10);
        }

    // Sum of natural numbers using recursion
    public static int sumNaturalNumbers(int n) {
            // base case
            if (n == 1) {
                    return 1;
            }
            return n + sumNaturalNumbers(n - 1);
     }

    // Rope Cutting Problem
    public static int ropeCutting(int n, int a, int b, int c) {
            // base case
            if (n == 0) {
                    return 0;
            }
            if (n < 0) {
                    return -1;
            }
            int res = Math.max(ropeCutting(n - a, a, b, c),
                      Math.max(ropeCutting(n - b, a, b, c),
                              ropeCutting(n - c, a, b, c)));
            if (res == -1) {
                    return -1;
            }
            return res + 1;
     }

     // Tower of Hanoi
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
            // base case
            if (n == 1) {
                    System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
                    return;
            }
            towerOfHanoi(n - 1, source, auxiliary, destination);
            System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
            towerOfHanoi(n - 1, auxiliary, destination, source);
     }

     
        
  
    public static void main(String[] args) {
        printNto1(10);
        String str = "ABC";
        permute(str, "");

    }
}
