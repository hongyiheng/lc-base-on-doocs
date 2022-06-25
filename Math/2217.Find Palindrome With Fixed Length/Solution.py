class Solution:
    def kthPalindrome(self, queries: List[int], intLength: int) -> List[int]:
        event = intLength % 2 == 0
        n = intLength // 2 if event else intLength // 2 + 1
        start = 10 ** (n - 1)
        ans = []
        for v in queries:
            left = str(start + v - 1)
            right = left[:] if event else left[:-1]
            right = right[::-1]
            cur = left + right
            if len(cur) == intLength:
                ans.append(int(cur))
            else:
                ans.append(-1)
        return ans