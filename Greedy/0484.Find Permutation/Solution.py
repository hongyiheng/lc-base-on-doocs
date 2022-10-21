class Solution:
    def findPermutation(self, s: str) -> List[int]:
        n = len(s)
        ans = [0] * (n + 1)
        for i in range(1, n + 2):
            ans[i - 1] = i
        idx = 0
        while idx < n:
            if s[idx] == 'I':
                idx += 1
            else:
                l = idx
                while idx < n and s[idx] == 'D':
                    idx += 1
                r = idx
                while l < r:
                    ans[l], ans[r] = ans[r], ans[l]
                    r -= 1
                    l += 1
        return ans
