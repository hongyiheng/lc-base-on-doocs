class Solution:
    def minCharacters(self, a: str, b: str) -> int:
        m, n = len(a), len(b)
        cnt1, cnt2 = [0] * 26, [0] * 26
        for c in a:
            cnt1[ord(c) - ord('a')] += 1
        for c in b:
            cnt2[ord(c) - ord('a')] += 1
        ans = m - cnt1[0] + n - cnt2[0]
        for i in range(1, 26):
            first = second = third = 0
            for j in range(i, 26):
                first += cnt1[j]
                second += cnt2[j]
            for j in range(0, i):
                first += cnt2[j]
                second += cnt1[j]
            ans = min(ans, min(first, second))
            third = m - cnt1[i] + n - cnt2[i]
            ans = min(ans, third)
        return ans