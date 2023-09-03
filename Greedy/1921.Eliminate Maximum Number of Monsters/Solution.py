class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        t = [max((d + s - 1) // s, 1) for d, s in zip(dist, speed)]
        print(t)
        t.sort()
        ans = 0
        for i, v in enumerate(t):
            if v <= i:
                break
            ans += 1
        return ans
