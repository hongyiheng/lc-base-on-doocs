class Solution:
    def getWordsInLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        def check(s1, s2):
            diff = 0
            for a, b in zip(s1, s2):
                if a != b:
                    diff += 1
                if diff > 1:
                    return False
            return diff <= 1

        @cache
        def dfs(i, p):
            if i == n:
                return []
            ans = dfs(i + 1, p)
            if groups[i] != groups[p] and len(words[i]) == len(words[p]) and check(words[i], words[p]):
                ans2 = dfs(i + 1, i)
                if len(ans2) + 1 > len(ans):
                    return [words[i]] + ans2
            return ans

        n = len(words)
        mx = 0
        ans = []
        for i in range(n):
            cur = [words[i]] + dfs(i + 1, i)
            if len(cur) > mx:
                ans = cur
                mx = len(cur)
        return ans


