class Solution:
    def robotWithString(self, s: str) -> str:
        def is_min(c):
            idx = ord(c) - ord('a')
            for i in range(idx - 1, -1, -1):
                if cnt[i] > 0:
                    return False
            return True

        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        q = []
        ans = ""
        for c in s:
            q.append(c)
            cnt[ord(c) - ord('a')] -= 1
            while q and is_min(q[-1]):
                ans += q.pop()
        while q:
            ans += q.pop()
        return ans
