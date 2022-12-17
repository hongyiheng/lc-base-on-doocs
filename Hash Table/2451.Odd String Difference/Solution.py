class Solution:
    def oddString(self, words: List[str]) -> str:
        mp, ws = defaultdict(int), dict()
        for w in words:
            q = []
            for i in range(1, len(w)):
                q.append(ord(w[i]) - ord(w[i - 1]))
            mp[str(q)] += 1
            ws[str(q)] = w
        ans = ""
        for k in mp.keys():
            if mp[k] == 1:
                ans = k
                break
        return ws[ans]
