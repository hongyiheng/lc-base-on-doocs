class Solution:
    def equalFrequency(self, word: str) -> bool:
        cnt = [0] * 26
        for c in word:
            cnt[ord(c) - ord('a')] += 1
        for i, v in enumerate(cnt):
            cnt[i] -= 1
            if len({v for v in cnt if v}) == 1:
                return True
            cnt[i] += 1
        return False