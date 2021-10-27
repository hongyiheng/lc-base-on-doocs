class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m = len(heights)
        n = len(heights[0])
        p = [i for i in range(m * n)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1 = find(i1)
            r2 = find(i2)
            if r1 != r2:
                p[r1] = r2

        dic_list = list()
        for i in range(m):
            for j in range(n):
                index = i * n + j
                if i < m - 1:
                    w = abs(heights[i][j] - heights[i + 1][j])
                    dic_list.append([index, index + n, w])
                if j < n - 1:
                    w = abs(heights[i][j] - heights[i][j + 1])
                    dic_list.append([index, index + 1, w])
        dic_list.sort(key=lambda elem: elem[2])
        start, end = 0, m * n - 1
        for item in dic_list:
            union(item[0], item[1])
            if find(start) == find(end):
                return item[2]
        return 0