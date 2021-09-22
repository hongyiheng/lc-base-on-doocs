class Solution {
    public int trap(int[] height) {
        int area = 0;
        int leftMax = height[0];
        int[] leftMaxArray = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax = Math.max(height[i], leftMax);
            leftMaxArray[i] = leftMax;
        }
        int rightMax = height[height.length - 1];
        int[] rightMaxArray = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax = Math.max(height[i], rightMax);
            rightMaxArray[i] = rightMax;
        }

        for (int i = 1; i < height.length - 1; i++) {
            if (leftMaxArray[i] > height[i] && rightMaxArray[i] > height[i]) {
                area += Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];
            }
        }
        return area;
    }
}