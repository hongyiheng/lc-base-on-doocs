class Solution:
    def firstUniqChar(self, s: str) -> int:
        cnt = Counter(s)
        for i, v in enumerate(s):
            if cnt[v] == 1:
                return i
        return -1