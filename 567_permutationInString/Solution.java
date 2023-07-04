class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // trivial brute force -- generate all permutations of s1, search in s for each of them
        // O(n!) which is gigantic

        // Sliding window 

        // If we encounter one of s1's letters in s2, we may find a permutation.
        // Start a window of s1.length() . All of s1's other letters should be contained in the window
        // This has a slow runtime if there are many matches to s1's letters but the permutation does not appear early

        // Similar idea to "longest repeating character replacement?" -- start a window of a set length, record the 
        // appearances of each letter
        // Compare frequency set of window for equality with frequency set of s1
        // If no match, move window one step ahead

        // ascii table (lowercase = 97 - 122)
        // https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

        if (s2.length() < s1.length()) { return false; }

        int end = s1.length() - 1;

        // all are initialized to 0 by default
        int[] permutationFrequencies = new int[26];
        int[] windowFrequencies = new int[26];

        for (char c : s1.toCharArray()) {
            permutationFrequencies[c - 'a']++;
        }

        // initialize windowFrequencies
        for (int i = 0; i < end+1; i++) {
            windowFrequencies[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (Arrays.equals(permutationFrequencies, windowFrequencies)) {
                return true;
            }

            // Move window ahead
            end++;
            if (end == s2.length()) {
                return false;
            }
            windowFrequencies[s2.charAt(i) - 'a']--;
            windowFrequencies[s2.charAt(end) - 'a']++;
        }


        return false;
        
    }
}