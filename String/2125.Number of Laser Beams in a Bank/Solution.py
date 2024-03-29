class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        ans = last = 0
        for row in bank:
            cur = 0
            for c in row:
                if c == '1':
                    cur += 1
                    ans += last
            if cur:
                last = cur
        return ans