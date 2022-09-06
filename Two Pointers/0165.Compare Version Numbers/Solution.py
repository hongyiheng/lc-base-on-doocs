class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        s1, s2 = version1.split("."), version2.split(".")
        i = j = 0
        while i < len(s1) or j < len(s2):
            v1 = int(s1[i]) if i < len(s1) else 0
            v2 = int(s2[j]) if j < len(s2) else 0
            if v1 == v2:
                i += 1
                j += 1
                continue
            return 1 if v1 > v2 else -1
        return 0