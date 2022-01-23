class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        mp = dict()
        n = len(arr)
        for i in range(n - 1, -1, -1):
            cur = mp.get(arr[i] + difference, 0) + 1
            mp[arr[i]] = cur
        return max(mp.values())