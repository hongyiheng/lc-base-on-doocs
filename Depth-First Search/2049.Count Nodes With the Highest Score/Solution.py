class Solution:
    def countHighestScoreNodes(self, parents: List[int]) -> int:
        ans, mx, n = 0, 0, len(parents)
        mp = dict()
        cnt = [-1] * n
        for i, v in enumerate(parents):
            if v == -1:
                continue
            children = mp.get(v, list())
            children.append(i)
            mp[v] = children

        def dfs(index):
            nonlocal mx, ans, n, cnt, mp
            left, right = 0, 0
            children = mp.get(index, list())
            if len(children) > 0:
                left = dfs(children[0]) if cnt[children[0]] == -1 else cnt[children[0]]
            if len(children) > 1:
                right = dfs(children[1]) if cnt[children[1]] == -1 else cnt[children[1]]
            source = max(1, left) * max(1, right) * max(1, (n - 1 - right - left))
            if source > mx:
                mx = source
                ans = 1
            elif source == mx:
                ans += 1
            cnt[index] = left + right + 1
            return cnt[index]

        dfs(0)
        return ans