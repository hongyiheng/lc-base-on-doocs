class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        s = []
        for i, v in enumerate(nums):
            if v == key:
                s.append(i)
        ans = []
        for i in range(len(nums)):
            l, r = 0, len(s) - 1
            while l < r:
                mid = (l + r) >> 1
                if s[mid] < i:
                    l = mid + 1
                else:
                    r = mid
            diff = abs(i - s[l])
            if l > 0:
                diff = min(diff, abs(i - s[l - 1]))
            if diff <= k:
                ans.append(i)
        return ans