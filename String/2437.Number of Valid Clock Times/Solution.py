class Solution:
    def countTime(self, time: str) -> int:
        ans = 1
        if time[0] == '?' and time[1] == '?':
            ans = 24
        elif time[0] == '?':
            ans = 3 if time[1] < '4' else 2
        elif time[1] == '?':
            ans = 10 if time[0] < '2' else 4
        ans *= 6 if time[3] == '?' else 1
        ans *= 10 if time[4] == '?' else 1
        return ans
