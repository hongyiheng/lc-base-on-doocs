class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        def f(x):
            ans1 = ans2 = 0
            for t, b in zip(tops, bottoms):
                if t == b == x:
                    continue
                if t == x:
                    ans2 += 1
                elif b == x:
                    ans1 += 1
                else:
                    return -1
            return min(ans1, ans2)
        
        ans1, ans2 = f(tops[0]), f(bottoms[0])
        if ans1 == -1:
            return ans2
        elif ans2 == -1:
            return ans1
        return min(ans1, ans2)