class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        def getVal():
            ans = 0
            for i in range(31):
                if s[i]:
                    ans |= 1 << i
            return ans

        if k == 0:
            return 1
        n = len(nums)
        l = r = 0
        s = [0] * 32
        ans = n + 1
        while r < n:
            for i in range(31):
                if nums[r] >> i & 1:
                    s[i] += 1
            while getVal() >= k:
                ans = min(ans, r - l + 1)
                for i in range(31):
                    if nums[l] >> i & 1:
                        s[i] -= 1
                l += 1
            r += 1
        return -1 if ans > n else ans
