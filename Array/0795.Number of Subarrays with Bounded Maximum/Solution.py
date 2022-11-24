class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        q = []
        ans = cnt = 0
        for v in nums:
            if v <= right:
                q.append(v)
                if left <= v:
                    cnt = len(q)
                ans += cnt
            else:
                q.clear()
                cnt = 0
        return ans
