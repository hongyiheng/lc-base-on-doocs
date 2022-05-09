class Solution:
    def diStringMatch(self, s: str) -> List[int]:
        n = len(s)
        left, right, idx = 0, n, 0
        ans = [0] * (n + 1)
        for c in s:
            if c == 'I':
                ans[idx] = left
                left += 1
            else:
                ans[idx] = right
                right -= 1
            idx += 1
        ans[idx] = left
        return ans