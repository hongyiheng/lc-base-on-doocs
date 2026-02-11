class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        ans = 0
        n = len(nums)
        for i in range(n):
            odd_seen = defaultdict(int)
            even_seen = defaultdict(int)
            for j in range(i, n):
                num = nums[j]
                if num & 1:
                    odd_seen[num] = 1
                else:
                    even_seen[num] = 1
                if len(odd_seen) == len(even_seen):
                    ans = max(ans, j - i + 1)
        return ans