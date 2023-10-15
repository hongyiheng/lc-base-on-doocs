class Solution:
    def isItPossible(self, word1: str, word2: str) -> bool:
        cnt1, cnt2 = [0] * 26, [0] * 26
        for c in word1:
            cnt1[ord(c) - ord('a')] += 1
        for c in word2:
            cnt2[ord(c) - ord('a')] += 1
        f1 = f2 = 0
        for i in range(26):
            f1 += 1 if cnt1[i] else 0
            f2 += 1 if cnt2[i] else 0
        if abs(f1 - f2) > 2:
            return False
        for i in range(26):
            for j in range(26):
                if not cnt1[i] or not cnt2[j]:
                    continue
                if i == j:
                    if f1 == f2:
                        return True
                    continue
                v1, v2 = f1, f2
                if cnt1[i] - 1 == 0:
                    v1 -= 1
                if not cnt1[j]:
                    v1 += 1
                if cnt2[j] - 1 == 0:
                    v2 -= 1
                if not cnt2[i]:
                    v2 += 1
                if v1 == v2:
                    return True
        return False

