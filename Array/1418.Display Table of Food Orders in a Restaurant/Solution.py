class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        fs = set()
        g = dict()
        for _, t, f in orders:
            if t not in g:
                g[t] = defaultdict(int)
            g[t][f] += 1
            fs.add(f)
        fs = sorted(list(fs))
        ts = sorted([int(v) for v in g.keys()])
        ans = [["Table"] + fs]
        for t in ts:
            r = [str(t)]
            for f in fs:
                r.append(str(g[str(t)][f]))
            ans.append(r)
        return ans