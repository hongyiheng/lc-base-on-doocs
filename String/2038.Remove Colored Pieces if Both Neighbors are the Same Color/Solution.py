class Solution:
    def winnerOfGame(self, colors: str) -> bool:
        a_time, b_time = 0, 0
        cur = '.'
        cur_len = 0
        for c in colors:
            if c != cur:
                cur = c
                cur_len = 1
            else:
                cur_len += 1
                if cur_len >= 3:
                    if cur == 'A':
                        a_time += 1
                    else:
                        b_time += 1
        return a_time > b_time