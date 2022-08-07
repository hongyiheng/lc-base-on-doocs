class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        ans = set()
        for v in nums:
            if v == 0:
                continue
            ans.add(v)
        return len(ans)