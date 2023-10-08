class Solution:
    def numTeams(self, rating: List[int]) -> int:
        ans = 0
        for i, v in enumerate(rating):
            llt = rlt = lgt = rgt = 0
            for j, x in enumerate(rating):
                if x < v:
                    if j < i:
                        llt += 1
                    else:
                        rlt += 1
                if x > v:
                    if j < i:
                        lgt += 1
                    else:
                        rgt += 1
            ans += (llt * rgt) + (lgt * rlt)
        return ans