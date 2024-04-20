class Solution:
    def mostFrequentPrime(self, mat: List[List[int]]) -> int:
        def is_primes(x):
            for i in range(2, int(x ** 0.5) + 1):
                if not x % i:
                    return False
            return True

        m, n = len(mat), len(mat[0])
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1], [1, 1], [1, -1], [-1, 1], [-1, -1]]
        g = defaultdict(int)
        for i in range(m):
            for j in range(n):
                for d in dirs:
                    x, y, v = i, j, mat[i][j]
                    while True:
                        nx, ny = x + d[0], y + d[1]
                        if nx < 0 or nx >= m or ny < 0 or ny >= n:
                            break
                        v = v * 10 + mat[nx][ny]
                        x, y = nx, ny
                        if v > 10:
                            g[v] += 1
        q = [(k, g[k]) for k in g.keys()]
        q.sort(key=lambda x: (x[1], x[0]), reverse=True)
        for v, _ in q:
            if is_primes(v):
                return v
        return -1