class Solution:
    def hardestWorker(self, n: int, logs: List[List[int]]) -> int:
        mx = last = ans = 0
        for i, t in logs:
            if t - last > mx:
                ans = i
                mx = t - last
            elif t - last == mx and ans > i:
                ans = i
            last = t
        return ans
