class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        cnt = [0] * (n + 1)
        vis = set()
        for u, v in friendships:
            lu, lv = set(languages[u - 1]), set(languages[v - 1])
            if not lu & lv:
                for k in range(1, n + 1):
                    if u not in vis and k not in lu:
                        cnt[k] += 1
                    if v not in vis and k not in lv:
                        cnt[k] += 1
                vis.add(u)
                vis.add(v)
        return min(cnt[1:])

