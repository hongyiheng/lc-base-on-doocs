class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        ans = 0
        for w in words:
            if len(w) < len(pref):
                continue
            flag = True
            for a, b in zip(pref, w):
                if a != b:
                    flag = False
                    break
            if flag:
                ans += 1
        return ans

