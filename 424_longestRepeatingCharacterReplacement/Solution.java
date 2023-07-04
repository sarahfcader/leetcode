class Solution {
    public int characterReplacement(String s, int k) {
        
        // First suboptimal solution ------------------------------------
        // char[] chars = s.toCharArray();
        // int maxLength = 0;

        // for (int i = 0; i < chars.length; i ++) {
        //     int currLength = 1;
        //     char currChar = chars[i];
        //     int currIndex = i+1;
        //     int replaceCount = 0;

        //     while (currIndex < chars.length && (replaceCount < k || chars[currIndex] == currChar)) {
        //         if (chars[currIndex] != currChar) {
        //             replaceCount++;
        //         }
        //         currLength++;
        //         currIndex++;
        //     }

        //     currLength = Math.min(currLength + k - replaceCount, chars.length);
        //     maxLength = Math.max(currLength, maxLength);

        //     while (i + 1 < chars.length && chars[i+1] == currChar) {
        //         // Fast-forward through adjacent same letters
        //         i++;
        //     }

        // }

        // return maxLength;


        // From description -- s consists only of uppercase English letters. ASCII 65 - 90. 
        // Counts of each letter in the current window. Convert char to frequency table index w/  char - 'A'.
        int[] count = new int[26];
        int start = 0;
        int maxFrequency = 0;

        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A'] += 1;
            // Get the frequency of the most frequent character in the current window.
            // By using most frequent character in window as the "base" instead of the character at start or end, we can 
            // Look for the max lengt "backwards", i.e. count using the size of the whole window
            maxFrequency = Math.max(maxFrequency, count[s.charAt(end) - 'A']);
            // If that max frequency + the number of allowed replacements is smaller or equal to the window size, we've 
            // maxed out the potential for the current region max character. Even if more occurances exist farther right, 
            // they're unreachable for the given k. We move the window right, but don't shrink it to keep track of the max  
            // size.
            if (maxFrequency + k <= end - start) {
                count[s.charAt(start) - 'A']  -= 1;
                start++;
            }
        }

        // The max substring length is the largest window size.
        return s.length() - start;

        
    }
}