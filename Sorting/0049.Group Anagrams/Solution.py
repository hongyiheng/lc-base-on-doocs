class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp = defaultdict(list)
        for w in strs:
            cs = list(w)
            cs.sort()
            mp["".join(cs)].append(w)
        return [v for v in mp.values()]