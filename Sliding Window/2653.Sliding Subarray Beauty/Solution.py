class Solution:
    def getSubarrayBeauty(self, nums: List[int], k: int, x: int) -> List[int]:
        def getXMin():
            t = x
            for i, v in enumerate(cnt):
                if v >= t:
                    return i - 50 if i <= 50 else 0
                t -= v
            return 0

        ans = []
        l = r = 0
        cnt = [0] * 110
        while r < len(nums):
            cnt[nums[r] + 50] += 1
            if r - l + 1 == k:
                ans.append(getXMin())
                cnt[nums[l] + 50] -= 1
                l += 1
            r += 1
        return ans