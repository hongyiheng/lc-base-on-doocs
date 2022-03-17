class Solution:
    def longestWord(self, words: List[str]) -> str:
        ans = ""
        w_set = set(words)
        for s in w_set:
            n, m = len(s), len(ans)
            if n < m:
                continue
            if n == m and s > ans:
                continue
            flag = True
            for i in range(1, n + 1):
                sub = s[:i]
                if sub not in w_set:
                    flag = False
                    break
            if flag:
                ans = s
        return ans