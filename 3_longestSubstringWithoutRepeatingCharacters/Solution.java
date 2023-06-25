class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int lengthOfLongestSubstring = 0;
        int startOfCurrentSequence = 0;

        // Attempted HashSet solution -- but needed a way to record the indexes of previously seen elements.
        // Sliding window -- start keeps track of the window frame start.

        HashMap<Character, Integer> charsToIndex = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {

            // Is the current character a repeat and within the current sequence? If so, shrink the left of the window to 
            // just after it.
            Integer indexOrNull = charsToIndex.get(chars[i]);
            if (indexOrNull != null && indexOrNull >= startOfCurrentSequence) {
                startOfCurrentSequence = indexOrNull + 1;
            }

            charsToIndex.put(chars[i], i);
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, i - startOfCurrentSequence + 1);
        }

        return lengthOfLongestSubstring;
        
    }
}