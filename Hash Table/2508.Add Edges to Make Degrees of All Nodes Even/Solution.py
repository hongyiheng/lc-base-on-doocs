class Solution:
    def isPossible(self, n: int, edges: List[List[int]]) -> bool:
        mp = defaultdict(set)
        for u, v in edges:
            mp[u].add(v)
            mp[v].add(u)
        odd = [k for k in mp.keys() if len(mp[k]) % 2]
        m = len(odd)
        if m == 0:
            return True
        elif m == 2:
            a, b = odd
            if b not in mp[a] and a not in mp[b]:
                return True
            for c in range(1, n + 1):
                if c == a or c == b:
                    continue
                if a not in mp[c] and b not in mp[c]:
                    return True
        elif m == 4:
            a, b, c, d = odd
            if b not in mp[a] and a not in mp[b] and c not in mp[d] and d not in mp[c]:
                return True
            if c not in mp[a] and a not in mp[c] and b not in mp[d] and d not in mp[b]:
                return True
            if d not in mp[a] and a not in mp[d] and b not in mp[c] and c not in mp[b]:
                return True
        return False