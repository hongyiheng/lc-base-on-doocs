class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [[1]]
        for i in range(1, numRows):
            last = ans[-1]
            cur = [0] * (len(last) + 1)
            cur[0] = cur[-1] = 1
            for j in range(1, len(cur) - 1):
                cur[j] = last[j - 1] + last[j]
            ans.append(cur)
        return ans

