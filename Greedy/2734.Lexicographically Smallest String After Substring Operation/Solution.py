class Solution:
    def smallestString(self, s: str) -> str:
        cs = list(s)
        flag = False
        for i, c in enumerate(cs):
            if c != 'a':
                cs[i] = chr(ord(c) - 1)
                flag = True
            elif flag:
                break
        if not flag:
            cs[-1] = 'z'
        return "".join(cs)
