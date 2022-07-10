class Solution:
    def digArtifacts(self, n: int, artifacts: List[List[int]], dig: List[List[int]]) -> int:
        g = [[False] * n for _ in range(n)]
        for i, j in dig:
            g[i][j] = True
        ans = 0
        for a in artifacts:
            flag = True
            for i in range(a[0], a[2] + 1):
                if not flag:
                    break
                for j in range(a[1], a[3] + 1):
                    if not g[i][j]:
                        flag = False
                        break
            if flag:
                ans += 1
        return ans