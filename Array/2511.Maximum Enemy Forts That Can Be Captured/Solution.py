class Solution:
    def captureForts(self, forts: List[int]) -> int:
        i, n = 0, len(forts)
        ans = 0
        while i < n:
            if forts[i]:
                t = -forts[i]
                cnt = 0
                while i + 1 < n and forts[i + 1] == 0:
                    cnt += 1
                    i += 1
                if i + 1 < n and forts[i + 1] == t:
                    ans = max(ans, cnt)
            i += 1
        return ans
