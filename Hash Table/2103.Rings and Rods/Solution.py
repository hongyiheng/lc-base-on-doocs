class Solution:
    def countPoints(self, rings: str) -> int:
        cnt = [0] * 10
        for i in range(0, len(rings), 2):
            cnt[int(rings[i + 1])] |= 1 << (ord(rings[i]) - ord('A'))
        t = 1 << (ord('R') - ord('A')) | 1 << (ord('G') - ord('A')) | 1 << (ord('B') - ord('A'))
        ans = 0
        for v in cnt:
            if v == t:
                ans += 1
        return ans