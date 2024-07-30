class Solution:
    def getGoodIndices(self, variables: List[List[int]], target: int) -> List[int]:
        ans = []
        for i, v in enumerate(variables):
            a, b, c, m = v
            if (a ** b % 10) ** c % m == target:
                ans.append(i)
        return ans