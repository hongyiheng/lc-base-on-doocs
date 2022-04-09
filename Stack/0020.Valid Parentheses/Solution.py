class Solution:
    def isValid(self, s: str) -> bool:
        mp = dict()
        mp[")"] = "("
        mp["}"] = "{"
        mp["]"] = "["
        q = []
        for c in s:
            if c in mp:
                if not q or q.pop() != mp[c]:
                    return False
                continue
            q.append(c)
        return not q