class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        n = len(asteroids)
        ans = []
        for v in asteroids:
            if v > 0:
                ans.append(v)
            else:
                exist = True
                while ans and exist:
                    if ans[-1] < 0:
                        break
                    if ans[-1] > abs(v):
                        exist = False
                    elif ans[-1] == abs(v):
                        ans.pop()
                        exist = False
                    else:
                        ans.pop()
                if exist:
                    ans.append(v)
        return ans