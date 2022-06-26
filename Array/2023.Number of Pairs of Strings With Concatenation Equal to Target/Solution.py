class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        m, n = len(nums), len(target)
        ans = 0
        for i in range(m):
            for j in range(m):
                if i == j:
                    continue
                if nums[i] + nums[j] == target:
                    ans += 1
        return ans