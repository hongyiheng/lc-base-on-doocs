class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        n = len(pref)
        ans = [0] * n
        cur = 0
        for i in range(n):
            ans[i] = cur ^ pref[i]
            cur ^= ans[i]
        return ans
