class Solution:
    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        last, first = dict(), dict()
        for i, v in enumerate(nums):
            if v in last:
                last_pos = last[v]
                d = min(i - last_pos, n - i + first[v])
                ans[i] = d
                if ans[last_pos] == -1:
                    ans[last_pos] = d
                else:
                    ans[last_pos] = min(ans[last_pos], i - last_pos, n - i + last_pos)
                ans[first[v]] = min(ans[first[v]], n - i + first[v])
            last[v] = i
            first.setdefault(v, i)
        return [ans[v] for v in queries]
