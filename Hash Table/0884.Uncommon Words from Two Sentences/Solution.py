class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        mp = dict()
        for w in s1.split(" "):
            mp[w] = mp.get(w, 0) + 1
        for w in s2.split(" "):
            mp[w] = mp.get(w, 0) + 1
        ans = []
        for k in mp.keys():
            if mp[k] == 1:
                ans.append(k)
        return ans