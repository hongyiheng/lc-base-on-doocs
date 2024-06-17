class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        def check(i, j):
            if i == j or len(strs[j]) < len(strs[j]):
                return False
            idx = 0
            for c in strs[j]:
                if c == strs[i][idx]:
                    idx += 1
                if idx == len(strs[i]):
                    return True
            return False

        n = len(strs)
        ans = -1
        for i in range(n):
            if len(strs[i]) < ans:
                continue
            same = False
            for j in range(n):
                if check(i, j):
                    same = True
                    break
            if not same:
                ans = len(strs[i])
        return ans