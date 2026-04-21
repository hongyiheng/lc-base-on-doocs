class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x, y):
            px, py = find(x), find(y)
            if px != py:
                parent[px] = py

        n = len(source)
        parent = list(range(n))
        for a, b in allowedSwaps:
            union(a, b)
        groups = defaultdict(list)
        for i in range(n):
            root = find(i)
            groups[root].append(i)
        ans = 0
        for vals in groups.values():
            cnt = Counter()
            for i in vals:
                cnt[source[i]] += 1
                cnt[target[i]] -= 1
            for v in cnt.values():
                if v > 0:
                    ans += v
        return ans