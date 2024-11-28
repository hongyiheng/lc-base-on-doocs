class Solution:
    def stringSequence(self, target: str) -> List[str]:
        ans = []
        s = ""
        for t in target:
            v = 'a'
            ans.append(s[:] + v)
            while v != t:
                v = chr(ord(v) + 1)
                ans.append(s[:] + v)
            s += v
        return ans
