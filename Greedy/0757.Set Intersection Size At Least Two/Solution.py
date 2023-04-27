class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        def cmp(a, b):
            return a[0] - b[0] if a[1] == b[1] else a[1] - b[1]

        intervals.sort(key=cmp_to_key(cmp))
        ans = []
        use = set()
        for l, r in intervals:
            need = 2
            if len(ans) >= 1 and ans[-1] >= l:
                need -= 1
            if len(ans) >= 2 and ans[-2] >= l:
                need -= 1
            if need == 2:
                ans.append(r - 1)
                ans.append(r)
                use.add(r)
            if need == 1:
                if r not in use:
                    ans.append(r)
                else:
                    ans.append(r - 1)
                use.add(r)
        return len(ans)