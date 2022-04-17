class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        def check(x):
            nonlocal removable
            del_set = set(removable[:x])
            idx = 0
            for i, c in enumerate(s):
                if idx == len(p):
                    break
                if i in del_set:
                    continue
                if c == p[idx]:
                    idx += 1
            return idx == len(p)

        n = len(removable)
        left, right = 0, n
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left