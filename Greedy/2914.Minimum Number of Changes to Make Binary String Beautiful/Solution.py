class Solution:
    def minChanges(self, s: str) -> int:
        ans = cnt = cur = 0
        for v in s:
            if v != cur:
                if cnt:
                    ans += 1
                    cnt ^= 1
                else:
                    cur = v
                    cnt = 1
            else:
                cnt ^= 1
        return ans + 1 if cnt else ans
