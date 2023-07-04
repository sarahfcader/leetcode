class Solution {
    public int longestConsecutive(int[] nums) {

        int longest = 0;

        // Construct frequency hashmap
        // for (int num : nums) {
        //     freq.put(num, freq.getOrDefault(num, 0) + 1);
        // }

        // Better way: convert nums to a set
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        // Calculate longest consecutive
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currLength = 1;
                int nextInSequence = num + 1;
                while (set.contains(nextInSequence)) {
                    currLength++;
                    nextInSequence++;
                }

                if (currLength > longest) {
                    longest = currLength;
                }
            }   
                
        }

        return longest;
        
    }
}