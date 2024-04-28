class Solution:
    def unmarkedSumArray(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        def cmp(a, b):
            return a[1] - b[1] if a[1] != b[1] else a[0] - b[0]

        q = [(i, v) for i, v in enumerate(nums)]
        q.sort(key=cmp_to_key(cmp))
        used = set()
        s, idx = sum(nums), 0
        ans = []
        for i, k in queries:
            if i not in used:
                s -= nums[i]
                used.add(i)
            while k and idx < len(q):
                if q[idx][0] in used:
                    idx += 1
                    continue
                s -= q[idx][1]
                used.add(q[idx][0])
                k -= 1
                idx += 1
            ans.append(s)
        return ans