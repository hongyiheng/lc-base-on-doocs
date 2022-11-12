class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        cnt = [0] * 26
        for c in s1:
            cnt[ord(c) - ord('a')] += 1
        l, r, n = 0, 0, len(s2)
        while r < n:
            while l < r and cnt[ord(s2[r]) - ord('a')] == 0:
                cnt[ord(s2[l]) - ord('a')] += 1
                l += 1
            if cnt[ord(s2[r]) - ord('a')] == 0:
                l += 1
            else:
                cnt[ord(s2[r]) - ord('a')] -= 1
                if r - l + 1 == len(s1):
                    return True
            r += 1
        return False
