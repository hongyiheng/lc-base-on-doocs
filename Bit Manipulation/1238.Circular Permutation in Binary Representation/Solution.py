class Solution:
    def circularPermutation(self, n: int, start: int) -> List[int]:
        ans = []
        for i in range(2 ** n):
            ans.append(i ^ (i >> 1))
        for i, v in enumerate(ans):
            if v == start:
                ans = ans[i:] + ans[:i]
                break
        return ans
