class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1, maxSpeed = 1;
        for (int item : piles) {
            maxSpeed = Math.max(item, maxSpeed);
        }

        while (minSpeed < maxSpeed) {
            int mid = (minSpeed + maxSpeed) >> 1;
            if (canEatAll(piles, mid, h)) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    public boolean canEatAll(int[] nums, int speed,int h) {
        int costTime = 0;
        for (int num : nums) {
            costTime += (num + speed - 1) / speed;
        }
        return costTime <= h;
    }
}