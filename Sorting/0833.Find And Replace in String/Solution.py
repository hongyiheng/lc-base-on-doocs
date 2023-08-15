class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        q = []
        for i in range(len(indices)):
            l, r = indices[i], indices[i] + len(sources[i])
            if s[l:r] == sources[i]:
                q.append((indices[i], i))
        q.sort(reverse=True)
        for _, i in q:
            l, r = indices[i], indices[i] + len(sources[i])
            s = s[:l] + targets[i] + s[r:]
        return s