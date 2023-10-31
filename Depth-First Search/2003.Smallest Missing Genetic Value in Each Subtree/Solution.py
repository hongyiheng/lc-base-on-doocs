class Solution:
    def smallestMissingValueSubtree(self, parents: List[int], nums: List[int]) -> List[int]:
        def dfs(x):
            vis.add(nums[x])
            for v in g[x]:
                if nums[v] not in vis:
                    dfs(v)

        g = defaultdict(list)
        for i, p in enumerate(parents):
            g[p].append(i)

        ans = [1] * len(parents)
        vis = set()
        cur = 1
        node = nums.index(min(nums))
        while node >= 0:
            dfs(node)
            while cur in vis:
                cur += 1
            ans[node] = cur
            node = parents[node]
        return ans