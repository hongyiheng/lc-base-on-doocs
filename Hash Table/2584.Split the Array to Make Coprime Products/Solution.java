class Solution {

    Map<Integer, Integer> left = new HashMap<>();
    int[] right;

    public void f(int x, int i) {
        if (!left.containsKey(x)) {
            left.put(x, i);
        } else {
            right[left.get(x)] = i;
        }
    }

    public int findValidSplit(int[] nums) {
        int n = nums.length;
        right = new int[n];

        for (int i = 0; i < n; i++) {
            int d = 2;
            while (d * d <= nums[i]) {
                if (nums[i] % d == 0) {
                    f(d, i);
                    while (nums[i] % d == 0) {
                        nums[i] /= d;
                    }
                }
                d++;
            }
            if (nums[i] > 1) {
                f(nums[i], i);
            }
        }

        int mr = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = right[i];
            if (l > mr) {
                return mr;
            }
            mr = Math.max(r, mr);
        }
        return -1;
    }
}