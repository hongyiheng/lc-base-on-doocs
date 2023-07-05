class Solution {
    public boolean primeSubOperation(int[] nums) {
        int M = 1010;
        boolean[] primes = new boolean[M];
        for (int i = 2; i < M; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < M; j += i) {
                    primes[j] = true;
                }
            }
        }
        List<Integer> q = new ArrayList<>();
        for (int i = 2; i < M; i++) {
            if (!primes[i]) {
                q.add(i);
            }
        }
        int n = nums.length;
        for (int i = n - 2; i > -1; i--) {
            if (nums[i] >= nums[i + 1]) {
                int t = nums[i] - nums[i + 1];
                int l = 0, r = q.size();
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (q.get(mid) <= t) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (q.get(l) > t && q.get(l) < nums[i]) {
                    nums[i] -= q.get(l);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}