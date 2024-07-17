class Solution:
    def findWinningPlayer(self, skills: List[int], k: int) -> int:
        ans, cur, cnt = 0, skills[0], 0
        for i in range(1, len(skills)):
            if cur < skills[i]:
                cur = skills[i]
                ans = i
                cnt = 0
            cnt += 1
            if cnt == k:
                return ans
        return ans