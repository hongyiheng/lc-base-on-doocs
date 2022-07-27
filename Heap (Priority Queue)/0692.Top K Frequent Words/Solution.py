from sortedcontainers import SortedList

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        def cmp(a, b):
            if a[0] != b[0]:
                return a[0] - b[0]
            return 1 if b[1] > a[1] else -1

        mp = {}
        for w in words:
            mp[w] = mp.get(w, 0) + 1
        q = SortedList(key=cmp_to_key(cmp))
        for key in mp.keys():
            q.add((mp[key], key))
            if len(q) > k:
                q.pop(0)
        ans = deque()
        for _, w in q:
            ans.appendleft(w)
        return list(ans)