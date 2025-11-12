class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        cnt = Counter(nums)
        if cnt[1]:
            return n - cnt[1]
        mi = n + 1
        for i in range(n - 1):
            s = nums[i]
            for j in range(i + 1, n):
                s = gcd(s, nums[j])
                if s == 1:
                    mi = min(mi, j - i + 1)
        return -1 if mi > n else n + mi - 2
