class Solution:
    def longestCommonPrefix(self, words: List[str]) -> List[int]:
        def f(s1, s2):
            ans = 0
            for a, b in zip(s1, s2):
                if a != b:
                    break
                ans += 1
            return ans

        n = len(words)
        ans = [0] * n
        if n <= 2:
            return ans

        suf = [0] * n
        for i in range(n - 2, -1, -1):
            suf[i] = max(suf[i + 1], f(words[i], words[i + 1]))

        ans[0] = suf[1]
        pre = 0
        for i in range(1, n - 1):
            ans[i] = max(pre, f(words[i - 1], words[i + 1]), suf[i + 1])
            pre = max(pre, f(words[i - 1], words[i]))
        ans[-1] = pre
        return ans

