class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda x:x[1])
        run = [False] * (tasks[-1][1] + 1)
        ans = 0
        for l, r, t in tasks:
            t -= sum(run[l:r + 1])
            if t > 0:
                for i in range(r, l - 1, -1):
                    if not run[i]:
                        run[i] = True
                        t -= 1
                        ans += 1
                    if t <= 0:
                        break
        return ans
