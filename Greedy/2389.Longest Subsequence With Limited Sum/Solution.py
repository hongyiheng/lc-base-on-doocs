class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()
        q = [[v, i] for i, v in enumerate(queries)]
        q.sort()
        ans = [0] * len(queries)
        idx = cur = k = 0
        for v, i in q:
            while idx < len(nums) and cur + nums[idx] <= v:
                cur += nums[idx]
                idx += 1
                k += 1
            ans[i] = k
        return ans
