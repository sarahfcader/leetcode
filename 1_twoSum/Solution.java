class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> diffs = new HashMap();

        for (int i = 0; i < nums.length; i++) {
             if (diffs.get(nums[i]) != null) {
                return new int[]{i, diffs.get(nums[i])};
            }
            diffs.put(target - nums[i], i);
        }

        return null;
    }
}