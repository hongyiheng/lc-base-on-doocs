class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        mp = defaultdict(list)
        for a, b, c in allowed:
            mp[(a, b)].append(c)

        @cache
        def dfs(row, cur):
            if len(row) == 1:
                return True
            if len(cur) + 1 == len(row):
                return dfs(cur, "")
            a, b = row[len(cur)], row[len(cur) + 1]
            for c in mp.get((a, b), []):
                cur += c
                if dfs(row, cur):
                    return True
                cur = cur[:-1]
            return False

        return dfs(bottom, "")
