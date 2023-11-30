class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        cnt1 = [0] * 26
        for c in word1:
            cnt1[ord(c) - ord('a')] += 1
        cnt2 = [0] * 26
        for c in word2:
            if not cnt1[ord(c) - ord('a')]:
                return False
            cnt2[ord(c) - ord('a')] += 1
        cnt1.sort()
        cnt2.sort()
        return cnt1 == cnt2