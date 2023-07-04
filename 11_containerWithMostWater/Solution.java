 class Solution {
    public int maxArea(int[] height) {

        // First maximize distance by starting at opposite ends
        int left = 0;
        int right = height.length - 1;
        int mostWater = 0;

        while (left < right) {
            int water = (right-left)*(Math.min(height[left], height[right]));
            if (water > mostWater) {
                mostWater = water;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return mostWater;
        
    }
}