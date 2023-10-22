class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        satisfaction.sort()
        ans = posSum = posCnt = 0
        negs = []
        for v in satisfaction:
            if v >= 0:
                posCnt += 1
                posSum += v
                ans += v * posCnt
            else:
                negs.append(v)

        negs.sort(reverse=True)
        for i, v in enumerate(negs):
            cur = ans + posSum + v
            if cur <= ans:
                break
            posSum += v
            ans = cur
        return ans