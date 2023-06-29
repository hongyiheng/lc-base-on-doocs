class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        n = len(colsum)
        ans = [[0] * n for _ in range(2)]
        for i, v in enumerate(colsum):
            if v == 2:
                if upper > 0 and lower > 0:
                    ans[0][i] = ans[1][i] = 1
                    upper -= 1
                    lower -= 1
                else:
                    return []
        for i, v in enumerate(colsum):
            if v == 1:
                if upper > 0:
                    upper -= 1
                    ans[0][i] = 1
                elif lower > 0:
                    lower -= 1
                    ans[1][i] = 1
                else:
                    return []
        return ans if lower == 0 and upper == 0 else []