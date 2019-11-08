package main.java.recursion;

import java.util.HashSet;
import java.util.Set;
/* Write a recursion function for generating all permutation of an input String.
 Return them as a set.
 Time complexity:
 1. How many times does function perm get called in its base case?
 As we can understand from the recursion explained above that for a string of length 3
 it is printing 6 permutations which is actually 3!. This is because if it needs
 to generate permutation, it is needed to pick characters for each slot.
 If there are 3 characters in our string, in the first slot, there are 3 choices,
 2 choices for the next slot (for each of 3 choices earlier, i.e multiplication and not addition) and so on.
 This tells that there are n! permutations being printed in the base case which is what is shown in the image.

 2. How many times does function perm get called before its base case?
 Consider that lines 9 through 12 are hit n number of times. Therefore, there will be no more than (n * n!) function calls
 */

public class StringPermutation {
    public static Set<String> findAllPermutation(String str) {
        Set<String> set = new HashSet<>();
        if (str == null || str.length() == 0) return set;
        generate("", str, set);
        return set;
    }

    private static void generate(String candidate, String remaining, Set<String> set) {
        if (remaining.length() == 0) {
            set.add(candidate);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            generate(candidate + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), set);
        }
    }

    public static void main(String[] args) {
        Set<String> set = findAllPermutation("abc");
        for (String str : set) {
            System.out.println(str);
        }
    }
}
