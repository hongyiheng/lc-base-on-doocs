class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        s = "#".join(source)
        i = 0
        while i + 1 < len(s):
            if s[i:i + 2] == '//':
                end = s.find("#", i + 2)
                if end != -1:
                    s = s[:i] + s[end:]
                else:
                    s = s[:i]
            elif s[i:i + 2] == '/*':
                end = s.find("*/", i + 2)
                if end != -1:
                    s = s[:i] + s[end + 2:]
            else:
                i += 1
        return [w for w in s.split("#") if w]