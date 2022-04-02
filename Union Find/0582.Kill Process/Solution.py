class Solution:
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        p = [i for i in range(50010)]

        def find(x):
            if x == kill:
                return x
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1, r2 = find(i1), find(i2)
            if r1 != r2:
                p[r1] = r2

        n = len(pid)
        for i in range(n):
            union(pid[i], ppid[i])
        ans = []
        for v in pid:
            if find(v) == kill:
                ans.append(v)
        return ans