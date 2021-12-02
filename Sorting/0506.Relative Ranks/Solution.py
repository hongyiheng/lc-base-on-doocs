class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        score1 = score.copy()
        score1.sort(reverse=True)
        mp, ans = dict(), list()
        for v, i in enumerate(score1):
            if v == 0:
                mp[i] = 'Gold Medal'
            elif v == 1:
                mp[i] = 'Silver Medal'
            elif v == 2:
                mp[i] = 'Bronze Medal'
            else:
                mp[i] = str(v + 1)
        for i in score:
            ans.append(mp[i])
        return ans
