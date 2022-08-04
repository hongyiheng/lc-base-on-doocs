class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        ans = mx = 0
        for i, v in enumerate(arr):
            mx = max(mx, v)
            if i == mx:
                ans += 1
        return ans