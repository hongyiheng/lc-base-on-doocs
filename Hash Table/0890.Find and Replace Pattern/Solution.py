class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        ans = []
        for w in words:
            if len(pattern) != len(w):
                continue
            a, b = dict(), dict()
            same = True
            for i in range(len(w)):
                if w[i] not in a:
                    a[w[i]] = pattern[i]
                elif a[w[i]] != pattern[i]:
                    same = False
                    break
                if pattern[i] not in b:
                    b[pattern[i]] = w[i]
                elif b[pattern[i]] != w[i]:
                    same = False
                    break
            if same:
                ans.append(w)
        return ans