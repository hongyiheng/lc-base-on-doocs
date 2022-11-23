class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        cnt = defaultdict(list)
        for a, b in adjacentPairs:
            cnt[a].append(b)
            cnt[b].append(a)
        n = len(cnt)
        ans = [0] * n
        for k in cnt.keys():
            if len(cnt[k]) == 1:
                ans[0] = k
                ans[1] = cnt[k][0]
                break
        for i in range(2, n):
            a, b = cnt.get(ans[i - 1])
            if a == ans[i - 2]:
                ans[i] = b
            else:
                ans[i] = a
        return ans
