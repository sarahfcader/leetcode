class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> solution = new ArrayList<>();
 
        for (int i = 0; i < nums.length; i ++) {
            // We only do the calculation of triplets once per value. Fuplicates will be adjacent because array is sorted.
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }

            // Only search the elements that come after i, since any tuples containing previous elements would have been 
            // found in their search
            int left = i + 1;
            int right = nums.length - 1;

            // -5 -5 4 3 2 1
            // ^     ^------^
            // i     L      R
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    solution.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Close the window past any duplicated elements of the tuple we just found.
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    // Move pointers beyond the last copy of any duplicated elements
                    left++;
                    right--;
                }
             }
        }
        return solution;
    }

}