class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        n, m = len(s), len(queries)
        left, right, cnt = [0] * n, [0] * n, [0] * n
        l = r = -1
        num = 0
        for i in range(n):
            j = n - i - 1
            if s[i] == '*':
                num += 1
            if s[i] == '|':
                l = i
            if s[j] == '|':
                r = j
            left[i] = l
            right[j] = r
            cnt[i] = num
        ans = [0] * m
        for i in range(m):
            a = right[queries[i][0]]
            b = left[queries[i][1]]
            if a != -1 and b != -1 and a < b:
                ans[i] = cnt[b] - cnt[a]
        return ans


