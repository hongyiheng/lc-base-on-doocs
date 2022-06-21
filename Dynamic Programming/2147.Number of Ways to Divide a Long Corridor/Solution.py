class Solution:
    def numberOfWays(self, corridor: str) -> int:
        mod = int(1e9 + 7)
        ans = s_cnt = p_cnt = 0
        for c in corridor:
            if c == 'S':
                s_cnt += 1
                if s_cnt % 2 == 0:
                    if ans == 0:
                        ans = 1
                    if p_cnt:
                        ans = ans * (p_cnt + 1) % mod
                        p_cnt = 0
            else:
                if s_cnt and s_cnt % 2 == 0:
                    p_cnt += 1
        return ans % mod if s_cnt % 2 == 0 else 0