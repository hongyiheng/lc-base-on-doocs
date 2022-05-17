class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        mp = [0] * 26
        for i in range(26):
            idx = ord(order[i]) - ord('a')
            mp[idx] = i
        pre = ""
        for w in words:
            eq = True
            for a, b in zip(pre, w):
                idx1 = ord(a) - ord('a')
                idx2 = ord(b) - ord('a')
                if mp[idx1] < mp[idx2]:
                    eq = False
                    break
                elif mp[idx1] > mp[idx2]:
                    return False
            if eq and len(pre) > len(w):
                return False
            pre = w
        return True