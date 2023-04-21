class Solution:
    def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
        def dfs(cur, idx):
            nonlocal mx
            if idx == len(nums):
                return
            cur ^= nums[idx]
            dfs(cur, idx + 1)
            ans.append(cur ^ mx)

        mx = (1 << maximumBit) - 1
        ans = []
        dfs(0, 0)
        return ans